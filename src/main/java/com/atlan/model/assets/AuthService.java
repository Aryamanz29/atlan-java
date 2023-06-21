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
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Instance of an authorization service in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Slf4j
@SuppressWarnings("cast")
public class AuthService extends Asset implements IAuthService, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "AuthService";

    /** Fixed typeName for AuthServices. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    @Singular("putAuthServiceConfig")
    Map<String, String> authServiceConfig;

    /** TBC */
    @Attribute
    Boolean authServiceIsEnabled;

    /** TBC */
    @Attribute
    Long authServicePolicyLastSync;

    /** TBC */
    @Attribute
    String authServiceType;

    /** TBC */
    @Attribute
    String tagService;

    /**
     * Reference to a AuthService by GUID.
     *
     * @param guid the GUID of the AuthService to reference
     * @return reference to a AuthService that can be used for defining a relationship to a AuthService
     */
    public static AuthService refByGuid(String guid) {
        return AuthService.builder().guid(guid).build();
    }

    /**
     * Reference to a AuthService by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the AuthService to reference
     * @return reference to a AuthService that can be used for defining a relationship to a AuthService
     */
    public static AuthService refByQualifiedName(String qualifiedName) {
        return AuthService.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a AuthService by its GUID, complete with all of its relationships.
     *
     * @param guid of the AuthService to retrieve
     * @return the requested full AuthService, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the AuthService does not exist or the provided GUID is not a AuthService
     */
    public static AuthService retrieveByGuid(String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof AuthService) {
            return (AuthService) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "AuthService");
        }
    }

    /**
     * Retrieves a AuthService by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the AuthService to retrieve
     * @return the requested full AuthService, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the AuthService does not exist
     */
    public static AuthService retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(TYPE_NAME, qualifiedName);
        if (asset instanceof AuthService) {
            return (AuthService) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "AuthService");
        }
    }

    /**
     * Restore the archived (soft-deleted) AuthService to active.
     *
     * @param qualifiedName for the AuthService
     * @return true if the AuthService is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return Asset.restore(TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a AuthService.
     *
     * @param qualifiedName of the AuthService
     * @param name of the AuthService
     * @return the minimal request necessary to update the AuthService, as a builder
     */
    public static AuthServiceBuilder<?, ?> updater(String qualifiedName, String name) {
        return AuthService.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a AuthService, from a potentially
     * more-complete AuthService object.
     *
     * @return the minimal object necessary to update the AuthService, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for AuthService are not found in the initial object
     */
    @Override
    public AuthServiceBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "AuthService", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a AuthService.
     *
     * @param qualifiedName of the AuthService
     * @param name of the AuthService
     * @return the updated AuthService, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthService removeDescription(String qualifiedName, String name) throws AtlanException {
        return (AuthService) Asset.removeDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a AuthService.
     *
     * @param qualifiedName of the AuthService
     * @param name of the AuthService
     * @return the updated AuthService, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthService removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return (AuthService) Asset.removeUserDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a AuthService.
     *
     * @param qualifiedName of the AuthService
     * @param name of the AuthService
     * @return the updated AuthService, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthService removeOwners(String qualifiedName, String name) throws AtlanException {
        return (AuthService) Asset.removeOwners(updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a AuthService.
     *
     * @param qualifiedName of the AuthService
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated AuthService, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static AuthService updateCertificate(String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (AuthService) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a AuthService.
     *
     * @param qualifiedName of the AuthService
     * @param name of the AuthService
     * @return the updated AuthService, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthService removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (AuthService) Asset.removeCertificate(updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a AuthService.
     *
     * @param qualifiedName of the AuthService
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static AuthService updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (AuthService) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a AuthService.
     *
     * @param qualifiedName of the AuthService
     * @param name of the AuthService
     * @return the updated AuthService, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthService removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (AuthService) Asset.removeAnnouncement(updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the AuthService.
     *
     * @param qualifiedName for the AuthService
     * @param name human-readable name of the AuthService
     * @param terms the list of terms to replace on the AuthService, or null to remove all terms from the AuthService
     * @return the AuthService that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static AuthService replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (AuthService) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the AuthService, without replacing existing terms linked to the AuthService.
     * Note: this operation must make two API calls — one to retrieve the AuthService's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the AuthService
     * @param terms the list of terms to append to the AuthService
     * @return the AuthService that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static AuthService appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (AuthService) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a AuthService, without replacing all existing terms linked to the AuthService.
     * Note: this operation must make two API calls — one to retrieve the AuthService's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the AuthService
     * @param terms the list of terms to remove from the AuthService, which must be referenced by GUID
     * @return the AuthService that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static AuthService removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (AuthService) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a AuthService, without replacing existing Atlan tags linked to the AuthService.
     * Note: this operation must make two API calls — one to retrieve the AuthService's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the AuthService
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated AuthService
     */
    public static AuthService appendAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        return (AuthService) Asset.appendAtlanTags(TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a AuthService, without replacing existing Atlan tags linked to the AuthService.
     * Note: this operation must make two API calls — one to retrieve the AuthService's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the AuthService
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated AuthService
     */
    public static AuthService appendAtlanTags(
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (AuthService) Asset.appendAtlanTags(
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a AuthService.
     *
     * @param qualifiedName of the AuthService
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the AuthService
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        Asset.addAtlanTags(TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a AuthService.
     *
     * @param qualifiedName of the AuthService
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the AuthService
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
     * Remove an Atlan tag from a AuthService.
     *
     * @param qualifiedName of the AuthService
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the AuthService
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        Asset.removeAtlanTag(TYPE_NAME, qualifiedName, atlanTagName);
    }
}