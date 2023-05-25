/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.exception.AtlanException;
import com.atlan.exception.ErrorCode;
import com.atlan.exception.InvalidRequestException;
import com.atlan.exception.NotFoundException;
import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.CertificateStatus;
import com.atlan.model.relations.UniqueAttributes;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * TBC
 */
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class ThoughtspotAnswer extends Thoughtspot {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "ThoughtspotAnswer";

    /** Fixed typeName for ThoughtspotAnswers. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /**
     * Reference to a ThoughtspotAnswer by GUID.
     *
     * @param guid the GUID of the ThoughtspotAnswer to reference
     * @return reference to a ThoughtspotAnswer that can be used for defining a relationship to a ThoughtspotAnswer
     */
    public static ThoughtspotAnswer refByGuid(String guid) {
        return ThoughtspotAnswer.builder().guid(guid).build();
    }

    /**
     * Reference to a ThoughtspotAnswer by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the ThoughtspotAnswer to reference
     * @return reference to a ThoughtspotAnswer that can be used for defining a relationship to a ThoughtspotAnswer
     */
    public static ThoughtspotAnswer refByQualifiedName(String qualifiedName) {
        return ThoughtspotAnswer.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a ThoughtspotAnswer by its GUID, complete with all of its relationships.
     *
     * @param guid of the ThoughtspotAnswer to retrieve
     * @return the requested full ThoughtspotAnswer, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the ThoughtspotAnswer does not exist or the provided GUID is not a ThoughtspotAnswer
     */
    public static ThoughtspotAnswer retrieveByGuid(String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof ThoughtspotAnswer) {
            return (ThoughtspotAnswer) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "ThoughtspotAnswer");
        }
    }

    /**
     * Retrieves a ThoughtspotAnswer by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the ThoughtspotAnswer to retrieve
     * @return the requested full ThoughtspotAnswer, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the ThoughtspotAnswer does not exist
     */
    public static ThoughtspotAnswer retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(TYPE_NAME, qualifiedName);
        if (asset instanceof ThoughtspotAnswer) {
            return (ThoughtspotAnswer) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "ThoughtspotAnswer");
        }
    }

    /**
     * Restore the archived (soft-deleted) ThoughtspotAnswer to active.
     *
     * @param qualifiedName for the ThoughtspotAnswer
     * @return true if the ThoughtspotAnswer is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return Asset.restore(TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a ThoughtspotAnswer.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param name of the ThoughtspotAnswer
     * @return the minimal request necessary to update the ThoughtspotAnswer, as a builder
     */
    public static ThoughtspotAnswerBuilder<?, ?> updater(String qualifiedName, String name) {
        return ThoughtspotAnswer.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a ThoughtspotAnswer, from a potentially
     * more-complete ThoughtspotAnswer object.
     *
     * @return the minimal object necessary to update the ThoughtspotAnswer, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for ThoughtspotAnswer are not found in the initial object
     */
    @Override
    public ThoughtspotAnswerBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "ThoughtspotAnswer", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a ThoughtspotAnswer.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param name of the ThoughtspotAnswer
     * @return the updated ThoughtspotAnswer, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotAnswer removeDescription(String qualifiedName, String name) throws AtlanException {
        return (ThoughtspotAnswer) Asset.removeDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a ThoughtspotAnswer.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param name of the ThoughtspotAnswer
     * @return the updated ThoughtspotAnswer, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotAnswer removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return (ThoughtspotAnswer) Asset.removeUserDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a ThoughtspotAnswer.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param name of the ThoughtspotAnswer
     * @return the updated ThoughtspotAnswer, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotAnswer removeOwners(String qualifiedName, String name) throws AtlanException {
        return (ThoughtspotAnswer) Asset.removeOwners(updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a ThoughtspotAnswer.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated ThoughtspotAnswer, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotAnswer updateCertificate(
            String qualifiedName, CertificateStatus certificate, String message) throws AtlanException {
        return (ThoughtspotAnswer) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a ThoughtspotAnswer.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param name of the ThoughtspotAnswer
     * @return the updated ThoughtspotAnswer, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotAnswer removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (ThoughtspotAnswer) Asset.removeCertificate(updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a ThoughtspotAnswer.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotAnswer updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (ThoughtspotAnswer) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a ThoughtspotAnswer.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param name of the ThoughtspotAnswer
     * @return the updated ThoughtspotAnswer, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotAnswer removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (ThoughtspotAnswer) Asset.removeAnnouncement(updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the ThoughtspotAnswer.
     *
     * @param qualifiedName for the ThoughtspotAnswer
     * @param name human-readable name of the ThoughtspotAnswer
     * @param terms the list of terms to replace on the ThoughtspotAnswer, or null to remove all terms from the ThoughtspotAnswer
     * @return the ThoughtspotAnswer that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotAnswer replaceTerms(String qualifiedName, String name, List<GlossaryTerm> terms)
            throws AtlanException {
        return (ThoughtspotAnswer) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the ThoughtspotAnswer, without replacing existing terms linked to the ThoughtspotAnswer.
     * Note: this operation must make two API calls — one to retrieve the ThoughtspotAnswer's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the ThoughtspotAnswer
     * @param terms the list of terms to append to the ThoughtspotAnswer
     * @return the ThoughtspotAnswer that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotAnswer appendTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (ThoughtspotAnswer) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a ThoughtspotAnswer, without replacing all existing terms linked to the ThoughtspotAnswer.
     * Note: this operation must make two API calls — one to retrieve the ThoughtspotAnswer's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the ThoughtspotAnswer
     * @param terms the list of terms to remove from the ThoughtspotAnswer, which must be referenced by GUID
     * @return the ThoughtspotAnswer that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotAnswer removeTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (ThoughtspotAnswer) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add classifications to a ThoughtspotAnswer, without replacing existing classifications linked to the ThoughtspotAnswer.
     * Note: this operation must make two API calls — one to retrieve the ThoughtspotAnswer's existing classifications,
     * and a second to append the new classifications.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems
     * @return the updated ThoughtspotAnswer
     */
    public static ThoughtspotAnswer appendClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        return (ThoughtspotAnswer) Asset.appendClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Add classifications to a ThoughtspotAnswer, without replacing existing classifications linked to the ThoughtspotAnswer.
     * Note: this operation must make two API calls — one to retrieve the ThoughtspotAnswer's existing classifications,
     * and a second to append the new classifications.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param classificationNames human-readable names of the classifications to add
     * @param propagate whether to propagate the classification (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated classifications when the classification is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated ThoughtspotAnswer
     */
    public static ThoughtspotAnswer appendClassifications(
            String qualifiedName,
            List<String> classificationNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (ThoughtspotAnswer) Asset.appendClassifications(
                TYPE_NAME,
                qualifiedName,
                classificationNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add classifications to a ThoughtspotAnswer.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the ThoughtspotAnswer
     * @deprecated see {@link #appendClassifications(String, List)} instead
     */
    @Deprecated
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Add classifications to a ThoughtspotAnswer.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param classificationNames human-readable names of the classifications to add
     * @param propagate whether to propagate the classification (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated classifications when the classification is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the ThoughtspotAnswer
     * @deprecated see {@link #appendClassifications(String, List, boolean, boolean, boolean)} instead
     */
    @Deprecated
    public static void addClassifications(
            String qualifiedName,
            List<String> classificationNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        Asset.addClassifications(
                TYPE_NAME,
                qualifiedName,
                classificationNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Remove a classification from a ThoughtspotAnswer.
     *
     * @param qualifiedName of the ThoughtspotAnswer
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the ThoughtspotAnswer
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }
}