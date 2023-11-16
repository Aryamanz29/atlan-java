/* SPDX-License-Identifier: Apache-2.0
   Copyright 2023 Atlan Pte. Ltd. */
package com.atlan.pkg.serde

import com.atlan.Atlan
import com.atlan.model.assets.Connection
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer
import com.fasterxml.jackson.module.kotlin.readValue

/**
 * Utility class to deserialize the results of a connection creator widget, since it returns
 * a string-encoded connection object.
 */
class ConnectionDeserializer : StdDeserializer<Connection>(
    Connection::class.java,
) {
    override fun deserializeWithType(
        p: JsonParser?,
        ctxt: DeserializationContext?,
        typeDeserializer: TypeDeserializer?,
    ): Connection? {
        return deserialize(p, ctxt)
    }

    override fun deserialize(
        p: JsonParser?,
        ctxt: DeserializationContext?,
    ): Connection? {
        val root = p?.codec?.readTree<JsonNode>(p)
        if (root != null && !root.isNull && root.isTextual) {
            return deserialize(root.textValue())
        }
        return null
    }

    companion object {
        fun deserialize(value: String?): Connection? {
            if (!value.isNullOrEmpty()) {
                return Atlan.getDefaultClient().readValue(value, Connection::class.java)
            }
            return null
        }
    }
}
