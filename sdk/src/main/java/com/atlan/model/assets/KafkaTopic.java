/* SPDX-License-Identifier: Apache-2.0
   Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.Atlan;
import com.atlan.AtlanClient;
import com.atlan.exception.AtlanException;
import com.atlan.exception.ErrorCode;
import com.atlan.exception.InvalidRequestException;
import com.atlan.exception.NotFoundException;
import com.atlan.model.core.AssetFilter;
import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.CertificateStatus;
import com.atlan.model.enums.KafkaTopicCleanupPolicy;
import com.atlan.model.enums.KafkaTopicCompressionType;
import com.atlan.model.relations.Reference;
import com.atlan.model.relations.UniqueAttributes;
import com.atlan.model.search.CompoundQuery;
import com.atlan.model.search.FluentSearch;
import com.atlan.util.QueryFactory;
import com.atlan.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Instance of a Kafka Topic in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true, builderMethodName = "_internal")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class KafkaTopic extends Asset implements IKafkaTopic, IKafka, IEventStore, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "KafkaTopic";

    /** Fixed typeName for KafkaTopics. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Tasks to which this asset provides input. */
    @Attribute
    @Singular
    SortedSet<IAirflowTask> inputToAirflowTasks;

    /** Processes to which this asset provides input. */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** Consumer groups subscribed to this topic. */
    @Attribute
    @Singular
    SortedSet<IKafkaConsumerGroup> kafkaConsumerGroups;

    /** Cleanup policy for this topic. */
    @Attribute
    KafkaTopicCleanupPolicy kafkaTopicCleanupPolicy;

    /** Type of compression used for this topic. */
    @Attribute
    KafkaTopicCompressionType kafkaTopicCompressionType;

    /** Whether this topic is an internal topic (true) or not (false). */
    @Attribute
    Boolean kafkaTopicIsInternal;

    /** Number of partitions for this topic. */
    @Attribute
    Long kafkaTopicPartitionsCount;

    /** Number of (unexpired) messages in this topic. */
    @Attribute
    Long kafkaTopicRecordCount;

    /** Replication factor for this topic. */
    @Attribute
    Long kafkaTopicReplicationFactor;

    /** Amount of time messages will be retained in this topic, in milliseconds. */
    @Attribute
    Long kafkaTopicRetentionTimeInMs;

    /** Segment size for this topic. */
    @Attribute
    Long kafkaTopicSegmentBytes;

    /** Size of this topic, in bytes. */
    @Attribute
    Long kafkaTopicSizeInBytes;

    /** Tasks from which this asset is output. */
    @Attribute
    @Singular
    SortedSet<IAirflowTask> outputFromAirflowTasks;

    /** Processes from which this asset is produced as output. */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;

    /**
     * Builds the minimal object necessary to create a relationship to a KafkaTopic, from a potentially
     * more-complete KafkaTopic object.
     *
     * @return the minimal object necessary to relate to the KafkaTopic
     * @throws InvalidRequestException if any of the minimal set of required properties for a KafkaTopic relationship are not found in the initial object
     */
    @Override
    public KafkaTopic trimToReference() throws InvalidRequestException {
        if (this.getGuid() != null && !this.getGuid().isEmpty()) {
            return refByGuid(this.getGuid());
        }
        if (this.getQualifiedName() != null && !this.getQualifiedName().isEmpty()) {
            return refByQualifiedName(this.getQualifiedName());
        }
        if (this.getUniqueAttributes() != null
                && this.getUniqueAttributes().getQualifiedName() != null
                && !this.getUniqueAttributes().getQualifiedName().isEmpty()) {
            return refByQualifiedName(this.getUniqueAttributes().getQualifiedName());
        }
        throw new InvalidRequestException(
                ErrorCode.MISSING_REQUIRED_RELATIONSHIP_PARAM, TYPE_NAME, "guid, qualifiedName");
    }

    /**
     * Start a fluent search that will return all KafkaTopic assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) KafkaTopic assets will be included.
     *
     * @return a fluent search that includes all KafkaTopic assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select() {
        return select(Atlan.getDefaultClient());
    }

    /**
     * Start a fluent search that will return all KafkaTopic assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) KafkaTopic assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return a fluent search that includes all KafkaTopic assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(AtlanClient client) {
        return select(client, false);
    }

    /**
     * Start a fluent search that will return all KafkaTopic assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) KafkaTopics will be included
     * @return a fluent search that includes all KafkaTopic assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(boolean includeArchived) {
        return select(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start a fluent search that will return all KafkaTopic assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) KafkaTopics will be included
     * @return a fluent search that includes all KafkaTopic assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(AtlanClient client, boolean includeArchived) {
        FluentSearch.FluentSearchBuilder<?, ?> builder =
                FluentSearch.builder(client).where(CompoundQuery.assetType(TYPE_NAME));
        if (!includeArchived) {
            builder.where(CompoundQuery.ACTIVE);
        }
        return builder;
    }

    /**
     * Start an asset filter that will return all KafkaTopic assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) KafkaTopic assets will be included.
     *
     * @return an asset filter that includes all KafkaTopic assets
     * @deprecated replaced by {@link #select()}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all() {
        return all(Atlan.getDefaultClient());
    }

    /**
     * Start an asset filter that will return all KafkaTopic assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) KafkaTopic assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return an asset filter that includes all KafkaTopic assets
     * @deprecated replaced by {@link #select(AtlanClient)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(AtlanClient client) {
        return all(client, false);
    }

    /**
     * Start an asset filter that will return all KafkaTopic assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) KafkaTopics will be included
     * @return an asset filter that includes all KafkaTopic assets
     * @deprecated replaced by {@link #select(boolean)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(boolean includeArchived) {
        return all(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start an asset filter that will return all KafkaTopic assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) KafkaTopics will be included
     * @return an asset filter that includes all KafkaTopic assets
     * @deprecated replaced by {@link #select(AtlanClient, boolean)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(AtlanClient client, boolean includeArchived) {
        AssetFilter.AssetFilterBuilder builder =
                AssetFilter.builder().client(client).filter(QueryFactory.type(TYPE_NAME));
        if (!includeArchived) {
            builder.filter(QueryFactory.active());
        }
        return builder;
    }

    /**
     * Reference to a KafkaTopic by GUID. Use this to create a relationship to this KafkaTopic,
     * where the relationship should be replaced.
     *
     * @param guid the GUID of the KafkaTopic to reference
     * @return reference to a KafkaTopic that can be used for defining a relationship to a KafkaTopic
     */
    public static KafkaTopic refByGuid(String guid) {
        return refByGuid(guid, Reference.SaveSemantic.REPLACE);
    }

    /**
     * Reference to a KafkaTopic by GUID. Use this to create a relationship to this KafkaTopic,
     * where you want to further control how that relationship should be updated (i.e. replaced,
     * appended, or removed).
     *
     * @param guid the GUID of the KafkaTopic to reference
     * @param semantic how to save this relationship (replace all with this, append it, or remove it)
     * @return reference to a KafkaTopic that can be used for defining a relationship to a KafkaTopic
     */
    public static KafkaTopic refByGuid(String guid, Reference.SaveSemantic semantic) {
        return KafkaTopic._internal().guid(guid).semantic(semantic).build();
    }

    /**
     * Reference to a KafkaTopic by qualifiedName. Use this to create a relationship to this KafkaTopic,
     * where the relationship should be replaced.
     *
     * @param qualifiedName the qualifiedName of the KafkaTopic to reference
     * @return reference to a KafkaTopic that can be used for defining a relationship to a KafkaTopic
     */
    public static KafkaTopic refByQualifiedName(String qualifiedName) {
        return refByQualifiedName(qualifiedName, Reference.SaveSemantic.REPLACE);
    }

    /**
     * Reference to a KafkaTopic by qualifiedName. Use this to create a relationship to this KafkaTopic,
     * where you want to further control how that relationship should be updated (i.e. replaced,
     * appended, or removed).
     *
     * @param qualifiedName the qualifiedName of the KafkaTopic to reference
     * @param semantic how to save this relationship (replace all with this, append it, or remove it)
     * @return reference to a KafkaTopic that can be used for defining a relationship to a KafkaTopic
     */
    public static KafkaTopic refByQualifiedName(String qualifiedName, Reference.SaveSemantic semantic) {
        return KafkaTopic._internal()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .semantic(semantic)
                .build();
    }

    /**
     * Retrieves a KafkaTopic by one of its identifiers, complete with all of its relationships.
     *
     * @param id of the KafkaTopic to retrieve, either its GUID or its full qualifiedName
     * @return the requested full KafkaTopic, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the KafkaTopic does not exist or the provided GUID is not a KafkaTopic
     */
    @JsonIgnore
    public static KafkaTopic get(String id) throws AtlanException {
        return get(Atlan.getDefaultClient(), id);
    }

    /**
     * Retrieves a KafkaTopic by one of its identifiers, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the KafkaTopic to retrieve, either its GUID or its full qualifiedName
     * @return the requested full KafkaTopic, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the KafkaTopic does not exist or the provided GUID is not a KafkaTopic
     */
    @JsonIgnore
    public static KafkaTopic get(AtlanClient client, String id) throws AtlanException {
        return get(client, id, true);
    }

    /**
     * Retrieves a KafkaTopic by one of its identifiers, optionally complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the KafkaTopic to retrieve, either its GUID or its full qualifiedName
     * @param includeRelationships if true, all of the asset's relationships will also be retrieved; if false, no relationships will be retrieved
     * @return the requested full KafkaTopic, optionally complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the KafkaTopic does not exist or the provided GUID is not a KafkaTopic
     */
    @JsonIgnore
    public static KafkaTopic get(AtlanClient client, String id, boolean includeRelationships) throws AtlanException {
        if (id == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, "(null)");
        } else if (StringUtils.isUUID(id)) {
            Asset asset = Asset.get(client, id, includeRelationships);
            if (asset == null) {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, id);
            } else if (asset instanceof KafkaTopic) {
                return (KafkaTopic) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, id, TYPE_NAME);
            }
        } else {
            Asset asset = Asset.get(client, TYPE_NAME, id, includeRelationships);
            if (asset instanceof KafkaTopic) {
                return (KafkaTopic) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, id, TYPE_NAME);
            }
        }
    }

    /**
     * Retrieves a KafkaTopic by its GUID, complete with all of its relationships.
     *
     * @param guid of the KafkaTopic to retrieve
     * @return the requested full KafkaTopic, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the KafkaTopic does not exist or the provided GUID is not a KafkaTopic
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static KafkaTopic retrieveByGuid(String guid) throws AtlanException {
        return get(Atlan.getDefaultClient(), guid);
    }

    /**
     * Retrieves a KafkaTopic by its GUID, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param guid of the KafkaTopic to retrieve
     * @return the requested full KafkaTopic, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the KafkaTopic does not exist or the provided GUID is not a KafkaTopic
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static KafkaTopic retrieveByGuid(AtlanClient client, String guid) throws AtlanException {
        return get(client, guid);
    }

    /**
     * Retrieves a KafkaTopic by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the KafkaTopic to retrieve
     * @return the requested full KafkaTopic, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the KafkaTopic does not exist
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static KafkaTopic retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        return get(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Retrieves a KafkaTopic by its qualifiedName, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param qualifiedName of the KafkaTopic to retrieve
     * @return the requested full KafkaTopic, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the KafkaTopic does not exist
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static KafkaTopic retrieveByQualifiedName(AtlanClient client, String qualifiedName) throws AtlanException {
        return get(client, qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) KafkaTopic to active.
     *
     * @param qualifiedName for the KafkaTopic
     * @return true if the KafkaTopic is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return restore(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) KafkaTopic to active.
     *
     * @param client connectivity to the Atlan tenant on which to restore the asset
     * @param qualifiedName for the KafkaTopic
     * @return true if the KafkaTopic is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(AtlanClient client, String qualifiedName) throws AtlanException {
        return Asset.restore(client, TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a KafkaTopic.
     *
     * @param qualifiedName of the KafkaTopic
     * @param name of the KafkaTopic
     * @return the minimal request necessary to update the KafkaTopic, as a builder
     */
    public static KafkaTopicBuilder<?, ?> updater(String qualifiedName, String name) {
        return KafkaTopic._internal()
                .guid("-" + ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE - 1))
                .qualifiedName(qualifiedName)
                .name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a KafkaTopic, from a potentially
     * more-complete KafkaTopic object.
     *
     * @return the minimal object necessary to update the KafkaTopic, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for KafkaTopic are not found in the initial object
     */
    @Override
    public KafkaTopicBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "KafkaTopic", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a KafkaTopic.
     *
     * @param qualifiedName of the KafkaTopic
     * @param name of the KafkaTopic
     * @return the updated KafkaTopic, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic removeDescription(String qualifiedName, String name) throws AtlanException {
        return removeDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the system description from a KafkaTopic.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the KafkaTopic
     * @param name of the KafkaTopic
     * @return the updated KafkaTopic, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic removeDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (KafkaTopic) Asset.removeDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a KafkaTopic.
     *
     * @param qualifiedName of the KafkaTopic
     * @param name of the KafkaTopic
     * @return the updated KafkaTopic, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return removeUserDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the user's description from a KafkaTopic.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the KafkaTopic
     * @param name of the KafkaTopic
     * @return the updated KafkaTopic, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic removeUserDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (KafkaTopic) Asset.removeUserDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a KafkaTopic.
     *
     * @param qualifiedName of the KafkaTopic
     * @param name of the KafkaTopic
     * @return the updated KafkaTopic, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic removeOwners(String qualifiedName, String name) throws AtlanException {
        return removeOwners(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the owners from a KafkaTopic.
     *
     * @param client connectivity to the Atlan tenant from which to remove the KafkaTopic's owners
     * @param qualifiedName of the KafkaTopic
     * @param name of the KafkaTopic
     * @return the updated KafkaTopic, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic removeOwners(AtlanClient client, String qualifiedName, String name) throws AtlanException {
        return (KafkaTopic) Asset.removeOwners(client, updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a KafkaTopic.
     *
     * @param qualifiedName of the KafkaTopic
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated KafkaTopic, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic updateCertificate(String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return updateCertificate(Atlan.getDefaultClient(), qualifiedName, certificate, message);
    }

    /**
     * Update the certificate on a KafkaTopic.
     *
     * @param client connectivity to the Atlan tenant on which to update the KafkaTopic's certificate
     * @param qualifiedName of the KafkaTopic
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated KafkaTopic, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic updateCertificate(
            AtlanClient client, String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (KafkaTopic)
                Asset.updateCertificate(client, _internal(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a KafkaTopic.
     *
     * @param qualifiedName of the KafkaTopic
     * @param name of the KafkaTopic
     * @return the updated KafkaTopic, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic removeCertificate(String qualifiedName, String name) throws AtlanException {
        return removeCertificate(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the certificate from a KafkaTopic.
     *
     * @param client connectivity to the Atlan tenant from which to remove the KafkaTopic's certificate
     * @param qualifiedName of the KafkaTopic
     * @param name of the KafkaTopic
     * @return the updated KafkaTopic, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic removeCertificate(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (KafkaTopic) Asset.removeCertificate(client, updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a KafkaTopic.
     *
     * @param qualifiedName of the KafkaTopic
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return updateAnnouncement(Atlan.getDefaultClient(), qualifiedName, type, title, message);
    }

    /**
     * Update the announcement on a KafkaTopic.
     *
     * @param client connectivity to the Atlan tenant on which to update the KafkaTopic's announcement
     * @param qualifiedName of the KafkaTopic
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic updateAnnouncement(
            AtlanClient client, String qualifiedName, AtlanAnnouncementType type, String title, String message)
            throws AtlanException {
        return (KafkaTopic)
                Asset.updateAnnouncement(client, _internal(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a KafkaTopic.
     *
     * @param qualifiedName of the KafkaTopic
     * @param name of the KafkaTopic
     * @return the updated KafkaTopic, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return removeAnnouncement(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the announcement from a KafkaTopic.
     *
     * @param client connectivity to the Atlan client from which to remove the KafkaTopic's announcement
     * @param qualifiedName of the KafkaTopic
     * @param name of the KafkaTopic
     * @return the updated KafkaTopic, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic removeAnnouncement(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (KafkaTopic) Asset.removeAnnouncement(client, updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the KafkaTopic.
     *
     * @param qualifiedName for the KafkaTopic
     * @param name human-readable name of the KafkaTopic
     * @param terms the list of terms to replace on the KafkaTopic, or null to remove all terms from the KafkaTopic
     * @return the KafkaTopic that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return replaceTerms(Atlan.getDefaultClient(), qualifiedName, name, terms);
    }

    /**
     * Replace the terms linked to the KafkaTopic.
     *
     * @param client connectivity to the Atlan tenant on which to replace the KafkaTopic's assigned terms
     * @param qualifiedName for the KafkaTopic
     * @param name human-readable name of the KafkaTopic
     * @param terms the list of terms to replace on the KafkaTopic, or null to remove all terms from the KafkaTopic
     * @return the KafkaTopic that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic replaceTerms(
            AtlanClient client, String qualifiedName, String name, List<IGlossaryTerm> terms) throws AtlanException {
        return (KafkaTopic) Asset.replaceTerms(client, updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the KafkaTopic, without replacing existing terms linked to the KafkaTopic.
     * Note: this operation must make two API calls — one to retrieve the KafkaTopic's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the KafkaTopic
     * @param terms the list of terms to append to the KafkaTopic
     * @return the KafkaTopic that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return appendTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Link additional terms to the KafkaTopic, without replacing existing terms linked to the KafkaTopic.
     * Note: this operation must make two API calls — one to retrieve the KafkaTopic's existing terms,
     * and a second to append the new terms.
     *
     * @param client connectivity to the Atlan tenant on which to append terms to the KafkaTopic
     * @param qualifiedName for the KafkaTopic
     * @param terms the list of terms to append to the KafkaTopic
     * @return the KafkaTopic that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic appendTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (KafkaTopic) Asset.appendTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a KafkaTopic, without replacing all existing terms linked to the KafkaTopic.
     * Note: this operation must make two API calls — one to retrieve the KafkaTopic's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the KafkaTopic
     * @param terms the list of terms to remove from the KafkaTopic, which must be referenced by GUID
     * @return the KafkaTopic that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return removeTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Remove terms from a KafkaTopic, without replacing all existing terms linked to the KafkaTopic.
     * Note: this operation must make two API calls — one to retrieve the KafkaTopic's existing terms,
     * and a second to remove the provided terms.
     *
     * @param client connectivity to the Atlan tenant from which to remove terms from the KafkaTopic
     * @param qualifiedName for the KafkaTopic
     * @param terms the list of terms to remove from the KafkaTopic, which must be referenced by GUID
     * @return the KafkaTopic that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static KafkaTopic removeTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (KafkaTopic) Asset.removeTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a KafkaTopic, without replacing existing Atlan tags linked to the KafkaTopic.
     * Note: this operation must make two API calls — one to retrieve the KafkaTopic's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the KafkaTopic
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated KafkaTopic
     */
    public static KafkaTopic appendAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        return appendAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a KafkaTopic, without replacing existing Atlan tags linked to the KafkaTopic.
     * Note: this operation must make two API calls — one to retrieve the KafkaTopic's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the KafkaTopic
     * @param qualifiedName of the KafkaTopic
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated KafkaTopic
     */
    public static KafkaTopic appendAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return (KafkaTopic) Asset.appendAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a KafkaTopic, without replacing existing Atlan tags linked to the KafkaTopic.
     * Note: this operation must make two API calls — one to retrieve the KafkaTopic's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the KafkaTopic
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated KafkaTopic
     */
    public static KafkaTopic appendAtlanTags(
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return appendAtlanTags(
                Atlan.getDefaultClient(),
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a KafkaTopic, without replacing existing Atlan tags linked to the KafkaTopic.
     * Note: this operation must make two API calls — one to retrieve the KafkaTopic's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the KafkaTopic
     * @param qualifiedName of the KafkaTopic
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated KafkaTopic
     */
    public static KafkaTopic appendAtlanTags(
            AtlanClient client,
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (KafkaTopic) Asset.appendAtlanTags(
                client,
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a KafkaTopic.
     *
     * @param qualifiedName of the KafkaTopic
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the KafkaTopic
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        addAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a KafkaTopic.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the KafkaTopic
     * @param qualifiedName of the KafkaTopic
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the KafkaTopic
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        Asset.addAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a KafkaTopic.
     *
     * @param qualifiedName of the KafkaTopic
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the KafkaTopic
     * @deprecated see {@link #appendAtlanTags(String, List, boolean, boolean, boolean)} instead
     */
    @Deprecated
    public static void addAtlanTags(
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        addAtlanTags(
                Atlan.getDefaultClient(),
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a KafkaTopic.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the KafkaTopic
     * @param qualifiedName of the KafkaTopic
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the KafkaTopic
     * @deprecated see {@link #appendAtlanTags(String, List, boolean, boolean, boolean)} instead
     */
    @Deprecated
    public static void addAtlanTags(
            AtlanClient client,
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        Asset.addAtlanTags(
                client,
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Remove an Atlan tag from a KafkaTopic.
     *
     * @param qualifiedName of the KafkaTopic
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the KafkaTopic
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        removeAtlanTag(Atlan.getDefaultClient(), qualifiedName, atlanTagName);
    }

    /**
     * Remove an Atlan tag from a KafkaTopic.
     *
     * @param client connectivity to the Atlan tenant from which to remove an Atlan tag from a KafkaTopic
     * @param qualifiedName of the KafkaTopic
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the KafkaTopic
     */
    public static void removeAtlanTag(AtlanClient client, String qualifiedName, String atlanTagName)
            throws AtlanException {
        Asset.removeAtlanTag(client, TYPE_NAME, qualifiedName, atlanTagName);
    }
}
