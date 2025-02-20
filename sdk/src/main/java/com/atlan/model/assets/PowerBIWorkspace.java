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
import com.atlan.model.enums.PowerBIEndorsementType;
import com.atlan.model.relations.Reference;
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
 * Instance of a Power BI workspace in Atlan. Workspaces contain dashboards, reports, workbooks, datasets and dataflows.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true, builderMethodName = "_internal")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class PowerBIWorkspace extends Asset
        implements IPowerBIWorkspace, IPowerBI, IBI, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "PowerBIWorkspace";

    /** Fixed typeName for PowerBIWorkspaces. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Number of dashboards in this workspace. */
    @Attribute
    Long dashboardCount;

    /** Dashboards that exist within this workspace. */
    @Attribute
    @Singular
    SortedSet<IPowerBIDashboard> dashboards;

    /** Number of dataflows in this workspace. */
    @Attribute
    Long dataflowCount;

    /** Dataflows that exist within this workspace. */
    @Attribute
    @Singular
    SortedSet<IPowerBIDataflow> dataflows;

    /** Number of datasets in this workspace. */
    @Attribute
    Long datasetCount;

    /** Datasets that exist within this workspace. */
    @Attribute
    @Singular
    SortedSet<IPowerBIDataset> datasets;

    /** Tasks to which this asset provides input. */
    @Attribute
    @Singular
    SortedSet<IAirflowTask> inputToAirflowTasks;

    /** Processes to which this asset provides input. */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** Tasks from which this asset is output. */
    @Attribute
    @Singular
    SortedSet<IAirflowTask> outputFromAirflowTasks;

    /** Processes from which this asset is produced as output. */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;

    /** Endorsement status of this asset, in Power BI. */
    @Attribute
    PowerBIEndorsementType powerBIEndorsement;

    /** Format of this asset, as specified in the FORMAT_STRING of the MDX cell property. */
    @Attribute
    String powerBIFormatString;

    /** Whether this asset is hidden in Power BI (true) or not (false). */
    @Attribute
    Boolean powerBIIsHidden;

    /** Unique name of the Power BI table in which this asset exists. */
    @Attribute
    String powerBITableQualifiedName;

    /** Number of reports in this workspace. */
    @Attribute
    Long reportCount;

    /** Reports that exist within this workspace. */
    @Attribute
    @Singular
    SortedSet<IPowerBIReport> reports;

    /** Deprecated. */
    @Attribute
    String webUrl;

    /**
     * Builds the minimal object necessary to create a relationship to a PowerBIWorkspace, from a potentially
     * more-complete PowerBIWorkspace object.
     *
     * @return the minimal object necessary to relate to the PowerBIWorkspace
     * @throws InvalidRequestException if any of the minimal set of required properties for a PowerBIWorkspace relationship are not found in the initial object
     */
    @Override
    public PowerBIWorkspace trimToReference() throws InvalidRequestException {
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
     * Start a fluent search that will return all PowerBIWorkspace assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) PowerBIWorkspace assets will be included.
     *
     * @return a fluent search that includes all PowerBIWorkspace assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select() {
        return select(Atlan.getDefaultClient());
    }

    /**
     * Start a fluent search that will return all PowerBIWorkspace assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) PowerBIWorkspace assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return a fluent search that includes all PowerBIWorkspace assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(AtlanClient client) {
        return select(client, false);
    }

    /**
     * Start a fluent search that will return all PowerBIWorkspace assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) PowerBIWorkspaces will be included
     * @return a fluent search that includes all PowerBIWorkspace assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(boolean includeArchived) {
        return select(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start a fluent search that will return all PowerBIWorkspace assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) PowerBIWorkspaces will be included
     * @return a fluent search that includes all PowerBIWorkspace assets
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
     * Start an asset filter that will return all PowerBIWorkspace assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) PowerBIWorkspace assets will be included.
     *
     * @return an asset filter that includes all PowerBIWorkspace assets
     * @deprecated replaced by {@link #select()}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all() {
        return all(Atlan.getDefaultClient());
    }

    /**
     * Start an asset filter that will return all PowerBIWorkspace assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) PowerBIWorkspace assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return an asset filter that includes all PowerBIWorkspace assets
     * @deprecated replaced by {@link #select(AtlanClient)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(AtlanClient client) {
        return all(client, false);
    }

    /**
     * Start an asset filter that will return all PowerBIWorkspace assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) PowerBIWorkspaces will be included
     * @return an asset filter that includes all PowerBIWorkspace assets
     * @deprecated replaced by {@link #select(boolean)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(boolean includeArchived) {
        return all(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start an asset filter that will return all PowerBIWorkspace assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) PowerBIWorkspaces will be included
     * @return an asset filter that includes all PowerBIWorkspace assets
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
     * Reference to a PowerBIWorkspace by GUID. Use this to create a relationship to this PowerBIWorkspace,
     * where the relationship should be replaced.
     *
     * @param guid the GUID of the PowerBIWorkspace to reference
     * @return reference to a PowerBIWorkspace that can be used for defining a relationship to a PowerBIWorkspace
     */
    public static PowerBIWorkspace refByGuid(String guid) {
        return refByGuid(guid, Reference.SaveSemantic.REPLACE);
    }

    /**
     * Reference to a PowerBIWorkspace by GUID. Use this to create a relationship to this PowerBIWorkspace,
     * where you want to further control how that relationship should be updated (i.e. replaced,
     * appended, or removed).
     *
     * @param guid the GUID of the PowerBIWorkspace to reference
     * @param semantic how to save this relationship (replace all with this, append it, or remove it)
     * @return reference to a PowerBIWorkspace that can be used for defining a relationship to a PowerBIWorkspace
     */
    public static PowerBIWorkspace refByGuid(String guid, Reference.SaveSemantic semantic) {
        return PowerBIWorkspace._internal().guid(guid).semantic(semantic).build();
    }

    /**
     * Reference to a PowerBIWorkspace by qualifiedName. Use this to create a relationship to this PowerBIWorkspace,
     * where the relationship should be replaced.
     *
     * @param qualifiedName the qualifiedName of the PowerBIWorkspace to reference
     * @return reference to a PowerBIWorkspace that can be used for defining a relationship to a PowerBIWorkspace
     */
    public static PowerBIWorkspace refByQualifiedName(String qualifiedName) {
        return refByQualifiedName(qualifiedName, Reference.SaveSemantic.REPLACE);
    }

    /**
     * Reference to a PowerBIWorkspace by qualifiedName. Use this to create a relationship to this PowerBIWorkspace,
     * where you want to further control how that relationship should be updated (i.e. replaced,
     * appended, or removed).
     *
     * @param qualifiedName the qualifiedName of the PowerBIWorkspace to reference
     * @param semantic how to save this relationship (replace all with this, append it, or remove it)
     * @return reference to a PowerBIWorkspace that can be used for defining a relationship to a PowerBIWorkspace
     */
    public static PowerBIWorkspace refByQualifiedName(String qualifiedName, Reference.SaveSemantic semantic) {
        return PowerBIWorkspace._internal()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .semantic(semantic)
                .build();
    }

    /**
     * Retrieves a PowerBIWorkspace by one of its identifiers, complete with all of its relationships.
     *
     * @param id of the PowerBIWorkspace to retrieve, either its GUID or its full qualifiedName
     * @return the requested full PowerBIWorkspace, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIWorkspace does not exist or the provided GUID is not a PowerBIWorkspace
     */
    @JsonIgnore
    public static PowerBIWorkspace get(String id) throws AtlanException {
        return get(Atlan.getDefaultClient(), id);
    }

    /**
     * Retrieves a PowerBIWorkspace by one of its identifiers, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the PowerBIWorkspace to retrieve, either its GUID or its full qualifiedName
     * @return the requested full PowerBIWorkspace, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIWorkspace does not exist or the provided GUID is not a PowerBIWorkspace
     */
    @JsonIgnore
    public static PowerBIWorkspace get(AtlanClient client, String id) throws AtlanException {
        return get(client, id, true);
    }

    /**
     * Retrieves a PowerBIWorkspace by one of its identifiers, optionally complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the PowerBIWorkspace to retrieve, either its GUID or its full qualifiedName
     * @param includeRelationships if true, all of the asset's relationships will also be retrieved; if false, no relationships will be retrieved
     * @return the requested full PowerBIWorkspace, optionally complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIWorkspace does not exist or the provided GUID is not a PowerBIWorkspace
     */
    @JsonIgnore
    public static PowerBIWorkspace get(AtlanClient client, String id, boolean includeRelationships)
            throws AtlanException {
        if (id == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, "(null)");
        } else if (StringUtils.isUUID(id)) {
            Asset asset = Asset.get(client, id, includeRelationships);
            if (asset == null) {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, id);
            } else if (asset instanceof PowerBIWorkspace) {
                return (PowerBIWorkspace) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, id, TYPE_NAME);
            }
        } else {
            Asset asset = Asset.get(client, TYPE_NAME, id, includeRelationships);
            if (asset instanceof PowerBIWorkspace) {
                return (PowerBIWorkspace) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, id, TYPE_NAME);
            }
        }
    }

    /**
     * Retrieves a PowerBIWorkspace by its GUID, complete with all of its relationships.
     *
     * @param guid of the PowerBIWorkspace to retrieve
     * @return the requested full PowerBIWorkspace, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIWorkspace does not exist or the provided GUID is not a PowerBIWorkspace
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static PowerBIWorkspace retrieveByGuid(String guid) throws AtlanException {
        return get(Atlan.getDefaultClient(), guid);
    }

    /**
     * Retrieves a PowerBIWorkspace by its GUID, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param guid of the PowerBIWorkspace to retrieve
     * @return the requested full PowerBIWorkspace, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIWorkspace does not exist or the provided GUID is not a PowerBIWorkspace
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static PowerBIWorkspace retrieveByGuid(AtlanClient client, String guid) throws AtlanException {
        return get(client, guid);
    }

    /**
     * Retrieves a PowerBIWorkspace by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the PowerBIWorkspace to retrieve
     * @return the requested full PowerBIWorkspace, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIWorkspace does not exist
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static PowerBIWorkspace retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        return get(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Retrieves a PowerBIWorkspace by its qualifiedName, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param qualifiedName of the PowerBIWorkspace to retrieve
     * @return the requested full PowerBIWorkspace, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the PowerBIWorkspace does not exist
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static PowerBIWorkspace retrieveByQualifiedName(AtlanClient client, String qualifiedName)
            throws AtlanException {
        return get(client, qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) PowerBIWorkspace to active.
     *
     * @param qualifiedName for the PowerBIWorkspace
     * @return true if the PowerBIWorkspace is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return restore(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) PowerBIWorkspace to active.
     *
     * @param client connectivity to the Atlan tenant on which to restore the asset
     * @param qualifiedName for the PowerBIWorkspace
     * @return true if the PowerBIWorkspace is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(AtlanClient client, String qualifiedName) throws AtlanException {
        return Asset.restore(client, TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a PowerBIWorkspace.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param name of the PowerBIWorkspace
     * @return the minimal request necessary to update the PowerBIWorkspace, as a builder
     */
    public static PowerBIWorkspaceBuilder<?, ?> updater(String qualifiedName, String name) {
        return PowerBIWorkspace._internal()
                .guid("-" + ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE - 1))
                .qualifiedName(qualifiedName)
                .name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a PowerBIWorkspace, from a potentially
     * more-complete PowerBIWorkspace object.
     *
     * @return the minimal object necessary to update the PowerBIWorkspace, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for PowerBIWorkspace are not found in the initial object
     */
    @Override
    public PowerBIWorkspaceBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "PowerBIWorkspace", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a PowerBIWorkspace.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param name of the PowerBIWorkspace
     * @return the updated PowerBIWorkspace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace removeDescription(String qualifiedName, String name) throws AtlanException {
        return removeDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the system description from a PowerBIWorkspace.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the PowerBIWorkspace
     * @param name of the PowerBIWorkspace
     * @return the updated PowerBIWorkspace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace removeDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (PowerBIWorkspace) Asset.removeDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a PowerBIWorkspace.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param name of the PowerBIWorkspace
     * @return the updated PowerBIWorkspace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return removeUserDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the user's description from a PowerBIWorkspace.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the PowerBIWorkspace
     * @param name of the PowerBIWorkspace
     * @return the updated PowerBIWorkspace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace removeUserDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (PowerBIWorkspace) Asset.removeUserDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a PowerBIWorkspace.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param name of the PowerBIWorkspace
     * @return the updated PowerBIWorkspace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace removeOwners(String qualifiedName, String name) throws AtlanException {
        return removeOwners(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the owners from a PowerBIWorkspace.
     *
     * @param client connectivity to the Atlan tenant from which to remove the PowerBIWorkspace's owners
     * @param qualifiedName of the PowerBIWorkspace
     * @param name of the PowerBIWorkspace
     * @return the updated PowerBIWorkspace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace removeOwners(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (PowerBIWorkspace) Asset.removeOwners(client, updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a PowerBIWorkspace.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated PowerBIWorkspace, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace updateCertificate(
            String qualifiedName, CertificateStatus certificate, String message) throws AtlanException {
        return updateCertificate(Atlan.getDefaultClient(), qualifiedName, certificate, message);
    }

    /**
     * Update the certificate on a PowerBIWorkspace.
     *
     * @param client connectivity to the Atlan tenant on which to update the PowerBIWorkspace's certificate
     * @param qualifiedName of the PowerBIWorkspace
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated PowerBIWorkspace, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace updateCertificate(
            AtlanClient client, String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (PowerBIWorkspace)
                Asset.updateCertificate(client, _internal(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a PowerBIWorkspace.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param name of the PowerBIWorkspace
     * @return the updated PowerBIWorkspace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace removeCertificate(String qualifiedName, String name) throws AtlanException {
        return removeCertificate(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the certificate from a PowerBIWorkspace.
     *
     * @param client connectivity to the Atlan tenant from which to remove the PowerBIWorkspace's certificate
     * @param qualifiedName of the PowerBIWorkspace
     * @param name of the PowerBIWorkspace
     * @return the updated PowerBIWorkspace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace removeCertificate(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (PowerBIWorkspace) Asset.removeCertificate(client, updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a PowerBIWorkspace.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return updateAnnouncement(Atlan.getDefaultClient(), qualifiedName, type, title, message);
    }

    /**
     * Update the announcement on a PowerBIWorkspace.
     *
     * @param client connectivity to the Atlan tenant on which to update the PowerBIWorkspace's announcement
     * @param qualifiedName of the PowerBIWorkspace
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace updateAnnouncement(
            AtlanClient client, String qualifiedName, AtlanAnnouncementType type, String title, String message)
            throws AtlanException {
        return (PowerBIWorkspace)
                Asset.updateAnnouncement(client, _internal(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a PowerBIWorkspace.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param name of the PowerBIWorkspace
     * @return the updated PowerBIWorkspace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return removeAnnouncement(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the announcement from a PowerBIWorkspace.
     *
     * @param client connectivity to the Atlan client from which to remove the PowerBIWorkspace's announcement
     * @param qualifiedName of the PowerBIWorkspace
     * @param name of the PowerBIWorkspace
     * @return the updated PowerBIWorkspace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace removeAnnouncement(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (PowerBIWorkspace) Asset.removeAnnouncement(client, updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the PowerBIWorkspace.
     *
     * @param qualifiedName for the PowerBIWorkspace
     * @param name human-readable name of the PowerBIWorkspace
     * @param terms the list of terms to replace on the PowerBIWorkspace, or null to remove all terms from the PowerBIWorkspace
     * @return the PowerBIWorkspace that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return replaceTerms(Atlan.getDefaultClient(), qualifiedName, name, terms);
    }

    /**
     * Replace the terms linked to the PowerBIWorkspace.
     *
     * @param client connectivity to the Atlan tenant on which to replace the PowerBIWorkspace's assigned terms
     * @param qualifiedName for the PowerBIWorkspace
     * @param name human-readable name of the PowerBIWorkspace
     * @param terms the list of terms to replace on the PowerBIWorkspace, or null to remove all terms from the PowerBIWorkspace
     * @return the PowerBIWorkspace that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace replaceTerms(
            AtlanClient client, String qualifiedName, String name, List<IGlossaryTerm> terms) throws AtlanException {
        return (PowerBIWorkspace) Asset.replaceTerms(client, updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the PowerBIWorkspace, without replacing existing terms linked to the PowerBIWorkspace.
     * Note: this operation must make two API calls — one to retrieve the PowerBIWorkspace's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the PowerBIWorkspace
     * @param terms the list of terms to append to the PowerBIWorkspace
     * @return the PowerBIWorkspace that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return appendTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Link additional terms to the PowerBIWorkspace, without replacing existing terms linked to the PowerBIWorkspace.
     * Note: this operation must make two API calls — one to retrieve the PowerBIWorkspace's existing terms,
     * and a second to append the new terms.
     *
     * @param client connectivity to the Atlan tenant on which to append terms to the PowerBIWorkspace
     * @param qualifiedName for the PowerBIWorkspace
     * @param terms the list of terms to append to the PowerBIWorkspace
     * @return the PowerBIWorkspace that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace appendTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (PowerBIWorkspace) Asset.appendTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a PowerBIWorkspace, without replacing all existing terms linked to the PowerBIWorkspace.
     * Note: this operation must make two API calls — one to retrieve the PowerBIWorkspace's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the PowerBIWorkspace
     * @param terms the list of terms to remove from the PowerBIWorkspace, which must be referenced by GUID
     * @return the PowerBIWorkspace that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return removeTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Remove terms from a PowerBIWorkspace, without replacing all existing terms linked to the PowerBIWorkspace.
     * Note: this operation must make two API calls — one to retrieve the PowerBIWorkspace's existing terms,
     * and a second to remove the provided terms.
     *
     * @param client connectivity to the Atlan tenant from which to remove terms from the PowerBIWorkspace
     * @param qualifiedName for the PowerBIWorkspace
     * @param terms the list of terms to remove from the PowerBIWorkspace, which must be referenced by GUID
     * @return the PowerBIWorkspace that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static PowerBIWorkspace removeTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (PowerBIWorkspace) Asset.removeTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a PowerBIWorkspace, without replacing existing Atlan tags linked to the PowerBIWorkspace.
     * Note: this operation must make two API calls — one to retrieve the PowerBIWorkspace's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated PowerBIWorkspace
     */
    public static PowerBIWorkspace appendAtlanTags(String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return appendAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a PowerBIWorkspace, without replacing existing Atlan tags linked to the PowerBIWorkspace.
     * Note: this operation must make two API calls — one to retrieve the PowerBIWorkspace's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the PowerBIWorkspace
     * @param qualifiedName of the PowerBIWorkspace
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated PowerBIWorkspace
     */
    public static PowerBIWorkspace appendAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return (PowerBIWorkspace) Asset.appendAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a PowerBIWorkspace, without replacing existing Atlan tags linked to the PowerBIWorkspace.
     * Note: this operation must make two API calls — one to retrieve the PowerBIWorkspace's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated PowerBIWorkspace
     */
    public static PowerBIWorkspace appendAtlanTags(
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
     * Add Atlan tags to a PowerBIWorkspace, without replacing existing Atlan tags linked to the PowerBIWorkspace.
     * Note: this operation must make two API calls — one to retrieve the PowerBIWorkspace's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the PowerBIWorkspace
     * @param qualifiedName of the PowerBIWorkspace
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated PowerBIWorkspace
     */
    public static PowerBIWorkspace appendAtlanTags(
            AtlanClient client,
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (PowerBIWorkspace) Asset.appendAtlanTags(
                client,
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a PowerBIWorkspace.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the PowerBIWorkspace
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        addAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a PowerBIWorkspace.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the PowerBIWorkspace
     * @param qualifiedName of the PowerBIWorkspace
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the PowerBIWorkspace
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        Asset.addAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a PowerBIWorkspace.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the PowerBIWorkspace
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
     * Add Atlan tags to a PowerBIWorkspace.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the PowerBIWorkspace
     * @param qualifiedName of the PowerBIWorkspace
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the PowerBIWorkspace
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
     * Remove an Atlan tag from a PowerBIWorkspace.
     *
     * @param qualifiedName of the PowerBIWorkspace
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the PowerBIWorkspace
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        removeAtlanTag(Atlan.getDefaultClient(), qualifiedName, atlanTagName);
    }

    /**
     * Remove an Atlan tag from a PowerBIWorkspace.
     *
     * @param client connectivity to the Atlan tenant from which to remove an Atlan tag from a PowerBIWorkspace
     * @param qualifiedName of the PowerBIWorkspace
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the PowerBIWorkspace
     */
    public static void removeAtlanTag(AtlanClient client, String qualifiedName, String atlanTagName)
            throws AtlanException {
        Asset.removeAtlanTag(client, TYPE_NAME, qualifiedName, atlanTagName);
    }
}
