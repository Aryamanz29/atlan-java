/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.Atlan;
import com.atlan.AtlanClient;
import com.atlan.exception.AtlanException;
import com.atlan.exception.ErrorCode;
import com.atlan.exception.InvalidRequestException;
import com.atlan.exception.NotFoundException;
import com.atlan.model.enums.IconType;
import com.atlan.model.relations.UniqueAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.UUID;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Instance of a link in Atlan.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
@SuppressWarnings("cast")
public class Link extends Asset implements ILink, IResource, ICatalog, IAsset, IReferenceable {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "Link";

    /** Fixed typeName for Links. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Asset to which the link is attached. */
    @Attribute
    IAsset asset;

    /** Icon for the link. */
    @Attribute
    String icon;

    /** Type of icon for the link. */
    @Attribute
    IconType iconType;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** TBC */
    @Attribute
    Boolean isGlobal;

    /** TBC */
    @Attribute
    String link;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;

    /** TBC */
    @Attribute
    String reference;

    /** TBC */
    @Attribute
    @Singular("putResourceMetadata")
    Map<String, String> resourceMetadata;

    /**
     * Reference to a Link by GUID.
     *
     * @param guid the GUID of the Link to reference
     * @return reference to a Link that can be used for defining a relationship to a Link
     */
    public static Link refByGuid(String guid) {
        return Link.builder().guid(guid).build();
    }

    /**
     * Reference to a Link by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the Link to reference
     * @return reference to a Link that can be used for defining a relationship to a Link
     */
    public static Link refByQualifiedName(String qualifiedName) {
        return Link.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Retrieves a Link by its GUID, complete with all of its relationships.
     *
     * @param guid of the Link to retrieve
     * @return the requested full Link, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the Link does not exist or the provided GUID is not a Link
     */
    public static Link retrieveByGuid(String guid) throws AtlanException {
        return retrieveByGuid(Atlan.getDefaultClient(), guid);
    }

    /**
     * Retrieves a Link by its GUID, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param guid of the Link to retrieve
     * @return the requested full Link, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the Link does not exist or the provided GUID is not a Link
     */
    public static Link retrieveByGuid(AtlanClient client, String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(client, guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof Link) {
            return (Link) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "Link");
        }
    }

    /**
     * Retrieves a Link by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the Link to retrieve
     * @return the requested full Link, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the Link does not exist
     */
    public static Link retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        return retrieveByQualifiedName(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Retrieves a Link by its qualifiedName, complete with all of its relationships.
     *
     * @param client connectivity to the Atlan tenant from which to retrieve the asset
     * @param qualifiedName of the Link to retrieve
     * @return the requested full Link, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the Link does not exist
     */
    public static Link retrieveByQualifiedName(AtlanClient client, String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(client, TYPE_NAME, qualifiedName);
        if (asset instanceof Link) {
            return (Link) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "Link");
        }
    }

    /**
     * Restore the archived (soft-deleted) Link to active.
     *
     * @param qualifiedName for the Link
     * @return true if the Link is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return restore(Atlan.getDefaultClient(), qualifiedName);
    }

    /**
     * Restore the archived (soft-deleted) Link to active.
     *
     * @param client connectivity to the Atlan tenant on which to restore the asset
     * @param qualifiedName for the Link
     * @return true if the Link is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(AtlanClient client, String qualifiedName) throws AtlanException {
        return Asset.restore(client, TYPE_NAME, qualifiedName);
    }

    /**
     * Builds the minimal object necessary to update a Link.
     *
     * @param reference a reference to the asset to which the Link should be attached
     * @param title for the Link
     * @param url of the Link
     * @return the minimal object necessary to create the Link and attach it to the asset, as a builder
     */
    public static LinkBuilder<?, ?> creator(Asset reference, String title, String url) {
        return Link.builder()
                .qualifiedName(generateQualifiedName())
                .name(title)
                .link(url)
                .asset(reference);
    }

    /**
     * Builds the minimal object necessary to update a Link.
     *
     * @param qualifiedName of the Link
     * @param name of the Link
     * @return the minimal request necessary to update the Link, as a builder
     */
    public static LinkBuilder<?, ?> updater(String qualifiedName, String name) {
        return Link.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a Link, from a potentially
     * more-complete Link object.
     *
     * @return the minimal object necessary to update the Link, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for Link are not found in the initial object
     */
    @Override
    public LinkBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "Link", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Generate a unique link name.
     *
     * @return a unique name for the link
     */
    private static String generateQualifiedName() {
        return UUID.randomUUID().toString();
    }

    /**
     * Remove the system description from a Link.
     *
     * @param qualifiedName of the Link
     * @param name of the Link
     * @return the updated Link, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Link removeDescription(String qualifiedName, String name) throws AtlanException {
        return removeDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the system description from a Link.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the Link
     * @param name of the Link
     * @return the updated Link, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Link removeDescription(AtlanClient client, String qualifiedName, String name) throws AtlanException {
        return (Link) Asset.removeDescription(client, updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a Link.
     *
     * @param qualifiedName of the Link
     * @param name of the Link
     * @return the updated Link, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Link removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return removeUserDescription(Atlan.getDefaultClient(), qualifiedName, name);
    }

    /**
     * Remove the user's description from a Link.
     *
     * @param client connectivity to the Atlan tenant on which to remove the asset's description
     * @param qualifiedName of the Link
     * @param name of the Link
     * @return the updated Link, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Link removeUserDescription(AtlanClient client, String qualifiedName, String name)
            throws AtlanException {
        return (Link) Asset.removeUserDescription(client, updater(qualifiedName, name));
    }
}
