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
 * Instance of a Looker model in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class LookerModel extends Asset implements ILookerModel, ILooker, IBI, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "LookerModel";

    /** Fixed typeName for LookerModels. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    String projectName;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILookerExplore> explores;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILookerField> fields;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** TBC */
    @Attribute
    ILookerLook look;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;

    /** TBC */
    @Attribute
    ILookerProject project;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILookerQuery> queries;

    /**
     * Reference to a LookerModel by GUID.
     *
     * @param guid the GUID of the LookerModel to reference
     * @return reference to a LookerModel that can be used for defining a relationship to a LookerModel
     */
    public static LookerModel refByGuid(String guid) {
        return LookerModel.builder().guid(guid).build();
    }

    /**
     * Reference to a LookerModel by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the LookerModel to reference
     * @return reference to a LookerModel that can be used for defining a relationship to a LookerModel
     */
    public static LookerModel refByQualifiedName(String qualifiedName) {
        return LookerModel.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a LookerModel by its GUID, complete with all of its relationships.
     *
     * @param guid of the LookerModel to retrieve
     * @return the requested full LookerModel, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the LookerModel does not exist or the provided GUID is not a LookerModel
     */
    public static LookerModel retrieveByGuid(String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof LookerModel) {
            return (LookerModel) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "LookerModel");
        }
    }

    /**
     * Retrieves a LookerModel by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the LookerModel to retrieve
     * @return the requested full LookerModel, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the LookerModel does not exist
     */
    public static LookerModel retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(TYPE_NAME, qualifiedName);
        if (asset instanceof LookerModel) {
            return (LookerModel) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "LookerModel");
        }
    }

    /**
     * Restore the archived (soft-deleted) LookerModel to active.
     *
     * @param qualifiedName for the LookerModel
     * @return true if the LookerModel is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return Asset.restore(TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a LookerModel.
     *
     * @param qualifiedName of the LookerModel
     * @param name of the LookerModel
     * @return the minimal request necessary to update the LookerModel, as a builder
     */
    public static LookerModelBuilder<?, ?> updater(String qualifiedName, String name) {
        return LookerModel.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a LookerModel, from a potentially
     * more-complete LookerModel object.
     *
     * @return the minimal object necessary to update the LookerModel, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for LookerModel are not found in the initial object
     */
    @Override
    public LookerModelBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "LookerModel", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a LookerModel.
     *
     * @param qualifiedName of the LookerModel
     * @param name of the LookerModel
     * @return the updated LookerModel, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static LookerModel removeDescription(String qualifiedName, String name) throws AtlanException {
        return (LookerModel) Asset.removeDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a LookerModel.
     *
     * @param qualifiedName of the LookerModel
     * @param name of the LookerModel
     * @return the updated LookerModel, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static LookerModel removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return (LookerModel) Asset.removeUserDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a LookerModel.
     *
     * @param qualifiedName of the LookerModel
     * @param name of the LookerModel
     * @return the updated LookerModel, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static LookerModel removeOwners(String qualifiedName, String name) throws AtlanException {
        return (LookerModel) Asset.removeOwners(updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a LookerModel.
     *
     * @param qualifiedName of the LookerModel
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated LookerModel, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static LookerModel updateCertificate(String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (LookerModel) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a LookerModel.
     *
     * @param qualifiedName of the LookerModel
     * @param name of the LookerModel
     * @return the updated LookerModel, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static LookerModel removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (LookerModel) Asset.removeCertificate(updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a LookerModel.
     *
     * @param qualifiedName of the LookerModel
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static LookerModel updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (LookerModel) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a LookerModel.
     *
     * @param qualifiedName of the LookerModel
     * @param name of the LookerModel
     * @return the updated LookerModel, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static LookerModel removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (LookerModel) Asset.removeAnnouncement(updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the LookerModel.
     *
     * @param qualifiedName for the LookerModel
     * @param name human-readable name of the LookerModel
     * @param terms the list of terms to replace on the LookerModel, or null to remove all terms from the LookerModel
     * @return the LookerModel that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static LookerModel replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (LookerModel) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the LookerModel, without replacing existing terms linked to the LookerModel.
     * Note: this operation must make two API calls — one to retrieve the LookerModel's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the LookerModel
     * @param terms the list of terms to append to the LookerModel
     * @return the LookerModel that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static LookerModel appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (LookerModel) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a LookerModel, without replacing all existing terms linked to the LookerModel.
     * Note: this operation must make two API calls — one to retrieve the LookerModel's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the LookerModel
     * @param terms the list of terms to remove from the LookerModel, which must be referenced by GUID
     * @return the LookerModel that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static LookerModel removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (LookerModel) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a LookerModel, without replacing existing Atlan tags linked to the LookerModel.
     * Note: this operation must make two API calls — one to retrieve the LookerModel's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the LookerModel
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated LookerModel
     */
    public static LookerModel appendAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        return (LookerModel) Asset.appendAtlanTags(TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a LookerModel, without replacing existing Atlan tags linked to the LookerModel.
     * Note: this operation must make two API calls — one to retrieve the LookerModel's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the LookerModel
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated LookerModel
     */
    public static LookerModel appendAtlanTags(
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (LookerModel) Asset.appendAtlanTags(
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a LookerModel.
     *
     * @param qualifiedName of the LookerModel
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the LookerModel
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        Asset.addAtlanTags(TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a LookerModel.
     *
     * @param qualifiedName of the LookerModel
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the LookerModel
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
     * Remove an Atlan tag from a LookerModel.
     *
     * @param qualifiedName of the LookerModel
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the LookerModel
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        Asset.removeAtlanTag(TYPE_NAME, qualifiedName, atlanTagName);
    }
}
