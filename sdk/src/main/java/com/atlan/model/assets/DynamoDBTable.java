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
import com.atlan.model.enums.DynamoDBStatus;
import com.atlan.model.relations.UniqueAttributes;
import com.atlan.model.search.CompoundQuery;
import com.atlan.model.search.FluentSearch;
import com.atlan.util.QueryFactory;
import com.atlan.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Atlan DynamoDB Table Asset
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true, builderMethodName = "_internal")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
@SuppressWarnings("cast")
public class DynamoDBTable extends Asset
        implements IDynamoDBTable, ITable, IDynamoDB, ISQL, ICatalog, IAsset, IReferenceable, INoSQL {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "DynamoDBTable";

    /** Fixed typeName for DynamoDBTables. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Alias for this table. */
    @Attribute
    String alias;

    /** Number of columns in this table. */
    @Attribute
    Long columnCount;

    /** Columns that exist within this table. */
    @Attribute
    @Singular
    SortedSet<IColumn> columns;

    /** Simple name of the database in which this SQL asset exists, or empty if it does not exist within a database. */
    @Attribute
    String databaseName;

    /** Unique name of the database in which this SQL asset exists, or empty if it does not exist within a database. */
    @Attribute
    String databaseQualifiedName;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IDbtModel> dbtModels;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IDbtSource> dbtSources;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IDbtTest> dbtTests;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ITable> dimensions;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IDynamoDBGlobalSecondaryIndex> dynamoDBGlobalSecondaryIndexes;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IDynamoDBLocalSecondaryIndex> dynamoDBLocalSecondaryIndexes;

    /** Specifies the partition key of the DynamoDB Table/Index */
    @Attribute
    String dynamoDBPartitionKey;

    /** The maximum number of strongly consistent reads consumed per second before DynamoDB returns a ThrottlingException */
    @Attribute
    Long dynamoDBReadCapacityUnits;

    /** Specifies the sort key of the DynamoDB Table/Index */
    @Attribute
    String dynamoDBSortKey;

    /** Status of the DynamoDB Asset */
    @Attribute
    DynamoDBStatus dynamoDBStatus;

    /** Represents the number of global secondary indexes on the table. */
    @Attribute
    Integer dynamoDBTableGSICount;

    /** Represents the number of local secondary indexes on the table. */
    @Attribute
    Integer dynamoDBTableLSICount;

    /** The maximum number of writes consumed per second before DynamoDB returns a ThrottlingException */
    @Attribute
    Long dynamoDBWriteCapacityUnits;

    /** External location of this table, for example: an S3 object location. */
    @Attribute
    String externalLocation;

    /** Format of the external location of this table, for example: JSON, CSV, PARQUET, etc. */
    @Attribute
    String externalLocationFormat;

    /** Region of the external location of this table, for example: S3 region. */
    @Attribute
    String externalLocationRegion;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ITable> facts;

    /** Tasks to which this asset provides input. */
    @Attribute
    @Singular
    SortedSet<IAirflowTask> inputToAirflowTasks;

    /** Processes to which this asset provides input. */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** Whether this table is partitioned (true) or not (false). */
    @Attribute
    Boolean isPartitioned;

    /** Whether this asset has been profiled (true) or not (false). */
    @Attribute
    Boolean isProfiled;

    /** Whether preview queries are allowed for this table (true) or not (false). */
    @Attribute
    Boolean isQueryPreview;

    /** Whether this table is temporary (true) or not (false). */
    @Attribute
    Boolean isTemporary;

    /** Time (epoch) at which this asset was last profiled, in milliseconds. */
    @Attribute
    Long lastProfiledAt;

    /** Represents attributes for describing the key schema for the table and indexes. */
    @Attribute
    String noSQLSchemaDefinition;

    /** Tasks from which this asset is output. */
    @Attribute
    @Singular
    SortedSet<IAirflowTask> outputFromAirflowTasks;

    /** Processes from which this asset is produced as output. */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;

    /** Number of partitions in this table. */
    @Attribute
    Long partitionCount;

    /** List of partitions in this table. */
    @Attribute
    String partitionList;

    /** Partition strategy for this table. */
    @Attribute
    String partitionStrategy;

    /** Partitions that exist within this table. */
    @Attribute
    @Singular
    SortedSet<ITablePartition> partitions;

    /** Queries that access this table. */
    @Attribute
    @Singular
    SortedSet<IAtlanQuery> queries;

    /** Number of times this asset has been queried. */
    @Attribute
    Long queryCount;

    /** Time (epoch) at which the query count was last updated, in milliseconds. */
    @Attribute
    Long queryCountUpdatedAt;

    /** Configuration for preview queries. */
    @Attribute
    @Singular("putQueryPreviewConfig")
    Map<String, String> queryPreviewConfig;

    /** Number of unique users who have queried this asset. */
    @Attribute
    Long queryUserCount;

    /** Map of unique users who have queried this asset to the number of times they have queried it. */
    @Attribute
    @Singular("putQueryUserMap")
    Map<String, Long> queryUserMap;

    /** Number of rows in this table. */
    @Attribute
    Long rowCount;

    /** Schema in which this table exists. */
    @Attribute
    @JsonProperty("atlanSchema")
    ISchema schema;

    /** Simple name of the schema in which this SQL asset exists, or empty if it does not exist within a schema. */
    @Attribute
    String schemaName;

    /** Unique name of the schema in which this SQL asset exists, or empty if it does not exist within a schema. */
    @Attribute
    String schemaQualifiedName;

    /** Size of this table, in bytes. */
    @Attribute
    Long sizeBytes;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IDbtSource> sqlDBTSources;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IDbtModel> sqlDbtModels;

    /** Simple name of the table in which this SQL asset exists, or empty if it does not exist within a table. */
    @Attribute
    String tableName;

    /** Unique name of the table in which this SQL asset exists, or empty if it does not exist within a table. */
    @Attribute
    String tableQualifiedName;

    /** Simple name of the view in which this SQL asset exists, or empty if it does not exist within a view. */
    @Attribute
    String viewName;

    /** Unique name of the view in which this SQL asset exists, or empty if it does not exist within a view. */
    @Attribute
    String viewQualifiedName;

    /**
     * Builds the minimal object necessary to create a relationship to a DynamoDBTable, from a potentially
     * more-complete DynamoDBTable object.
     *
     * @return the minimal object necessary to relate to the DynamoDBTable
     * @throws InvalidRequestException if any of the minimal set of required properties for a DynamoDBTable relationship are not found in the initial object
     */
    @Override
    public DynamoDBTable trimToReference() throws InvalidRequestException {
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
     * Start a fluent search that will return all DynamoDBTable assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) DynamoDBTable assets will be included.
     *
     * @return a fluent search that includes all DynamoDBTable assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select() {
        return select(Atlan.getDefaultClient());
    }

    /**
     * Start a fluent search that will return all DynamoDBTable assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) DynamoDBTable assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return a fluent search that includes all DynamoDBTable assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(AtlanClient client) {
        return select(client, false);
    }

    /**
     * Start a fluent search that will return all DynamoDBTable assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) DynamoDBTables will be included
     * @return a fluent search that includes all DynamoDBTable assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(boolean includeArchived) {
        return select(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start a fluent search that will return all DynamoDBTable assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) DynamoDBTables will be included
     * @return a fluent search that includes all DynamoDBTable assets
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
     * Start an asset filter that will return all DynamoDBTable assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) DynamoDBTable assets will be included.
     *
     * @return an asset filter that includes all DynamoDBTable assets
     * @deprecated replaced by {@link #select()}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all() {
        return all(Atlan.getDefaultClient());
    }

    /**
     * Start an asset filter that will return all DynamoDBTable assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) DynamoDBTable assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return an asset filter that includes all DynamoDBTable assets
     * @deprecated replaced by {@link #select(AtlanClient)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(AtlanClient client) {
        return all(client, false);
    }

    /**
     * Start an asset filter that will return all DynamoDBTable assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) DynamoDBTables will be included
     * @return an asset filter that includes all DynamoDBTable assets
     * @deprecated replaced by {@link #select(boolean)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(boolean includeArchived) {
        return all(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start an asset filter that will return all DynamoDBTable assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) DynamoDBTables will be included
     * @return an asset filter that includes all DynamoDBTable assets
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
     * Reference to a DynamoDBTable by GUID.
     *
     * @param guid the GUID of the DynamoDBTable to reference
     * @return reference to a DynamoDBTable that can be used for defining a relationship to a DynamoDBTable
     */
    public static DynamoDBTable refByGuid(String guid) {
        return DynamoDBTable._internal().guid(guid).build();
    }

    /**
     * Reference to a DynamoDBTable by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the DynamoDBTable to reference
     * @return reference to a DynamoDBTable that can be used for defining a relationship to a DynamoDBTable
     */
    public static DynamoDBTable refByQualifiedName(String qualifiedName) {
        return DynamoDBTable._internal()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a DynamoDBTable by one of its identifiers, complete with all of its relationships.
     *
     * @param id of the DynamoDBTable to retrieve, either its GUID or its full qualifiedName
     * @return the requested full DynamoDBTable, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the DynamoDBTable does not exist or the provided GUID is not a DynamoDBTable
     */
    @JsonIgnore
    public static DynamoDBTable get(String id) throws AtlanException {
        return get(Atlan.getDefaultClient(), id);
    }

    /**
     * Retrieves a DynamoDBTable by one of its identifiers, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the DynamoDBTable to retrieve, either its GUID or its full qualifiedName
     * @return the requested full DynamoDBTable, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the DynamoDBTable does not exist or the provided GUID is not a DynamoDBTable
     */
    @JsonIgnore
    public static DynamoDBTable get(AtlanClient client, String id) throws AtlanException {
        return get(client, id, true);
    }

    /**
     * Retrieves a DynamoDBTable by one of its identifiers, optionally complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the DynamoDBTable to retrieve, either its GUID or its full qualifiedName
     * @param includeRelationships if true, all of the asset's relationships will also be retrieved; if false, no relationships will be retrieved
     * @return the requested full DynamoDBTable, optionally complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the DynamoDBTable does not exist or the provided GUID is not a DynamoDBTable
     */
    @JsonIgnore
    public static DynamoDBTable get(AtlanClient client, String id, boolean includeRelationships) throws AtlanException {
        if (id == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, "(null)");
        } else if (StringUtils.isUUID(id)) {
            Asset asset = Asset.get(client, id, includeRelationships);
            if (asset == null) {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, id);
            } else if (asset instanceof DynamoDBTable) {
                return (DynamoDBTable) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, id, TYPE_NAME);
            }
        } else {
            Asset asset = Asset.get(client, TYPE_NAME, id, includeRelationships);
            if (asset instanceof DynamoDBTable) {
                return (DynamoDBTable) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, id, TYPE_NAME);
            }
        }
    }

    /**
     * Retrieves a DynamoDBTable by its GUID, complete with all of its relationships.
     *
     * @param guid of the DynamoDBTable to retrieve
     * @return the requested full DynamoDBTable, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the DynamoDBTable does not exist or the provided GUID is not a DynamoDBTable
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static DynamoDBTable retrieveByGuid(String guid) throws AtlanException {
        return get(Atlan.getDefaultClient(), guid);
    }

    /**
     * Retrieves a DynamoDBTable by its GUID, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param guid of the DynamoDBTable to retrieve
     * @return the requested full DynamoDBTable, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the DynamoDBTable does not exist or the provided GUID is not a DynamoDBTable
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static DynamoDBTable retrieveByGuid(AtlanClient client, String guid) throws AtlanException {
        return get(client, guid);
    }

    /**
     * Retrieves a DynamoDBTable by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the DynamoDBTable to retrieve
     * @return the requested full DynamoDBTable, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the DynamoDBTable does not exist
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static DynamoDBTable retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        return get(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Retrieves a DynamoDBTable by its qualifiedName, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param qualifiedName of the DynamoDBTable to retrieve
     * @return the requested full DynamoDBTable, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the DynamoDBTable does not exist
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static DynamoDBTable retrieveByQualifiedName(AtlanClient client, String qualifiedName)
            throws AtlanException {
        return get(client, qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) DynamoDBTable to active.
     *
     * @param qualifiedName for the DynamoDBTable
     * @return true if the DynamoDBTable is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return restore(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) DynamoDBTable to active.
     *
     * @param client connectivity to the Atlan tenant on which to restore the asset
     * @param qualifiedName for the DynamoDBTable
     * @return true if the DynamoDBTable is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(AtlanClient client, String qualifiedName) throws AtlanException {
        return Asset.restore(client, TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a DynamoDBTable.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param name of the DynamoDBTable
     * @return the minimal request necessary to update the DynamoDBTable, as a builder
     */
    public static DynamoDBTableBuilder<?, ?> updater(String qualifiedName, String name) {
        return DynamoDBTable._internal()
                .guid("-" + ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE - 1))
                .qualifiedName(qualifiedName)
                .name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a DynamoDBTable, from a potentially
     * more-complete DynamoDBTable object.
     *
     * @return the minimal object necessary to update the DynamoDBTable, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for DynamoDBTable are not found in the initial object
     */
    @Override
    public DynamoDBTableBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "DynamoDBTable", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a DynamoDBTable.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param name of the DynamoDBTable
     * @return the updated DynamoDBTable, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable removeDescription(String qualifiedName, String name) throws AtlanException {
        return removeDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the system description from a DynamoDBTable.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the DynamoDBTable
     * @param name of the DynamoDBTable
     * @return the updated DynamoDBTable, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable removeDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (DynamoDBTable) Asset.removeDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a DynamoDBTable.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param name of the DynamoDBTable
     * @return the updated DynamoDBTable, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return removeUserDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the user's description from a DynamoDBTable.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the DynamoDBTable
     * @param name of the DynamoDBTable
     * @return the updated DynamoDBTable, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable removeUserDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (DynamoDBTable) Asset.removeUserDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a DynamoDBTable.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param name of the DynamoDBTable
     * @return the updated DynamoDBTable, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable removeOwners(String qualifiedName, String name) throws AtlanException {
        return removeOwners(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the owners from a DynamoDBTable.
     *
     * @param client connectivity to the Atlan tenant from which to remove the DynamoDBTable's owners
     * @param qualifiedName of the DynamoDBTable
     * @param name of the DynamoDBTable
     * @return the updated DynamoDBTable, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable removeOwners(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (DynamoDBTable) Asset.removeOwners(client, updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a DynamoDBTable.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated DynamoDBTable, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable updateCertificate(String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return updateCertificate(Atlan.getDefaultClient(), qualifiedName, certificate, message);
    }

    /**
     * Update the certificate on a DynamoDBTable.
     *
     * @param client connectivity to the Atlan tenant on which to update the DynamoDBTable's certificate
     * @param qualifiedName of the DynamoDBTable
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated DynamoDBTable, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable updateCertificate(
            AtlanClient client, String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (DynamoDBTable)
                Asset.updateCertificate(client, _internal(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a DynamoDBTable.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param name of the DynamoDBTable
     * @return the updated DynamoDBTable, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable removeCertificate(String qualifiedName, String name) throws AtlanException {
        return removeCertificate(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the certificate from a DynamoDBTable.
     *
     * @param client connectivity to the Atlan tenant from which to remove the DynamoDBTable's certificate
     * @param qualifiedName of the DynamoDBTable
     * @param name of the DynamoDBTable
     * @return the updated DynamoDBTable, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable removeCertificate(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (DynamoDBTable) Asset.removeCertificate(client, updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a DynamoDBTable.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return updateAnnouncement(Atlan.getDefaultClient(), qualifiedName, type, title, message);
    }

    /**
     * Update the announcement on a DynamoDBTable.
     *
     * @param client connectivity to the Atlan tenant on which to update the DynamoDBTable's announcement
     * @param qualifiedName of the DynamoDBTable
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable updateAnnouncement(
            AtlanClient client, String qualifiedName, AtlanAnnouncementType type, String title, String message)
            throws AtlanException {
        return (DynamoDBTable)
                Asset.updateAnnouncement(client, _internal(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a DynamoDBTable.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param name of the DynamoDBTable
     * @return the updated DynamoDBTable, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return removeAnnouncement(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the announcement from a DynamoDBTable.
     *
     * @param client connectivity to the Atlan client from which to remove the DynamoDBTable's announcement
     * @param qualifiedName of the DynamoDBTable
     * @param name of the DynamoDBTable
     * @return the updated DynamoDBTable, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable removeAnnouncement(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (DynamoDBTable) Asset.removeAnnouncement(client, updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the DynamoDBTable.
     *
     * @param qualifiedName for the DynamoDBTable
     * @param name human-readable name of the DynamoDBTable
     * @param terms the list of terms to replace on the DynamoDBTable, or null to remove all terms from the DynamoDBTable
     * @return the DynamoDBTable that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return replaceTerms(Atlan.getDefaultClient(), qualifiedName, name, terms);
    }

    /**
     * Replace the terms linked to the DynamoDBTable.
     *
     * @param client connectivity to the Atlan tenant on which to replace the DynamoDBTable's assigned terms
     * @param qualifiedName for the DynamoDBTable
     * @param name human-readable name of the DynamoDBTable
     * @param terms the list of terms to replace on the DynamoDBTable, or null to remove all terms from the DynamoDBTable
     * @return the DynamoDBTable that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable replaceTerms(
            AtlanClient client, String qualifiedName, String name, List<IGlossaryTerm> terms) throws AtlanException {
        return (DynamoDBTable) Asset.replaceTerms(client, updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the DynamoDBTable, without replacing existing terms linked to the DynamoDBTable.
     * Note: this operation must make two API calls — one to retrieve the DynamoDBTable's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the DynamoDBTable
     * @param terms the list of terms to append to the DynamoDBTable
     * @return the DynamoDBTable that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return appendTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Link additional terms to the DynamoDBTable, without replacing existing terms linked to the DynamoDBTable.
     * Note: this operation must make two API calls — one to retrieve the DynamoDBTable's existing terms,
     * and a second to append the new terms.
     *
     * @param client connectivity to the Atlan tenant on which to append terms to the DynamoDBTable
     * @param qualifiedName for the DynamoDBTable
     * @param terms the list of terms to append to the DynamoDBTable
     * @return the DynamoDBTable that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable appendTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (DynamoDBTable) Asset.appendTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a DynamoDBTable, without replacing all existing terms linked to the DynamoDBTable.
     * Note: this operation must make two API calls — one to retrieve the DynamoDBTable's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the DynamoDBTable
     * @param terms the list of terms to remove from the DynamoDBTable, which must be referenced by GUID
     * @return the DynamoDBTable that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return removeTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Remove terms from a DynamoDBTable, without replacing all existing terms linked to the DynamoDBTable.
     * Note: this operation must make two API calls — one to retrieve the DynamoDBTable's existing terms,
     * and a second to remove the provided terms.
     *
     * @param client connectivity to the Atlan tenant from which to remove terms from the DynamoDBTable
     * @param qualifiedName for the DynamoDBTable
     * @param terms the list of terms to remove from the DynamoDBTable, which must be referenced by GUID
     * @return the DynamoDBTable that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static DynamoDBTable removeTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (DynamoDBTable) Asset.removeTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a DynamoDBTable, without replacing existing Atlan tags linked to the DynamoDBTable.
     * Note: this operation must make two API calls — one to retrieve the DynamoDBTable's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated DynamoDBTable
     */
    public static DynamoDBTable appendAtlanTags(String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return appendAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a DynamoDBTable, without replacing existing Atlan tags linked to the DynamoDBTable.
     * Note: this operation must make two API calls — one to retrieve the DynamoDBTable's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the DynamoDBTable
     * @param qualifiedName of the DynamoDBTable
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated DynamoDBTable
     */
    public static DynamoDBTable appendAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return (DynamoDBTable) Asset.appendAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a DynamoDBTable, without replacing existing Atlan tags linked to the DynamoDBTable.
     * Note: this operation must make two API calls — one to retrieve the DynamoDBTable's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated DynamoDBTable
     */
    public static DynamoDBTable appendAtlanTags(
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
     * Add Atlan tags to a DynamoDBTable, without replacing existing Atlan tags linked to the DynamoDBTable.
     * Note: this operation must make two API calls — one to retrieve the DynamoDBTable's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the DynamoDBTable
     * @param qualifiedName of the DynamoDBTable
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated DynamoDBTable
     */
    public static DynamoDBTable appendAtlanTags(
            AtlanClient client,
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (DynamoDBTable) Asset.appendAtlanTags(
                client,
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a DynamoDBTable.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the DynamoDBTable
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        addAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a DynamoDBTable.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the DynamoDBTable
     * @param qualifiedName of the DynamoDBTable
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the DynamoDBTable
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        Asset.addAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a DynamoDBTable.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the DynamoDBTable
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
     * Add Atlan tags to a DynamoDBTable.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the DynamoDBTable
     * @param qualifiedName of the DynamoDBTable
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the DynamoDBTable
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
     * Remove an Atlan tag from a DynamoDBTable.
     *
     * @param qualifiedName of the DynamoDBTable
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the DynamoDBTable
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        removeAtlanTag(Atlan.getDefaultClient(), qualifiedName, atlanTagName);
    }

    /**
     * Remove an Atlan tag from a DynamoDBTable.
     *
     * @param client connectivity to the Atlan tenant from which to remove an Atlan tag from a DynamoDBTable
     * @param qualifiedName of the DynamoDBTable
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the DynamoDBTable
     */
    public static void removeAtlanTag(AtlanClient client, String qualifiedName, String atlanTagName)
            throws AtlanException {
        Asset.removeAtlanTag(client, TYPE_NAME, qualifiedName, atlanTagName);
    }
}
