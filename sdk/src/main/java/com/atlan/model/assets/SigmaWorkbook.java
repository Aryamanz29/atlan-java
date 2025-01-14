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
 * Instance of a Sigma workbook in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true, builderMethodName = "_internal")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class SigmaWorkbook extends Asset implements ISigmaWorkbook, ISigma, IBI, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "SigmaWorkbook";

    /** Fixed typeName for SigmaWorkbooks. */
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

    /** Simple name of the data element in which this asset exists. */
    @Attribute
    String sigmaDataElementName;

    /** Unique name of the data element in which this asset exists. */
    @Attribute
    String sigmaDataElementQualifiedName;

    /** Number of pages in this workbook. */
    @Attribute
    Long sigmaPageCount;

    /** Simple name of the page on which this asset exists. */
    @Attribute
    String sigmaPageName;

    /** Unique name of the page on which this asset exists. */
    @Attribute
    String sigmaPageQualifiedName;

    /** Pages that exist in this workbook. */
    @Attribute
    @Singular
    SortedSet<ISigmaPage> sigmaPages;

    /** Simple name of the workbook in which this asset exists. */
    @Attribute
    String sigmaWorkbookName;

    /** Unique name of the workbook in which this asset exists. */
    @Attribute
    String sigmaWorkbookQualifiedName;

    /**
     * Builds the minimal object necessary to create a relationship to a SigmaWorkbook, from a potentially
     * more-complete SigmaWorkbook object.
     *
     * @return the minimal object necessary to relate to the SigmaWorkbook
     * @throws InvalidRequestException if any of the minimal set of required properties for a SigmaWorkbook relationship are not found in the initial object
     */
    @Override
    public SigmaWorkbook trimToReference() throws InvalidRequestException {
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
     * Start a fluent search that will return all SigmaWorkbook assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) SigmaWorkbook assets will be included.
     *
     * @return a fluent search that includes all SigmaWorkbook assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select() {
        return select(Atlan.getDefaultClient());
    }

    /**
     * Start a fluent search that will return all SigmaWorkbook assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) SigmaWorkbook assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return a fluent search that includes all SigmaWorkbook assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(AtlanClient client) {
        return select(client, false);
    }

    /**
     * Start a fluent search that will return all SigmaWorkbook assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) SigmaWorkbooks will be included
     * @return a fluent search that includes all SigmaWorkbook assets
     */
    public static FluentSearch.FluentSearchBuilder<?, ?> select(boolean includeArchived) {
        return select(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start a fluent search that will return all SigmaWorkbook assets.
     * Additional conditions can be chained onto the returned search before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) SigmaWorkbooks will be included
     * @return a fluent search that includes all SigmaWorkbook assets
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
     * Start an asset filter that will return all SigmaWorkbook assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) SigmaWorkbook assets will be included.
     *
     * @return an asset filter that includes all SigmaWorkbook assets
     * @deprecated replaced by {@link #select()}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all() {
        return all(Atlan.getDefaultClient());
    }

    /**
     * Start an asset filter that will return all SigmaWorkbook assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval. Only active (non-archived) SigmaWorkbook assets will be included.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @return an asset filter that includes all SigmaWorkbook assets
     * @deprecated replaced by {@link #select(AtlanClient)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(AtlanClient client) {
        return all(client, false);
    }

    /**
     * Start an asset filter that will return all SigmaWorkbook assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param includeArchived when true, archived (soft-deleted) SigmaWorkbooks will be included
     * @return an asset filter that includes all SigmaWorkbook assets
     * @deprecated replaced by {@link #select(boolean)}
     */
    @Deprecated
    public static AssetFilter.AssetFilterBuilder all(boolean includeArchived) {
        return all(Atlan.getDefaultClient(), includeArchived);
    }

    /**
     * Start an asset filter that will return all SigmaWorkbook assets.
     * Additional conditions can be chained onto the returned filter before any
     * asset retrieval is attempted, ensuring all conditions are pushed-down for
     * optimal retrieval.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the assets
     * @param includeArchived when true, archived (soft-deleted) SigmaWorkbooks will be included
     * @return an asset filter that includes all SigmaWorkbook assets
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
     * Reference to a SigmaWorkbook by GUID. Use this to create a relationship to this SigmaWorkbook,
     * where the relationship should be replaced.
     *
     * @param guid the GUID of the SigmaWorkbook to reference
     * @return reference to a SigmaWorkbook that can be used for defining a relationship to a SigmaWorkbook
     */
    public static SigmaWorkbook refByGuid(String guid) {
        return refByGuid(guid, Reference.SaveSemantic.REPLACE);
    }

    /**
     * Reference to a SigmaWorkbook by GUID. Use this to create a relationship to this SigmaWorkbook,
     * where you want to further control how that relationship should be updated (i.e. replaced,
     * appended, or removed).
     *
     * @param guid the GUID of the SigmaWorkbook to reference
     * @param semantic how to save this relationship (replace all with this, append it, or remove it)
     * @return reference to a SigmaWorkbook that can be used for defining a relationship to a SigmaWorkbook
     */
    public static SigmaWorkbook refByGuid(String guid, Reference.SaveSemantic semantic) {
        return SigmaWorkbook._internal().guid(guid).semantic(semantic).build();
    }

    /**
     * Reference to a SigmaWorkbook by qualifiedName. Use this to create a relationship to this SigmaWorkbook,
     * where the relationship should be replaced.
     *
     * @param qualifiedName the qualifiedName of the SigmaWorkbook to reference
     * @return reference to a SigmaWorkbook that can be used for defining a relationship to a SigmaWorkbook
     */
    public static SigmaWorkbook refByQualifiedName(String qualifiedName) {
        return refByQualifiedName(qualifiedName, Reference.SaveSemantic.REPLACE);
    }

    /**
     * Reference to a SigmaWorkbook by qualifiedName. Use this to create a relationship to this SigmaWorkbook,
     * where you want to further control how that relationship should be updated (i.e. replaced,
     * appended, or removed).
     *
     * @param qualifiedName the qualifiedName of the SigmaWorkbook to reference
     * @param semantic how to save this relationship (replace all with this, append it, or remove it)
     * @return reference to a SigmaWorkbook that can be used for defining a relationship to a SigmaWorkbook
     */
    public static SigmaWorkbook refByQualifiedName(String qualifiedName, Reference.SaveSemantic semantic) {
        return SigmaWorkbook._internal()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .semantic(semantic)
                .build();
    }

    /**
     * Retrieves a SigmaWorkbook by one of its identifiers, complete with all of its relationships.
     *
     * @param id of the SigmaWorkbook to retrieve, either its GUID or its full qualifiedName
     * @return the requested full SigmaWorkbook, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SigmaWorkbook does not exist or the provided GUID is not a SigmaWorkbook
     */
    @JsonIgnore
    public static SigmaWorkbook get(String id) throws AtlanException {
        return get(Atlan.getDefaultClient(), id);
    }

    /**
     * Retrieves a SigmaWorkbook by one of its identifiers, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the SigmaWorkbook to retrieve, either its GUID or its full qualifiedName
     * @return the requested full SigmaWorkbook, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SigmaWorkbook does not exist or the provided GUID is not a SigmaWorkbook
     */
    @JsonIgnore
    public static SigmaWorkbook get(AtlanClient client, String id) throws AtlanException {
        return get(client, id, true);
    }

    /**
     * Retrieves a SigmaWorkbook by one of its identifiers, optionally complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param id of the SigmaWorkbook to retrieve, either its GUID or its full qualifiedName
     * @param includeRelationships if true, all of the asset's relationships will also be retrieved; if false, no relationships will be retrieved
     * @return the requested full SigmaWorkbook, optionally complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SigmaWorkbook does not exist or the provided GUID is not a SigmaWorkbook
     */
    @JsonIgnore
    public static SigmaWorkbook get(AtlanClient client, String id, boolean includeRelationships) throws AtlanException {
        if (id == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, "(null)");
        } else if (StringUtils.isUUID(id)) {
            Asset asset = Asset.get(client, id, includeRelationships);
            if (asset == null) {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, id);
            } else if (asset instanceof SigmaWorkbook) {
                return (SigmaWorkbook) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, id, TYPE_NAME);
            }
        } else {
            Asset asset = Asset.get(client, TYPE_NAME, id, includeRelationships);
            if (asset instanceof SigmaWorkbook) {
                return (SigmaWorkbook) asset;
            } else {
                throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, id, TYPE_NAME);
            }
        }
    }

    /**
     * Retrieves a SigmaWorkbook by its GUID, complete with all of its relationships.
     *
     * @param guid of the SigmaWorkbook to retrieve
     * @return the requested full SigmaWorkbook, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SigmaWorkbook does not exist or the provided GUID is not a SigmaWorkbook
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static SigmaWorkbook retrieveByGuid(String guid) throws AtlanException {
        return get(Atlan.getDefaultClient(), guid);
    }

    /**
     * Retrieves a SigmaWorkbook by its GUID, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param guid of the SigmaWorkbook to retrieve
     * @return the requested full SigmaWorkbook, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SigmaWorkbook does not exist or the provided GUID is not a SigmaWorkbook
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static SigmaWorkbook retrieveByGuid(AtlanClient client, String guid) throws AtlanException {
        return get(client, guid);
    }

    /**
     * Retrieves a SigmaWorkbook by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the SigmaWorkbook to retrieve
     * @return the requested full SigmaWorkbook, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SigmaWorkbook does not exist
     * @deprecated see {@link #get(String)} instead
     */
    @Deprecated
    public static SigmaWorkbook retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        return get(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Retrieves a SigmaWorkbook by its qualifiedName, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param qualifiedName of the SigmaWorkbook to retrieve
     * @return the requested full SigmaWorkbook, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the SigmaWorkbook does not exist
     * @deprecated see {@link #get(AtlanClient, String)} instead
     */
    @Deprecated
    public static SigmaWorkbook retrieveByQualifiedName(AtlanClient client, String qualifiedName)
            throws AtlanException {
        return get(client, qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) SigmaWorkbook to active.
     *
     * @param qualifiedName for the SigmaWorkbook
     * @return true if the SigmaWorkbook is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return restore(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) SigmaWorkbook to active.
     *
     * @param client connectivity to the Atlan tenant on which to restore the asset
     * @param qualifiedName for the SigmaWorkbook
     * @return true if the SigmaWorkbook is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(AtlanClient client, String qualifiedName) throws AtlanException {
        return Asset.restore(client, TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a SigmaWorkbook.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param name of the SigmaWorkbook
     * @return the minimal request necessary to update the SigmaWorkbook, as a builder
     */
    public static SigmaWorkbookBuilder<?, ?> updater(String qualifiedName, String name) {
        return SigmaWorkbook._internal()
                .guid("-" + ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE - 1))
                .qualifiedName(qualifiedName)
                .name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a SigmaWorkbook, from a potentially
     * more-complete SigmaWorkbook object.
     *
     * @return the minimal object necessary to update the SigmaWorkbook, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for SigmaWorkbook are not found in the initial object
     */
    @Override
    public SigmaWorkbookBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "SigmaWorkbook", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Remove the system description from a SigmaWorkbook.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param name of the SigmaWorkbook
     * @return the updated SigmaWorkbook, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook removeDescription(String qualifiedName, String name) throws AtlanException {
        return removeDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the system description from a SigmaWorkbook.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the SigmaWorkbook
     * @param name of the SigmaWorkbook
     * @return the updated SigmaWorkbook, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook removeDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (SigmaWorkbook) Asset.removeDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a SigmaWorkbook.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param name of the SigmaWorkbook
     * @return the updated SigmaWorkbook, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return removeUserDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the user's description from a SigmaWorkbook.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the SigmaWorkbook
     * @param name of the SigmaWorkbook
     * @return the updated SigmaWorkbook, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook removeUserDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (SigmaWorkbook) Asset.removeUserDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a SigmaWorkbook.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param name of the SigmaWorkbook
     * @return the updated SigmaWorkbook, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook removeOwners(String qualifiedName, String name) throws AtlanException {
        return removeOwners(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the owners from a SigmaWorkbook.
     *
     * @param client connectivity to the Atlan tenant from which to remove the SigmaWorkbook's owners
     * @param qualifiedName of the SigmaWorkbook
     * @param name of the SigmaWorkbook
     * @return the updated SigmaWorkbook, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook removeOwners(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (SigmaWorkbook) Asset.removeOwners(client, updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a SigmaWorkbook.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated SigmaWorkbook, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook updateCertificate(String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return updateCertificate(Atlan.getDefaultClient(), qualifiedName, certificate, message);
    }

    /**
     * Update the certificate on a SigmaWorkbook.
     *
     * @param client connectivity to the Atlan tenant on which to update the SigmaWorkbook's certificate
     * @param qualifiedName of the SigmaWorkbook
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated SigmaWorkbook, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook updateCertificate(
            AtlanClient client, String qualifiedName, CertificateStatus certificate, String message)
            throws AtlanException {
        return (SigmaWorkbook)
                Asset.updateCertificate(client, _internal(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a SigmaWorkbook.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param name of the SigmaWorkbook
     * @return the updated SigmaWorkbook, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook removeCertificate(String qualifiedName, String name) throws AtlanException {
        return removeCertificate(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the certificate from a SigmaWorkbook.
     *
     * @param client connectivity to the Atlan tenant from which to remove the SigmaWorkbook's certificate
     * @param qualifiedName of the SigmaWorkbook
     * @param name of the SigmaWorkbook
     * @return the updated SigmaWorkbook, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook removeCertificate(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (SigmaWorkbook) Asset.removeCertificate(client, updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a SigmaWorkbook.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return updateAnnouncement(Atlan.getDefaultClient(), qualifiedName, type, title, message);
    }

    /**
     * Update the announcement on a SigmaWorkbook.
     *
     * @param client connectivity to the Atlan tenant on which to update the SigmaWorkbook's announcement
     * @param qualifiedName of the SigmaWorkbook
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook updateAnnouncement(
            AtlanClient client, String qualifiedName, AtlanAnnouncementType type, String title, String message)
            throws AtlanException {
        return (SigmaWorkbook)
                Asset.updateAnnouncement(client, _internal(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a SigmaWorkbook.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param name of the SigmaWorkbook
     * @return the updated SigmaWorkbook, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return removeAnnouncement(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the announcement from a SigmaWorkbook.
     *
     * @param client connectivity to the Atlan client from which to remove the SigmaWorkbook's announcement
     * @param qualifiedName of the SigmaWorkbook
     * @param name of the SigmaWorkbook
     * @return the updated SigmaWorkbook, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook removeAnnouncement(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (SigmaWorkbook) Asset.removeAnnouncement(client, updater(qualifiedName, name));
    }

    /**
     * Replace the terms linked to the SigmaWorkbook.
     *
     * @param qualifiedName for the SigmaWorkbook
     * @param name human-readable name of the SigmaWorkbook
     * @param terms the list of terms to replace on the SigmaWorkbook, or null to remove all terms from the SigmaWorkbook
     * @return the SigmaWorkbook that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook replaceTerms(String qualifiedName, String name, List<IGlossaryTerm> terms)
            throws AtlanException {
        return replaceTerms(Atlan.getDefaultClient(), qualifiedName, name, terms);
    }

    /**
     * Replace the terms linked to the SigmaWorkbook.
     *
     * @param client connectivity to the Atlan tenant on which to replace the SigmaWorkbook's assigned terms
     * @param qualifiedName for the SigmaWorkbook
     * @param name human-readable name of the SigmaWorkbook
     * @param terms the list of terms to replace on the SigmaWorkbook, or null to remove all terms from the SigmaWorkbook
     * @return the SigmaWorkbook that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook replaceTerms(
            AtlanClient client, String qualifiedName, String name, List<IGlossaryTerm> terms) throws AtlanException {
        return (SigmaWorkbook) Asset.replaceTerms(client, updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the SigmaWorkbook, without replacing existing terms linked to the SigmaWorkbook.
     * Note: this operation must make two API calls — one to retrieve the SigmaWorkbook's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the SigmaWorkbook
     * @param terms the list of terms to append to the SigmaWorkbook
     * @return the SigmaWorkbook that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook appendTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return appendTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Link additional terms to the SigmaWorkbook, without replacing existing terms linked to the SigmaWorkbook.
     * Note: this operation must make two API calls — one to retrieve the SigmaWorkbook's existing terms,
     * and a second to append the new terms.
     *
     * @param client connectivity to the Atlan tenant on which to append terms to the SigmaWorkbook
     * @param qualifiedName for the SigmaWorkbook
     * @param terms the list of terms to append to the SigmaWorkbook
     * @return the SigmaWorkbook that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook appendTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (SigmaWorkbook) Asset.appendTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a SigmaWorkbook, without replacing all existing terms linked to the SigmaWorkbook.
     * Note: this operation must make two API calls — one to retrieve the SigmaWorkbook's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the SigmaWorkbook
     * @param terms the list of terms to remove from the SigmaWorkbook, which must be referenced by GUID
     * @return the SigmaWorkbook that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook removeTerms(String qualifiedName, List<IGlossaryTerm> terms) throws AtlanException {
        return removeTerms(Atlan.getDefaultClient(), qualifiedName, terms);
    }

    /**
     * Remove terms from a SigmaWorkbook, without replacing all existing terms linked to the SigmaWorkbook.
     * Note: this operation must make two API calls — one to retrieve the SigmaWorkbook's existing terms,
     * and a second to remove the provided terms.
     *
     * @param client connectivity to the Atlan tenant from which to remove terms from the SigmaWorkbook
     * @param qualifiedName for the SigmaWorkbook
     * @param terms the list of terms to remove from the SigmaWorkbook, which must be referenced by GUID
     * @return the SigmaWorkbook that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static SigmaWorkbook removeTerms(AtlanClient client, String qualifiedName, List<IGlossaryTerm> terms)
            throws AtlanException {
        return (SigmaWorkbook) Asset.removeTerms(client, TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Add Atlan tags to a SigmaWorkbook, without replacing existing Atlan tags linked to the SigmaWorkbook.
     * Note: this operation must make two API calls — one to retrieve the SigmaWorkbook's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated SigmaWorkbook
     */
    public static SigmaWorkbook appendAtlanTags(String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return appendAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a SigmaWorkbook, without replacing existing Atlan tags linked to the SigmaWorkbook.
     * Note: this operation must make two API calls — one to retrieve the SigmaWorkbook's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the SigmaWorkbook
     * @param qualifiedName of the SigmaWorkbook
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems
     * @return the updated SigmaWorkbook
     */
    public static SigmaWorkbook appendAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        return (SigmaWorkbook) Asset.appendAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a SigmaWorkbook, without replacing existing Atlan tags linked to the SigmaWorkbook.
     * Note: this operation must make two API calls — one to retrieve the SigmaWorkbook's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated SigmaWorkbook
     */
    public static SigmaWorkbook appendAtlanTags(
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
     * Add Atlan tags to a SigmaWorkbook, without replacing existing Atlan tags linked to the SigmaWorkbook.
     * Note: this operation must make two API calls — one to retrieve the SigmaWorkbook's existing Atlan tags,
     * and a second to append the new Atlan tags.
     *
     * @param client connectivity to the Atlan tenant on which to append Atlan tags to the SigmaWorkbook
     * @param qualifiedName of the SigmaWorkbook
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems
     * @return the updated SigmaWorkbook
     */
    public static SigmaWorkbook appendAtlanTags(
            AtlanClient client,
            String qualifiedName,
            List<String> atlanTagNames,
            boolean propagate,
            boolean removePropagationsOnDelete,
            boolean restrictLineagePropagation)
            throws AtlanException {
        return (SigmaWorkbook) Asset.appendAtlanTags(
                client,
                TYPE_NAME,
                qualifiedName,
                atlanTagNames,
                propagate,
                removePropagationsOnDelete,
                restrictLineagePropagation);
    }

    /**
     * Add Atlan tags to a SigmaWorkbook.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the SigmaWorkbook
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(String qualifiedName, List<String> atlanTagNames) throws AtlanException {
        addAtlanTags(Atlan.getDefaultClient(), qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a SigmaWorkbook.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the SigmaWorkbook
     * @param qualifiedName of the SigmaWorkbook
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the SigmaWorkbook
     * @deprecated see {@link #appendAtlanTags(String, List)} instead
     */
    @Deprecated
    public static void addAtlanTags(AtlanClient client, String qualifiedName, List<String> atlanTagNames)
            throws AtlanException {
        Asset.addAtlanTags(client, TYPE_NAME, qualifiedName, atlanTagNames);
    }

    /**
     * Add Atlan tags to a SigmaWorkbook.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the SigmaWorkbook
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
     * Add Atlan tags to a SigmaWorkbook.
     *
     * @param client connectivity to the Atlan tenant on which to add Atlan tags to the SigmaWorkbook
     * @param qualifiedName of the SigmaWorkbook
     * @param atlanTagNames human-readable names of the Atlan tags to add
     * @param propagate whether to propagate the Atlan tag (true) or not (false)
     * @param removePropagationsOnDelete whether to remove the propagated Atlan tags when the Atlan tag is removed from this asset (true) or not (false)
     * @param restrictLineagePropagation whether to avoid propagating through lineage (true) or do propagate through lineage (false)
     * @throws AtlanException on any API problems, or if any of the Atlan tags already exist on the SigmaWorkbook
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
     * Remove an Atlan tag from a SigmaWorkbook.
     *
     * @param qualifiedName of the SigmaWorkbook
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the SigmaWorkbook
     */
    public static void removeAtlanTag(String qualifiedName, String atlanTagName) throws AtlanException {
        removeAtlanTag(Atlan.getDefaultClient(), qualifiedName, atlanTagName);
    }

    /**
     * Remove an Atlan tag from a SigmaWorkbook.
     *
     * @param client connectivity to the Atlan tenant from which to remove an Atlan tag from a SigmaWorkbook
     * @param qualifiedName of the SigmaWorkbook
     * @param atlanTagName human-readable name of the Atlan tag to remove
     * @throws AtlanException on any API problems, or if the Atlan tag does not exist on the SigmaWorkbook
     */
    public static void removeAtlanTag(AtlanClient client, String qualifiedName, String atlanTagName)
            throws AtlanException {
        Asset.removeAtlanTag(client, TYPE_NAME, qualifiedName, atlanTagName);
    }
}
