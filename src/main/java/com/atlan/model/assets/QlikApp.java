/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.Atlan;
import com.atlan.AtlanClient;
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
 * Instance of a Qlik App in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class QlikApp extends Asset implements IQlikApp, IQlik, IBI, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "QlikApp";

    /** Fixed typeName for QlikApps. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

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
    String qlikAppId;

    /** TBC */
    @Attribute
    String qlikAppQualifiedName;

    /** Static space taken up by the app. */
    @Attribute
    Long qlikAppStaticByteSize;

    /** Whether section access or data masking is enabled (true) or not (false). */
    @Attribute
    Boolean qlikHasSectionAccess;

    /** TBC */
    @Attribute
    String qlikId;

    /** Whether the app is in direct query mode (true) or not (false). */
    @Attribute
    Boolean qlikIsDirectQueryMode;

    /** Whether the app is encrypted (true) or not (false). */
    @Attribute
    Boolean qlikIsEncrypted;

    /** TBC */
    @Attribute
    Boolean qlikIsPublished;

    /** Origin App ID of the Qlik app. */
    @Attribute
    String qlikOriginAppId;

    /** TBC */
    @Attribute
    String qlikOwnerId;

    /** TBC */
    @Attribute
    String qlikQRI;

    /** Sheets that exist within the app. */
    @Attribute
    @Singular
    SortedSet<IQlikSheet> qlikSheets;

    /** Space in which the app exists. */
    @Attribute
    IQlikSpace qlikSpace;

    /** TBC */
    @Attribute
    String qlikSpaceId;

    /** TBC */
    @Attribute
    String qlikSpaceQualifiedName;

    /**
     * Reference to a QlikApp by GUID.
     *
     * @param guid the GUID of the QlikApp to reference
     * @return reference to a QlikApp that can be used for defining a relationship to a QlikApp
     */
    public static QlikApp refByGuid(String guid) {
        return QlikApp.builder().guid(guid).build();
    }

    /**
     * Reference to a QlikApp by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the QlikApp to reference
     * @return reference to a QlikApp that can be used for defining a relationship to a QlikApp
     */
    public static QlikApp refByQualifiedName(String qualifiedName) {
        return QlikApp.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a QlikApp by its GUID, complete with all of its relationships.
     *
     * @param guid of the QlikApp to retrieve
     * @return the requested full QlikApp, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the QlikApp does not exist or the provided GUID is not a QlikApp
     */
    public static QlikApp retrieveByGuid(String guid) throws AtlanException {
        return retrieveByGuid(Atlan.getDefaultClient(), guid);
    }

    /**
     * Retrieves a QlikApp by its GUID, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param guid of the QlikApp to retrieve
     * @return the requested full QlikApp, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the QlikApp does not exist or the provided GUID is not a QlikApp
     */
    public static QlikApp retrieveByGuid(AtlanClient client, String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(client, guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof QlikApp) {
            return (QlikApp) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "QlikApp");
        }
    }

    /**
     * Retrieves a QlikApp by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the QlikApp to retrieve
     * @return the requested full QlikApp, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the QlikApp does not exist
     */
    public static QlikApp retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        return retrieveByQualifiedName(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Retrieves a QlikApp by its qualifiedName, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param qualifiedName of the QlikApp to retrieve
     * @return the requested full QlikApp, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the QlikApp does not exist
     */
    public static QlikApp retrieveByQualifiedName(AtlanClient client, String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(client, TYPE_NAME, qualifiedName);
        if (asset instanceof QlikApp) {
            return (QlikApp) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "QlikApp");
        }
    }

    /**
     * Restore the archived (soft-deleted) QlikApp to active.
     *
     * @param qualifiedName for the QlikApp
     * @return true if the QlikApp is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return restore(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) QlikApp to active.
     *
     * @param client connectivity to the Atlan tenant on which to restore the asset
     * @param qualifiedName for the QlikApp
     * @return true if the QlikApp is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(AtlanClient client, String qualifiedName) throws AtlanException {
        return Asset.restore(client, TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a QlikApp.
     *
     * @param qualifiedName of the QlikApp
     * @param name of the QlikApp
     * @return the minimal request necessary to update the QlikApp, as a builder
     */
    public static QlikAppBuilder<?, ?> updater(String qualifiedName, String name) {
        return QlikApp.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a QlikApp, from a potentially
     * more-complete QlikApp object.
     *
     * @return the minimal object necessary to update the QlikApp, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for QlikApp are not found in the initial object
     */
    @Override
    public QlikAppBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "QlikApp", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a QlikApp.
     *
     * @param qualifiedName of the QlikApp
     * @param name of the QlikApp
     * @return the updated QlikApp, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp removeDescription(String qualifiedName, String name) throws AtlanException {
        return removeDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the system description from a QlikApp.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the QlikApp
     * @param name of the QlikApp
     * @return the updated QlikApp, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp removeDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (QlikApp) Asset.removeDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a QlikApp.
     *
     * @param qualifiedName of the QlikApp
     * @param name of the QlikApp
     * @return the updated QlikApp, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return removeUserDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the user's description from a QlikApp.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the QlikApp
     * @param name of the QlikApp
     * @return the updated QlikApp, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp removeUserDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (QlikApp) Asset.removeUserDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a QlikApp.
     *
     * @param qualifiedName of the QlikApp
     * @param name of the QlikApp
     * @return the updated QlikApp, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp removeOwners(String qualifiedName, String name) throws AtlanException {
        return removeOwners(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the owners from a QlikApp.
     *
     * @param client connectivity to the Atlan tenant from which to remove the QlikApp's owners
     * @param qualifiedName of the QlikApp
     * @param name of the QlikApp
     * @return the updated QlikApp, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp removeOwners(AtlanClient client, String qualifiedName, String name) throws AtlanException {
        return (QlikApp) Asset.removeOwners(client, updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a QlikApp.
     *
     * @param qualifiedName of the QlikApp
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated QlikApp, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp updateCertificate(String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return updateCertificate(Atlan.getDefaultClient(), qualifiedName, certificate, message);
    }

    /**
     * Update the certificate on a QlikApp.
     *
     * @param client connectivity to the Atlan tenant on which to update the QlikApp's certificate
     * @param qualifiedName of the QlikApp
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated QlikApp, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp updateCertificate(
            AtlanClient client, String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (QlikApp) Asset.updateCertificate(client, builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a QlikApp.
     *
     * @param qualifiedName of the QlikApp
     * @param name of the QlikApp
     * @return the updated QlikApp, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp removeCertificate(String qualifiedName, String name) throws AtlanException {
        return removeCertificate(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the certificate from a QlikApp.
     *
     * @param client connectivity to the Atlan tenant from which to remove the QlikApp's certificate
     * @param qualifiedName of the QlikApp
     * @param name of the QlikApp
     * @return the updated QlikApp, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp removeCertificate(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (QlikApp) Asset.removeCertificate(client, updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a QlikApp.
     *
     * @param qualifiedName of the QlikApp
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return updateAnnouncement(Atlan.getDefaultClient(), qualifiedName, type, title, message);
    }

    /**
     * Update the announcement on a QlikApp.
     *
     * @param client connectivity to the Atlan tenant on which to update the QlikApp's announcement
     * @param qualifiedName of the QlikApp
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp updateAnnouncement(
            AtlanClient client, String qualifiedName, AtlanAnnouncementType type, String title, String message)
            throws AtlanException {
        return (QlikApp) Asset.updateAnnouncement(client, builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a QlikApp.
     *
     * @param qualifiedName of the QlikApp
     * @param name of the QlikApp
     * @return the updated QlikApp, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return removeAnnouncement(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the announcement from a QlikApp.
     *
     * @param client connectivity to the Atlan client from which to remove the QlikApp's announcement
     * @param qualifiedName of the QlikApp
     * @param name of the QlikApp
     * @return the updated QlikApp, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikApp removeAnnouncement(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (QlikApp) Asset.removeAnnouncement(client, updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the QlikApp.
     *
     * @param qualifiedName for the QlikApp
     * @param name human-readable name of the QlikApp
     * @param terms the list of terms to replace on the QlikApp, or null to remove all terms from the QlikApp
     * @return the QlikApp that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static QlikApp replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return replaceTerms(Atlan.getDefaultClient(), qualifiedName, name, terms);
    }

    /**
     * Replace the terms linked to the QlikApp.
     *
     * @param client connectivity to the Atlan tenant on which to replace the QlikApp's assigned terms
     * @param qualifiedName for the QlikApp
     * @param name human-readable name of the QlikApp
     * @param terms the list of terms to replace on the QlikApp, or null to remove all terms from the QlikApp
     * @return the QlikApp that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static QlikApp replaceTerms(AtlanClient client, String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (QlikApp) Asset.replaceTerms(client, updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the QlikApp, without replacing existing terms linked to the QlikApp.
     * Note: this operation must make two API calls — one to retrieve the QlikApp's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the QlikApp
     * @param terms the list of terms to append to the QlikApp
     * @return the QlikApp that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static QlikApp appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return appendTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Link additional terms to the QlikApp, without replacing existing terms linked to the QlikApp.
     * Note: this operation must make two API calls — one to retrieve the QlikApp's existing terms,
     * and a second to append the new terms.
     *
     * @param client connectivity to the Atlan tenant on which to append terms to the QlikApp
     * @param qualifiedName for the QlikApp
     * @param terms the list of terms to append to the QlikApp
     * @return the QlikApp that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static QlikApp appendTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (QlikApp) Asset.appendTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a QlikApp, without replacing all existing terms linked to the QlikApp.
     * Note: this operation must make two API calls — one to retrieve the QlikApp's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the QlikApp
     * @param terms the list of terms to remove from the QlikApp, which must be referenced by GUID
     * @return the QlikApp that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static QlikApp removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return removeTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Remove terms from a QlikApp, without replacing all existing terms linked to the QlikApp.
     * Note: this operation must make two API calls — one to retrieve the QlikApp's existing terms,
     * and a second to remove the provided terms.
     *
     * @param client connectivity to the Atlan tenant from which to remove terms from the QlikApp
     * @param qualifiedName for the QlikApp
     * @param terms the list of terms to remove from the QlikApp, which must be referenced by GUID
     * @return the QlikApp that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static QlikApp removeTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (QlikApp) Asset.removeTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a QlikApp, without replacing existing Atlan tags linked to the QlikApp.
     * Note: this operation must make two API calls — one to retrieve the QlikApp's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the QlikApp
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated QlikApp
     */
    public static QlikApp appendAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        return appendAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a QlikApp, without replacing existing Atlan tags linked to the QlikApp.
     * Note: this operation must make two API calls — one to retrieve the QlikApp's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the QlikApp
     * @param qualifiedName of the QlikApp
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated QlikApp
     */
    public static QlikApp appendAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return (QlikApp) Asset.appendAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a QlikApp, without replacing existing Atlan tags linked to the QlikApp.
     * Note: this operation must make two API calls — one to retrieve the QlikApp's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the QlikApp
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated QlikApp
     */
    public static QlikApp appendAtlanTags(
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return appendAtlanTags(
                Atlan.getDefaultClient(),
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a QlikApp, without replacing existing Atlan tags linked to the QlikApp.
     * Note: this operation must make two API calls — one to retrieve the QlikApp's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the QlikApp
     * @param qualifiedName of the QlikApp
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated QlikApp
     */
    public static QlikApp appendAtlanTags(
            AtlanClient client,
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (QlikApp) Asset.appendAtlanTags(
                client,
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a QlikApp.
     *
     * @param qualifiedName of the QlikApp
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the QlikApp
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        addAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a QlikApp.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the QlikApp
     * @param qualifiedName of the QlikApp
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the QlikApp
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        Asset.addAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a QlikApp.
     *
     * @param qualifiedName of the QlikApp
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the QlikApp
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
        addAtlanTags(
                Atlan.getDefaultClient(),
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a QlikApp.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the QlikApp
     * @param qualifiedName of the QlikApp
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the QlikApp
     * @deprecated see {@link #appendAtlanTags(String, List, boolean, boolean, boolean)} instead
     */
    @Deprecated
    public static void addAtlanTags(
            AtlanClient client,
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        Asset.addAtlanTags(
                client,
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Remove an Atlan tag from a QlikApp.
     *
     * @param qualifiedName of the QlikApp
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the QlikApp
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        removeAtlanTag(Atlan.getDefaultClient(), qualifiedName, atlanTagName);
    }

    /**
     * Remove an Atlan tag from a QlikApp.
     *
     * @param client connectivity to the Atlan tenant from which to remove an Atlan tag from a QlikApp
     * @param qualifiedName of the QlikApp
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the QlikApp
     */
    public static void removeAtlanTag(AtlanClient client, String qualifiedName, String atlanTagName)
            throws AtlanException {
        Asset.removeAtlanTag(client, TYPE_NAME, qualifiedName, atlanTagName);
    }
}
