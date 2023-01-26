/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.admin;

import com.atlan.api.PurposesEndpoint;
import com.atlan.exception.AtlanException;
import com.atlan.exception.ErrorCode;
import com.atlan.exception.InvalidRequestException;
import com.atlan.model.core.AtlanObject;
import com.atlan.model.enums.AssetSidebarTab;
import com.atlan.serde.PurposeDeserializer;
import com.atlan.serde.PurposeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
@JsonDeserialize(using = PurposeDeserializer.class)
@JsonSerialize(using = PurposeSerializer.class)
public class Purpose extends AtlanObject {
    private static final long serialVersionUID = 2L;

    /** Unique identifier (GUID) of the purpose. */
    String id;

    /** Name of the purpose. */
    String name;

    /** Name of the purpose as it appears in the UI. */
    String displayName;

    /** Description of the purpose. */
    String description;

    /** Unique identifiers (internal hashed-strings) of classifications that are associated with the purpose. */
    @Singular
    @JsonInclude(JsonInclude.Include.ALWAYS)
    SortedSet<String> tags;

    /** Set of metadata policies defined for this purpose. */
    @Singular
    @JsonInclude(JsonInclude.Include.ALWAYS)
    SortedSet<PurposeMetadataPolicy> metadataPolicies;

    /** Set of data policies defined for this purpose. */
    @Singular
    @JsonInclude(JsonInclude.Include.ALWAYS)
    SortedSet<PurposeDataPolicy> dataPolicies;

    /** Whether this purpose is currently active (true) or deactivated (false). */
    Boolean enabled;

    /** TBC */
    Boolean isActive;

    /** Time (epoch) at which this purpose was created, in milliseconds. */
    final Long createdAt;

    /** Username of the user who created this purpose. */
    final String createdBy;

    /** Time (formatted string) at which this purpose was last updated, in milliseconds. */
    final Long updatedAt;

    /** Username of the user who last updated this purpose. */
    final String updatedBy;

    /** Fixed value. */
    final String level;

    /** TBC */
    String version;

    /** README content for the purpose. */
    @JsonIgnore // TODO
    String readme;

    @JsonIgnore // TODO
    String resources;

    /** Details associated with the purpose. */
    PurposeAttributes attributes;

    /**
     * Builds the minimal object necessary to create a purpose.
     *
     * @param name of the purpose, as it should appear in the UI
     * @param classifications list of human-readable classification names to include in the purpose (must be at least one)
     * @return the minimal request necessary to update the purpose, as a builder
     * @throws InvalidRequestException if no classifications have been provided for the purpose
     */
    public static PurposeBuilder<?, ?> creator(String name, List<String> classifications)
            throws InvalidRequestException {
        if (classifications == null || classifications.isEmpty()) {
            throw new InvalidRequestException(ErrorCode.NO_CLASSIFICATION_FOR_PURPOSE);
        }
        return Purpose.builder().name(name).displayName(name).tags(classifications);
    }

    /**
     * Builds the minimal object necessary to update a purpose.
     *
     * @param id unique identifier (GUID) of the purpose
     * @param name of the purpose
     * @param classifications list of human-readable classification names to include in the purpose (must be at least one)
     * @return the minimal request necessary to update the purpose, as a builder
     * @throws InvalidRequestException if no classifications have been provided for the purpose
     */
    public static PurposeBuilder<?, ?> updater(String id, String name, List<String> classifications)
            throws InvalidRequestException {
        if (classifications == null || classifications.isEmpty()) {
            throw new InvalidRequestException(ErrorCode.NO_CLASSIFICATION_FOR_PURPOSE);
        }
        return Purpose.builder().id(id).name(name).tags(classifications);
    }

    /**
     * Send this purpose to Atlan to create the purpose in Atlan.
     *
     * @return the purpose that was created
     * @throws AtlanException on any error during API invocation
     */
    public Purpose create() throws AtlanException {
        return PurposesEndpoint.createPurpose(this);
    }

    /**
     * Send this purpose to Atlan to update the purpose in Atlan.
     *
     * @throws AtlanException on any error during API invocation
     */
    public void update() throws AtlanException {
        if (this.id == null || this.id.length() == 0) {
            throw new InvalidRequestException(ErrorCode.MISSING_PURPOSE_ID);
        }
        PurposesEndpoint.updatePurpose(this.id, this);
    }

    /**
     * Add the provided policy to this purpose in Atlan.
     * Note that the purpose needs to be a complete purpose object, not just a simple
     * stub with an ID.
     *
     * @param policy to add
     * @return the full purpose with all of its policies
     * @throws AtlanException on any error during API invocation
     */
    public Purpose addPolicy(AbstractPolicy policy) throws AtlanException {
        if (this.id == null || this.id.length() == 0) {
            throw new InvalidRequestException(ErrorCode.MISSING_PURPOSE_ID);
        }
        if (this.tags == null || this.tags.isEmpty()) {
            throw new InvalidRequestException(ErrorCode.NO_CLASSIFICATION_FOR_PURPOSE);
        }
        return PurposesEndpoint.addPolicyToPurpose(this, policy);
    }

    /**
     * Delete a purpose from Atlan.
     *
     * @param id unique identifier (GUID) of the purpose to delete
     * @throws AtlanException on any error during API invocation
     */
    public static void delete(String id) throws AtlanException {
        PurposesEndpoint.deletePurpose(id);
    }

    /**
     * Retrieves all purposes currently defined in Atlan.
     * @return the list of purposes currently defined in Atlan
     * @throws AtlanException on any error during API invocation
     */
    public static List<Purpose> retrieveAll() throws AtlanException {
        PurposeResponse response = PurposesEndpoint.getAllPurposes();
        if (response != null && response.getRecords() != null) {
            return response.getRecords();
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * Retrieves the purpose with a name that exactly matches the provided string.
     *
     * @param displayName name (as it appears in the UI) by which to retrieve the purpose
     * @return the purpose whose name (in the UI) contains the provided string, or null if there is none
     * @throws AtlanException on any error during API invocation
     */
    public static Purpose retrieveByName(String displayName) throws AtlanException {
        PurposeResponse response = PurposesEndpoint.getPurposes("{\"displayName\":\"" + displayName + "\"}");
        if (response != null && response.getRecords() != null) {
            return response.getRecords().get(0);
        } else {
            return null;
        }
    }

    @Getter
    @Setter
    @Jacksonized
    @SuperBuilder(toBuilder = true)
    @EqualsAndHashCode(callSuper = true)
    public static final class PurposeAttributes extends AtlanObject {
        private static final long serialVersionUID = 2L;

        /** Preferences associated with the purpose. */
        PurposePreferences preferences;
    }

    @Getter
    @Setter
    @Jacksonized
    @SuperBuilder(toBuilder = true)
    @EqualsAndHashCode(callSuper = true)
    public static final class PurposePreferences extends AtlanObject {
        private static final long serialVersionUID = 2L;

        /** Asset sidebar tabs that should be hidden from this purpose. */
        @Singular("assetTabDeny")
        SortedSet<AssetSidebarTab> assetTabsDenyList;

        /** Unique identifiers (GUIDs) of custom metadata that should be hidden from this purpose. */
        @Singular("customMetadataDeny")
        SortedSet<String> customMetadataDenyList;
    }
}
