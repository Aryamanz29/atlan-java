/* SPDX-License-Identifier: Apache-2.0
   Copyright 2023 Atlan Pte. Ltd. */
package com.atlan.pkg.cache

import com.atlan.Atlan
import com.atlan.exception.ApiException
import com.atlan.exception.AtlanException
import com.atlan.exception.ErrorCode
import com.atlan.exception.NotFoundException
import com.atlan.exception.PermissionException
import com.atlan.model.assets.Asset
import com.atlan.model.assets.Connection
import com.atlan.model.core.AtlanAsyncMutator.MAX_ASYNC_RETRIES
import com.atlan.model.enums.AtlanConnectorType
import com.atlan.model.fields.AtlanField
import com.atlan.net.HttpClient
import com.atlan.net.RequestOptions
import com.atlan.pkg.serde.cell.ConnectionXformer
import mu.KotlinLogging

object ConnectionCache : AssetCache() {
    private val logger = KotlinLogging.logger {}

    private val includesOnResults: List<AtlanField> = listOf(Connection.NAME, Connection.CONNECTOR_TYPE, Connection.STATUS)

    /** {@inheritDoc}  */
    override fun lookupAssetByIdentity(identity: String?): Asset? {
        val tokens = identity?.split(ConnectionXformer.CONNECTION_DELIMITER)
        if (tokens?.size == 2) {
            val name = tokens[0]
            val type = tokens[1]
            try {
                val found = Connection.findByName(name, AtlanConnectorType.fromValue(type), includesOnResults)
                return found[0]
            } catch (e: NotFoundException) {
                logger.warn { "Unable to find connection: $identity" }
                logger.debug("Full stack trace:", e)
            } catch (e: AtlanException) {
                logger.error("Unable to lookup or find connection: {}", identity, e)
            }
        } else {
            logger.error { "Unable to lookup or find connection, unexpected reference: $identity" }
        }
        identity?.let { addToIgnore(identity) }
        return null
    }

    /** {@inheritDoc}  */
    override fun lookupAssetByGuid(guid: String?, currentAttempt: Int, maxRetries: Int): Asset? {
        try {
            val connection =
                Connection.select()
                    .where(Connection.GUID.eq(guid))
                    .includesOnResults(includesOnResults)
                    .pageSize(1)
                    .stream()
                    .findFirst()
            if (connection.isPresent) {
                return isAccessible(connection.get())
            } else {
                if (currentAttempt >= maxRetries) {
                    logger.error { "No connection found with GUID: $guid" }
                } else {
                    Thread.sleep(HttpClient.waitTime(currentAttempt).toMillis())
                    return lookupAssetByGuid(guid, currentAttempt + 1, maxRetries)
                }
            }
        } catch (e: AtlanException) {
            logger.error("Unable to lookup or find connection: {}", guid, e)
        }
        guid?.let { addToIgnore(guid) }
        return null
    }

    /** {@inheritDoc}  */
    override fun getIdentityForAsset(asset: Asset): String {
        return when (asset) {
            is Connection -> {
                if (asset.connectorType != null) {
                    getIdentityForAsset(asset.name, asset.connectorType)
                } else {
                    ""
                }
            }
            else -> ""
        }
    }

    /**
     * Build a connection identity from its component parts.
     *
     * @param name of the connection
     * @param type of the connector for the connection (as a string)
     * @return identity for the connection
     */
    fun getIdentityForAsset(name: String, type: AtlanConnectorType): String {
        return ConnectionXformer.encode(name, type.value)
    }

    /** {@inheritDoc} */
    override fun preload() {
        logger.info { "Caching all connections, up-front..." }
        Connection.select()
            .includesOnResults(includesOnResults)
            .stream(true)
            .forEach { connection ->
                addByGuid(connection.guid, connection)
            }
    }

    /**
     * Uniquely for connections, we need to ensure they are accessible before
     * caching them, as any other operation that interacts with them will need more
     * than the search to succeed to do anything with them.
     *
     * @param connection the result from a search
     * @return the accessible connection, in full
     */
    private fun isAccessible(connection: Asset): Asset {
        try {
            val candidate = Atlan.getDefaultClient().assets.get(
                connection.guid,
                false,
                false,
                RequestOptions.from(Atlan.getDefaultClient())
                    .maxNetworkRetries(MAX_ASYNC_RETRIES)
                    .build(),
            )
            if (candidate?.asset == null) {
                // Since the retry logic in this case is actually embedded in the retrieveMinimal
                // call, if we get to this point without retrieving the connection we have by
                // definition overrun the retry limit
                throw ApiException(ErrorCode.RETRY_OVERRUN, null)
            }
            return candidate.asset
        } catch (e: PermissionException) {
            // If we get a permission exception after the built-in retries above, throw it
            // onwards as a retry overrun
            throw ApiException(ErrorCode.RETRY_OVERRUN, e)
        }
    }
}
