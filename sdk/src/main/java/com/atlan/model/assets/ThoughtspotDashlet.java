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
 * Instance of a Thoughtspot dashlet in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true, builderMethodName = "_internal")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class ThoughtspotDashlet extends Asset
        implements IThoughtspotDashlet, IThoughtspot, IBI, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "ThoughtspotDashlet";

    /** Fixed typeName for ThoughtspotDashlets. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

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

    /** TBC */
    @Attribute
    String thoughtspotChartType;

    /** Liveboard in which this dashlet exists. */
    @Attribute
    IThoughtspotLiveboard thoughtspotLiveboard;

    /** Simple name of the liveboard in which this dashlet exists. */
    @Attribute
    String thoughtspotLiveboardName;

    /** Unique name of the liveboard in which this dashlet exists. */
    @Attribute
    String thoughtspotLiveboardQualifiedName;

    /** TBC */
    @Attribute
    String thoughtspotQuestionText;

    /**
     * Builds the minimal object necessary to create a relationship to a ThoughtspotDashlet, from a potentially
     * more-complete ThoughtspotDashlet object.
     *
     * @return the minimal object necessary to relate to the ThoughtspotDashlet
     * @throws InvalidRequestException if any of the minimal set of required properties for a ThoughtspotDashlet relationship are not found in the initial object
     */
    @Override
    public ThoughtspotDashlet trimToReference() throws InvalidRequestException {
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
     * Start a fluent search that will return all ThoughtspotDashlet assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) ThoughtspotDashlet assets will be included.
     *
     * @return a fluent search that includes all ThoughtspotDashlet assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select() {
        return select(Atlan.getDefaultClient());
    }

    /**
     * Start a fluent search that will return all ThoughtspotDashlet assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) ThoughtspotDashlet assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return a fluent search that includes all ThoughtspotDashlet assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(AtlanClient client) {
        return select(client, false);
    }

    /**
     * Start a fluent search that will return all ThoughtspotDashlet assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) ThoughtspotDashlets will be included
     * @return a fluent search that includes all ThoughtspotDashlet assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(boolean includeArchived) {
        return select(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start a fluent search that will return all ThoughtspotDashlet assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) ThoughtspotDashlets will be included
     * @return a fluent search that includes all ThoughtspotDashlet assets
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
     * Start an asset filter that will return all ThoughtspotDashlet assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) ThoughtspotDashlet assets will be included.
     *
     * @return an asset filter that includes all ThoughtspotDashlet assets
     * @deprecated replaced by {@link #select()}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all() {
        return all(Atlan.getDefaultClient());
    }

    /**
     * Start an asset filter that will return all ThoughtspotDashlet assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) ThoughtspotDashlet assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return an asset filter that includes all ThoughtspotDashlet assets
     * @deprecated replaced by {@link #select(AtlanClient)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(AtlanClient client) {
        return all(client, false);
    }

    /**
     * Start an asset filter that will return all ThoughtspotDashlet assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) ThoughtspotDashlets will be included
     * @return an asset filter that includes all ThoughtspotDashlet assets
     * @deprecated replaced by {@link #select(boolean)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(boolean includeArchived) {
        return all(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start an asset filter that will return all ThoughtspotDashlet assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) ThoughtspotDashlets will be included
     * @return an asset filter that includes all ThoughtspotDashlet assets
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
     * Reference to a ThoughtspotDashlet by GUID. Use this to create a relationship to this ThoughtspotDashlet,
     * where the relationship should be replaced.
     *
     * @param guid the GUID of the ThoughtspotDashlet to reference
     * @return reference to a ThoughtspotDashlet that can be used for defining a relationship to a ThoughtspotDashlet
     */
    public static ThoughtspotDashlet refByGuid(String guid) {
        return refByGuid(guid, Reference.SaveSemantic.REPLACE);
    }

    /**
     * Reference to a ThoughtspotDashlet by GUID. Use this to create a relationship to this ThoughtspotDashlet,
     * where you want to further control how that relationship should be updated (i.e. replaced,
     * appended, or removed).
     *
     * @param guid the GUID of the ThoughtspotDashlet to reference
     * @param semantic how to save this relationship (replace all with this, append it, or remove it)
     * @return reference to a ThoughtspotDashlet that can be used for defining a relationship to a ThoughtspotDashlet
     */
    public static ThoughtspotDashlet refByGuid(String guid, Reference.SaveSemantic semantic) {
        return ThoughtspotDashlet._internal().guid(guid).semantic(semantic).build();
    }

    /**
     * Reference to a ThoughtspotDashlet by qualifiedName. Use this to create a relationship to this ThoughtspotDashlet,
     * where the relationship should be replaced.
     *
     * @param qualifiedName the qualifiedName of the ThoughtspotDashlet to reference
     * @return reference to a ThoughtspotDashlet that can be used for defining a relationship to a ThoughtspotDashlet
     */
    public static ThoughtspotDashlet refByQualifiedName(String qualifiedName) {
        return refByQualifiedName(qualifiedName, Reference.SaveSemantic.REPLACE);
    }

    /**
     * Reference to a ThoughtspotDashlet by qualifiedName. Use this to create a relationship to this ThoughtspotDashlet,
     * where you want to further control how that relationship should be updated (i.e. replaced,
     * appended, or removed).
     *
     * @param qualifiedName the qualifiedName of the ThoughtspotDashlet to reference
     * @param semantic how to save this relationship (replace all with this, append it, or remove it)
     * @return reference to a ThoughtspotDashlet that can be used for defining a relationship to a ThoughtspotDashlet
     */
    public static ThoughtspotDashlet refByQualifiedName(String qualifiedName, Reference.SaveSemantic semantic) {
        return ThoughtspotDashlet._internal()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .semantic(semantic)
                .build();
    }

    /**
     * Retrieves a ThoughtspotDashlet by one of its identifiers, complete with all of its relationships.
     *
     * @param id of the ThoughtspotDashlet to retrieve, either its GUID or its full qualifiedName
     * @return the requested full ThoughtspotDashlet, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the ThoughtspotDashlet does not exist or the provided GUID is not a ThoughtspotDashlet
     */
    @JsonIgnore
    public static ThoughtspotDashlet get(String id) throws AtlanException {
        return get(Atlan.getDefaultClient(), id);
    }

    /**
     * Retrieves a ThoughtspotDashlet by one of its identifiers, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the ThoughtspotDashlet to retrieve, either its GUID or its full qualifiedName
     * @return the requested full ThoughtspotDashlet, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the ThoughtspotDashlet does not exist or the provided GUID is not a ThoughtspotDashlet
     */
    @JsonIgnore
    public static ThoughtspotDashlet get(AtlanClient client, String id) throws AtlanException {
        return get(client, id, true);
    }

    /**
     * Retrieves a ThoughtspotDashlet by one of its identifiers, optionally complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the ThoughtspotDashlet to retrieve, either its GUID or its full qualifiedName
     * @param includeRelationships if true, all of the asset's relationships will also be retrieved; if false, no relationships will be retrieved
     * @return the requested full ThoughtspotDashlet, optionally complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the ThoughtspotDashlet does not exist or the provided GUID is not a ThoughtspotDashlet
     */
    @JsonIgnore
    public static ThoughtspotDashlet get(AtlanClient client, String id, boolean includeRelationships)
            throws AtlanException {
        if (id == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, "(null)");
        } else if (StringUtils.isUUID(id)) {
            Asset asset = Asset.get(client, id, includeRelationships);
            if (asset == null) {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, id);
            } else if (asset instanceof ThoughtspotDashlet) {
                return (ThoughtspotDashlet) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, id, TYPE_NAME);
            }
        } else {
            Asset asset = Asset.get(client, TYPE_NAME, id, includeRelationships);
            if (asset instanceof ThoughtspotDashlet) {
                return (ThoughtspotDashlet) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, id, TYPE_NAME);
            }
        }
    }

    /**
     * Retrieves a ThoughtspotDashlet by its GUID, complete with all of its relationships.
     *
     * @param guid of the ThoughtspotDashlet to retrieve
     * @return the requested full ThoughtspotDashlet, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the ThoughtspotDashlet does not exist or the provided GUID is not a ThoughtspotDashlet
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static ThoughtspotDashlet retrieveByGuid(String guid) throws AtlanException {
        return get(Atlan.getDefaultClient(), guid);
    }

    /**
     * Retrieves a ThoughtspotDashlet by its GUID, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param guid of the ThoughtspotDashlet to retrieve
     * @return the requested full ThoughtspotDashlet, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the ThoughtspotDashlet does not exist or the provided GUID is not a ThoughtspotDashlet
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static ThoughtspotDashlet retrieveByGuid(AtlanClient client, String guid) throws AtlanException {
        return get(client, guid);
    }

    /**
     * Retrieves a ThoughtspotDashlet by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the ThoughtspotDashlet to retrieve
     * @return the requested full ThoughtspotDashlet, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the ThoughtspotDashlet does not exist
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static ThoughtspotDashlet retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        return get(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Retrieves a ThoughtspotDashlet by its qualifiedName, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param qualifiedName of the ThoughtspotDashlet to retrieve
     * @return the requested full ThoughtspotDashlet, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the ThoughtspotDashlet does not exist
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static ThoughtspotDashlet retrieveByQualifiedName(AtlanClient client, String qualifiedName)
            throws AtlanException {
        return get(client, qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) ThoughtspotDashlet to active.
     *
     * @param qualifiedName for the ThoughtspotDashlet
     * @return true if the ThoughtspotDashlet is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return restore(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) ThoughtspotDashlet to active.
     *
     * @param client connectivity to the Atlan tenant on which to restore the asset
     * @param qualifiedName for the ThoughtspotDashlet
     * @return true if the ThoughtspotDashlet is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(AtlanClient client, String qualifiedName) throws AtlanException {
        return Asset.restore(client, TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a ThoughtspotDashlet.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param name of the ThoughtspotDashlet
     * @return the minimal request necessary to update the ThoughtspotDashlet, as a builder
     */
    public static ThoughtspotDashletBuilder<?, ?> updater(String qualifiedName, String name) {
        return ThoughtspotDashlet._internal()
                .guid("-" + ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE - 1))
                .qualifiedName(qualifiedName)
                .name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a ThoughtspotDashlet, from a potentially
     * more-complete ThoughtspotDashlet object.
     *
     * @return the minimal object necessary to update the ThoughtspotDashlet, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for ThoughtspotDashlet are not found in the initial object
     */
    @Override
    public ThoughtspotDashletBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "ThoughtspotDashlet", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a ThoughtspotDashlet.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param name of the ThoughtspotDashlet
     * @return the updated ThoughtspotDashlet, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet removeDescription(String qualifiedName, String name) throws AtlanException {
        return removeDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the system description from a ThoughtspotDashlet.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the ThoughtspotDashlet
     * @param name of the ThoughtspotDashlet
     * @return the updated ThoughtspotDashlet, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet removeDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (ThoughtspotDashlet) Asset.removeDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a ThoughtspotDashlet.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param name of the ThoughtspotDashlet
     * @return the updated ThoughtspotDashlet, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return removeUserDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the user's description from a ThoughtspotDashlet.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the ThoughtspotDashlet
     * @param name of the ThoughtspotDashlet
     * @return the updated ThoughtspotDashlet, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet removeUserDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (ThoughtspotDashlet) Asset.removeUserDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a ThoughtspotDashlet.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param name of the ThoughtspotDashlet
     * @return the updated ThoughtspotDashlet, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet removeOwners(String qualifiedName, String name) throws AtlanException {
        return removeOwners(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the owners from a ThoughtspotDashlet.
     *
     * @param client connectivity to the Atlan tenant from which to remove the ThoughtspotDashlet's owners
     * @param qualifiedName of the ThoughtspotDashlet
     * @param name of the ThoughtspotDashlet
     * @return the updated ThoughtspotDashlet, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet removeOwners(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (ThoughtspotDashlet) Asset.removeOwners(client, updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a ThoughtspotDashlet.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated ThoughtspotDashlet, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet updateCertificate(
            String qualifiedName, CertificateStatus certificate, String message) throws AtlanException {
        return updateCertificate(Atlan.getDefaultClient(), qualifiedName, certificate, message);
    }

    /**
     * Update the certificate on a ThoughtspotDashlet.
     *
     * @param client connectivity to the Atlan tenant on which to update the ThoughtspotDashlet's certificate
     * @param qualifiedName of the ThoughtspotDashlet
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated ThoughtspotDashlet, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet updateCertificate(
            AtlanClient client, String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (ThoughtspotDashlet)
                Asset.updateCertificate(client, _internal(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a ThoughtspotDashlet.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param name of the ThoughtspotDashlet
     * @return the updated ThoughtspotDashlet, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet removeCertificate(String qualifiedName, String name) throws AtlanException {
        return removeCertificate(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the certificate from a ThoughtspotDashlet.
     *
     * @param client connectivity to the Atlan tenant from which to remove the ThoughtspotDashlet's certificate
     * @param qualifiedName of the ThoughtspotDashlet
     * @param name of the ThoughtspotDashlet
     * @return the updated ThoughtspotDashlet, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet removeCertificate(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (ThoughtspotDashlet) Asset.removeCertificate(client, updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a ThoughtspotDashlet.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return updateAnnouncement(Atlan.getDefaultClient(), qualifiedName, type, title, message);
    }

    /**
     * Update the announcement on a ThoughtspotDashlet.
     *
     * @param client connectivity to the Atlan tenant on which to update the ThoughtspotDashlet's announcement
     * @param qualifiedName of the ThoughtspotDashlet
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet updateAnnouncement(
            AtlanClient client, String qualifiedName, AtlanAnnouncementType type, String title, String message)
            throws AtlanException {
        return (ThoughtspotDashlet)
                Asset.updateAnnouncement(client, _internal(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a ThoughtspotDashlet.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param name of the ThoughtspotDashlet
     * @return the updated ThoughtspotDashlet, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return removeAnnouncement(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the announcement from a ThoughtspotDashlet.
     *
     * @param client connectivity to the Atlan client from which to remove the ThoughtspotDashlet's announcement
     * @param qualifiedName of the ThoughtspotDashlet
     * @param name of the ThoughtspotDashlet
     * @return the updated ThoughtspotDashlet, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet removeAnnouncement(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (ThoughtspotDashlet) Asset.removeAnnouncement(client, updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the ThoughtspotDashlet.
     *
     * @param qualifiedName for the ThoughtspotDashlet
     * @param name human-readable name of the ThoughtspotDashlet
     * @param terms the list of terms to replace on the ThoughtspotDashlet, or null to remove all terms from the ThoughtspotDashlet
     * @return the ThoughtspotDashlet that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return replaceTerms(Atlan.getDefaultClient(), qualifiedName, name, terms);
    }

    /**
     * Replace the terms linked to the ThoughtspotDashlet.
     *
     * @param client connectivity to the Atlan tenant on which to replace the ThoughtspotDashlet's assigned terms
     * @param qualifiedName for the ThoughtspotDashlet
     * @param name human-readable name of the ThoughtspotDashlet
     * @param terms the list of terms to replace on the ThoughtspotDashlet, or null to remove all terms from the ThoughtspotDashlet
     * @return the ThoughtspotDashlet that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet replaceTerms(
            AtlanClient client, String qualifiedName, String name, List<IGlossaryTerm> terms) throws AtlanException {
        return (ThoughtspotDashlet) Asset.replaceTerms(client, updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the ThoughtspotDashlet, without replacing existing terms linked to the ThoughtspotDashlet.
     * Note: this operation must make two API calls — one to retrieve the ThoughtspotDashlet's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the ThoughtspotDashlet
     * @param terms the list of terms to append to the ThoughtspotDashlet
     * @return the ThoughtspotDashlet that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet appendTerms(String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return appendTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Link additional terms to the ThoughtspotDashlet, without replacing existing terms linked to the ThoughtspotDashlet.
     * Note: this operation must make two API calls — one to retrieve the ThoughtspotDashlet's existing terms,
     * and a second to append the new terms.
     *
     * @param client connectivity to the Atlan tenant on which to append terms to the ThoughtspotDashlet
     * @param qualifiedName for the ThoughtspotDashlet
     * @param terms the list of terms to append to the ThoughtspotDashlet
     * @return the ThoughtspotDashlet that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet appendTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (ThoughtspotDashlet) Asset.appendTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a ThoughtspotDashlet, without replacing all existing terms linked to the ThoughtspotDashlet.
     * Note: this operation must make two API calls — one to retrieve the ThoughtspotDashlet's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the ThoughtspotDashlet
     * @param terms the list of terms to remove from the ThoughtspotDashlet, which must be referenced by GUID
     * @return the ThoughtspotDashlet that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet removeTerms(String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return removeTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Remove terms from a ThoughtspotDashlet, without replacing all existing terms linked to the ThoughtspotDashlet.
     * Note: this operation must make two API calls — one to retrieve the ThoughtspotDashlet's existing terms,
     * and a second to remove the provided terms.
     *
     * @param client connectivity to the Atlan tenant from which to remove terms from the ThoughtspotDashlet
     * @param qualifiedName for the ThoughtspotDashlet
     * @param terms the list of terms to remove from the ThoughtspotDashlet, which must be referenced by GUID
     * @return the ThoughtspotDashlet that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static ThoughtspotDashlet removeTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (ThoughtspotDashlet) Asset.removeTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a ThoughtspotDashlet, without replacing existing Atlan tags linked to the ThoughtspotDashlet.
     * Note: this operation must make two API calls — one to retrieve the ThoughtspotDashlet's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated ThoughtspotDashlet
     */
    public static ThoughtspotDashlet appendAtlanTags(String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return appendAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a ThoughtspotDashlet, without replacing existing Atlan tags linked to the ThoughtspotDashlet.
     * Note: this operation must make two API calls — one to retrieve the ThoughtspotDashlet's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the ThoughtspotDashlet
     * @param qualifiedName of the ThoughtspotDashlet
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated ThoughtspotDashlet
     */
    public static ThoughtspotDashlet appendAtlanTags(
            AtlanClient client, String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        return (ThoughtspotDashlet) Asset.appendAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a ThoughtspotDashlet, without replacing existing Atlan tags linked to the ThoughtspotDashlet.
     * Note: this operation must make two API calls — one to retrieve the ThoughtspotDashlet's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated ThoughtspotDashlet
     */
    public static ThoughtspotDashlet appendAtlanTags(
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
     * Add Atlan tags to a ThoughtspotDashlet, without replacing existing Atlan tags linked to the ThoughtspotDashlet.
     * Note: this operation must make two API calls — one to retrieve the ThoughtspotDashlet's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the ThoughtspotDashlet
     * @param qualifiedName of the ThoughtspotDashlet
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated ThoughtspotDashlet
     */
    public static ThoughtspotDashlet appendAtlanTags(
            AtlanClient client,
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (ThoughtspotDashlet) Asset.appendAtlanTags(
                client,
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a ThoughtspotDashlet.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the ThoughtspotDashlet
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        addAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a ThoughtspotDashlet.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the ThoughtspotDashlet
     * @param qualifiedName of the ThoughtspotDashlet
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the ThoughtspotDashlet
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        Asset.addAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a ThoughtspotDashlet.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the ThoughtspotDashlet
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
     * Add Atlan tags to a ThoughtspotDashlet.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the ThoughtspotDashlet
     * @param qualifiedName of the ThoughtspotDashlet
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the ThoughtspotDashlet
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
     * Remove an Atlan tag from a ThoughtspotDashlet.
     *
     * @param qualifiedName of the ThoughtspotDashlet
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the ThoughtspotDashlet
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        removeAtlanTag(Atlan.getDefaultClient(), qualifiedName, atlanTagName);
    }

    /**
     * Remove an Atlan tag from a ThoughtspotDashlet.
     *
     * @param client connectivity to the Atlan tenant from which to remove an Atlan tag from a ThoughtspotDashlet
     * @param qualifiedName of the ThoughtspotDashlet
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the ThoughtspotDashlet
     */
    public static void removeAtlanTag(AtlanClient client, String qualifiedName, String atlanTagName)
            throws AtlanException {
        Asset.removeAtlanTag(client, TYPE_NAME, qualifiedName, atlanTagName);
    }
}
