/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.api.EntityBulkEndpoint;
import com.atlan.api.EntityUniqueAttributesEndpoint;
import com.atlan.exception.AtlanException;
import com.atlan.exception.InvalidRequestException;
import com.atlan.model.core.Entity;
import com.atlan.model.core.EntityMutationResponse;
import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.AtlanCertificateStatus;
import com.atlan.model.enums.AtlanConnectorType;
import com.atlan.model.enums.AtlanStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import java.util.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Catalog.class, name = Catalog.TYPE_NAME),
    @JsonSubTypes.Type(value = Namespace.class, name = Namespace.TYPE_NAME),
    @JsonSubTypes.Type(value = Glossary.class, name = Glossary.TYPE_NAME),
    @JsonSubTypes.Type(value = GlossaryCategory.class, name = GlossaryCategory.TYPE_NAME),
    @JsonSubTypes.Type(value = GlossaryTerm.class, name = GlossaryTerm.TYPE_NAME),
    @JsonSubTypes.Type(value = Cloud.class, name = Cloud.TYPE_NAME),
    @JsonSubTypes.Type(value = Connection.class, name = Connection.TYPE_NAME),
})
public abstract class Asset extends Entity {

    public static final String TYPE_NAME = "Asset";

    /**
     * Unique name for this entity. This is typically a concatenation of the asset's name onto its
     * parent's qualifiedName.
     */
    @Attribute
    String qualifiedName;

    /** Human-readable name of the asset. */
    @Attribute
    String name;

    /** Name used for display purposes (in user interfaces). */
    @Attribute
    String displayName;

    /** Description of the asset, as crawled from a source. */
    @Attribute
    String description;

    /**
     * Description of the asset, as provided by a user. If present, this will be used for the
     * description in user interfaces. If not present, the description will be used.
     */
    @Attribute
    String userDescription;

    /** Name of the Atlan workspace in which the asset exists. */
    @Attribute
    String tenantId;

    /** Status of the asset's certification. */
    @Attribute
    AtlanCertificateStatus certificateStatus;

    /**
     * Human-readable descriptive message that can optionally be submitted when the
     * `certificateStatus` is changed.
     */
    @Attribute
    String certificateStatusMessage;

    /** Name of the user who last updated the `certificateStatus`. */
    @Attribute
    String certificateUpdatedBy;

    /** Time (epoch) at which the `certificateStatus` was last updated, in milliseconds. */
    @Attribute
    Long certificateUpdatedAt;

    /**
     * Brief title for the announcement on this asset. Required when `announcementType` is specified.
     */
    @Attribute
    String announcementTitle;

    /** Detailed message to include in the announcement on this asset. */
    @Attribute
    String announcementMessage;

    /** Time (epoch) at which the announcement was last updated, in milliseconds. */
    @Attribute
    Long announcementUpdatedAt;

    /** User who last updated the announcement. */
    @Attribute
    String announcementUpdatedBy;

    /** Type of announcement on the asset. */
    @Attribute
    AtlanAnnouncementType announcementType;

    /** List of users who own the asset. */
    @Singular
    @Attribute
    SortedSet<String> ownerUsers;

    /** List of groups who own the asset. */
    @Singular
    @Attribute
    SortedSet<String> ownerGroups;

    /** List of users who administer the asset. (This is only used for Connection assets.) */
    @Singular
    @Attribute
    SortedSet<String> adminUsers;

    /** List of groups who administer the asset. (This is only used for Connection assets.) */
    @Singular
    @Attribute
    SortedSet<String> adminGroups;

    /** List of roles who administer the asset. (This is only used for Connection assets.) */
    @Singular
    @Attribute
    SortedSet<String> adminRoles;

    /** Unused. */
    @Singular
    @Attribute
    SortedSet<String> viewerUsers;

    /** Unused. */
    @Singular
    @Attribute
    SortedSet<String> viewerGroups;

    /** Type of the connector through which this asset is accessible. */
    @Attribute
    @JsonProperty("connectorName")
    AtlanConnectorType connectorType;

    /** Unused. */
    @Attribute
    String connectionName;

    /** Unique name of the connection through which this asset is accessible. */
    @Attribute
    String connectionQualifiedName;

    /** Indicates whether this asset has lineage (true) or not. */
    @Attribute
    @JsonProperty("__hasLineage")
    Boolean hasLineage;

    /** Unused. */
    @Attribute
    Boolean isDiscoverable;

    /** Unused. */
    @Attribute
    Boolean isEditable;

    /** Unused. */
    @Attribute
    Object subType;

    /** Unused. */
    @Attribute
    Double viewScore;

    /** Unused. */
    @Attribute
    Double popularityScore;

    /** Unused. */
    @Attribute
    String sourceOwners;

    /** URL to the resource within the source application. */
    @Attribute
    String sourceURL;

    /** URL to create an embed for a resource (for example, an image of a dashboard) within Atlan. */
    @Attribute
    String sourceEmbedURL;

    /** Name of the crawler that last synchronized this asset. */
    @Attribute
    String lastSyncWorkflowName;

    /** Time (epoch) at which the asset was last crawled, in milliseconds. */
    @Attribute
    Long lastSyncRunAt;

    /** Name of the last run of the crawler that last synchronized this asset. */
    @Attribute
    String lastSyncRun;

    /** Who created the asset. */
    @Attribute
    String sourceCreatedBy;

    /** Time (epoch) at which the asset was created, in milliseconds. */
    @Attribute
    Long sourceCreatedAt;

    /** Time (epoch) at which the asset was last updated, in milliseconds. */
    @Attribute
    Long sourceUpdatedAt;

    /** Who last updated the asset. */
    @Attribute
    String sourceUpdatedBy;

    /** TBC */
    @Attribute
    String dbtQualifiedName;

    /** TBC */
    @Attribute
    String assetDbtAlias;

    /** TBC */
    @Attribute
    String assetDbtMeta;

    /** TBC */
    @Attribute
    String assetDbtUniqueId;

    /** TBC */
    @Attribute
    String assetDbtAccountName;

    /** TBC */
    @Attribute
    String assetDbtProjectName;

    /** TBC */
    @Attribute
    String assetDbtPackageName;

    /** TBC */
    @Attribute
    String assetDbtJobName;

    /** TBC */
    @Attribute
    String assetDbtJobSchedule;

    /** TBC */
    @Attribute
    String assetDbtJobStatus;

    /** TBC */
    @Attribute
    String assetDbtJobScheduleCronHumanized;

    /** TBC */
    @Attribute
    Long assetDbtJobLastRun;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunUrl;

    /** TBC */
    @Attribute
    Long assetDbtJobLastRunCreatedAt;

    /** TBC */
    @Attribute
    Long assetDbtJobLastRunUpdatedAt;

    /** TBC */
    @Attribute
    Long assetDbtJobLastRunDequedAt;

    /** TBC */
    @Attribute
    Long assetDbtJobLastRunStartedAt;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunTotalDuration;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunTotalDurationHumanized;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunQueuedDuration;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunQueuedDurationHumanized;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunRunDuration;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunRunDurationHumanized;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunGitBranch;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunGitSha;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunStatusMessage;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunOwnerThreadId;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunExecutedByThreadId;

    /** TBC */
    @Attribute
    Boolean assetDbtJobLastRunArtifactsSaved;

    /** TBC */
    @Attribute
    String assetDbtJobLastRunArtifactS3Path;

    /** TBC */
    @Attribute
    Boolean assetDbtJobLastRunHasDocsGenerated;

    /** TBC */
    @Attribute
    Boolean assetDbtJobLastRunHasSourcesGenerated;

    /** TBC */
    @Attribute
    Boolean assetDbtJobLastRunNotificationsSent;

    /** TBC */
    @Attribute
    Long assetDbtJobNextRun;

    /** TBC */
    @Attribute
    String assetDbtJobNextRunHumanized;

    /** TBC */
    @Attribute
    String assetDbtEnvironmentName;

    /** TBC */
    @Attribute
    String assetDbtEnvironmentDbtVersion;

    /** TBC */
    @Singular
    @Attribute
    SortedSet<String> assetDbtTags;

    /** TBC */
    @Attribute
    String assetDbtSemanticLayerProxyUrl;

    /** Resources that are linked to this asset. */
    @Singular
    @Attribute
    SortedSet<Link> links;

    /** Readme that is linked to this asset. */
    @Attribute
    Readme readme;

    /** Terms that are linked to this asset. */
    @Singular
    @Attribute
    SortedSet<GlossaryTerm> meanings;

    /** Remove the system description from the asset, if any is set on the asset. */
    public void removeDescription() {
        addNullField("description");
    }

    /** Remove the user's description from the asset, if any is set on the asset. */
    public void removeUserDescription() {
        addNullField("userDescription");
    }

    /** Remove the owners from the asset, if any are set on the asset. */
    public void removeOwners() {
        addNullField("ownerUsers");
        addNullField("ownerGroups");
    }

    /** Remove the certificate from the asset, if any is set on the asset. */
    public void removeCertificate() {
        addNullField("certificateStatus");
        addNullField("certificateStatusMessage");
    }

    /** Remove the announcement from the asset, if any is set on the asset. */
    public void removeAnnouncement() {
        addNullField("announcementType");
        addNullField("announcementTitle");
        addNullField("announcementMessage");
    }

    /** Remove the linked terms from the asset, if any are set on the asset. */
    public void removeMeanings() {
        addNullField("meanings");
    }

    protected abstract AssetBuilder<?, ?> trimToRequired();

    /**
     * Update the certificate on an asset.
     *
     * @param builder the builder to use for updating the certificate
     * @param certificate certificate to set
     * @param message (optional) message to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    protected static Entity updateCertificate(
            AssetBuilder<?, ?> builder, AtlanCertificateStatus certificate, String message) throws AtlanException {
        builder = builder.certificateStatus(certificate);
        if (message != null && message.length() > 1) {
            builder = builder.certificateStatusMessage(message);
        }
        return updateAttributes(builder.build());
    }

    /**
     * Remove the certificate on an asset.
     *
     * @param builder the builder to use for removing the certificate
     * @return the result of the removal, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    protected static Entity removeCertificate(AssetBuilder<?, ?> builder) throws AtlanException {
        Asset asset = builder.build();
        asset.removeCertificate();
        EntityMutationResponse response = asset.upsert();
        if (response != null && !response.getUpdatedEntities().isEmpty()) {
            return response.getUpdatedEntities().get(0);
        } else {
            return null;
        }
    }

    /**
     * Update the announcement on an asset.
     *
     * @param builder the builder to use for updating the announcement
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    protected static Entity updateAnnouncement(
            AssetBuilder<?, ?> builder, AtlanAnnouncementType type, String title, String message)
            throws AtlanException {
        builder = builder.announcementType(type);
        if (title != null && title.length() > 1) {
            builder = builder.announcementTitle(title);
        }
        if (message != null && message.length() > 1) {
            builder = builder.announcementMessage(message);
        }
        return updateAttributes(builder.build());
    }

    /**
     * Remove the announcement on an asset.
     *
     * @param builder the builder to use for removing the announcement
     * @return the result of the removal, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    protected static Entity removeAnnouncement(AssetBuilder<?, ?> builder) throws AtlanException {
        Asset asset = builder.build();
        asset.removeAnnouncement();
        EntityMutationResponse response = asset.upsert();
        if (response != null && !response.getUpdatedEntities().isEmpty()) {
            return response.getUpdatedEntities().get(0);
        } else {
            return null;
        }
    }

    /**
     * Remove the system description from an asset.
     *
     * @param builder the builder to use for removing the description
     * @return the result of the removal, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    protected static Entity removeDescription(AssetBuilder<?, ?> builder) throws AtlanException {
        Asset asset = builder.build();
        asset.removeDescription();
        EntityMutationResponse response = asset.upsert();
        if (response != null && !response.getUpdatedEntities().isEmpty()) {
            return response.getUpdatedEntities().get(0);
        } else {
            return null;
        }
    }

    /**
     * Remove the user-provided description from an asset.
     *
     * @param builder the builder to use for removing the description
     * @return the result of the removal, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    protected static Entity removeUserDescription(AssetBuilder<?, ?> builder) throws AtlanException {
        Asset asset = builder.build();
        asset.removeUserDescription();
        EntityMutationResponse response = asset.upsert();
        if (response != null && !response.getUpdatedEntities().isEmpty()) {
            return response.getUpdatedEntities().get(0);
        } else {
            return null;
        }
    }

    /**
     * Remove the owners from an asset.
     *
     * @param builder the builder to use for removing the owners
     * @return the result of the removal, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    protected static Entity removeOwners(AssetBuilder<?, ?> builder) throws AtlanException {
        Asset asset = builder.build();
        asset.removeOwners();
        EntityMutationResponse response = asset.upsert();
        if (response != null && !response.getUpdatedEntities().isEmpty()) {
            return response.getUpdatedEntities().get(0);
        } else {
            return null;
        }
    }

    private static Entity updateAttributes(Asset asset) throws AtlanException {
        EntityMutationResponse response = EntityBulkEndpoint.upsert(asset, false, false);
        if (response != null && !response.getUpdatedEntities().isEmpty()) {
            return response.getUpdatedEntities().get(0);
        }
        return null;
    }

    /**
     * Update the certificate on an asset.
     *
     * @param builder the builder to use for updating the certificate
     * @param typeName type of the asset
     * @param qualifiedName for the asset
     * @param certificate certificate to set
     * @param message (optional) message to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    protected static Entity updateCertificate(
            AssetBuilder<?, ?> builder,
            String typeName,
            String qualifiedName,
            AtlanCertificateStatus certificate,
            String message)
            throws AtlanException {
        builder = builder.qualifiedName(qualifiedName).certificateStatus(certificate);
        if (message != null && message.length() > 1) {
            builder = builder.certificateStatusMessage(message);
        }
        return updateAttributes(typeName, qualifiedName, builder.build());
    }

    /**
     * Update the announcement on an asset.
     *
     * @param builder the builder to use for updating the announcement
     * @param typeName type of the asset
     * @param qualifiedName for the asset
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    protected static Entity updateAnnouncement(
            AssetBuilder<?, ?> builder,
            String typeName,
            String qualifiedName,
            AtlanAnnouncementType type,
            String title,
            String message)
            throws AtlanException {
        builder = builder.qualifiedName(qualifiedName).announcementType(type);
        if (title != null && title.length() > 1) {
            builder = builder.announcementTitle(title);
        }
        if (message != null && message.length() > 1) {
            builder = builder.announcementMessage(message);
        }
        return updateAttributes(typeName, qualifiedName, builder.build());
    }

    private static Entity updateAttributes(String typeName, String qualifiedName, Asset asset) throws AtlanException {
        EntityMutationResponse response =
                EntityUniqueAttributesEndpoint.updateAttributes(typeName, qualifiedName, asset);
        if (response != null && !response.getPartiallyUpdatedEntities().isEmpty()) {
            return response.getPartiallyUpdatedEntities().get(0);
        }
        if (response != null && !response.getUpdatedEntities().isEmpty()) {
            return response.getUpdatedEntities().get(0);
        }
        return null;
    }

    /**
     * Restore an archived (soft-deleted) asset to active.
     *
     * @return the asset that was restored
     * @throws AtlanException on any API problems
     */
    protected static Entity restore(String typeName, String qualifiedName) throws AtlanException {
        Asset existing = getExistingAsset(typeName, qualifiedName);
        if (existing != null && existing.getStatus() != AtlanStatus.ACTIVE) {
            existing.setStatus(AtlanStatus.ACTIVE);
            return updateRelationships(existing);
        } else {
            return existing;
        }
    }

    /**
     * Replace the terms linked to an asset.
     *
     * @param builder the builder to use for updating the terms
     * @param terms the list of terms to replace on the asset, or null to remove all terms from an asset
     * @return the asset that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    protected static Entity replaceTerms(AssetBuilder<?, ?> builder, List<GlossaryTerm> terms) throws AtlanException {
        if (terms == null || terms.isEmpty()) {
            Asset asset = builder.build();
            asset.removeMeanings();
            return updateRelationships(asset);
        } else {
            return updateRelationships(builder.meanings(terms).build());
        }
    }

    /**
     * Link additional terms to an asset, without replacing existing terms linked to the asset.
     * Note: this operation must make two API calls — one to retrieve the asset's existing terms,
     * and a second to append the new terms.
     *
     * @param typeName type of the asset
     * @param qualifiedName for the asset
     * @param terms the list of terms to append to the asset
     * @return the asset that was updated (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    protected static Entity appendTerms(String typeName, String qualifiedName, List<GlossaryTerm> terms)
            throws AtlanException {
        Asset existing = getExistingAsset(typeName, qualifiedName);
        if (existing != null) {
            Set<GlossaryTerm> replacementTerms = new TreeSet<>();
            Set<GlossaryTerm> existingTerms = existing.getMeanings();
            if (existingTerms != null) {
                for (GlossaryTerm term : existingTerms) {
                    if (term.getRelationshipStatus() != AtlanStatus.DELETED) {
                        // Only re-include the terms that are not already deleted
                        replacementTerms.add(term);
                    }
                }
            }
            replacementTerms.addAll(terms);
            AssetBuilder<?, ?> minimal = existing.trimToRequired();
            return updateRelationships(minimal.meanings(replacementTerms).build());
        }
        return null;
    }

    /**
     * Remove terms from an asset, without replacing all existing terms linked to the asset.
     * Note: this operation must make two API calls — one to retrieve the asset's existing terms,
     * and a second to remove the provided terms.
     *
     * @param typeName type of the asset
     * @param qualifiedName for the asset
     * @param terms the list of terms to remove from the asset (note: these must be references by GUID
     *              in order to efficiently remove any existing terms)
     * @return the asset that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     * @throws InvalidRequestException if any of the passed terms are not valid references by GUID to a term
     */
    protected static Entity removeTerms(String typeName, String qualifiedName, List<GlossaryTerm> terms)
            throws AtlanException {
        Asset existing = getExistingAsset(typeName, qualifiedName);
        if (existing != null) {
            Set<GlossaryTerm> replacementTerms = new TreeSet<>();
            Set<GlossaryTerm> existingTerms = existing.getMeanings();
            Set<String> removeGuids = new HashSet<>();
            for (GlossaryTerm term : terms) {
                if (term.isValidReferenceByGuid()) {
                    removeGuids.add(term.getGuid());
                } else {
                    throw new InvalidRequestException(
                            "Term provided for removal did not specify its GUID",
                            "terms",
                            "ATLAN_JAVA_CLIENT-400-301",
                            400,
                            null);
                }
            }
            for (GlossaryTerm term : existingTerms) {
                String existingTermGuid = term.getGuid();
                if (!removeGuids.contains(existingTermGuid) && term.getRelationshipStatus() != AtlanStatus.DELETED) {
                    // Only re-include the terms that we are not removing and that are not already deleted
                    replacementTerms.add(term);
                }
            }
            AssetBuilder<?, ?> minimal = existing.trimToRequired();
            Asset update;
            if (replacementTerms.isEmpty()) {
                // If there are no terms left after the removal, we need to do the same as removing all terms
                update = minimal.build();
                update.removeMeanings();
            } else {
                // Otherwise we should do the update with the difference
                update = minimal.meanings(replacementTerms).build();
            }
            return updateRelationships(update);
        }
        return null;
    }

    private static Asset getExistingAsset(String typeName, String qualifiedName) throws AtlanException {
        return (Asset) Entity.retrieveFull(typeName, qualifiedName);
    }

    private static Entity updateRelationships(Asset asset) throws AtlanException {
        String typeNameToUpdate = asset.getTypeName();
        EntityMutationResponse response = EntityBulkEndpoint.upsert(asset, false, false);
        if (response != null && !response.getUpdatedEntities().isEmpty()) {
            for (Entity result : response.getUpdatedEntities()) {
                if (result.getTypeName().equals(typeNameToUpdate)) {
                    // Return the first result that matches the type that we attempted to update
                    // (This may not work if the type in a relationship is the same as the type
                    // of asset being updated — term-to-term relationships maybe the only example?)
                    return result;
                }
            }
        }
        return null;
    }
}
