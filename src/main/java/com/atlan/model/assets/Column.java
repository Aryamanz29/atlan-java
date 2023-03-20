/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.exception.AtlanException;
import com.atlan.exception.ErrorCode;
import com.atlan.exception.InvalidRequestException;
import com.atlan.exception.NotFoundException;
import com.atlan.model.enums.*;
import com.atlan.model.relations.UniqueAttributes;
import com.atlan.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Instance of a column in Atlan.
 */
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@SuppressWarnings("cast")
public class Column extends SQL {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "Column";

    /** Fixed typeName for Columns. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Data type of values in the column. */
    @Attribute
    String dataType;

    /** TBC */
    @Attribute
    String subDataType;

    /** Order (position) in which the column appears in the table (starting at 1). */
    @Attribute
    Integer order;

    /** TBC */
    @Attribute
    Boolean isPartition;

    /** TBC */
    @Attribute
    Integer partitionOrder;

    /** TBC */
    @Attribute
    Boolean isClustered;

    /** When true, this column is the primary key for the table. */
    @Attribute
    Boolean isPrimary;

    /** When true, this column is a foreign key to another table. */
    @Attribute
    Boolean isForeign;

    /** When true, this column is indexed in the database. */
    @Attribute
    Boolean isIndexed;

    /** TBC */
    @Attribute
    Boolean isSort;

    /** TBC */
    @Attribute
    Boolean isDist;

    /** TBC */
    @Attribute
    Boolean isPinned;

    /** TBC */
    @Attribute
    String pinnedBy;

    /** TBC */
    @Attribute
    Long pinnedAt;

    /** Total number of digits allowed when the dataType is numeric. */
    @Attribute
    Integer precision;

    /** TBC */
    @Attribute
    String defaultValue;

    /** When true, the values in this column can be null. */
    @Attribute
    Boolean isNullable;

    /** Number of digits allowed to the right of the decimal point. */
    @Attribute
    Double numericScale;

    /** Maximum length of a value in this column. */
    @Attribute
    Long maxLength;

    /** TBC */
    @Attribute
    @Singular
    Map<String, String> validations;

    /** Number of rows that contain distinct values. */
    @Attribute
    Integer columnDistinctValuesCount;

    /** TBC */
    @Attribute
    Long columnDistinctValuesCountLong;

    /** List of values in a histogram that represents the contents of the column. */
    @Attribute
    Histogram columnHistogram;

    /** Greatest value in a numeric column. */
    @Attribute
    Double columnMax;

    /** Least value in a numeric column. */
    @Attribute
    Double columnMin;

    /** Arithmetic mean of the values in a numeric column. */
    @Attribute
    Double columnMean;

    /** Calculated sum of the values in a numeric column. */
    @Attribute
    Double columnSum;

    /** Calculated median of the values in a numeric column. */
    @Attribute
    Double columnMedian;

    /** Calculated standard deviation of the values in a numeric column. */
    @Attribute
    Double columnStandardDeviation;

    /** Number of rows in which a value in this column appears only once. */
    @Attribute
    Integer columnUniqueValuesCount;

    /** TBC */
    @Attribute
    Long columnUniqueValuesCountLong;

    /** TBC */
    @Attribute
    Double columnAverage;

    /** Average length of values in a string column. */
    @Attribute
    Double columnAverageLength;

    /** Number of rows that contain duplicate values. */
    @Attribute
    Integer columnDuplicateValuesCount;

    /** TBC */
    @Attribute
    Long columnDuplicateValuesCountLong;

    /** Length of the longest value in a string column. */
    @Attribute
    Integer columnMaximumStringLength;

    /** List of the greatest values in a column. */
    @Attribute
    SortedSet<String> columnMaxs;

    /** Length of the shortest value in a string column. */
    @Attribute
    Integer columnMinimumStringLength;

    /** List of the least values in a column. */
    @Attribute
    SortedSet<String> columnMins;

    /** Number of rows in a column that do not contain content. */
    @Attribute
    Integer columnMissingValuesCount;

    /** TBC */
    @Attribute
    Long columnMissingValuesCountLong;

    /** Percentage of rows in a column that do not contain content. */
    @Attribute
    Double columnMissingValuesPercentage;

    /** Ratio indicating how unique data in the column is: 0 indicates that all values are the same, 100 indicates that all values in the column are unique. */
    @Attribute
    Double columnUniquenessPercentage;

    /** Calculated variance of the values in a numeric column. */
    @Attribute
    Double columnVariance;

    /** TBC */
    @Attribute
    @Singular
    List<ColumnValueFrequencyMap> columnTopValues;

    /** Materialized view in which this column exists, or empty if the column instead exists in a table or view. */
    @Attribute
    @JsonProperty("materialisedView")
    MaterializedView materializedView;

    /** Queries that involve this column. */
    @Attribute
    @Singular
    SortedSet<AtlanQuery> queries;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<Metric> metricTimestamps;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<DbtMetric> dbtMetrics;

    /** View in which this column exists, or empty if the column instead exists in a table or materialized view. */
    @Attribute
    View view;

    /** TBC */
    @Attribute
    TablePartition tablePartition;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<Metric> dataQualityMetricDimensions;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<DbtModelColumn> dbtModelColumns;

    /** Table in which this column exists, or empty if the column instead exists in a view or materialized view. */
    @Attribute
    Table table;

    /**
     * Retrieve the parent of this column, irrespective of its type.
     * @return the reference to this column's parent
     */
    public SQL getParent() {
        if (table != null) {
            return table;
        } else if (view != null) {
            return view;
        } else if (materializedView != null) {
            return materializedView;
        }
        return null;
    }

    /**
     * Reference to a Column by GUID.
     *
     * @param guid the GUID of the Column to reference
     * @return reference to a Column that can be used for defining a relationship to a Column
     */
    public static Column refByGuid(String guid) {
        return Column.builder().guid(guid).build();
    }

    /**
     * Reference to a Column by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the Column to reference
     * @return reference to a Column that can be used for defining a relationship to a Column
     */
    public static Column refByQualifiedName(String qualifiedName) {
        return Column.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Builds the minimal object necessary to create a column.
     *
     * @param name of the column
     * @param parentType type of parent (table, view, materialized view), should be a TYPE_NAME static string
     * @param parentQualifiedName unique name of the table / view / materialized view in which this column exists
     * @param order the order the column appears within its parent (the column's position)
     * @return the minimal request necessary to create the column, as a builder
     */
    public static ColumnBuilder<?, ?> creator(String name, String parentType, String parentQualifiedName, int order) {
        String[] tokens = parentQualifiedName.split("/");
        AtlanConnectorType connectorType = Connection.getConnectorTypeFromQualifiedName(tokens);
        String parentName = StringUtils.getNameFromQualifiedName(parentQualifiedName);
        String schemaQualifiedName = StringUtils.getParentQualifiedNameFromQualifiedName(parentQualifiedName);
        String schemaName = StringUtils.getNameFromQualifiedName(schemaQualifiedName);
        String databaseQualifiedName = StringUtils.getParentQualifiedNameFromQualifiedName(schemaQualifiedName);
        String databaseName = StringUtils.getNameFromQualifiedName(databaseQualifiedName);
        String connectionQualifiedName = StringUtils.getParentQualifiedNameFromQualifiedName(databaseQualifiedName);
        ColumnBuilder<?, ?> builder = Column.builder()
                .name(name)
                .qualifiedName(generateQualifiedName(name, parentQualifiedName))
                .connectorType(connectorType)
                .schemaName(schemaName)
                .schemaQualifiedName(schemaQualifiedName)
                .databaseName(databaseName)
                .databaseQualifiedName(databaseQualifiedName)
                .connectionQualifiedName(connectionQualifiedName)
                .order(order);
        switch (parentType) {
            case Table.TYPE_NAME:
                builder.tableName(parentName)
                        .tableQualifiedName(parentQualifiedName)
                        .table(Table.refByQualifiedName(parentQualifiedName));
                break;
            case View.TYPE_NAME:
                builder.viewName(parentName)
                        .viewQualifiedName(parentQualifiedName)
                        .view(View.refByQualifiedName(parentQualifiedName));
                break;
            case MaterializedView.TYPE_NAME:
                builder.viewName(parentName)
                        .viewQualifiedName(parentQualifiedName)
                        .materializedView(MaterializedView.refByQualifiedName(parentQualifiedName));
                break;
        }
        return builder;
    }

    /**
     * Generate a unique column name.
     *
     * @param name of the column
     * @param parentQualifiedName unique name of the container in which this column exists
     * @return a unique name for the column
     */
    public static String generateQualifiedName(String name, String parentQualifiedName) {
        return parentQualifiedName + "/" + name;
    }

    /**
     * Builds the minimal object necessary to update a Column.
     *
     * @param qualifiedName of the Column
     * @param name of the Column
     * @return the minimal request necessary to update the Column, as a builder
     */
    public static ColumnBuilder<?, ?> updater(String qualifiedName, String name) {
        return Column.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a Column, from a potentially
     * more-complete Column object.
     *
     * @return the minimal object necessary to update the Column, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for Column are not found in the initial object
     */
    @Override
    public ColumnBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "Column", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Retrieves a Column by its GUID, complete with all of its relationships.
     *
     * @param guid of the Column to retrieve
     * @return the requested full Column, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the Column does not exist or the provided GUID is not a Column
     */
    public static Column retrieveByGuid(String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof Column) {
            return (Column) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "Column");
        }
    }

    /**
     * Retrieves a Column by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the Column to retrieve
     * @return the requested full Column, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the Column does not exist
     */
    public static Column retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(TYPE_NAME, qualifiedName);
        if (asset instanceof Column) {
            return (Column) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "Column");
        }
    }

    /**
     * Restore the archived (soft-deleted) Column to active.
     *
     * @param qualifiedName for the Column
     * @return true if the Column is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return Asset.restore(TYPE_NAME, qualifiedName);
    }

    /**
     * Remove the system description from a Column.
     *
     * @param qualifiedName of the Column
     * @param name of the Column
     * @return the updated Column, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Column removeDescription(String qualifiedName, String name) throws AtlanException {
        return (Column) Asset.removeDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a Column.
     *
     * @param qualifiedName of the Column
     * @param name of the Column
     * @return the updated Column, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Column removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return (Column) Asset.removeUserDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a Column.
     *
     * @param qualifiedName of the Column
     * @param name of the Column
     * @return the updated Column, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Column removeOwners(String qualifiedName, String name) throws AtlanException {
        return (Column) Asset.removeOwners(updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a Column.
     *
     * @param qualifiedName of the Column
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated Column, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static Column updateCertificate(String qualifiedName, AtlanCertificateStatus certificate, String message)
            throws AtlanException {
        return (Column) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a Column.
     *
     * @param qualifiedName of the Column
     * @param name of the Column
     * @return the updated Column, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Column removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (Column) Asset.removeCertificate(updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a Column.
     *
     * @param qualifiedName of the Column
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static Column updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (Column) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a Column.
     *
     * @param qualifiedName of the Column
     * @param name of the Column
     * @return the updated Column, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Column removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (Column) Asset.removeAnnouncement(updater(qualifiedName, name));
    }

    /**
     * Add classifications to a Column.
     *
     * @param qualifiedName of the Column
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the Column
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a Column.
     *
     * @param qualifiedName of the Column
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the Column
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }

    /**
     * Replace the terms linked to the Column.
     *
     * @param qualifiedName for the Column
     * @param name human-readable name of the Column
     * @param terms the list of terms to replace on the Column, or null to remove all terms from the Column
     * @return the Column that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static Column replaceTerms(String qualifiedName, String name, List<GlossaryTerm> terms)
            throws AtlanException {
        return (Column) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the Column, without replacing existing terms linked to the Column.
     * Note: this operation must make two API calls — one to retrieve the Column's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the Column
     * @param terms the list of terms to append to the Column
     * @return the Column that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static Column appendTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (Column) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a Column, without replacing all existing terms linked to the Column.
     * Note: this operation must make two API calls — one to retrieve the Column's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the Column
     * @param terms the list of terms to remove from the Column, which must be referenced by GUID
     * @return the Column that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static Column removeTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (Column) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }
}
