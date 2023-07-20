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
import com.atlan.model.enums.AtlanConnectorType;
import com.atlan.model.enums.CertificateStatus;
import com.atlan.model.relations.UniqueAttributes;
import com.atlan.model.structs.GoogleLabel;
import com.atlan.model.structs.GoogleTag;
import com.atlan.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Instance of a Google Cloud Storage object in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class GCSObject extends Asset
        implements IGCSObject, IGCS, IGoogle, IObjectStore, ICloud, IAsset, IReferenceable, ICatalog {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "GCSObject";

    /** Fixed typeName for GCSObjects. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    String gcsAccessControl;

    /** GCS bucket in which the object exists. */
    @Attribute
    IGCSBucket gcsBucket;

    /** Human-readable name of the bucket in which this object exists. */
    @Attribute
    String gcsBucketName;

    /** qualifiedName of the bucket in which this object exists. */
    @Attribute
    String gcsBucketQualifiedName;

    /** TBC */
    @Attribute
    String gcsETag;

    /** TBC */
    @Attribute
    String gcsEncryptionType;

    /** TBC */
    @Attribute
    Long gcsMetaGenerationId;

    /** TBC */
    @Attribute
    String gcsObjectCRC32CHash;

    /** Information about how the object's content should be presented. */
    @Attribute
    String gcsObjectContentDisposition;

    /** TBC */
    @Attribute
    String gcsObjectContentEncoding;

    /** TBC */
    @Attribute
    String gcsObjectContentLanguage;

    /** Type of content in the object. */
    @Attribute
    String gcsObjectContentType;

    /** TBC */
    @Attribute
    Long gcsObjectDataLastModifiedTime;

    /** TBC */
    @Attribute
    Long gcsObjectGenerationId;

    /** TBC */
    @Attribute
    String gcsObjectHoldType;

    /** TBC */
    @Attribute
    String gcsObjectKey;

    /** TBC */
    @Attribute
    String gcsObjectMD5Hash;

    /** TBC */
    @Attribute
    String gcsObjectMediaLink;

    /** TBC */
    @Attribute
    Long gcsObjectRetentionExpirationDate;

    /** Object size in bytes. */
    @Attribute
    Long gcsObjectSize;

    /** TBC */
    @Attribute
    Boolean gcsRequesterPays;

    /** TBC */
    @Attribute
    String gcsStorageClass;

    /** TBC */
    @Attribute
    @Singular
    List<GoogleLabel> googleLabels;

    /** TBC */
    @Attribute
    String googleLocation;

    /** TBC */
    @Attribute
    String googleLocationType;

    /** TBC */
    @Attribute
    String googleProjectId;

    /** TBC */
    @Attribute
    String googleProjectName;

    /** TBC */
    @Attribute
    Long googleProjectNumber;

    /** TBC */
    @Attribute
    String googleService;

    /** TBC */
    @Attribute
    @Singular
    List<GoogleTag> googleTags;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;

    /**
     * Reference to a GCSObject by GUID.
     *
     * @param guid the GUID of the GCSObject to reference
     * @return reference to a GCSObject that can be used for defining a relationship to a GCSObject
     */
    public static GCSObject refByGuid(String guid) {
        return GCSObject.builder().guid(guid).build();
    }

    /**
     * Reference to a GCSObject by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the GCSObject to reference
     * @return reference to a GCSObject that can be used for defining a relationship to a GCSObject
     */
    public static GCSObject refByQualifiedName(String qualifiedName) {
        return GCSObject.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a GCSObject by its GUID, complete with all of its relationships.
     *
     * @param guid of the GCSObject to retrieve
     * @return the requested full GCSObject, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the GCSObject does not exist or the provided GUID is not a GCSObject
     */
    public static GCSObject retrieveByGuid(String guid) throws AtlanException {
        return retrieveByGuid(Atlan.getDefaultClient(), guid);
    }

    /**
     * Retrieves a GCSObject by its GUID, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param guid of the GCSObject to retrieve
     * @return the requested full GCSObject, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the GCSObject does not exist or the provided GUID is not a GCSObject
     */
    public static GCSObject retrieveByGuid(AtlanClient client, String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(client, guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof GCSObject) {
            return (GCSObject) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "GCSObject");
        }
    }

    /**
     * Retrieves a GCSObject by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the GCSObject to retrieve
     * @return the requested full GCSObject, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the GCSObject does not exist
     */
    public static GCSObject retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        return retrieveByQualifiedName(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Retrieves a GCSObject by its qualifiedName, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param qualifiedName of the GCSObject to retrieve
     * @return the requested full GCSObject, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the GCSObject does not exist
     */
    public static GCSObject retrieveByQualifiedName(AtlanClient client, String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(client, TYPE_NAME, qualifiedName);
        if (asset instanceof GCSObject) {
            return (GCSObject) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "GCSObject");
        }
    }

    /**
     * Restore the archived (soft-deleted) GCSObject to active.
     *
     * @param qualifiedName for the GCSObject
     * @return true if the GCSObject is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return restore(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) GCSObject to active.
     *
     * @param client connectivity to the Atlan tenant on which to restore the asset
     * @param qualifiedName for the GCSObject
     * @return true if the GCSObject is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(AtlanClient client, String qualifiedName) throws AtlanException {
        return Asset.restore(client, TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to create a GCSObject.
     *
     * @param name of the GCSObject
     * @param bucketQualifiedName unique name of the bucket in which the GCSObject is contained
     * @return the minimal object necessary to create the GCSObject, as a builder
     */
    public static GCSObjectBuilder<?, ?> creator(String name, String bucketQualifiedName) {
        String connectionQualifiedName = StringUtils.getConnectionQualifiedName(bucketQualifiedName);
        String bucketName = StringUtils.getNameFromQualifiedName(bucketQualifiedName);
        return GCSObject.builder()
                .qualifiedName(generateQualifiedName(name, bucketQualifiedName))
                .name(name)
                .connectionQualifiedName(connectionQualifiedName)
                .connectorType(AtlanConnectorType.GCS)
                .gcsBucketName(bucketName)
                .gcsBucketQualifiedName(bucketQualifiedName)
                .gcsBucket(GCSBucket.refByQualifiedName(bucketQualifiedName));
    }

    /**
     * Generate a unique GCSObject name.
     *
     * @param name of the GCSObject
     * @param bucketQualifiedName unique name of the bucket in which the GCSObject is contained
     * @return a unique name for the GCSObject
     */
    public static String generateQualifiedName(String name, String bucketQualifiedName) {
        return bucketQualifiedName + "/" + name;
    }

    /**
     * Builds the minimal object necessary to update a GCSObject.
     *
     * @param qualifiedName of the GCSObject
     * @param name of the GCSObject
     * @return the minimal request necessary to update the GCSObject, as a builder
     */
    public static GCSObjectBuilder<?, ?> updater(String qualifiedName, String name) {
        return GCSObject.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a GCSObject, from a potentially
     * more-complete GCSObject object.
     *
     * @return the minimal object necessary to update the GCSObject, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for GCSObject are not found in the initial object
     */
    @Override
    public GCSObjectBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "GCSObject", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a GCSObject.
     *
     * @param qualifiedName of the GCSObject
     * @param name of the GCSObject
     * @return the updated GCSObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject removeDescription(String qualifiedName, String name) throws AtlanException {
        return removeDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the system description from a GCSObject.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the GCSObject
     * @param name of the GCSObject
     * @return the updated GCSObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject removeDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (GCSObject) Asset.removeDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a GCSObject.
     *
     * @param qualifiedName of the GCSObject
     * @param name of the GCSObject
     * @return the updated GCSObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return removeUserDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the user's description from a GCSObject.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the GCSObject
     * @param name of the GCSObject
     * @return the updated GCSObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject removeUserDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (GCSObject) Asset.removeUserDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a GCSObject.
     *
     * @param qualifiedName of the GCSObject
     * @param name of the GCSObject
     * @return the updated GCSObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject removeOwners(String qualifiedName, String name) throws AtlanException {
        return removeOwners(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the owners from a GCSObject.
     *
     * @param client connectivity to the Atlan tenant from which to remove the GCSObject's owners
     * @param qualifiedName of the GCSObject
     * @param name of the GCSObject
     * @return the updated GCSObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject removeOwners(AtlanClient client, String qualifiedName, String name) throws AtlanException {
        return (GCSObject) Asset.removeOwners(client, updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a GCSObject.
     *
     * @param qualifiedName of the GCSObject
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated GCSObject, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject updateCertificate(String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return updateCertificate(Atlan.getDefaultClient(), qualifiedName, certificate, message);
    }

    /**
     * Update the certificate on a GCSObject.
     *
     * @param client connectivity to the Atlan tenant on which to update the GCSObject's certificate
     * @param qualifiedName of the GCSObject
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated GCSObject, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject updateCertificate(
            AtlanClient client, String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (GCSObject) Asset.updateCertificate(client, builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a GCSObject.
     *
     * @param qualifiedName of the GCSObject
     * @param name of the GCSObject
     * @return the updated GCSObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject removeCertificate(String qualifiedName, String name) throws AtlanException {
        return removeCertificate(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the certificate from a GCSObject.
     *
     * @param client connectivity to the Atlan tenant from which to remove the GCSObject's certificate
     * @param qualifiedName of the GCSObject
     * @param name of the GCSObject
     * @return the updated GCSObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject removeCertificate(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (GCSObject) Asset.removeCertificate(client, updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a GCSObject.
     *
     * @param qualifiedName of the GCSObject
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return updateAnnouncement(Atlan.getDefaultClient(), qualifiedName, type, title, message);
    }

    /**
     * Update the announcement on a GCSObject.
     *
     * @param client connectivity to the Atlan tenant on which to update the GCSObject's announcement
     * @param qualifiedName of the GCSObject
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject updateAnnouncement(
            AtlanClient client, String qualifiedName, AtlanAnnouncementType type, String title, String message)
            throws AtlanException {
        return (GCSObject) Asset.updateAnnouncement(client, builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a GCSObject.
     *
     * @param qualifiedName of the GCSObject
     * @param name of the GCSObject
     * @return the updated GCSObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return removeAnnouncement(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the announcement from a GCSObject.
     *
     * @param client connectivity to the Atlan client from which to remove the GCSObject's announcement
     * @param qualifiedName of the GCSObject
     * @param name of the GCSObject
     * @return the updated GCSObject, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static GCSObject removeAnnouncement(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (GCSObject) Asset.removeAnnouncement(client, updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the GCSObject.
     *
     * @param qualifiedName for the GCSObject
     * @param name human-readable name of the GCSObject
     * @param terms the list of terms to replace on the GCSObject, or null to remove all terms from the GCSObject
     * @return the GCSObject that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static GCSObject replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return replaceTerms(Atlan.getDefaultClient(), qualifiedName, name, terms);
    }

    /**
     * Replace the terms linked to the GCSObject.
     *
     * @param client connectivity to the Atlan tenant on which to replace the GCSObject's assigned terms
     * @param qualifiedName for the GCSObject
     * @param name human-readable name of the GCSObject
     * @param terms the list of terms to replace on the GCSObject, or null to remove all terms from the GCSObject
     * @return the GCSObject that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static GCSObject replaceTerms(
            AtlanClient client, String qualifiedName, String name, List<IGlossaryTerm> terms) throws AtlanException {
        return (GCSObject) Asset.replaceTerms(client, updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the GCSObject, without replacing existing terms linked to the GCSObject.
     * Note: this operation must make two API calls — one to retrieve the GCSObject's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the GCSObject
     * @param terms the list of terms to append to the GCSObject
     * @return the GCSObject that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static GCSObject appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return appendTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Link additional terms to the GCSObject, without replacing existing terms linked to the GCSObject.
     * Note: this operation must make two API calls — one to retrieve the GCSObject's existing terms,
     * and a second to append the new terms.
     *
     * @param client connectivity to the Atlan tenant on which to append terms to the GCSObject
     * @param qualifiedName for the GCSObject
     * @param terms the list of terms to append to the GCSObject
     * @return the GCSObject that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static GCSObject appendTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (GCSObject) Asset.appendTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a GCSObject, without replacing all existing terms linked to the GCSObject.
     * Note: this operation must make two API calls — one to retrieve the GCSObject's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the GCSObject
     * @param terms the list of terms to remove from the GCSObject, which must be referenced by GUID
     * @return the GCSObject that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static GCSObject removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return removeTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Remove terms from a GCSObject, without replacing all existing terms linked to the GCSObject.
     * Note: this operation must make two API calls — one to retrieve the GCSObject's existing terms,
     * and a second to remove the provided terms.
     *
     * @param client connectivity to the Atlan tenant from which to remove terms from the GCSObject
     * @param qualifiedName for the GCSObject
     * @param terms the list of terms to remove from the GCSObject, which must be referenced by GUID
     * @return the GCSObject that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static GCSObject removeTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (GCSObject) Asset.removeTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a GCSObject, without replacing existing Atlan tags linked to the GCSObject.
     * Note: this operation must make two API calls — one to retrieve the GCSObject's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the GCSObject
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated GCSObject
     */
    public static GCSObject appendAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        return appendAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a GCSObject, without replacing existing Atlan tags linked to the GCSObject.
     * Note: this operation must make two API calls — one to retrieve the GCSObject's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the GCSObject
     * @param qualifiedName of the GCSObject
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated GCSObject
     */
    public static GCSObject appendAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return (GCSObject) Asset.appendAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a GCSObject, without replacing existing Atlan tags linked to the GCSObject.
     * Note: this operation must make two API calls — one to retrieve the GCSObject's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the GCSObject
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated GCSObject
     */
    public static GCSObject appendAtlanTags(
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
     * Add Atlan tags to a GCSObject, without replacing existing Atlan tags linked to the GCSObject.
     * Note: this operation must make two API calls — one to retrieve the GCSObject's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the GCSObject
     * @param qualifiedName of the GCSObject
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated GCSObject
     */
    public static GCSObject appendAtlanTags(
            AtlanClient client,
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (GCSObject) Asset.appendAtlanTags(
                client,
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a GCSObject.
     *
     * @param qualifiedName of the GCSObject
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the GCSObject
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        addAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a GCSObject.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the GCSObject
     * @param qualifiedName of the GCSObject
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the GCSObject
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        Asset.addAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a GCSObject.
     *
     * @param qualifiedName of the GCSObject
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the GCSObject
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
     * Add Atlan tags to a GCSObject.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the GCSObject
     * @param qualifiedName of the GCSObject
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the GCSObject
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
     * Remove an Atlan tag from a GCSObject.
     *
     * @param qualifiedName of the GCSObject
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the GCSObject
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        removeAtlanTag(Atlan.getDefaultClient(), qualifiedName, atlanTagName);
    }

    /**
     * Remove an Atlan tag from a GCSObject.
     *
     * @param client connectivity to the Atlan tenant from which to remove an Atlan tag from a GCSObject
     * @param qualifiedName of the GCSObject
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the GCSObject
     */
    public static void removeAtlanTag(AtlanClient client, String qualifiedName, String atlanTagName)
            throws AtlanException {
        Asset.removeAtlanTag(client, TYPE_NAME, qualifiedName, atlanTagName);
    }
}
