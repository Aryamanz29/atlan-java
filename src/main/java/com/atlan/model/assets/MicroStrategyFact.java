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
import java.util.Map;
import java.util.SortedSet;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Instance of a MicroStrategy fact in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Slf4j
@SuppressWarnings("cast")
public class MicroStrategyFact extends Asset
        implements IMicroStrategyFact, IMicroStrategy, IBI, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "MicroStrategyFact";

    /** Fixed typeName for MicroStrategyFacts. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** TBC */
    @Attribute
    Long microStrategyCertifiedAt;

    /** TBC */
    @Attribute
    String microStrategyCertifiedBy;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<String> microStrategyCubeNames;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<String> microStrategyCubeQualifiedNames;

    /** List of expressions for the fact. */
    @Attribute
    @Singular
    SortedSet<String> microStrategyFactExpressions;

    /** TBC */
    @Attribute
    Boolean microStrategyIsCertified;

    /** TBC */
    @Attribute
    @Singular("putMicroStrategyLocation")
    List<Map<String, String>> microStrategyLocation;

    /** Metrics where the fact is used. */
    @Attribute
    @Singular
    SortedSet<IMicroStrategyMetric> microStrategyMetrics;

    /** Project containing the fact. */
    @Attribute
    IMicroStrategyProject microStrategyProject;

    /** TBC */
    @Attribute
    String microStrategyProjectName;

    /** TBC */
    @Attribute
    String microStrategyProjectQualifiedName;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<String> microStrategyReportNames;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<String> microStrategyReportQualifiedNames;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;

    /**
     * Reference to a MicroStrategyFact by GUID.
     *
     * @param guid the GUID of the MicroStrategyFact to reference
     * @return reference to a MicroStrategyFact that can be used for defining a relationship to a MicroStrategyFact
     */
    public static MicroStrategyFact refByGuid(String guid) {
        return MicroStrategyFact.builder().guid(guid).build();
    }

    /**
     * Reference to a MicroStrategyFact by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the MicroStrategyFact to reference
     * @return reference to a MicroStrategyFact that can be used for defining a relationship to a MicroStrategyFact
     */
    public static MicroStrategyFact refByQualifiedName(String qualifiedName) {
        return MicroStrategyFact.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a MicroStrategyFact by its GUID, complete with all of its relationships.
     *
     * @param guid of the MicroStrategyFact to retrieve
     * @return the requested full MicroStrategyFact, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the MicroStrategyFact does not exist or the provided GUID is not a MicroStrategyFact
     */
    public static MicroStrategyFact retrieveByGuid(String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof MicroStrategyFact) {
            return (MicroStrategyFact) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "MicroStrategyFact");
        }
    }

    /**
     * Retrieves a MicroStrategyFact by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the MicroStrategyFact to retrieve
     * @return the requested full MicroStrategyFact, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the MicroStrategyFact does not exist
     */
    public static MicroStrategyFact retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(TYPE_NAME, qualifiedName);
        if (asset instanceof MicroStrategyFact) {
            return (MicroStrategyFact) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "MicroStrategyFact");
        }
    }

    /**
     * Restore the archived (soft-deleted) MicroStrategyFact to active.
     *
     * @param qualifiedName for the MicroStrategyFact
     * @return true if the MicroStrategyFact is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return Asset.restore(TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a MicroStrategyFact.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param name of the MicroStrategyFact
     * @return the minimal request necessary to update the MicroStrategyFact, as a builder
     */
    public static MicroStrategyFactBuilder<?, ?> updater(String qualifiedName, String name) {
        return MicroStrategyFact.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a MicroStrategyFact, from a potentially
     * more-complete MicroStrategyFact object.
     *
     * @return the minimal object necessary to update the MicroStrategyFact, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for MicroStrategyFact are not found in the initial object
     */
    @Override
    public MicroStrategyFactBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "MicroStrategyFact", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a MicroStrategyFact.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param name of the MicroStrategyFact
     * @return the updated MicroStrategyFact, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyFact removeDescription(String qualifiedName, String name) throws AtlanException {
        return (MicroStrategyFact) Asset.removeDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a MicroStrategyFact.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param name of the MicroStrategyFact
     * @return the updated MicroStrategyFact, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyFact removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return (MicroStrategyFact) Asset.removeUserDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a MicroStrategyFact.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param name of the MicroStrategyFact
     * @return the updated MicroStrategyFact, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyFact removeOwners(String qualifiedName, String name) throws AtlanException {
        return (MicroStrategyFact) Asset.removeOwners(updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a MicroStrategyFact.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated MicroStrategyFact, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyFact updateCertificate(
            String qualifiedName, CertificateStatus certificate, String message) throws AtlanException {
        return (MicroStrategyFact) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a MicroStrategyFact.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param name of the MicroStrategyFact
     * @return the updated MicroStrategyFact, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyFact removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (MicroStrategyFact) Asset.removeCertificate(updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a MicroStrategyFact.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyFact updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (MicroStrategyFact) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a MicroStrategyFact.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param name of the MicroStrategyFact
     * @return the updated MicroStrategyFact, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyFact removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (MicroStrategyFact) Asset.removeAnnouncement(updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the MicroStrategyFact.
     *
     * @param qualifiedName for the MicroStrategyFact
     * @param name human-readable name of the MicroStrategyFact
     * @param terms the list of terms to replace on the MicroStrategyFact, or null to remove all terms from the MicroStrategyFact
     * @return the MicroStrategyFact that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyFact replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (MicroStrategyFact) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the MicroStrategyFact, without replacing existing terms linked to the MicroStrategyFact.
     * Note: this operation must make two API calls — one to retrieve the MicroStrategyFact's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the MicroStrategyFact
     * @param terms the list of terms to append to the MicroStrategyFact
     * @return the MicroStrategyFact that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyFact appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (MicroStrategyFact) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a MicroStrategyFact, without replacing all existing terms linked to the MicroStrategyFact.
     * Note: this operation must make two API calls — one to retrieve the MicroStrategyFact's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the MicroStrategyFact
     * @param terms the list of terms to remove from the MicroStrategyFact, which must be referenced by GUID
     * @return the MicroStrategyFact that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyFact removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (MicroStrategyFact) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a MicroStrategyFact, without replacing existing Atlan tags linked to the MicroStrategyFact.
     * Note: this operation must make two API calls — one to retrieve the MicroStrategyFact's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated MicroStrategyFact
     */
    public static MicroStrategyFact appendAtlanTags(String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return (MicroStrategyFact) Asset.appendAtlanTags(TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a MicroStrategyFact, without replacing existing Atlan tags linked to the MicroStrategyFact.
     * Note: this operation must make two API calls — one to retrieve the MicroStrategyFact's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated MicroStrategyFact
     */
    public static MicroStrategyFact appendAtlanTags(
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (MicroStrategyFact) Asset.appendAtlanTags(
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a MicroStrategyFact.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the MicroStrategyFact
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        Asset.addAtlanTags(TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a MicroStrategyFact.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the MicroStrategyFact
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
     * Remove an Atlan tag from a MicroStrategyFact.
     *
     * @param qualifiedName of the MicroStrategyFact
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the MicroStrategyFact
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        Asset.removeAtlanTag(TYPE_NAME, qualifiedName, atlanTagName);
    }
}