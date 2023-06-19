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
 * Instance of a Power BI dataset in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class PowerBIDataset extends Asset implements IPowerBIDataset, IPowerBI, IBI, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "PowerBIDataset";

    /** Fixed typeName for PowerBIDatasets. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IPowerBIDataflow> dataflows;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IPowerBIDatasource> datasources;

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
    PowerBIEndorsementType powerBIEndorsement;

    /** TBC */
    @Attribute
    String powerBIFormatString;

    /** TBC */
    @Attribute
    Boolean powerBIIsHidden;

    /** TBC */
    @Attribute
    String powerBITableQualifiedName;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IPowerBIReport> reports;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IPowerBITable> tables;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IPowerBITile> tiles;

    /** TBC */
    @Attribute
    String webUrl;

    /** TBC */
    @Attribute
    IPowerBIWorkspace workspace;

    /** TBC */
    @Attribute
    String workspaceQualifiedName;

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
     * Retrieves a PowerBIDataset by its GUID, complete with all of its relationships.
     *
     * @param guid of the PowerBIDataset to retrieve
     * @return the requested full PowerBIDataset, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIDataset does not exist or the provided GUID is not a PowerBIDataset
     */
    public static PowerBIDataset retrieveByGuid(String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof PowerBIDataset) {
            return (PowerBIDataset) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "PowerBIDataset");
        }
    }

    /**
     * Retrieves a PowerBIDataset by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the PowerBIDataset to retrieve
     * @return the requested full PowerBIDataset, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIDataset does not exist
     */
    public static PowerBIDataset retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(TYPE_NAME, qualifiedName);
        if (asset instanceof PowerBIDataset) {
            return (PowerBIDataset) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "PowerBIDataset");
        }
    }

    /**
     * Restore the archived (soft-deleted) PowerBIDataset to active.
     *
     * @param qualifiedName for the PowerBIDataset
     * @return true if the PowerBIDataset is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return Asset.restore(TYPE_NAME, qualifiedName);
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
     * @throws InvalidRequestException if any of the minimal set of required properties for PowerBIDataset are not found in the initial object
     */
    @Override
    public PowerBIDatasetBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "PowerBIDataset", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param name of the PowerBIDataset
     * @return the updated PowerBIDataset, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIDataset removeDescription(String qualifiedName, String name) throws AtlanException {
        return (PowerBIDataset) Asset.removeDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param name of the PowerBIDataset
     * @return the updated PowerBIDataset, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIDataset removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return (PowerBIDataset) Asset.removeUserDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param name of the PowerBIDataset
     * @return the updated PowerBIDataset, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIDataset removeOwners(String qualifiedName, String name) throws AtlanException {
        return (PowerBIDataset) Asset.removeOwners(updater(qualifiedName, name));
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
    public static PowerBIDataset updateCertificate(String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
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
        return (PowerBIDataset) Asset.removeCertificate(updater(qualifiedName, name));
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
        return (PowerBIDataset) Asset.removeAnnouncement(updater(qualifiedName, name));
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
    public static PowerBIDataset replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
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
    public static PowerBIDataset appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
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
    public static PowerBIDataset removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (PowerBIDataset) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a PowerBIDataset, without replacing existing Atlan tags linked to the PowerBIDataset.
     * Note: this operation must make two API calls — one to retrieve the PowerBIDataset's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated PowerBIDataset
     */
    public static PowerBIDataset appendAtlanTags(String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return (PowerBIDataset) Asset.appendAtlanTags(TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a PowerBIDataset, without replacing existing Atlan tags linked to the PowerBIDataset.
     * Note: this operation must make two API calls — one to retrieve the PowerBIDataset's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated PowerBIDataset
     */
    public static PowerBIDataset appendAtlanTags(
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (PowerBIDataset) Asset.appendAtlanTags(
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the PowerBIDataset
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        Asset.addAtlanTags(TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the PowerBIDataset
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
     * Remove an Atlan tag from a PowerBIDataset.
     *
     * @param qualifiedName of the PowerBIDataset
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the PowerBIDataset
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        Asset.removeAtlanTag(TYPE_NAME, qualifiedName, atlanTagName);
    }
}
