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
import java.util.SortedSet;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class DbtColumnProcess extends AbstractColumnProcess {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "DbtColumnProcess";

    /** Fixed typeName for DbtColumnProcesss. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    String dbtColumnProcessJobStatus;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<LineageProcess> inputToProcesses;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<LineageProcess> outputFromProcesses;

    /**
     * Reference to a DbtColumnProcess by GUID.
     *
     * @param guid the GUID of the DbtColumnProcess to reference
     * @return reference to a DbtColumnProcess that can be used for defining a relationship to a DbtColumnProcess
     */
    public static DbtColumnProcess refByGuid(String guid) {
        return DbtColumnProcess.builder().guid(guid).build();
    }

    /**
     * Reference to a DbtColumnProcess by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the DbtColumnProcess to reference
     * @return reference to a DbtColumnProcess that can be used for defining a relationship to a DbtColumnProcess
     */
    public static DbtColumnProcess refByQualifiedName(String qualifiedName) {
        return DbtColumnProcess.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Builds the minimal object necessary to update a DbtColumnProcess.
     *
     * @param qualifiedName of the DbtColumnProcess
     * @param name of the DbtColumnProcess
     * @return the minimal request necessary to update the DbtColumnProcess, as a builder
     */
    public static DbtColumnProcessBuilder<?, ?> updater(String qualifiedName, String name) {
        return DbtColumnProcess.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a DbtColumnProcess, from a potentially
     * more-complete DbtColumnProcess object.
     *
     * @return the minimal object necessary to update the DbtColumnProcess, as a builder
     */
    @Override
    protected DbtColumnProcessBuilder<?, ?> trimToRequired() {
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Retrieves a DbtColumnProcess by its GUID, complete with all of its relationships.
     *
     * @param guid of the DbtColumnProcess to retrieve
     * @return the requested full DbtColumnProcess, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the DbtColumnProcess does not exist or the provided GUID is not a DbtColumnProcess
     */
    public static DbtColumnProcess retrieveByGuid(String guid) throws AtlanException {
        Entity entity = Entity.retrieveFull(guid);
        if (entity == null) {
            throw new NotFoundException("No entity found with GUID: " + guid, "ATLAN_JAVA_CLIENT-404-001", 404, null);
        } else if (entity instanceof DbtColumnProcess) {
            return (DbtColumnProcess) entity;
        } else {
            throw new NotFoundException(
                    "Entity with GUID " + guid + " is not a DbtColumnProcess.", "ATLAN_JAVA_CLIENT-404-002", 404, null);
        }
    }

    /**
     * Retrieves a DbtColumnProcess by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the DbtColumnProcess to retrieve
     * @return the requested full DbtColumnProcess, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the DbtColumnProcess does not exist
     */
    public static DbtColumnProcess retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Entity entity = Entity.retrieveFull(TYPE_NAME, qualifiedName);
        if (entity instanceof DbtColumnProcess) {
            return (DbtColumnProcess) entity;
        } else {
            throw new NotFoundException(
                    "No DbtColumnProcess found with qualifiedName: " + qualifiedName,
                    "ATLAN_JAVA_CLIENT-404-003",
                    404,
                    null);
        }
    }

    /**
     * Update the certificate on a DbtColumnProcess.
     *
     * @param qualifiedName of the DbtColumnProcess
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated DbtColumnProcess, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static DbtColumnProcess updateCertificate(
            String qualifiedName, AtlanCertificateStatus certificate, String message) throws AtlanException {
        return (DbtColumnProcess) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a DbtColumnProcess.
     *
     * @param qualifiedName of the DbtColumnProcess
     * @param name of the DbtColumnProcess
     * @return the updated DbtColumnProcess, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DbtColumnProcess removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (DbtColumnProcess)
                Asset.removeCertificate(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Update the announcement on a DbtColumnProcess.
     *
     * @param qualifiedName of the DbtColumnProcess
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static DbtColumnProcess updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (DbtColumnProcess) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a DbtColumnProcess.
     *
     * @param qualifiedName of the DbtColumnProcess
     * @param name of the DbtColumnProcess
     * @return the updated DbtColumnProcess, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static DbtColumnProcess removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (DbtColumnProcess)
                Asset.removeAnnouncement(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Add classifications to a DbtColumnProcess.
     *
     * @param qualifiedName of the DbtColumnProcess
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the DbtColumnProcess
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a DbtColumnProcess.
     *
     * @param qualifiedName of the DbtColumnProcess
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the DbtColumnProcess
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }

    /**
     * Replace the terms linked to the DbtColumnProcess.
     *
     * @param qualifiedName for the DbtColumnProcess
     * @param name human-readable name of the DbtColumnProcess
     * @param terms the list of terms to replace on the DbtColumnProcess, or null to remove all terms from the DbtColumnProcess
     * @return the DbtColumnProcess that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static DbtColumnProcess replaceTerms(String qualifiedName, String name, List<GlossaryTerm> terms)
            throws AtlanException {
        return (DbtColumnProcess) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the DbtColumnProcess, without replacing existing terms linked to the DbtColumnProcess.
     * Note: this operation must make two API calls — one to retrieve the DbtColumnProcess's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the DbtColumnProcess
     * @param terms the list of terms to append to the DbtColumnProcess
     * @return the DbtColumnProcess that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static DbtColumnProcess appendTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (DbtColumnProcess) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a DbtColumnProcess, without replacing all existing terms linked to the DbtColumnProcess.
     * Note: this operation must make two API calls — one to retrieve the DbtColumnProcess's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the DbtColumnProcess
     * @param terms the list of terms to remove from the DbtColumnProcess, which must be referenced by GUID
     * @return the DbtColumnProcess that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static DbtColumnProcess removeTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (DbtColumnProcess) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }
}