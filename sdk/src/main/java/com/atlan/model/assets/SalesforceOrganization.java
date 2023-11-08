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
import com.atlan.model.enums.CertificateStatus;
import com.atlan.model.relations.UniqueAttributes;
import com.atlan.model.search.CompoundQuery;
import com.atlan.model.search.FluentSearch;
import com.atlan.util.QueryFactory;
import com.atlan.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Instance of a Salesforce organization in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true, builderMethodName = "_internal")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class SalesforceOrganization extends Asset
        implements ISalesforceOrganization, ISalesforce, ISaaS, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "SalesforceOrganization";

    /** Fixed typeName for SalesforceOrganizations. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    String apiName;

    /** Dashboards that exist within this organization. */
    @Attribute
    @Singular
    SortedSet<ISalesforceDashboard> dashboards;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IAirflowTask> inputToAirflowTasks;

    /** Processes to which this asset provides input. */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** Objects that exist within this organization. */
    @Attribute
    @Singular
    SortedSet<ISalesforceObject> objects;

    /** TBC */
    @Attribute
    String organizationQualifiedName;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IAirflowTask> outputFromAirflowTasks;

    /** Processes from which this asset is produced as output. */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;

    /** Reports that exist within this organization. */
    @Attribute
    @Singular
    SortedSet<ISalesforceReport> reports;

    /** Identifier of the organization in Salesforce. */
    @Attribute
    String sourceId;

    /**
     * Builds the minimal object necessary to create a relationship to a SalesforceOrganization, from a potentially
     * more-complete SalesforceOrganization object.
     *
     * @return the minimal object necessary to relate to the SalesforceOrganization
     * @throws InvalidRequestException if any of the minimal set of required properties for a SalesforceOrganization relationship are not found in the initial object
     */
    @Override
    public SalesforceOrganization trimToReference() throws InvalidRequestException {
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
     * Start a fluent search that will return all SalesforceOrganization assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) SalesforceOrganization assets will be included.
     *
     * @return a fluent search that includes all SalesforceOrganization assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select() {
        return select(Atlan.getDefaultClient());
    }

    /**
     * Start a fluent search that will return all SalesforceOrganization assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) SalesforceOrganization assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return a fluent search that includes all SalesforceOrganization assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(AtlanClient client) {
        return select(client, false);
    }

    /**
     * Start a fluent search that will return all SalesforceOrganization assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) SalesforceOrganizations will be included
     * @return a fluent search that includes all SalesforceOrganization assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(boolean includeArchived) {
        return select(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start a fluent search that will return all SalesforceOrganization assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) SalesforceOrganizations will be included
     * @return a fluent search that includes all SalesforceOrganization assets
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
     * Start an asset filter that will return all SalesforceOrganization assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) SalesforceOrganization assets will be included.
     *
     * @return an asset filter that includes all SalesforceOrganization assets
     * @deprecated replaced by {@link #select()}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all() {
        return all(Atlan.getDefaultClient());
    }

    /**
     * Start an asset filter that will return all SalesforceOrganization assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) SalesforceOrganization assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return an asset filter that includes all SalesforceOrganization assets
     * @deprecated replaced by {@link #select(AtlanClient)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(AtlanClient client) {
        return all(client, false);
    }

    /**
     * Start an asset filter that will return all SalesforceOrganization assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) SalesforceOrganizations will be included
     * @return an asset filter that includes all SalesforceOrganization assets
     * @deprecated replaced by {@link #select(boolean)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(boolean includeArchived) {
        return all(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start an asset filter that will return all SalesforceOrganization assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) SalesforceOrganizations will be included
     * @return an asset filter that includes all SalesforceOrganization assets
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
     * Reference to a SalesforceOrganization by GUID.
     *
     * @param guid the GUID of the SalesforceOrganization to reference
     * @return reference to a SalesforceOrganization that can be used for defining a relationship to a SalesforceOrganization
     */
    public static SalesforceOrganization refByGuid(String guid) {
        return SalesforceOrganization._internal().guid(guid).build();
    }

    /**
     * Reference to a SalesforceOrganization by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the SalesforceOrganization to reference
     * @return reference to a SalesforceOrganization that can be used for defining a relationship to a SalesforceOrganization
     */
    public static SalesforceOrganization refByQualifiedName(String qualifiedName) {
        return SalesforceOrganization._internal()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a SalesforceOrganization by one of its identifiers, complete with all of its relationships.
     *
     * @param id of the SalesforceOrganization to retrieve, either its GUID or its full qualifiedName
     * @return the requested full SalesforceOrganization, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SalesforceOrganization does not exist or the provided GUID is not a SalesforceOrganization
     */
    @JsonIgnore
    public static SalesforceOrganization get(String id) throws AtlanException {
        return get(Atlan.getDefaultClient(), id);
    }

    /**
     * Retrieves a SalesforceOrganization by one of its identifiers, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the SalesforceOrganization to retrieve, either its GUID or its full qualifiedName
     * @return the requested full SalesforceOrganization, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SalesforceOrganization does not exist or the provided GUID is not a SalesforceOrganization
     */
    @JsonIgnore
    public static SalesforceOrganization get(AtlanClient client, String id) throws AtlanException {
        return get(client, id, true);
    }

    /**
     * Retrieves a SalesforceOrganization by one of its identifiers, optionally complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the SalesforceOrganization to retrieve, either its GUID or its full qualifiedName
     * @param includeRelationships if true, all of the asset's relationships will also be retrieved; if false, no relationships will be retrieved
     * @return the requested full SalesforceOrganization, optionally complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SalesforceOrganization does not exist or the provided GUID is not a SalesforceOrganization
     */
    @JsonIgnore
    public static SalesforceOrganization get(AtlanClient client, String id, boolean includeRelationships)
            throws AtlanException {
        if (id == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, "(null)");
        } else if (StringUtils.isUUID(id)) {
            Asset asset = Asset.get(client, id, includeRelationships);
            if (asset == null) {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, id);
            } else if (asset instanceof SalesforceOrganization) {
                return (SalesforceOrganization) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, id, TYPE_NAME);
            }
        } else {
            Asset asset = Asset.get(client, TYPE_NAME, id, includeRelationships);
            if (asset instanceof SalesforceOrganization) {
                return (SalesforceOrganization) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, id, TYPE_NAME);
            }
        }
    }

    /**
     * Retrieves a SalesforceOrganization by its GUID, complete with all of its relationships.
     *
     * @param guid of the SalesforceOrganization to retrieve
     * @return the requested full SalesforceOrganization, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SalesforceOrganization does not exist or the provided GUID is not a SalesforceOrganization
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static SalesforceOrganization retrieveByGuid(String guid) throws AtlanException {
        return get(Atlan.getDefaultClient(), guid);
    }

    /**
     * Retrieves a SalesforceOrganization by its GUID, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param guid of the SalesforceOrganization to retrieve
     * @return the requested full SalesforceOrganization, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SalesforceOrganization does not exist or the provided GUID is not a SalesforceOrganization
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static SalesforceOrganization retrieveByGuid(AtlanClient client, String guid) throws AtlanException {
        return get(client, guid);
    }

    /**
     * Retrieves a SalesforceOrganization by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the SalesforceOrganization to retrieve
     * @return the requested full SalesforceOrganization, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SalesforceOrganization does not exist
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static SalesforceOrganization retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        return get(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Retrieves a SalesforceOrganization by its qualifiedName, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param qualifiedName of the SalesforceOrganization to retrieve
     * @return the requested full SalesforceOrganization, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SalesforceOrganization does not exist
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static SalesforceOrganization retrieveByQualifiedName(AtlanClient client, String qualifiedName)
            throws AtlanException {
        return get(client, qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) SalesforceOrganization to active.
     *
     * @param qualifiedName for the SalesforceOrganization
     * @return true if the SalesforceOrganization is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return restore(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) SalesforceOrganization to active.
     *
     * @param client connectivity to the Atlan tenant on which to restore the asset
     * @param qualifiedName for the SalesforceOrganization
     * @return true if the SalesforceOrganization is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(AtlanClient client, String qualifiedName) throws AtlanException {
        return Asset.restore(client, TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a SalesforceOrganization.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param name of the SalesforceOrganization
     * @return the minimal request necessary to update the SalesforceOrganization, as a builder
     */
    public static SalesforceOrganizationBuilder<?, ?> updater(String qualifiedName, String name) {
        return SalesforceOrganization._internal()
                .guid("-" + ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE - 1))
                .qualifiedName(qualifiedName)
                .name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a SalesforceOrganization, from a potentially
     * more-complete SalesforceOrganization object.
     *
     * @return the minimal object necessary to update the SalesforceOrganization, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for SalesforceOrganization are not found in the initial object
     */
    @Override
    public SalesforceOrganizationBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "SalesforceOrganization", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a SalesforceOrganization.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param name of the SalesforceOrganization
     * @return the updated SalesforceOrganization, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization removeDescription(String qualifiedName, String name) throws AtlanException {
        return removeDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the system description from a SalesforceOrganization.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the SalesforceOrganization
     * @param name of the SalesforceOrganization
     * @return the updated SalesforceOrganization, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization removeDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (SalesforceOrganization) Asset.removeDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a SalesforceOrganization.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param name of the SalesforceOrganization
     * @return the updated SalesforceOrganization, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization removeUserDescription(String qualifiedName, String name)
            throws AtlanException {
        return removeUserDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the user's description from a SalesforceOrganization.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the SalesforceOrganization
     * @param name of the SalesforceOrganization
     * @return the updated SalesforceOrganization, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization removeUserDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (SalesforceOrganization) Asset.removeUserDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a SalesforceOrganization.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param name of the SalesforceOrganization
     * @return the updated SalesforceOrganization, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization removeOwners(String qualifiedName, String name) throws AtlanException {
        return removeOwners(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the owners from a SalesforceOrganization.
     *
     * @param client connectivity to the Atlan tenant from which to remove the SalesforceOrganization's owners
     * @param qualifiedName of the SalesforceOrganization
     * @param name of the SalesforceOrganization
     * @return the updated SalesforceOrganization, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization removeOwners(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (SalesforceOrganization) Asset.removeOwners(client, updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a SalesforceOrganization.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated SalesforceOrganization, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization updateCertificate(
            String qualifiedName, CertificateStatus certificate, String message) throws AtlanException {
        return updateCertificate(Atlan.getDefaultClient(), qualifiedName, certificate, message);
    }

    /**
     * Update the certificate on a SalesforceOrganization.
     *
     * @param client connectivity to the Atlan tenant on which to update the SalesforceOrganization's certificate
     * @param qualifiedName of the SalesforceOrganization
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated SalesforceOrganization, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization updateCertificate(
            AtlanClient client, String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (SalesforceOrganization)
                Asset.updateCertificate(client, _internal(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a SalesforceOrganization.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param name of the SalesforceOrganization
     * @return the updated SalesforceOrganization, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization removeCertificate(String qualifiedName, String name) throws AtlanException {
        return removeCertificate(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the certificate from a SalesforceOrganization.
     *
     * @param client connectivity to the Atlan tenant from which to remove the SalesforceOrganization's certificate
     * @param qualifiedName of the SalesforceOrganization
     * @param name of the SalesforceOrganization
     * @return the updated SalesforceOrganization, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization removeCertificate(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (SalesforceOrganization) Asset.removeCertificate(client, updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a SalesforceOrganization.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return updateAnnouncement(Atlan.getDefaultClient(), qualifiedName, type, title, message);
    }

    /**
     * Update the announcement on a SalesforceOrganization.
     *
     * @param client connectivity to the Atlan tenant on which to update the SalesforceOrganization's announcement
     * @param qualifiedName of the SalesforceOrganization
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization updateAnnouncement(
            AtlanClient client, String qualifiedName, AtlanAnnouncementType type, String title, String message)
            throws AtlanException {
        return (SalesforceOrganization)
                Asset.updateAnnouncement(client, _internal(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a SalesforceOrganization.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param name of the SalesforceOrganization
     * @return the updated SalesforceOrganization, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return removeAnnouncement(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the announcement from a SalesforceOrganization.
     *
     * @param client connectivity to the Atlan client from which to remove the SalesforceOrganization's announcement
     * @param qualifiedName of the SalesforceOrganization
     * @param name of the SalesforceOrganization
     * @return the updated SalesforceOrganization, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization removeAnnouncement(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (SalesforceOrganization) Asset.removeAnnouncement(client, updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the SalesforceOrganization.
     *
     * @param qualifiedName for the SalesforceOrganization
     * @param name human-readable name of the SalesforceOrganization
     * @param terms the list of terms to replace on the SalesforceOrganization, or null to remove all terms from the SalesforceOrganization
     * @return the SalesforceOrganization that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return replaceTerms(Atlan.getDefaultClient(), qualifiedName, name, terms);
    }

    /**
     * Replace the terms linked to the SalesforceOrganization.
     *
     * @param client connectivity to the Atlan tenant on which to replace the SalesforceOrganization's assigned terms
     * @param qualifiedName for the SalesforceOrganization
     * @param name human-readable name of the SalesforceOrganization
     * @param terms the list of terms to replace on the SalesforceOrganization, or null to remove all terms from the SalesforceOrganization
     * @return the SalesforceOrganization that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization replaceTerms(
            AtlanClient client, String qualifiedName, String name, List<IGlossaryTerm> terms) throws AtlanException {
        return (SalesforceOrganization) Asset.replaceTerms(client, updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the SalesforceOrganization, without replacing existing terms linked to the SalesforceOrganization.
     * Note: this operation must make two API calls — one to retrieve the SalesforceOrganization's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the SalesforceOrganization
     * @param terms the list of terms to append to the SalesforceOrganization
     * @return the SalesforceOrganization that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization appendTerms(String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return appendTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Link additional terms to the SalesforceOrganization, without replacing existing terms linked to the SalesforceOrganization.
     * Note: this operation must make two API calls — one to retrieve the SalesforceOrganization's existing terms,
     * and a second to append the new terms.
     *
     * @param client connectivity to the Atlan tenant on which to append terms to the SalesforceOrganization
     * @param qualifiedName for the SalesforceOrganization
     * @param terms the list of terms to append to the SalesforceOrganization
     * @return the SalesforceOrganization that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization appendTerms(
            AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (SalesforceOrganization) Asset.appendTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a SalesforceOrganization, without replacing all existing terms linked to the SalesforceOrganization.
     * Note: this operation must make two API calls — one to retrieve the SalesforceOrganization's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the SalesforceOrganization
     * @param terms the list of terms to remove from the SalesforceOrganization, which must be referenced by GUID
     * @return the SalesforceOrganization that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization removeTerms(String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return removeTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Remove terms from a SalesforceOrganization, without replacing all existing terms linked to the SalesforceOrganization.
     * Note: this operation must make two API calls — one to retrieve the SalesforceOrganization's existing terms,
     * and a second to remove the provided terms.
     *
     * @param client connectivity to the Atlan tenant from which to remove terms from the SalesforceOrganization
     * @param qualifiedName for the SalesforceOrganization
     * @param terms the list of terms to remove from the SalesforceOrganization, which must be referenced by GUID
     * @return the SalesforceOrganization that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static SalesforceOrganization removeTerms(
            AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return (SalesforceOrganization) Asset.removeTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a SalesforceOrganization, without replacing existing Atlan tags linked to the SalesforceOrganization.
     * Note: this operation must make two API calls — one to retrieve the SalesforceOrganization's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated SalesforceOrganization
     */
    public static SalesforceOrganization appendAtlanTags(String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return appendAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a SalesforceOrganization, without replacing existing Atlan tags linked to the SalesforceOrganization.
     * Note: this operation must make two API calls — one to retrieve the SalesforceOrganization's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the SalesforceOrganization
     * @param qualifiedName of the SalesforceOrganization
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated SalesforceOrganization
     */
    public static SalesforceOrganization appendAtlanTags(
            AtlanClient client, String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        return (SalesforceOrganization) Asset.appendAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a SalesforceOrganization, without replacing existing Atlan tags linked to the SalesforceOrganization.
     * Note: this operation must make two API calls — one to retrieve the SalesforceOrganization's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated SalesforceOrganization
     */
    public static SalesforceOrganization appendAtlanTags(
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
     * Add Atlan tags to a SalesforceOrganization, without replacing existing Atlan tags linked to the SalesforceOrganization.
     * Note: this operation must make two API calls — one to retrieve the SalesforceOrganization's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the SalesforceOrganization
     * @param qualifiedName of the SalesforceOrganization
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated SalesforceOrganization
     */
    public static SalesforceOrganization appendAtlanTags(
            AtlanClient client,
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (SalesforceOrganization) Asset.appendAtlanTags(
                client,
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a SalesforceOrganization.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the SalesforceOrganization
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        addAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a SalesforceOrganization.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the SalesforceOrganization
     * @param qualifiedName of the SalesforceOrganization
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the SalesforceOrganization
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        Asset.addAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a SalesforceOrganization.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the SalesforceOrganization
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
     * Add Atlan tags to a SalesforceOrganization.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the SalesforceOrganization
     * @param qualifiedName of the SalesforceOrganization
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the SalesforceOrganization
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
     * Remove an Atlan tag from a SalesforceOrganization.
     *
     * @param qualifiedName of the SalesforceOrganization
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the SalesforceOrganization
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        removeAtlanTag(Atlan.getDefaultClient(), qualifiedName, atlanTagName);
    }

    /**
     * Remove an Atlan tag from a SalesforceOrganization.
     *
     * @param client connectivity to the Atlan tenant from which to remove an Atlan tag from a SalesforceOrganization
     * @param qualifiedName of the SalesforceOrganization
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the SalesforceOrganization
     */
    public static void removeAtlanTag(AtlanClient client, String qualifiedName, String atlanTagName)
            throws AtlanException {
        Asset.removeAtlanTag(client, TYPE_NAME, qualifiedName, atlanTagName);
    }
}