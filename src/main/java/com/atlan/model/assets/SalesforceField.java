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
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Instance of a Salesforce field in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class SalesforceField extends Asset
        implements ISalesforceField, ISalesforce, ISaaS, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "SalesforceField";

    /** Fixed typeName for SalesforceFields. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    String apiName;

    /** Data type of values in the field. */
    @Attribute
    String dataType;

    /** TBC */
    @Attribute
    String defaultValueFormula;

    /** TBC */
    @Attribute
    String formula;

    /** TBC */
    @Attribute
    String inlineHelpText;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** TBC */
    @Attribute
    Boolean isCalculated;

    /** TBC */
    @Attribute
    Boolean isCaseSensitive;

    /** TBC */
    @Attribute
    Boolean isEncrypted;

    /** TBC */
    @Attribute
    Boolean isNullable;

    /** Whether the field references a record of multiple objects (true) or not (false). */
    @Attribute
    Boolean isPolymorphicForeignKey;

    /** TBC */
    @Attribute
    Boolean isUnique;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ISalesforceObject> lookupObjects;

    /** TBC */
    @Attribute
    Long maxLength;

    /** Number of digits allowed to the right of the decimal point. */
    @Attribute
    Double numericScale;

    /** TBC */
    @Attribute
    ISalesforceObject object;

    /** TBC */
    @Attribute
    String objectQualifiedName;

    /** TBC */
    @Attribute
    Integer order;

    /** TBC */
    @Attribute
    String organizationQualifiedName;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;

    /** List of values from which a user can pick while adding a record. */
    @Attribute
    @Singular
    SortedSet<String> picklistValues;

    /** Total number of digits allowed. */
    @Attribute
    Integer precision;

    /**
     * Reference to a SalesforceField by GUID.
     *
     * @param guid the GUID of the SalesforceField to reference
     * @return reference to a SalesforceField that can be used for defining a relationship to a SalesforceField
     */
    public static SalesforceField refByGuid(String guid) {
        return SalesforceField.builder().guid(guid).build();
    }

    /**
     * Reference to a SalesforceField by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the SalesforceField to reference
     * @return reference to a SalesforceField that can be used for defining a relationship to a SalesforceField
     */
    public static SalesforceField refByQualifiedName(String qualifiedName) {
        return SalesforceField.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a SalesforceField by its GUID, complete with all of its relationships.
     *
     * @param guid of the SalesforceField to retrieve
     * @return the requested full SalesforceField, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SalesforceField does not exist or the provided GUID is not a SalesforceField
     */
    public static SalesforceField retrieveByGuid(String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof SalesforceField) {
            return (SalesforceField) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "SalesforceField");
        }
    }

    /**
     * Retrieves a SalesforceField by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the SalesforceField to retrieve
     * @return the requested full SalesforceField, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SalesforceField does not exist
     */
    public static SalesforceField retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(TYPE_NAME, qualifiedName);
        if (asset instanceof SalesforceField) {
            return (SalesforceField) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "SalesforceField");
        }
    }

    /**
     * Restore the archived (soft-deleted) SalesforceField to active.
     *
     * @param qualifiedName for the SalesforceField
     * @return true if the SalesforceField is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return Asset.restore(TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a SalesforceField.
     *
     * @param qualifiedName of the SalesforceField
     * @param name of the SalesforceField
     * @return the minimal request necessary to update the SalesforceField, as a builder
     */
    public static SalesforceFieldBuilder<?, ?> updater(String qualifiedName, String name) {
        return SalesforceField.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a SalesforceField, from a potentially
     * more-complete SalesforceField object.
     *
     * @return the minimal object necessary to update the SalesforceField, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for SalesforceField are not found in the initial object
     */
    @Override
    public SalesforceFieldBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "SalesforceField", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a SalesforceField.
     *
     * @param qualifiedName of the SalesforceField
     * @param name of the SalesforceField
     * @return the updated SalesforceField, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceField removeDescription(String qualifiedName, String name) throws AtlanException {
        return (SalesforceField) Asset.removeDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a SalesforceField.
     *
     * @param qualifiedName of the SalesforceField
     * @param name of the SalesforceField
     * @return the updated SalesforceField, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceField removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return (SalesforceField) Asset.removeUserDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a SalesforceField.
     *
     * @param qualifiedName of the SalesforceField
     * @param name of the SalesforceField
     * @return the updated SalesforceField, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceField removeOwners(String qualifiedName, String name) throws AtlanException {
        return (SalesforceField) Asset.removeOwners(updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a SalesforceField.
     *
     * @param qualifiedName of the SalesforceField
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated SalesforceField, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceField updateCertificate(String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (SalesforceField) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a SalesforceField.
     *
     * @param qualifiedName of the SalesforceField
     * @param name of the SalesforceField
     * @return the updated SalesforceField, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceField removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (SalesforceField) Asset.removeCertificate(updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a SalesforceField.
     *
     * @param qualifiedName of the SalesforceField
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceField updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (SalesforceField) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a SalesforceField.
     *
     * @param qualifiedName of the SalesforceField
     * @param name of the SalesforceField
     * @return the updated SalesforceField, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceField removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (SalesforceField) Asset.removeAnnouncement(updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the SalesforceField.
     *
     * @param qualifiedName for the SalesforceField
     * @param name human-readable name of the SalesforceField
     * @param terms the list of terms to replace on the SalesforceField, or null to remove all terms from the SalesforceField
     * @return the SalesforceField that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static SalesforceField replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (SalesforceField) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the SalesforceField, without replacing existing terms linked to the SalesforceField.
     * Note: this operation must make two API calls — one to retrieve the SalesforceField's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the SalesforceField
     * @param terms the list of terms to append to the SalesforceField
     * @return the SalesforceField that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static SalesforceField appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (SalesforceField) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a SalesforceField, without replacing all existing terms linked to the SalesforceField.
     * Note: this operation must make two API calls — one to retrieve the SalesforceField's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the SalesforceField
     * @param terms the list of terms to remove from the SalesforceField, which must be referenced by GUID
     * @return the SalesforceField that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static SalesforceField removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (SalesforceField) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a SalesforceField, without replacing existing Atlan tags linked to the SalesforceField.
     * Note: this operation must make two API calls — one to retrieve the SalesforceField's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the SalesforceField
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated SalesforceField
     */
    public static SalesforceField appendAtlanTags(String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return (SalesforceField) Asset.appendAtlanTags(TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a SalesforceField, without replacing existing Atlan tags linked to the SalesforceField.
     * Note: this operation must make two API calls — one to retrieve the SalesforceField's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the SalesforceField
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated SalesforceField
     */
    public static SalesforceField appendAtlanTags(
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (SalesforceField) Asset.appendAtlanTags(
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a SalesforceField.
     *
     * @param qualifiedName of the SalesforceField
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the SalesforceField
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        Asset.addAtlanTags(TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a SalesforceField.
     *
     * @param qualifiedName of the SalesforceField
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the SalesforceField
     * @deprecated see {@link #appendAtlanTags(String, List, boolean, boolean, boolean)} instead
     */
    @Deprecated
    public static void addAtlanTags(
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        Asset.addAtlanTags(
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Remove an Atlan tag from a SalesforceField.
     *
     * @param qualifiedName of the SalesforceField
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the SalesforceField
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        Asset.removeAtlanTag(TYPE_NAME, qualifiedName, atlanTagName);
    }
}
