/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.exception.AtlanException;
import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.AtlanCertificateStatus;
import com.atlan.model.relations.GuidReference;
import com.atlan.model.relations.Reference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Instance of a view in Atlan, with its detailed information.
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class View extends SQL {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "View";

    /** Fixed typeName for views. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Number of columns in this view. */
    @Attribute
    Long columnCount;

    /** Number of rows in this view. */
    @Attribute
    Long rowCount;

    /** Size of the view in bytes. */
    @Attribute
    Long sizeBytes;

    /** TBC */
    @Attribute
    String alias;

    /** Whether this view is temporary (true) or not (false). */
    @Attribute
    Boolean isTemporary;

    /** TBC */
    @Attribute
    Boolean isQueryPreview;

    /** Unused attributes. */
    @JsonIgnore
    Map<String, String> queryPreviewConfig;

    /** Definition of the view (DDL). */
    @Attribute
    String definition;

    /** Schema in which this view exists. */
    @Attribute
    @JsonProperty("atlanSchema")
    Reference schema;

    /** Columns that exist within this view. */
    @Singular
    @Attribute
    Set<Reference> columns;

    /**
     * Builds the minimal object necessary to create a view.
     *
     * @param name of the view
     * @param connectorName name of the connector (software / system) that hosts the view
     * @param schemaName name of schema in which this view exists
     * @param schemaQualifiedName unique name of the schema in which this view exists
     * @param databaseName name of database in which this view exists
     * @param databaseQualifiedName unique name of the database in which this view exists
     * @param connectionQualifiedName unique name of the specific instance of the software / system that hosts the view
     * @return the minimal request necessary to create the view, as a builder
     */
    public static ViewBuilder<?, ?> creator(
            String name,
            String connectorName,
            String schemaName,
            String schemaQualifiedName,
            String databaseName,
            String databaseQualifiedName,
            String connectionQualifiedName) {
        // TODO: can we simplify the argument list by just taking qualifiedNames and extracting the
        //  non-qualifiedNames from these?
        return View.builder()
                .name(name)
                .qualifiedName(schemaQualifiedName + "/" + name)
                .connectorName(connectorName)
                .schemaName(schemaName)
                .schemaQualifiedName(schemaQualifiedName)
                .schema(Reference.by(Schema.TYPE_NAME, schemaQualifiedName))
                .databaseName(databaseName)
                .databaseQualifiedName(databaseQualifiedName)
                .connectionQualifiedName(connectionQualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a view.
     *
     * @param qualifiedName of the view
     * @param name of the view
     * @return the minimal request necessary to update the view, as a builder
     */
    public static ViewBuilder<?, ?> updater(String qualifiedName, String name) {
        return View.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a view, from a potentially
     * more-complete view object.
     *
     * @return the minimal object necessary to update the view, as a builder
     */
    @Override
    protected ViewBuilder<?, ?> trimToRequired() {
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Update the certificate on a view.
     *
     * @param qualifiedName of the view
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated view, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static View updateCertificate(String qualifiedName, AtlanCertificateStatus certificate, String message)
            throws AtlanException {
        return (View) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a view.
     *
     * @param qualifiedName of the view
     * @param name of the view
     * @return the updated view, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static View removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (View)
                Asset.removeCertificate(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Update the announcement on a view.
     *
     * @param qualifiedName of the view
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static View updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (View) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a view.
     *
     * @param qualifiedName of the view
     * @param name of the view
     * @return the updated view, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static View removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (View)
                Asset.removeAnnouncement(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Add classifications to a view.
     *
     * @param qualifiedName of the view
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the view
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a view.
     *
     * @param qualifiedName of the view
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the view
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }

    /**
     * Replace the terms linked to the view.
     *
     * @param qualifiedName for the view
     * @param name human-readable name of the view
     * @param terms the list of terms to replace on the view, or null to remove all terms from the view
     * @return the view that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static View replaceTerms(String qualifiedName, String name, List<Reference> terms) throws AtlanException {
        return (View) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the view, without replacing existing terms linked to the view.
     * Note: this operation must make two API calls — one to retrieve the view's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the view
     * @param terms the list of terms to append to the view
     * @return the view that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static View appendTerms(String qualifiedName, List<Reference> terms) throws AtlanException {
        return (View) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a view, without replacing all existing terms linked to the view.
     * Note: this operation must make two API calls — one to retrieve the view's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the view
     * @param terms the list of terms to remove from the view, which must be referenced by GUID
     * @return the view that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static View removeTerms(String qualifiedName, List<GuidReference> terms) throws AtlanException {
        return (View) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }
}
