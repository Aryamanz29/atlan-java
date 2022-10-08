/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.exception.AtlanException;
import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.AtlanCertificateStatus;
import com.atlan.model.relations.UniqueAttributes;
import java.util.List;
import java.util.SortedSet;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class PowerBIDataset extends PowerBI {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "PowerBIDataset";

    /** Fixed typeName for PowerBIDatasets. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    String workspaceQualifiedName;

    /** TBC */
    @Attribute
    String webUrl;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<PowerBIReport> reports;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<PowerBITile> tiles;

    /** TBC */
    @Attribute
    PowerBIWorkspace workspace;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<PowerBITable> tables;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<PowerBIDatasource> datasources;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<PowerBIDataflow> dataflows;

    /**
     * Reference to a PowerBIDataset by GUID.
     *
     * @param guid the GUID of the PowerBIDataset to reference
     * @return reference to a PowerBIDataset that can be used for defining a relationship to a PowerBIDataset
     */
    public static PowerBIDataset refByGuid(String guid) {
        return PowerBIDataset.builder().guid(guid).build();
    }

    /**
     * Reference to a PowerBIDataset by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the PowerBIDataset to reference
     * @return reference to a PowerBIDataset that can be used for defining a relationship to a PowerBIDataset
     */
    public static PowerBIDataset refByQualifiedName(String qualifiedName) {
        return PowerBIDataset.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Builds the minimal object necessary to update a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param name of the PowerBIDataset
     * @return the minimal request necessary to update the PowerBIDataset, as a builder
     */
    public static PowerBIDatasetBuilder<?, ?> updater(String qualifiedName, String name) {
        return PowerBIDataset.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a PowerBIDataset, from a potentially
     * more-complete PowerBIDataset object.
     *
     * @return the minimal object necessary to update the PowerBIDataset, as a builder
     */
    @Override
    protected PowerBIDatasetBuilder<?, ?> trimToRequired() {
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Update the certificate on a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated PowerBIDataset, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIDataset updateCertificate(
            String qualifiedName, AtlanCertificateStatus certificate, String message) throws AtlanException {
        return (PowerBIDataset) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param name of the PowerBIDataset
     * @return the updated PowerBIDataset, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIDataset removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (PowerBIDataset)
                Asset.removeCertificate(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Update the announcement on a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIDataset updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (PowerBIDataset) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param name of the PowerBIDataset
     * @return the updated PowerBIDataset, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIDataset removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (PowerBIDataset)
                Asset.removeAnnouncement(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Add classifications to a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the PowerBIDataset
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the PowerBIDataset
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }

    /**
     * Replace the terms linked to the PowerBIDataset.
     *
     * @param qualifiedName for the PowerBIDataset
     * @param name human-readable name of the PowerBIDataset
     * @param terms the list of terms to replace on the PowerBIDataset, or null to remove all terms from the PowerBIDataset
     * @return the PowerBIDataset that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIDataset replaceTerms(String qualifiedName, String name, List<GlossaryTerm> terms)
            throws AtlanException {
        return (PowerBIDataset) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the PowerBIDataset, without replacing existing terms linked to the PowerBIDataset.
     * Note: this operation must make two API calls — one to retrieve the PowerBIDataset's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the PowerBIDataset
     * @param terms the list of terms to append to the PowerBIDataset
     * @return the PowerBIDataset that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIDataset appendTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (PowerBIDataset) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a PowerBIDataset, without replacing all existing terms linked to the PowerBIDataset.
     * Note: this operation must make two API calls — one to retrieve the PowerBIDataset's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the PowerBIDataset
     * @param terms the list of terms to remove from the PowerBIDataset, which must be referenced by GUID
     * @return the PowerBIDataset that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIDataset removeTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (PowerBIDataset) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }
}
