/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.exception.AtlanException;
import com.atlan.exception.ErrorCode;
import com.atlan.exception.InvalidRequestException;
import com.atlan.exception.NotFoundException;
import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.CertificateStatus;
import com.atlan.model.enums.PowerBIEndorsementType;
import com.atlan.model.relations.UniqueAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Instance of a Power BI measure in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class PowerBIMeasure extends Asset implements IPowerBIMeasure, IPowerBI, IBI, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "PowerBIMeasure";

    /** Fixed typeName for PowerBIMeasures. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    String datasetQualifiedName;

    /** TBC */
    @Attribute
    PowerBIEndorsementType powerBIEndorsement;

    /** TBC */
    @Attribute
    String powerBIFormatString;

    /** TBC */
    @Attribute
    Boolean powerBIIsExternalMeasure;

    /** TBC */
    @Attribute
    Boolean powerBIIsHidden;

    /** TBC */
    @Attribute
    String powerBIMeasureExpression;

    /** TBC */
    @Attribute
    String powerBITableQualifiedName;

    /** TBC */
    @Attribute
    String workspaceQualifiedName;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;

    /** TBC */
    @Attribute
    IPowerBITable table;

    /**
     * Reference to a PowerBIMeasure by GUID.
     *
     * @param guid the GUID of the PowerBIMeasure to reference
     * @return reference to a PowerBIMeasure that can be used for defining a relationship to a PowerBIMeasure
     */
    public static PowerBIMeasure refByGuid(String guid) {
        return PowerBIMeasure.builder().guid(guid).build();
    }

    /**
     * Reference to a PowerBIMeasure by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the PowerBIMeasure to reference
     * @return reference to a PowerBIMeasure that can be used for defining a relationship to a PowerBIMeasure
     */
    public static PowerBIMeasure refByQualifiedName(String qualifiedName) {
        return PowerBIMeasure.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a PowerBIMeasure by its GUID, complete with all of its relationships.
     *
     * @param guid of the PowerBIMeasure to retrieve
     * @return the requested full PowerBIMeasure, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIMeasure does not exist or the provided GUID is not a PowerBIMeasure
     */
    public static PowerBIMeasure retrieveByGuid(String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof PowerBIMeasure) {
            return (PowerBIMeasure) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "PowerBIMeasure");
        }
    }

    /**
     * Retrieves a PowerBIMeasure by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the PowerBIMeasure to retrieve
     * @return the requested full PowerBIMeasure, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIMeasure does not exist
     */
    public static PowerBIMeasure retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(TYPE_NAME, qualifiedName);
        if (asset instanceof PowerBIMeasure) {
            return (PowerBIMeasure) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "PowerBIMeasure");
        }
    }

    /**
     * Restore the archived (soft-deleted) PowerBIMeasure to active.
     *
     * @param qualifiedName for the PowerBIMeasure
     * @return true if the PowerBIMeasure is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return Asset.restore(TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a PowerBIMeasure.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param name of the PowerBIMeasure
     * @return the minimal request necessary to update the PowerBIMeasure, as a builder
     */
    public static PowerBIMeasureBuilder<?, ?> updater(String qualifiedName, String name) {
        return PowerBIMeasure.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a PowerBIMeasure, from a potentially
     * more-complete PowerBIMeasure object.
     *
     * @return the minimal object necessary to update the PowerBIMeasure, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for PowerBIMeasure are not found in the initial object
     */
    @Override
    public PowerBIMeasureBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "PowerBIMeasure", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a PowerBIMeasure.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param name of the PowerBIMeasure
     * @return the updated PowerBIMeasure, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIMeasure removeDescription(String qualifiedName, String name) throws AtlanException {
        return (PowerBIMeasure) Asset.removeDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a PowerBIMeasure.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param name of the PowerBIMeasure
     * @return the updated PowerBIMeasure, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIMeasure removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return (PowerBIMeasure) Asset.removeUserDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a PowerBIMeasure.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param name of the PowerBIMeasure
     * @return the updated PowerBIMeasure, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIMeasure removeOwners(String qualifiedName, String name) throws AtlanException {
        return (PowerBIMeasure) Asset.removeOwners(updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a PowerBIMeasure.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated PowerBIMeasure, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIMeasure updateCertificate(String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (PowerBIMeasure) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a PowerBIMeasure.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param name of the PowerBIMeasure
     * @return the updated PowerBIMeasure, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIMeasure removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (PowerBIMeasure) Asset.removeCertificate(updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a PowerBIMeasure.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIMeasure updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (PowerBIMeasure) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a PowerBIMeasure.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param name of the PowerBIMeasure
     * @return the updated PowerBIMeasure, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIMeasure removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (PowerBIMeasure) Asset.removeAnnouncement(updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the PowerBIMeasure.
     *
     * @param qualifiedName for the PowerBIMeasure
     * @param name human-readable name of the PowerBIMeasure
     * @param terms the list of terms to replace on the PowerBIMeasure, or null to remove all terms from the PowerBIMeasure
     * @return the PowerBIMeasure that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIMeasure replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (PowerBIMeasure) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the PowerBIMeasure, without replacing existing terms linked to the PowerBIMeasure.
     * Note: this operation must make two API calls — one to retrieve the PowerBIMeasure's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the PowerBIMeasure
     * @param terms the list of terms to append to the PowerBIMeasure
     * @return the PowerBIMeasure that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIMeasure appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (PowerBIMeasure) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a PowerBIMeasure, without replacing all existing terms linked to the PowerBIMeasure.
     * Note: this operation must make two API calls — one to retrieve the PowerBIMeasure's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the PowerBIMeasure
     * @param terms the list of terms to remove from the PowerBIMeasure, which must be referenced by GUID
     * @return the PowerBIMeasure that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIMeasure removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (PowerBIMeasure) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a PowerBIMeasure, without replacing existing Atlan tags linked to the PowerBIMeasure.
     * Note: this operation must make two API calls — one to retrieve the PowerBIMeasure's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated PowerBIMeasure
     */
    public static PowerBIMeasure appendAtlanTags(String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return (PowerBIMeasure) Asset.appendAtlanTags(TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a PowerBIMeasure, without replacing existing Atlan tags linked to the PowerBIMeasure.
     * Note: this operation must make two API calls — one to retrieve the PowerBIMeasure's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated PowerBIMeasure
     */
    public static PowerBIMeasure appendAtlanTags(
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (PowerBIMeasure) Asset.appendAtlanTags(
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a PowerBIMeasure.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the PowerBIMeasure
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        Asset.addAtlanTags(TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a PowerBIMeasure.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the PowerBIMeasure
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
     * Remove an Atlan tag from a PowerBIMeasure.
     *
     * @param qualifiedName of the PowerBIMeasure
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the PowerBIMeasure
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        Asset.removeAtlanTag(TYPE_NAME, qualifiedName, atlanTagName);
    }
}
