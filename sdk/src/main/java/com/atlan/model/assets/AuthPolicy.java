/* SPDX-License-Identifier: Apache-2.0
   Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.Atlan;
import com.atlan.AtlanClient;
import com.atlan.exception.AtlanException;
import com.atlan.exception.ErrorCode;
import com.atlan.exception.InvalidRequestException;
import com.atlan.exception.NotFoundException;
import com.atlan.model.core.AssetFilter;
import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.AtlanPolicyAction;
import com.atlan.model.enums.AuthPolicyCategory;
import com.atlan.model.enums.AuthPolicyResourceCategory;
import com.atlan.model.enums.AuthPolicyType;
import com.atlan.model.enums.CertificateStatus;
import com.atlan.model.enums.DataMaskingType;
import com.atlan.model.relations.UniqueAttributes;
import com.atlan.model.search.CompoundQuery;
import com.atlan.model.search.FluentSearch;
import com.atlan.model.structs.AuthPolicyCondition;
import com.atlan.model.structs.AuthPolicyValiditySchedule;
import com.atlan.util.QueryFactory;
import com.atlan.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Model to store an accesscontrol policy in Atlas
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true, builderMethodName = "_internal")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class AuthPolicy extends Asset implements IAuthPolicy, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "AuthPolicy";

    /** Fixed typeName for AuthPolicys. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    IAccessControl accessControl;

    /** TBC */
    @Attribute
    Boolean isPolicyEnabled;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<AtlanPolicyAction> policyActions;

    /** TBC */
    @Attribute
    AuthPolicyCategory policyCategory;

    /** TBC */
    @Attribute
    @Singular
    List<AuthPolicyCondition> policyConditions;

    /** TBC */
    @Attribute
    Boolean policyDelegateAdmin;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<String> policyGroups;

    /** TBC */
    @Attribute
    DataMaskingType policyMaskType;

    /** TBC */
    @Attribute
    Integer policyPriority;

    /** TBC */
    @Attribute
    AuthPolicyResourceCategory policyResourceCategory;

    /** TBC */
    @Attribute
    String policyResourceSignature;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<String> policyResources;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<String> policyRoles;

    /** TBC */
    @Attribute
    String policyServiceName;

    /** TBC */
    @Attribute
    String policySubCategory;

    /** TBC */
    @Attribute
    AuthPolicyType policyType;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<String> policyUsers;

    /** TBC */
    @Attribute
    @Singular("addPolicyValiditySchedule")
    List<AuthPolicyValiditySchedule> policyValiditySchedule;

    /**
     * Builds the minimal object necessary to create a relationship to a AuthPolicy, from a potentially
     * more-complete AuthPolicy object.
     *
     * @return the minimal object necessary to relate to the AuthPolicy
     * @throws InvalidRequestException if any of the minimal set of required properties for a AuthPolicy relationship are not found in the initial object
     */
    @Override
    public AuthPolicy trimToReference() throws InvalidRequestException {
        if (this.getGuid() != null && !this.getGuid().isEmpty()) {
            return refByGuid(this.getGuid());
        }
        if (this.getQualifiedName() != null && !this.getQualifiedName().isEmpty()) {
            return refByQualifiedName(this.getQualifiedName());
        }
        if (this.getUniqueAttributes() != null
                && this.getUniqueAttributes().getQualifiedName() != null
                && !this.getUniqueAttributes().getQualifiedName().isEmpty()) {
            return refByQualifiedName(this.getUniqueAttributes().getQualifiedName());
        }
        throw new InvalidRequestException(
                ErrorCode.MISSING_REQUIRED_RELATIONSHIP_PARAM, TYPE_NAME, "guid, qualifiedName");
    }

    /**
     * Start a fluent search that will return all AuthPolicy assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) AuthPolicy assets will be included.
     *
     * @return a fluent search that includes all AuthPolicy assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select() {
        return select(Atlan.getDefaultClient());
    }

    /**
     * Start a fluent search that will return all AuthPolicy assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) AuthPolicy assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return a fluent search that includes all AuthPolicy assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(AtlanClient client) {
        return select(client, false);
    }

    /**
     * Start a fluent search that will return all AuthPolicy assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) AuthPolicys will be included
     * @return a fluent search that includes all AuthPolicy assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(boolean includeArchived) {
        return select(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start a fluent search that will return all AuthPolicy assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) AuthPolicys will be included
     * @return a fluent search that includes all AuthPolicy assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(AtlanClient client, boolean includeArchived) {
        FluentSearch.FluentSearchBuilder<?, ?> builder =
                FluentSearch.builder(client).where(CompoundQuery.assetType(TYPE_NAME));
        if (!includeArchived) {
            builder.where(CompoundQuery.ACTIVE);
        }
        return builder;
    }

    /**
     * Start an asset filter that will return all AuthPolicy assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) AuthPolicy assets will be included.
     *
     * @return an asset filter that includes all AuthPolicy assets
     * @deprecated replaced by {@link #select()}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all() {
        return all(Atlan.getDefaultClient());
    }

    /**
     * Start an asset filter that will return all AuthPolicy assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) AuthPolicy assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return an asset filter that includes all AuthPolicy assets
     * @deprecated replaced by {@link #select(AtlanClient)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(AtlanClient client) {
        return all(client, false);
    }

    /**
     * Start an asset filter that will return all AuthPolicy assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) AuthPolicys will be included
     * @return an asset filter that includes all AuthPolicy assets
     * @deprecated replaced by {@link #select(boolean)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(boolean includeArchived) {
        return all(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start an asset filter that will return all AuthPolicy assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) AuthPolicys will be included
     * @return an asset filter that includes all AuthPolicy assets
     * @deprecated replaced by {@link #select(AtlanClient, boolean)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(AtlanClient client, boolean includeArchived) {
        AssetFilter.AssetFilterBuilder builder =
                AssetFilter.builder().client(client).filter(QueryFactory.type(TYPE_NAME));
        if (!includeArchived) {
            builder.filter(QueryFactory.active());
        }
        return builder;
    }

    /**
     * Reference to a AuthPolicy by GUID.
     *
     * @param guid the GUID of the AuthPolicy to reference
     * @return reference to a AuthPolicy that can be used for defining a relationship to a AuthPolicy
     */
    public static AuthPolicy refByGuid(String guid) {
        return AuthPolicy._internal().guid(guid).build();
    }

    /**
     * Reference to a AuthPolicy by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the AuthPolicy to reference
     * @return reference to a AuthPolicy that can be used for defining a relationship to a AuthPolicy
     */
    public static AuthPolicy refByQualifiedName(String qualifiedName) {
        return AuthPolicy._internal()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a AuthPolicy by one of its identifiers, complete with all of its relationships.
     *
     * @param id of the AuthPolicy to retrieve, either its GUID or its full qualifiedName
     * @return the requested full AuthPolicy, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the AuthPolicy does not exist or the provided GUID is not a AuthPolicy
     */
    @JsonIgnore
    public static AuthPolicy get(String id) throws AtlanException {
        return get(Atlan.getDefaultClient(), id);
    }

    /**
     * Retrieves a AuthPolicy by one of its identifiers, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the AuthPolicy to retrieve, either its GUID or its full qualifiedName
     * @return the requested full AuthPolicy, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the AuthPolicy does not exist or the provided GUID is not a AuthPolicy
     */
    @JsonIgnore
    public static AuthPolicy get(AtlanClient client, String id) throws AtlanException {
        return get(client, id, true);
    }

    /**
     * Retrieves a AuthPolicy by one of its identifiers, optionally complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the AuthPolicy to retrieve, either its GUID or its full qualifiedName
     * @param includeRelationships if true, all of the asset's relationships will also be retrieved; if false, no relationships will be retrieved
     * @return the requested full AuthPolicy, optionally complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the AuthPolicy does not exist or the provided GUID is not a AuthPolicy
     */
    @JsonIgnore
    public static AuthPolicy get(AtlanClient client, String id, boolean includeRelationships) throws AtlanException {
        if (id == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, "(null)");
        } else if (StringUtils.isUUID(id)) {
            Asset asset = Asset.get(client, id, includeRelationships);
            if (asset == null) {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, id);
            } else if (asset instanceof AuthPolicy) {
                return (AuthPolicy) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, id, TYPE_NAME);
            }
        } else {
            Asset asset = Asset.get(client, TYPE_NAME, id, includeRelationships);
            if (asset instanceof AuthPolicy) {
                return (AuthPolicy) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, id, TYPE_NAME);
            }
        }
    }

    /**
     * Retrieves a AuthPolicy by its GUID, complete with all of its relationships.
     *
     * @param guid of the AuthPolicy to retrieve
     * @return the requested full AuthPolicy, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the AuthPolicy does not exist or the provided GUID is not a AuthPolicy
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static AuthPolicy retrieveByGuid(String guid) throws AtlanException {
        return get(Atlan.getDefaultClient(), guid);
    }

    /**
     * Retrieves a AuthPolicy by its GUID, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param guid of the AuthPolicy to retrieve
     * @return the requested full AuthPolicy, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the AuthPolicy does not exist or the provided GUID is not a AuthPolicy
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static AuthPolicy retrieveByGuid(AtlanClient client, String guid) throws AtlanException {
        return get(client, guid);
    }

    /**
     * Retrieves a AuthPolicy by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the AuthPolicy to retrieve
     * @return the requested full AuthPolicy, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the AuthPolicy does not exist
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static AuthPolicy retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        return get(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Retrieves a AuthPolicy by its qualifiedName, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param qualifiedName of the AuthPolicy to retrieve
     * @return the requested full AuthPolicy, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the AuthPolicy does not exist
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static AuthPolicy retrieveByQualifiedName(AtlanClient client, String qualifiedName) throws AtlanException {
        return get(client, qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) AuthPolicy to active.
     *
     * @param qualifiedName for the AuthPolicy
     * @return true if the AuthPolicy is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return restore(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) AuthPolicy to active.
     *
     * @param client connectivity to the Atlan tenant on which to restore the asset
     * @param qualifiedName for the AuthPolicy
     * @return true if the AuthPolicy is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(AtlanClient client, String qualifiedName) throws AtlanException {
        return Asset.restore(client, TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to create an AuthPolicy.
     * Note: this method is only for internal use; for creating policies specific to a persona
     * or purpose, use the helper methods from those classes.
     *
     * @param name of the AuthPolicy
     * @return the minimal request necessary to create the AuthPolicy, as a builder
     * @see Persona#createMetadataPolicy(String, String, AuthPolicyType, Collection, String, Collection)
     * @see Persona#createDataPolicy(String, String, AuthPolicyType, String, Collection)
     * @see Persona#createGlossaryPolicy(String, String, AuthPolicyType, Collection, Collection)
     * @see Purpose#createMetadataPolicy(String, String, AuthPolicyType, Collection, Collection, Collection, boolean)
     * @see Purpose#createDataPolicy(String, String, AuthPolicyType, Collection, Collection, boolean)
     */
    public static AuthPolicyBuilder<?, ?> creator(String name) {
        return AuthPolicy._internal()
                .guid("-" + ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE - 1))
                .qualifiedName(name)
                .name(name)
                .displayName("");
    }

    /**
     * Builds the minimal object necessary to update an AuthPolicy.
     *
     * @param qualifiedName of the AuthPolicy
     * @param name of the AuthPolicy
     * @return the minimal request necessary to update the AuthPolicy, as a builder
     */
    public static AuthPolicyBuilder<?, ?> updater(String qualifiedName, String name) {
        return AuthPolicy._internal()
                .guid("-" + ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE - 1))
                .qualifiedName(qualifiedName)
                .name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to an AuthPolicy, from a potentially
     * more-complete AuthPolicy object.
     *
     * @return the minimal object necessary to update the AuthPolicy, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for AuthPolicy are not found in the initial object
     */
    @Override
    public AuthPolicyBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "AuthPolicy", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a AuthPolicy.
     *
     * @param qualifiedName of the AuthPolicy
     * @param name of the AuthPolicy
     * @return the updated AuthPolicy, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy removeDescription(String qualifiedName, String name) throws AtlanException {
        return removeDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the system description from a AuthPolicy.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the AuthPolicy
     * @param name of the AuthPolicy
     * @return the updated AuthPolicy, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy removeDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (AuthPolicy) Asset.removeDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a AuthPolicy.
     *
     * @param qualifiedName of the AuthPolicy
     * @param name of the AuthPolicy
     * @return the updated AuthPolicy, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return removeUserDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the user's description from a AuthPolicy.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the AuthPolicy
     * @param name of the AuthPolicy
     * @return the updated AuthPolicy, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy removeUserDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (AuthPolicy) Asset.removeUserDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a AuthPolicy.
     *
     * @param qualifiedName of the AuthPolicy
     * @param name of the AuthPolicy
     * @return the updated AuthPolicy, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy removeOwners(String qualifiedName, String name) throws AtlanException {
        return removeOwners(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the owners from a AuthPolicy.
     *
     * @param client connectivity to the Atlan tenant from which to remove the AuthPolicy's owners
     * @param qualifiedName of the AuthPolicy
     * @param name of the AuthPolicy
     * @return the updated AuthPolicy, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy removeOwners(AtlanClient client, String qualifiedName, String name) throws AtlanException {
        return (AuthPolicy) Asset.removeOwners(client, updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a AuthPolicy.
     *
     * @param qualifiedName of the AuthPolicy
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated AuthPolicy, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy updateCertificate(String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return updateCertificate(Atlan.getDefaultClient(), qualifiedName, certificate, message);
    }

    /**
     * Update the certificate on a AuthPolicy.
     *
     * @param client connectivity to the Atlan tenant on which to update the AuthPolicy's certificate
     * @param qualifiedName of the AuthPolicy
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated AuthPolicy, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy updateCertificate(
            AtlanClient client, String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (AuthPolicy)
                Asset.updateCertificate(client, _internal(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a AuthPolicy.
     *
     * @param qualifiedName of the AuthPolicy
     * @param name of the AuthPolicy
     * @return the updated AuthPolicy, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy removeCertificate(String qualifiedName, String name) throws AtlanException {
        return removeCertificate(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the certificate from a AuthPolicy.
     *
     * @param client connectivity to the Atlan tenant from which to remove the AuthPolicy's certificate
     * @param qualifiedName of the AuthPolicy
     * @param name of the AuthPolicy
     * @return the updated AuthPolicy, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy removeCertificate(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (AuthPolicy) Asset.removeCertificate(client, updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a AuthPolicy.
     *
     * @param qualifiedName of the AuthPolicy
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return updateAnnouncement(Atlan.getDefaultClient(), qualifiedName, type, title, message);
    }

    /**
     * Update the announcement on a AuthPolicy.
     *
     * @param client connectivity to the Atlan tenant on which to update the AuthPolicy's announcement
     * @param qualifiedName of the AuthPolicy
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy updateAnnouncement(
            AtlanClient client, String qualifiedName, AtlanAnnouncementType type, String title, String message)
            throws AtlanException {
        return (AuthPolicy)
                Asset.updateAnnouncement(client, _internal(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a AuthPolicy.
     *
     * @param qualifiedName of the AuthPolicy
     * @param name of the AuthPolicy
     * @return the updated AuthPolicy, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return removeAnnouncement(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the announcement from a AuthPolicy.
     *
     * @param client connectivity to the Atlan client from which to remove the AuthPolicy's announcement
     * @param qualifiedName of the AuthPolicy
     * @param name of the AuthPolicy
     * @return the updated AuthPolicy, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy removeAnnouncement(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (AuthPolicy) Asset.removeAnnouncement(client, updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the AuthPolicy.
     *
     * @param qualifiedName for the AuthPolicy
     * @param name human-readable name of the AuthPolicy
     * @param terms the list of terms to replace on the AuthPolicy, or null to remove all terms from the AuthPolicy
     * @return the AuthPolicy that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return replaceTerms(Atlan.getDefaultClient(), qualifiedName, name, terms);
    }

    /**
     * Replace the terms linked to the AuthPolicy.
     *
     * @param client connectivity to the Atlan tenant on which to replace the AuthPolicy's assigned terms
     * @param qualifiedName for the AuthPolicy
     * @param name human-readable name of the AuthPolicy
     * @param terms the list of terms to replace on the AuthPolicy, or null to remove all terms from the AuthPolicy
     * @return the AuthPolicy that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy replaceTerms(
            AtlanClient client, String qualifiedName, String name, List<IGlossaryTerm> terms) throws AtlanException {
        return (AuthPolicy) Asset.replaceTerms(client, updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the AuthPolicy, without replacing existing terms linked to the AuthPolicy.
     * Note: this operation must make two API calls — one to retrieve the AuthPolicy's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the AuthPolicy
     * @param terms the list of terms to append to the AuthPolicy
     * @return the AuthPolicy that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return appendTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Link additional terms to the AuthPolicy, without replacing existing terms linked to the AuthPolicy.
     * Note: this operation must make two API calls — one to retrieve the AuthPolicy's existing terms,
     * and a second to append the new terms.
     *
     * @param client connectivity to the Atlan tenant on which to append terms to the AuthPolicy
     * @param qualifiedName for the AuthPolicy
     * @param terms the list of terms to append to the AuthPolicy
     * @return the AuthPolicy that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy appendTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (AuthPolicy) Asset.appendTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a AuthPolicy, without replacing all existing terms linked to the AuthPolicy.
     * Note: this operation must make two API calls — one to retrieve the AuthPolicy's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the AuthPolicy
     * @param terms the list of terms to remove from the AuthPolicy, which must be referenced by GUID
     * @return the AuthPolicy that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return removeTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Remove terms from a AuthPolicy, without replacing all existing terms linked to the AuthPolicy.
     * Note: this operation must make two API calls — one to retrieve the AuthPolicy's existing terms,
     * and a second to remove the provided terms.
     *
     * @param client connectivity to the Atlan tenant from which to remove terms from the AuthPolicy
     * @param qualifiedName for the AuthPolicy
     * @param terms the list of terms to remove from the AuthPolicy, which must be referenced by GUID
     * @return the AuthPolicy that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static AuthPolicy removeTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (AuthPolicy) Asset.removeTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a AuthPolicy, without replacing existing Atlan tags linked to the AuthPolicy.
     * Note: this operation must make two API calls — one to retrieve the AuthPolicy's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the AuthPolicy
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated AuthPolicy
     */
    public static AuthPolicy appendAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        return appendAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a AuthPolicy, without replacing existing Atlan tags linked to the AuthPolicy.
     * Note: this operation must make two API calls — one to retrieve the AuthPolicy's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the AuthPolicy
     * @param qualifiedName of the AuthPolicy
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated AuthPolicy
     */
    public static AuthPolicy appendAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return (AuthPolicy) Asset.appendAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a AuthPolicy, without replacing existing Atlan tags linked to the AuthPolicy.
     * Note: this operation must make two API calls — one to retrieve the AuthPolicy's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the AuthPolicy
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated AuthPolicy
     */
    public static AuthPolicy appendAtlanTags(
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
     * Add Atlan tags to a AuthPolicy, without replacing existing Atlan tags linked to the AuthPolicy.
     * Note: this operation must make two API calls — one to retrieve the AuthPolicy's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the AuthPolicy
     * @param qualifiedName of the AuthPolicy
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated AuthPolicy
     */
    public static AuthPolicy appendAtlanTags(
            AtlanClient client,
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (AuthPolicy) Asset.appendAtlanTags(
                client,
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a AuthPolicy.
     *
     * @param qualifiedName of the AuthPolicy
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the AuthPolicy
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        addAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a AuthPolicy.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the AuthPolicy
     * @param qualifiedName of the AuthPolicy
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the AuthPolicy
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        Asset.addAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a AuthPolicy.
     *
     * @param qualifiedName of the AuthPolicy
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the AuthPolicy
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
     * Add Atlan tags to a AuthPolicy.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the AuthPolicy
     * @param qualifiedName of the AuthPolicy
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the AuthPolicy
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
     * Remove an Atlan tag from a AuthPolicy.
     *
     * @param qualifiedName of the AuthPolicy
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the AuthPolicy
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        removeAtlanTag(Atlan.getDefaultClient(), qualifiedName, atlanTagName);
    }

    /**
     * Remove an Atlan tag from a AuthPolicy.
     *
     * @param client connectivity to the Atlan tenant from which to remove an Atlan tag from a AuthPolicy
     * @param qualifiedName of the AuthPolicy
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the AuthPolicy
     */
    public static void removeAtlanTag(AtlanClient client, String qualifiedName, String atlanTagName)
            throws AtlanException {
        Asset.removeAtlanTag(client, TYPE_NAME, qualifiedName, atlanTagName);
    }
}