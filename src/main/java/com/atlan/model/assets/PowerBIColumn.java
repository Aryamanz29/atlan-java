/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.exception.AtlanException;
import com.atlan.exception.NotFoundException;
import com.atlan.model.core.Entity;
import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.AtlanCertificateStatus;
import com.atlan.model.relations.UniqueAttributes;
import java.util.List;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class PowerBIColumn extends PowerBI {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "PowerBIColumn";

    /** Fixed typeName for PowerBIColumns. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    String workspaceQualifiedName;

    /** TBC */
    @Attribute
    String datasetQualifiedName;

    /** TBC */
    @Attribute
    String powerBIColumnDataCategory;

    /** TBC */
    @Attribute
    String powerBIColumnDataType;

    /** TBC */
    @Attribute
    String powerBISortByColumn;

    /** TBC */
    @Attribute
    String powerBIColumnSummarizeBy;

    /** TBC */
    @Attribute
    PowerBITable table;

    /**
     * Reference to a PowerBIColumn by GUID.
     *
     * @param guid the GUID of the PowerBIColumn to reference
     * @return reference to a PowerBIColumn that can be used for defining a relationship to a PowerBIColumn
     */
    public static PowerBIColumn refByGuid(String guid) {
        return PowerBIColumn.builder().guid(guid).build();
    }

    /**
     * Reference to a PowerBIColumn by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the PowerBIColumn to reference
     * @return reference to a PowerBIColumn that can be used for defining a relationship to a PowerBIColumn
     */
    public static PowerBIColumn refByQualifiedName(String qualifiedName) {
        return PowerBIColumn.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Builds the minimal object necessary to update a PowerBIColumn.
     *
     * @param qualifiedName of the PowerBIColumn
     * @param name of the PowerBIColumn
     * @return the minimal request necessary to update the PowerBIColumn, as a builder
     */
    public static PowerBIColumnBuilder<?, ?> updater(String qualifiedName, String name) {
        return PowerBIColumn.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a PowerBIColumn, from a potentially
     * more-complete PowerBIColumn object.
     *
     * @return the minimal object necessary to update the PowerBIColumn, as a builder
     */
    @Override
    protected PowerBIColumnBuilder<?, ?> trimToRequired() {
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Retrieves a PowerBIColumn by its GUID, complete with all of its relationships.
     *
     * @param guid of the PowerBIColumn to retrieve
     * @return the requested full PowerBIColumn, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIColumn does not exist or the provided GUID is not a PowerBIColumn
     */
    public static PowerBIColumn retrieveByGuid(String guid) throws AtlanException {
        Entity entity = Entity.retrieveFull(guid);
        if (entity == null) {
            throw new NotFoundException("No entity found with GUID: " + guid, "ATLAN_JAVA_CLIENT-404-001", 404, null);
        } else if (entity instanceof PowerBIColumn) {
            return (PowerBIColumn) entity;
        } else {
            throw new NotFoundException(
                    "Entity with GUID " + guid + " is not a PowerBIColumn.", "ATLAN_JAVA_CLIENT-404-002", 404, null);
        }
    }

    /**
     * Retrieves a PowerBIColumn by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the PowerBIColumn to retrieve
     * @return the requested full PowerBIColumn, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIColumn does not exist
     */
    public static PowerBIColumn retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Entity entity = Entity.retrieveFull(TYPE_NAME, qualifiedName);
        if (entity instanceof PowerBIColumn) {
            return (PowerBIColumn) entity;
        } else {
            throw new NotFoundException(
                    "No PowerBIColumn found with qualifiedName: " + qualifiedName,
                    "ATLAN_JAVA_CLIENT-404-003",
                    404,
                    null);
        }
    }

    /**
     * Update the certificate on a PowerBIColumn.
     *
     * @param qualifiedName of the PowerBIColumn
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated PowerBIColumn, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIColumn updateCertificate(
            String qualifiedName, AtlanCertificateStatus certificate, String message) throws AtlanException {
        return (PowerBIColumn) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a PowerBIColumn.
     *
     * @param qualifiedName of the PowerBIColumn
     * @param name of the PowerBIColumn
     * @return the updated PowerBIColumn, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIColumn removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (PowerBIColumn)
                Asset.removeCertificate(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Update the announcement on a PowerBIColumn.
     *
     * @param qualifiedName of the PowerBIColumn
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIColumn updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (PowerBIColumn) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a PowerBIColumn.
     *
     * @param qualifiedName of the PowerBIColumn
     * @param name of the PowerBIColumn
     * @return the updated PowerBIColumn, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIColumn removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (PowerBIColumn)
                Asset.removeAnnouncement(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Add classifications to a PowerBIColumn.
     *
     * @param qualifiedName of the PowerBIColumn
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the PowerBIColumn
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a PowerBIColumn.
     *
     * @param qualifiedName of the PowerBIColumn
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the PowerBIColumn
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }

    /**
     * Replace the terms linked to the PowerBIColumn.
     *
     * @param qualifiedName for the PowerBIColumn
     * @param name human-readable name of the PowerBIColumn
     * @param terms the list of terms to replace on the PowerBIColumn, or null to remove all terms from the PowerBIColumn
     * @return the PowerBIColumn that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIColumn replaceTerms(String qualifiedName, String name, List<GlossaryTerm> terms)
            throws AtlanException {
        return (PowerBIColumn) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the PowerBIColumn, without replacing existing terms linked to the PowerBIColumn.
     * Note: this operation must make two API calls — one to retrieve the PowerBIColumn's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the PowerBIColumn
     * @param terms the list of terms to append to the PowerBIColumn
     * @return the PowerBIColumn that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIColumn appendTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (PowerBIColumn) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a PowerBIColumn, without replacing all existing terms linked to the PowerBIColumn.
     * Note: this operation must make two API calls — one to retrieve the PowerBIColumn's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the PowerBIColumn
     * @param terms the list of terms to remove from the PowerBIColumn, which must be referenced by GUID
     * @return the PowerBIColumn that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIColumn removeTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (PowerBIColumn) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }
}