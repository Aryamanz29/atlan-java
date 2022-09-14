/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.exception.AtlanException;
import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.AtlanCertificateStatus;
import com.atlan.model.enums.AtlanConnectorType;
import com.atlan.model.relations.GuidReference;
import com.atlan.model.relations.Reference;
import java.util.List;
import java.util.Set;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Instance of a database in Atlan, with its detailed information.
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Database extends SQL {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "Database";

    /** Fixed typeName for databases. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Number of schemas in this database. */
    @Attribute
    Integer schemaCount;

    /** Schemas that exist within this database. */
    @Singular
    @Attribute
    Set<Reference> schemas;

    /**
     * Builds the minimal object necessary to create a database.
     *
     * @param name of the database
     * @param connectionQualifiedName unique name of the specific instance of the software / system that hosts the database
     * @return the minimal request necessary to create the database, as a builder
     */
    public static DatabaseBuilder<?, ?> creator(String name, String connectionQualifiedName) {
        AtlanConnectorType connectorType =
                Connection.getConnectorTypeFromQualifiedName(connectionQualifiedName.split("/"));
        return Database.builder()
                .name(name)
                .qualifiedName(connectionQualifiedName + "/" + name)
                .connectorType(connectorType)
                .connectionQualifiedName(connectionQualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a database.
     *
     * @param qualifiedName of the database
     * @param name of the database
     * @return the minimal request necessary to update the database, as a builder
     */
    public static DatabaseBuilder<?, ?> updater(String qualifiedName, String name) {
        return Database.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a database, from a potentially
     * more-complete database object.
     *
     * @return the minimal object necessary to update the database, as a builder
     */
    @Override
    protected DatabaseBuilder<?, ?> trimToRequired() {
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Update the certificate on a database.
     *
     * @param qualifiedName of the database
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated database, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static Database updateCertificate(String qualifiedName, AtlanCertificateStatus certificate, String message)
            throws AtlanException {
        return (Database) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a database.
     *
     * @param qualifiedName of the database
     * @param name of the database
     * @return the updated database, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Database removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (Database)
                Asset.removeCertificate(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Update the announcement on a database.
     *
     * @param qualifiedName of the database
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static Database updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (Database) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a database.
     *
     * @param qualifiedName of the database
     * @param name of the database
     * @return the updated database, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Database removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (Database)
                Asset.removeAnnouncement(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Add classifications to a database.
     *
     * @param qualifiedName of the database
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the database
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a database.
     *
     * @param qualifiedName of the database
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the database
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }

    /**
     * Replace the terms linked to the database.
     *
     * @param qualifiedName for the database
     * @param name human-readable name of the database
     * @param terms the list of terms to replace on the database, or null to remove all terms from the database
     * @return the database that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static Database replaceTerms(String qualifiedName, String name, List<Reference> terms)
            throws AtlanException {
        return (Database) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the database, without replacing existing terms linked to the database.
     * Note: this operation must make two API calls — one to retrieve the database's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the database
     * @param terms the list of terms to append to the database
     * @return the database that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static Database appendTerms(String qualifiedName, List<Reference> terms) throws AtlanException {
        return (Database) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a database, without replacing all existing terms linked to the database.
     * Note: this operation must make two API calls — one to retrieve the database's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the database
     * @param terms the list of terms to remove from the database, which must be referenced by GUID
     * @return the database that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static Database removeTerms(String qualifiedName, List<GuidReference> terms) throws AtlanException {
        return (Database) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }
}