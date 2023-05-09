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
import java.util.SortedSet;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Instance of a Salesforce object in Atlan.
 */
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class SalesforceObject extends Salesforce {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "SalesforceObject";

    /** Fixed typeName for SalesforceObjects. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Whether the object is a custom object (true) or not (false). */
    @Attribute
    Boolean isCustom;

    /** TBC */
    @Attribute
    Boolean isMergable;

    /** TBC */
    @Attribute
    Boolean isQueryable;

    /** Number of fields in the object. */
    @Attribute
    Long fieldCount;

    /** TBC */
    @Attribute
    SalesforceOrganization organization;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<SalesforceField> lookupFields;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<SalesforceField> fields;

    /**
     * Reference to a SalesforceObject by GUID.
     *
     * @param guid the GUID of the SalesforceObject to reference
     * @return reference to a SalesforceObject that can be used for defining a relationship to a SalesforceObject
     */
    public static SalesforceObject refByGuid(String guid) {
        return SalesforceObject.builder().guid(guid).build();
    }

    /**
     * Reference to a SalesforceObject by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the SalesforceObject to reference
     * @return reference to a SalesforceObject that can be used for defining a relationship to a SalesforceObject
     */
    public static SalesforceObject refByQualifiedName(String qualifiedName) {
        return SalesforceObject.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a SalesforceObject by its GUID, complete with all of its relationships.
     *
     * @param guid of the SalesforceObject to retrieve
     * @return the requested full SalesforceObject, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SalesforceObject does not exist or the provided GUID is not a SalesforceObject
     */
    public static SalesforceObject retrieveByGuid(String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof SalesforceObject) {
            return (SalesforceObject) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "SalesforceObject");
        }
    }

    /**
     * Retrieves a SalesforceObject by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the SalesforceObject to retrieve
     * @return the requested full SalesforceObject, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SalesforceObject does not exist
     */
    public static SalesforceObject retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(TYPE_NAME, qualifiedName);
        if (asset instanceof SalesforceObject) {
            return (SalesforceObject) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "SalesforceObject");
        }
    }

    /**
     * Restore the archived (soft-deleted) SalesforceObject to active.
     *
     * @param qualifiedName for the SalesforceObject
     * @return true if the SalesforceObject is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return Asset.restore(TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a SalesforceObject.
     *
     * @param qualifiedName of the SalesforceObject
     * @param name of the SalesforceObject
     * @return the minimal request necessary to update the SalesforceObject, as a builder
     */
    public static SalesforceObjectBuilder<?, ?> updater(String qualifiedName, String name) {
        return SalesforceObject.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a SalesforceObject, from a potentially
     * more-complete SalesforceObject object.
     *
     * @return the minimal object necessary to update the SalesforceObject, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for SalesforceObject are not found in the initial object
     */
    @Override
    public SalesforceObjectBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "SalesforceObject", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a SalesforceObject.
     *
     * @param qualifiedName of the SalesforceObject
     * @param name of the SalesforceObject
     * @return the updated SalesforceObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceObject removeDescription(String qualifiedName, String name) throws AtlanException {
        return (SalesforceObject) Asset.removeDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a SalesforceObject.
     *
     * @param qualifiedName of the SalesforceObject
     * @param name of the SalesforceObject
     * @return the updated SalesforceObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceObject removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return (SalesforceObject) Asset.removeUserDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a SalesforceObject.
     *
     * @param qualifiedName of the SalesforceObject
     * @param name of the SalesforceObject
     * @return the updated SalesforceObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceObject removeOwners(String qualifiedName, String name) throws AtlanException {
        return (SalesforceObject) Asset.removeOwners(updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a SalesforceObject.
     *
     * @param qualifiedName of the SalesforceObject
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated SalesforceObject, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceObject updateCertificate(
            String qualifiedName, CertificateStatus certificate, String message) throws AtlanException {
        return (SalesforceObject) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a SalesforceObject.
     *
     * @param qualifiedName of the SalesforceObject
     * @param name of the SalesforceObject
     * @return the updated SalesforceObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceObject removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (SalesforceObject) Asset.removeCertificate(updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a SalesforceObject.
     *
     * @param qualifiedName of the SalesforceObject
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceObject updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (SalesforceObject) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a SalesforceObject.
     *
     * @param qualifiedName of the SalesforceObject
     * @param name of the SalesforceObject
     * @return the updated SalesforceObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceObject removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (SalesforceObject) Asset.removeAnnouncement(updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the SalesforceObject.
     *
     * @param qualifiedName for the SalesforceObject
     * @param name human-readable name of the SalesforceObject
     * @param terms the list of terms to replace on the SalesforceObject, or null to remove all terms from the SalesforceObject
     * @return the SalesforceObject that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static SalesforceObject replaceTerms(String qualifiedName, String name, List<GlossaryTerm> terms)
            throws AtlanException {
        return (SalesforceObject) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the SalesforceObject, without replacing existing terms linked to the SalesforceObject.
     * Note: this operation must make two API calls — one to retrieve the SalesforceObject's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the SalesforceObject
     * @param terms the list of terms to append to the SalesforceObject
     * @return the SalesforceObject that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static SalesforceObject appendTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (SalesforceObject) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a SalesforceObject, without replacing all existing terms linked to the SalesforceObject.
     * Note: this operation must make two API calls — one to retrieve the SalesforceObject's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the SalesforceObject
     * @param terms the list of terms to remove from the SalesforceObject, which must be referenced by GUID
     * @return the SalesforceObject that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static SalesforceObject removeTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (SalesforceObject) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add classifications to a SalesforceObject, without replacing existing classifications linked to the SalesforceObject.
     * Note: this operation must make two API calls — one to retrieve the SalesforceObject's existing classifications,
     * and a second to append the new classifications.
     *
     * @param qualifiedName of the SalesforceObject
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems
     * @return the updated SalesforceObject
     */
    public static SalesforceObject appendClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        return (SalesforceObject) Asset.appendClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Add classifications to a SalesforceObject, without replacing existing classifications linked to the SalesforceObject.
     * Note: this operation must make two API calls — one to retrieve the SalesforceObject's existing classifications,
     * and a second to append the new classifications.
     *
     * @param qualifiedName of the SalesforceObject
     * @param classificationNames human-readable names of the classifications to add
     * @param propagate whether to propagate the classification (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated classifications when the classification is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated SalesforceObject
     */
    public static SalesforceObject appendClassifications(
            String qualifiedName,
            List<String> classificationNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (SalesforceObject) Asset.appendClassifications(
                TYPE_NAME,
                qualifiedName,
                classificationNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add classifications to a SalesforceObject.
     *
     * @param qualifiedName of the SalesforceObject
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the SalesforceObject
     * @deprecated see {@link #appendClassifications(String, List)} instead
     */
    @Deprecated
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Add classifications to a SalesforceObject.
     *
     * @param qualifiedName of the SalesforceObject
     * @param classificationNames human-readable names of the classifications to add
     * @param propagate whether to propagate the classification (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated classifications when the classification is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the SalesforceObject
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
     * Remove a classification from a SalesforceObject.
     *
     * @param qualifiedName of the SalesforceObject
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the SalesforceObject
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }
}
