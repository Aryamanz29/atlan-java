/* SPDX-License-Identifier: Apache-2.0 */
package com.atlan.model;

import com.atlan.model.relations.Reference;
import java.util.List;
import java.util.Map;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Instance of a table in Atlan, with its detailed information.
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Table extends SQL {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "Table";

    /** Fixed typeName for tables. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Number of columns in this table. */
    @Attribute
    Long columnCount;

    /** Number of rows in this table. */
    @Attribute
    Long rowCount;

    /** Size of the table in bytes. */
    @Attribute
    Long sizeBytes;

    /** TBC */
    @Attribute
    String alias;

    /** Whether this table is temporary (true) or not (false). */
    @Attribute
    Boolean isTemporary;

    /** TBC */
    @Attribute
    Boolean isQueryPreview;

    /** Unused attributes. */
    transient Map<String, String> queryPreviewConfig;

    /** TBC */
    @Attribute
    String externalLocation;

    /** TBC */
    @Attribute
    String externalLocationRegion;

    /** TBC */
    @Attribute
    String externalLocationFormat;

    /** TBC */
    @Attribute
    Boolean isPartitioned;

    /** TBC */
    @Attribute
    String partitionStrategy;

    /** TBC */
    @Attribute
    Long partitionCount;

    /** TBC */
    @Attribute
    String partitionList;

    /** Schema in which this table exists. */
    @Attribute
    Reference atlanSchema;

    /** Columns that exist within this table. */
    @Singular
    @Attribute
    List<Reference> columns;

    /**
     * Builds the minimal object necessary to create a table.
     * To continue adding to the object, call {@link #toBuilder()} on the result and continue calling additional
     * methods to add metadata followed by {@link TableBuilder#build()}.
     *
     * @param name of the table
     * @param connectorName name of the connector (software / system) that hosts the table
     * @param schemaName name of schema in which this table exists
     * @param schemaQualifiedName unique name of the schema in which this table exists
     * @param databaseName name of database in which this table exists
     * @param databaseQualifiedName unique name of the database in which this table exists
     * @param connectionQualifiedName unique name of the specific instance of the software / system that hosts the table
     * @return the minimal request necessary to create the table
     */
    public static Table toCreate(
            String name,
            String connectorName,
            String schemaName,
            String schemaQualifiedName,
            String databaseName,
            String databaseQualifiedName,
            String connectionQualifiedName) {
        // TODO: can we simplify the argument list by just taking qualifiedNames and extracting the
        //  non-qualifiedNames from these?
        return Table.builder()
                .name(name)
                .qualifiedName(schemaQualifiedName + "/" + name)
                .connectorName(connectorName)
                .schemaName(schemaName)
                .schemaQualifiedName(schemaQualifiedName)
                .databaseName(databaseName)
                .databaseQualifiedName(databaseQualifiedName)
                .connectionQualifiedName(connectionQualifiedName)
                .build();
    }

    /**
     * Builds the minimal object necessary to update a table.
     * To continue adding to the object, call {@link #toBuilder()} on the result and continue calling additional
     * methods to add metadata followed by {@link TableBuilder#build()}.
     *
     * @param qualifiedName of the table
     * @param name of the table
     * @return the minimal request necessary to update the table
     */
    public static Table toUpdate(String qualifiedName, String name) {
        return Table.builder().qualifiedName(qualifiedName).name(name).build();
    }
}