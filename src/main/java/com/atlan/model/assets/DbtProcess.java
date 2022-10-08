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
public class DbtProcess extends AbstractProcess {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "DbtProcess";

    /** Fixed typeName for DbtProcesss. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    String dbtProcessJobStatus;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<LineageProcess> inputToProcesses;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<LineageProcess> outputFromProcesses;

    /**
     * Reference to a DbtProcess by GUID.
     *
     * @param guid the GUID of the DbtProcess to reference
     * @return reference to a DbtProcess that can be used for defining a relationship to a DbtProcess
     */
    public static DbtProcess refByGuid(String guid) {
        return DbtProcess.builder().guid(guid).build();
    }

    /**
     * Reference to a DbtProcess by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the DbtProcess to reference
     * @return reference to a DbtProcess that can be used for defining a relationship to a DbtProcess
     */
    public static DbtProcess refByQualifiedName(String qualifiedName) {
        return DbtProcess.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Builds the minimal object necessary to update a DbtProcess.
     *
     * @param qualifiedName of the DbtProcess
     * @param name of the DbtProcess
     * @return the minimal request necessary to update the DbtProcess, as a builder
     */
    public static DbtProcessBuilder<?, ?> updater(String qualifiedName, String name) {
        return DbtProcess.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a DbtProcess, from a potentially
     * more-complete DbtProcess object.
     *
     * @return the minimal object necessary to update the DbtProcess, as a builder
     */
    @Override
    protected DbtProcessBuilder<?, ?> trimToRequired() {
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Update the certificate on a DbtProcess.
     *
     * @param qualifiedName of the DbtProcess
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated DbtProcess, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static DbtProcess updateCertificate(String qualifiedName, AtlanCertificateStatus certificate, String message)
            throws AtlanException {
        return (DbtProcess) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a DbtProcess.
     *
     * @param qualifiedName of the DbtProcess
     * @param name of the DbtProcess
     * @return the updated DbtProcess, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DbtProcess removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (DbtProcess)
                Asset.removeCertificate(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Update the announcement on a DbtProcess.
     *
     * @param qualifiedName of the DbtProcess
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static DbtProcess updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (DbtProcess) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a DbtProcess.
     *
     * @param qualifiedName of the DbtProcess
     * @param name of the DbtProcess
     * @return the updated DbtProcess, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DbtProcess removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (DbtProcess)
                Asset.removeAnnouncement(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Add classifications to a DbtProcess.
     *
     * @param qualifiedName of the DbtProcess
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the DbtProcess
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a DbtProcess.
     *
     * @param qualifiedName of the DbtProcess
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the DbtProcess
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }

    /**
     * Replace the terms linked to the DbtProcess.
     *
     * @param qualifiedName for the DbtProcess
     * @param name human-readable name of the DbtProcess
     * @param terms the list of terms to replace on the DbtProcess, or null to remove all terms from the DbtProcess
     * @return the DbtProcess that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static DbtProcess replaceTerms(String qualifiedName, String name, List<GlossaryTerm> terms)
            throws AtlanException {
        return (DbtProcess) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the DbtProcess, without replacing existing terms linked to the DbtProcess.
     * Note: this operation must make two API calls — one to retrieve the DbtProcess's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the DbtProcess
     * @param terms the list of terms to append to the DbtProcess
     * @return the DbtProcess that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static DbtProcess appendTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (DbtProcess) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a DbtProcess, without replacing all existing terms linked to the DbtProcess.
     * Note: this operation must make two API calls — one to retrieve the DbtProcess's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the DbtProcess
     * @param terms the list of terms to remove from the DbtProcess, which must be referenced by GUID
     * @return the DbtProcess that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static DbtProcess removeTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (DbtProcess) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }
}
