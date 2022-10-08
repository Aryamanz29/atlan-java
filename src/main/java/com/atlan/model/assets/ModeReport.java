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
public class ModeReport extends Mode {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "ModeReport";

    /** Fixed typeName for ModeReports. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    String modeCollectionToken;

    /** TBC */
    @Attribute
    Long modeReportPublishedAt;

    /** TBC */
    @Attribute
    Long modeQueryCount;

    /** TBC */
    @Attribute
    Long modeChartCount;

    /** TBC */
    @Attribute
    String modeQueryPreview;

    /** TBC */
    @Attribute
    Boolean modeIsPublic;

    /** TBC */
    @Attribute
    Boolean modeIsShared;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ModeCollection> modeCollections;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ModeQuery> modeQueries;

    /**
     * Reference to a ModeReport by GUID.
     *
     * @param guid the GUID of the ModeReport to reference
     * @return reference to a ModeReport that can be used for defining a relationship to a ModeReport
     */
    public static ModeReport refByGuid(String guid) {
        return ModeReport.builder().guid(guid).build();
    }

    /**
     * Reference to a ModeReport by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the ModeReport to reference
     * @return reference to a ModeReport that can be used for defining a relationship to a ModeReport
     */
    public static ModeReport refByQualifiedName(String qualifiedName) {
        return ModeReport.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Builds the minimal object necessary to update a ModeReport.
     *
     * @param qualifiedName of the ModeReport
     * @param name of the ModeReport
     * @return the minimal request necessary to update the ModeReport, as a builder
     */
    public static ModeReportBuilder<?, ?> updater(String qualifiedName, String name) {
        return ModeReport.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a ModeReport, from a potentially
     * more-complete ModeReport object.
     *
     * @return the minimal object necessary to update the ModeReport, as a builder
     */
    @Override
    protected ModeReportBuilder<?, ?> trimToRequired() {
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Update the certificate on a ModeReport.
     *
     * @param qualifiedName of the ModeReport
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated ModeReport, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static ModeReport updateCertificate(String qualifiedName, AtlanCertificateStatus certificate, String message)
            throws AtlanException {
        return (ModeReport) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a ModeReport.
     *
     * @param qualifiedName of the ModeReport
     * @param name of the ModeReport
     * @return the updated ModeReport, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ModeReport removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (ModeReport)
                Asset.removeCertificate(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Update the announcement on a ModeReport.
     *
     * @param qualifiedName of the ModeReport
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static ModeReport updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (ModeReport) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a ModeReport.
     *
     * @param qualifiedName of the ModeReport
     * @param name of the ModeReport
     * @return the updated ModeReport, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ModeReport removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (ModeReport)
                Asset.removeAnnouncement(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Add classifications to a ModeReport.
     *
     * @param qualifiedName of the ModeReport
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the ModeReport
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a ModeReport.
     *
     * @param qualifiedName of the ModeReport
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the ModeReport
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }

    /**
     * Replace the terms linked to the ModeReport.
     *
     * @param qualifiedName for the ModeReport
     * @param name human-readable name of the ModeReport
     * @param terms the list of terms to replace on the ModeReport, or null to remove all terms from the ModeReport
     * @return the ModeReport that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static ModeReport replaceTerms(String qualifiedName, String name, List<GlossaryTerm> terms)
            throws AtlanException {
        return (ModeReport) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the ModeReport, without replacing existing terms linked to the ModeReport.
     * Note: this operation must make two API calls — one to retrieve the ModeReport's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the ModeReport
     * @param terms the list of terms to append to the ModeReport
     * @return the ModeReport that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static ModeReport appendTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (ModeReport) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a ModeReport, without replacing all existing terms linked to the ModeReport.
     * Note: this operation must make two API calls — one to retrieve the ModeReport's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the ModeReport
     * @param terms the list of terms to remove from the ModeReport, which must be referenced by GUID
     * @return the ModeReport that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static ModeReport removeTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (ModeReport) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }
}
