/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
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
import java.util.Map;
import java.util.SortedSet;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Instance of a MicroStrategy cube in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true, builderMethodName = "_internal")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
@SuppressWarnings("cast")
public class MicroStrategyCube extends Asset
        implements IMicroStrategyCube, IMicroStrategy, IBI, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "MicroStrategyCube";

    /** Fixed typeName for MicroStrategyCubes. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<IAirflowTask> inputToAirflowTasks;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** Attributes used by the cube. */
    @Attribute
    @Singular
    SortedSet<IMicroStrategyAttribute> microStrategyAttributes;

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

    /** Query used to create the cube. */
    @Attribute
    String microStrategyCubeQuery;

    /** Whether the cube is an OLAP or MTDI cube. */
    @Attribute
    String microStrategyCubeType;

    /** TBC */
    @Attribute
    Boolean microStrategyIsCertified;

    /** TBC */
    @Attribute
    @Singular("putMicroStrategyLocation")
    List<Map<String, String>> microStrategyLocation;

    /** Metrics where the cube is used. */
    @Attribute
    @Singular
    SortedSet<IMicroStrategyMetric> microStrategyMetrics;

    /** Project containing the cube. */
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
    SortedSet<IAirflowTask> outputFromAirflowTasks;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;

    /**
     * Builds the minimal object necessary to create a relationship to a MicroStrategyCube, from a potentially
     * more-complete MicroStrategyCube object.
     *
     * @return the minimal object necessary to relate to the MicroStrategyCube
     * @throws InvalidRequestException if any of the minimal set of required properties for a MicroStrategyCube relationship are not found in the initial object
     */
    @Override
    public MicroStrategyCube trimToReference() throws InvalidRequestException {
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
     * Start a fluent search that will return all MicroStrategyCube assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) MicroStrategyCube assets will be included.
     *
     * @return a fluent search that includes all MicroStrategyCube assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select() {
        return select(Atlan.getDefaultClient());
    }

    /**
     * Start a fluent search that will return all MicroStrategyCube assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) MicroStrategyCube assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return a fluent search that includes all MicroStrategyCube assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(AtlanClient client) {
        return select(client, false);
    }

    /**
     * Start a fluent search that will return all MicroStrategyCube assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) MicroStrategyCubes will be included
     * @return a fluent search that includes all MicroStrategyCube assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(boolean includeArchived) {
        return select(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start a fluent search that will return all MicroStrategyCube assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) MicroStrategyCubes will be included
     * @return a fluent search that includes all MicroStrategyCube assets
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
     * Start an asset filter that will return all MicroStrategyCube assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) MicroStrategyCube assets will be included.
     *
     * @return an asset filter that includes all MicroStrategyCube assets
     * @deprecated replaced by {@link #select()}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all() {
        return all(Atlan.getDefaultClient());
    }

    /**
     * Start an asset filter that will return all MicroStrategyCube assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) MicroStrategyCube assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return an asset filter that includes all MicroStrategyCube assets
     * @deprecated replaced by {@link #select(AtlanClient)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(AtlanClient client) {
        return all(client, false);
    }

    /**
     * Start an asset filter that will return all MicroStrategyCube assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) MicroStrategyCubes will be included
     * @return an asset filter that includes all MicroStrategyCube assets
     * @deprecated replaced by {@link #select(boolean)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(boolean includeArchived) {
        return all(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start an asset filter that will return all MicroStrategyCube assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) MicroStrategyCubes will be included
     * @return an asset filter that includes all MicroStrategyCube assets
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
     * Reference to a MicroStrategyCube by GUID.
     *
     * @param guid the GUID of the MicroStrategyCube to reference
     * @return reference to a MicroStrategyCube that can be used for defining a relationship to a MicroStrategyCube
     */
    public static MicroStrategyCube refByGuid(String guid) {
        return MicroStrategyCube._internal().guid(guid).build();
    }

    /**
     * Reference to a MicroStrategyCube by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the MicroStrategyCube to reference
     * @return reference to a MicroStrategyCube that can be used for defining a relationship to a MicroStrategyCube
     */
    public static MicroStrategyCube refByQualifiedName(String qualifiedName) {
        return MicroStrategyCube._internal()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a MicroStrategyCube by one of its identifiers, complete with all of its relationships.
     *
     * @param id of the MicroStrategyCube to retrieve, either its GUID or its full qualifiedName
     * @return the requested full MicroStrategyCube, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the MicroStrategyCube does not exist or the provided GUID is not a MicroStrategyCube
     */
    @JsonIgnore
    public static MicroStrategyCube get(String id) throws AtlanException {
        return get(Atlan.getDefaultClient(), id);
    }

    /**
     * Retrieves a MicroStrategyCube by one of its identifiers, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the MicroStrategyCube to retrieve, either its GUID or its full qualifiedName
     * @return the requested full MicroStrategyCube, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the MicroStrategyCube does not exist or the provided GUID is not a MicroStrategyCube
     */
    @JsonIgnore
    public static MicroStrategyCube get(AtlanClient client, String id) throws AtlanException {
        return get(client, id, true);
    }

    /**
     * Retrieves a MicroStrategyCube by one of its identifiers, optionally complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the MicroStrategyCube to retrieve, either its GUID or its full qualifiedName
     * @param includeRelationships if true, all of the asset's relationships will also be retrieved; if false, no relationships will be retrieved
     * @return the requested full MicroStrategyCube, optionally complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the MicroStrategyCube does not exist or the provided GUID is not a MicroStrategyCube
     */
    @JsonIgnore
    public static MicroStrategyCube get(AtlanClient client, String id, boolean includeRelationships)
            throws AtlanException {
        if (id == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, "(null)");
        } else if (StringUtils.isUUID(id)) {
            Asset asset = Asset.get(client, id, includeRelationships);
            if (asset == null) {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, id);
            } else if (asset instanceof MicroStrategyCube) {
                return (MicroStrategyCube) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, id, TYPE_NAME);
            }
        } else {
            Asset asset = Asset.get(client, TYPE_NAME, id, includeRelationships);
            if (asset instanceof MicroStrategyCube) {
                return (MicroStrategyCube) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, id, TYPE_NAME);
            }
        }
    }

    /**
     * Retrieves a MicroStrategyCube by its GUID, complete with all of its relationships.
     *
     * @param guid of the MicroStrategyCube to retrieve
     * @return the requested full MicroStrategyCube, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the MicroStrategyCube does not exist or the provided GUID is not a MicroStrategyCube
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static MicroStrategyCube retrieveByGuid(String guid) throws AtlanException {
        return get(Atlan.getDefaultClient(), guid);
    }

    /**
     * Retrieves a MicroStrategyCube by its GUID, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param guid of the MicroStrategyCube to retrieve
     * @return the requested full MicroStrategyCube, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the MicroStrategyCube does not exist or the provided GUID is not a MicroStrategyCube
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static MicroStrategyCube retrieveByGuid(AtlanClient client, String guid) throws AtlanException {
        return get(client, guid);
    }

    /**
     * Retrieves a MicroStrategyCube by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the MicroStrategyCube to retrieve
     * @return the requested full MicroStrategyCube, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the MicroStrategyCube does not exist
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static MicroStrategyCube retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        return get(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Retrieves a MicroStrategyCube by its qualifiedName, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param qualifiedName of the MicroStrategyCube to retrieve
     * @return the requested full MicroStrategyCube, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the MicroStrategyCube does not exist
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static MicroStrategyCube retrieveByQualifiedName(AtlanClient client, String qualifiedName)
            throws AtlanException {
        return get(client, qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) MicroStrategyCube to active.
     *
     * @param qualifiedName for the MicroStrategyCube
     * @return true if the MicroStrategyCube is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return restore(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) MicroStrategyCube to active.
     *
     * @param client connectivity to the Atlan tenant on which to restore the asset
     * @param qualifiedName for the MicroStrategyCube
     * @return true if the MicroStrategyCube is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(AtlanClient client, String qualifiedName) throws AtlanException {
        return Asset.restore(client, TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a MicroStrategyCube.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param name of the MicroStrategyCube
     * @return the minimal request necessary to update the MicroStrategyCube, as a builder
     */
    public static MicroStrategyCubeBuilder<?, ?> updater(String qualifiedName, String name) {
        return MicroStrategyCube._internal().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a MicroStrategyCube, from a potentially
     * more-complete MicroStrategyCube object.
     *
     * @return the minimal object necessary to update the MicroStrategyCube, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for MicroStrategyCube are not found in the initial object
     */
    @Override
    public MicroStrategyCubeBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "MicroStrategyCube", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a MicroStrategyCube.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param name of the MicroStrategyCube
     * @return the updated MicroStrategyCube, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube removeDescription(String qualifiedName, String name) throws AtlanException {
        return removeDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the system description from a MicroStrategyCube.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the MicroStrategyCube
     * @param name of the MicroStrategyCube
     * @return the updated MicroStrategyCube, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube removeDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (MicroStrategyCube) Asset.removeDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a MicroStrategyCube.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param name of the MicroStrategyCube
     * @return the updated MicroStrategyCube, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return removeUserDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the user's description from a MicroStrategyCube.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the MicroStrategyCube
     * @param name of the MicroStrategyCube
     * @return the updated MicroStrategyCube, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube removeUserDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (MicroStrategyCube) Asset.removeUserDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a MicroStrategyCube.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param name of the MicroStrategyCube
     * @return the updated MicroStrategyCube, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube removeOwners(String qualifiedName, String name) throws AtlanException {
        return removeOwners(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the owners from a MicroStrategyCube.
     *
     * @param client connectivity to the Atlan tenant from which to remove the MicroStrategyCube's owners
     * @param qualifiedName of the MicroStrategyCube
     * @param name of the MicroStrategyCube
     * @return the updated MicroStrategyCube, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube removeOwners(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (MicroStrategyCube) Asset.removeOwners(client, updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a MicroStrategyCube.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated MicroStrategyCube, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube updateCertificate(
            String qualifiedName, CertificateStatus certificate, String message) throws AtlanException {
        return updateCertificate(Atlan.getDefaultClient(), qualifiedName, certificate, message);
    }

    /**
     * Update the certificate on a MicroStrategyCube.
     *
     * @param client connectivity to the Atlan tenant on which to update the MicroStrategyCube's certificate
     * @param qualifiedName of the MicroStrategyCube
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated MicroStrategyCube, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube updateCertificate(
            AtlanClient client, String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (MicroStrategyCube)
                Asset.updateCertificate(client, _internal(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a MicroStrategyCube.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param name of the MicroStrategyCube
     * @return the updated MicroStrategyCube, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube removeCertificate(String qualifiedName, String name) throws AtlanException {
        return removeCertificate(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the certificate from a MicroStrategyCube.
     *
     * @param client connectivity to the Atlan tenant from which to remove the MicroStrategyCube's certificate
     * @param qualifiedName of the MicroStrategyCube
     * @param name of the MicroStrategyCube
     * @return the updated MicroStrategyCube, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube removeCertificate(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (MicroStrategyCube) Asset.removeCertificate(client, updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a MicroStrategyCube.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return updateAnnouncement(Atlan.getDefaultClient(), qualifiedName, type, title, message);
    }

    /**
     * Update the announcement on a MicroStrategyCube.
     *
     * @param client connectivity to the Atlan tenant on which to update the MicroStrategyCube's announcement
     * @param qualifiedName of the MicroStrategyCube
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube updateAnnouncement(
            AtlanClient client, String qualifiedName, AtlanAnnouncementType type, String title, String message)
            throws AtlanException {
        return (MicroStrategyCube)
                Asset.updateAnnouncement(client, _internal(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a MicroStrategyCube.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param name of the MicroStrategyCube
     * @return the updated MicroStrategyCube, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return removeAnnouncement(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the announcement from a MicroStrategyCube.
     *
     * @param client connectivity to the Atlan client from which to remove the MicroStrategyCube's announcement
     * @param qualifiedName of the MicroStrategyCube
     * @param name of the MicroStrategyCube
     * @return the updated MicroStrategyCube, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube removeAnnouncement(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (MicroStrategyCube) Asset.removeAnnouncement(client, updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the MicroStrategyCube.
     *
     * @param qualifiedName for the MicroStrategyCube
     * @param name human-readable name of the MicroStrategyCube
     * @param terms the list of terms to replace on the MicroStrategyCube, or null to remove all terms from the MicroStrategyCube
     * @return the MicroStrategyCube that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return replaceTerms(Atlan.getDefaultClient(), qualifiedName, name, terms);
    }

    /**
     * Replace the terms linked to the MicroStrategyCube.
     *
     * @param client connectivity to the Atlan tenant on which to replace the MicroStrategyCube's assigned terms
     * @param qualifiedName for the MicroStrategyCube
     * @param name human-readable name of the MicroStrategyCube
     * @param terms the list of terms to replace on the MicroStrategyCube, or null to remove all terms from the MicroStrategyCube
     * @return the MicroStrategyCube that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube replaceTerms(
            AtlanClient client, String qualifiedName, String name, List<IGlossaryTerm> terms) throws AtlanException {
        return (MicroStrategyCube) Asset.replaceTerms(client, updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the MicroStrategyCube, without replacing existing terms linked to the MicroStrategyCube.
     * Note: this operation must make two API calls — one to retrieve the MicroStrategyCube's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the MicroStrategyCube
     * @param terms the list of terms to append to the MicroStrategyCube
     * @return the MicroStrategyCube that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return appendTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Link additional terms to the MicroStrategyCube, without replacing existing terms linked to the MicroStrategyCube.
     * Note: this operation must make two API calls — one to retrieve the MicroStrategyCube's existing terms,
     * and a second to append the new terms.
     *
     * @param client connectivity to the Atlan tenant on which to append terms to the MicroStrategyCube
     * @param qualifiedName for the MicroStrategyCube
     * @param terms the list of terms to append to the MicroStrategyCube
     * @return the MicroStrategyCube that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube appendTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (MicroStrategyCube) Asset.appendTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a MicroStrategyCube, without replacing all existing terms linked to the MicroStrategyCube.
     * Note: this operation must make two API calls — one to retrieve the MicroStrategyCube's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the MicroStrategyCube
     * @param terms the list of terms to remove from the MicroStrategyCube, which must be referenced by GUID
     * @return the MicroStrategyCube that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return removeTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Remove terms from a MicroStrategyCube, without replacing all existing terms linked to the MicroStrategyCube.
     * Note: this operation must make two API calls — one to retrieve the MicroStrategyCube's existing terms,
     * and a second to remove the provided terms.
     *
     * @param client connectivity to the Atlan tenant from which to remove terms from the MicroStrategyCube
     * @param qualifiedName for the MicroStrategyCube
     * @param terms the list of terms to remove from the MicroStrategyCube, which must be referenced by GUID
     * @return the MicroStrategyCube that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static MicroStrategyCube removeTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (MicroStrategyCube) Asset.removeTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a MicroStrategyCube, without replacing existing Atlan tags linked to the MicroStrategyCube.
     * Note: this operation must make two API calls — one to retrieve the MicroStrategyCube's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated MicroStrategyCube
     */
    public static MicroStrategyCube appendAtlanTags(String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return appendAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a MicroStrategyCube, without replacing existing Atlan tags linked to the MicroStrategyCube.
     * Note: this operation must make two API calls — one to retrieve the MicroStrategyCube's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the MicroStrategyCube
     * @param qualifiedName of the MicroStrategyCube
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated MicroStrategyCube
     */
    public static MicroStrategyCube appendAtlanTags(
            AtlanClient client, String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        return (MicroStrategyCube) Asset.appendAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a MicroStrategyCube, without replacing existing Atlan tags linked to the MicroStrategyCube.
     * Note: this operation must make two API calls — one to retrieve the MicroStrategyCube's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated MicroStrategyCube
     */
    public static MicroStrategyCube appendAtlanTags(
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
     * Add Atlan tags to a MicroStrategyCube, without replacing existing Atlan tags linked to the MicroStrategyCube.
     * Note: this operation must make two API calls — one to retrieve the MicroStrategyCube's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the MicroStrategyCube
     * @param qualifiedName of the MicroStrategyCube
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated MicroStrategyCube
     */
    public static MicroStrategyCube appendAtlanTags(
            AtlanClient client,
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (MicroStrategyCube) Asset.appendAtlanTags(
                client,
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a MicroStrategyCube.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the MicroStrategyCube
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        addAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a MicroStrategyCube.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the MicroStrategyCube
     * @param qualifiedName of the MicroStrategyCube
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the MicroStrategyCube
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        Asset.addAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a MicroStrategyCube.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the MicroStrategyCube
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
     * Add Atlan tags to a MicroStrategyCube.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the MicroStrategyCube
     * @param qualifiedName of the MicroStrategyCube
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the MicroStrategyCube
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
     * Remove an Atlan tag from a MicroStrategyCube.
     *
     * @param qualifiedName of the MicroStrategyCube
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the MicroStrategyCube
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        removeAtlanTag(Atlan.getDefaultClient(), qualifiedName, atlanTagName);
    }

    /**
     * Remove an Atlan tag from a MicroStrategyCube.
     *
     * @param client connectivity to the Atlan tenant from which to remove an Atlan tag from a MicroStrategyCube
     * @param qualifiedName of the MicroStrategyCube
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the MicroStrategyCube
     */
    public static void removeAtlanTag(AtlanClient client, String qualifiedName, String atlanTagName)
            throws AtlanException {
        Asset.removeAtlanTag(client, TYPE_NAME, qualifiedName, atlanTagName);
    }
}
