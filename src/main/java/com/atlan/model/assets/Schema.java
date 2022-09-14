/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.exception.AtlanException;
import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.AtlanCertificateStatus;
import com.atlan.model.enums.AtlanConnectorType;
import com.atlan.model.relations.GuidReference;
import com.atlan.model.relations.Reference;
import com.atlan.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Set;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Instance of a schema in Atlan, with its detailed information.
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Schema extends SQL {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "Schema";

    /** Fixed typeName for schemas. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Number of tables in this schema. */
    @Attribute
    Integer tableCount;

    /** Number of views in this schema. */
    @Attribute
    @JsonProperty("viewsCount")
    Integer viewCount;

    /** Database in which this schema exists. */
    @Attribute
    Reference database;

    /** Tables that exist within this schema. */
    @Singular
    @Attribute
    Set<Reference> tables;

    /** Views that exist within this schema. */
    @Singular
    @Attribute
    Set<Reference> views;

    /** Materialized views that exist within this schema. */
    @Singular
    @JsonProperty("materialisedViews")
    @Attribute
    Set<Reference> materializedViews;

    /**
     * Builds the minimal object necessary to create a schema.
     *
     * @param name of the schema
     * @param databaseQualifiedName unique name of the database in which this schema exists
     * @return the minimal request necessary to create the schema, as a builder
     */
    public static SchemaBuilder<?, ?> creator(String name, String databaseQualifiedName) {
        String[] tokens = databaseQualifiedName.split("/");
        AtlanConnectorType connectorType = Connection.getConnectorTypeFromQualifiedName(tokens);
        String databaseName = StringUtils.getNameFromQualifiedName(databaseQualifiedName);
        String connectionQualifiedName = StringUtils.getParentQualifiedNameFromQualifiedName(databaseQualifiedName);
        return Schema.builder()
                .name(name)
                .qualifiedName(databaseQualifiedName + "/" + name)
                .connectorType(connectorType)
                .databaseName(databaseName)
                .databaseQualifiedName(databaseQualifiedName)
                .database(Reference.by(Database.TYPE_NAME, databaseQualifiedName))
                .connectionQualifiedName(connectionQualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a schema.
     *
     * @param qualifiedName of the schema
     * @param name of the schema
     * @return the minimal request necessary to update the schema, as a builder
     */
    public static SchemaBuilder<?, ?> updater(String qualifiedName, String name) {
        return Schema.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a schema, from a potentially
     * more-complete schema object.
     *
     * @return the minimal object necessary to update the schema, as a builder
     */
    @Override
    protected SchemaBuilder<?, ?> trimToRequired() {
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Update the certificate on a schema.
     *
     * @param qualifiedName of the schema
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated schema, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static Schema updateCertificate(String qualifiedName, AtlanCertificateStatus certificate, String message)
            throws AtlanException {
        return (Schema) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a schema.
     *
     * @param qualifiedName of the schema
     * @param name of the schema
     * @return the updated schema, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Schema removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (Schema)
                Asset.removeCertificate(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Update the announcement on a schema.
     *
     * @param qualifiedName of the schema
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static Schema updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (Schema) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a schema.
     *
     * @param qualifiedName of the schema
     * @param name of the schema
     * @return the updated schema, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Schema removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (Schema)
                Asset.removeAnnouncement(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Add classifications to a schema.
     *
     * @param qualifiedName of the schema
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the schema
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a schema.
     *
     * @param qualifiedName of the schema
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the schema
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }

    /**
     * Replace the terms linked to the schema.
     *
     * @param qualifiedName for the schema
     * @param name human-readable name of the schema
     * @param terms the list of terms to replace on the schema, or null to remove all terms from the schema
     * @return the schema that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static Schema replaceTerms(String qualifiedName, String name, List<Reference> terms) throws AtlanException {
        return (Schema) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the schema, without replacing existing terms linked to the schema.
     * Note: this operation must make two API calls — one to retrieve the schema's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the schema
     * @param terms the list of terms to append to the schema
     * @return the schema that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static Schema appendTerms(String qualifiedName, List<Reference> terms) throws AtlanException {
        return (Schema) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a schema, without replacing all existing terms linked to the schema.
     * Note: this operation must make two API calls — one to retrieve the schema's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the schema
     * @param terms the list of terms to remove from the schema, which must be referenced by GUID
     * @return the schema that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static Schema removeTerms(String qualifiedName, List<GuidReference> terms) throws AtlanException {
        return (Schema) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }
}