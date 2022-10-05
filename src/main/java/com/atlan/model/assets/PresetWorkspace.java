/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.exception.AtlanException;
import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.AtlanCertificateStatus;
import com.atlan.model.enums.AtlanConnectorType;
import com.atlan.model.relations.UniqueAttributes;
import java.util.List;
import java.util.SortedSet;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Instance of a Preset workspace in Atlan, with its detailed information.
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class PresetWorkspace extends Preset {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "PresetWorkspace";

    /** Fixed typeName for Preset workspaces. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Whether public collections are allowed in the workspace (true) or not (false). */
    @Attribute
    Boolean presetWorkspacePublicDashboardsAllowed;

    /** ID of the cluster for the Preset workspace. */
    @Attribute
    Long presetWorkspaceClusterId;

    /** ID of the deployment for the Preset workspace. */
    @Attribute
    Long presetWorkspaceDeploymentId;

    /** Hostname of the Preset workspace. */
    @Attribute
    String presetWorkspaceHostname;

    /** Whether the workspace is in maintenance mode (true) or not (false). */
    @Attribute
    Boolean presetWorkspaceIsInMaintenanceMode;

    /** Region of the workspace. */
    @Attribute
    String presetWorkspaceRegion;

    /** Status of the workspace. */
    @Attribute
    String presetWorkspaceStatus;

    /** Number of collections in the workspace. */
    @Attribute
    Long presetWorkspaceDashboardCount;

    /** Number of datasets in the workspace. */
    @Attribute
    Long presetWorkspaceDatasetCount;

    /** Collections within this workspace. */
    @Singular
    @Attribute
    SortedSet<PresetDashboard> presetDashboards;

    /**
     * Reference to a Preset workspace by GUID.
     *
     * @param guid the GUID of the Preset workspace to reference
     * @return reference to a Preset workspace that can be used for defining a relationship to a Preset workspace
     */
    public static PresetWorkspace refByGuid(String guid) {
        return PresetWorkspace.builder().guid(guid).build();
    }

    /**
     * Reference to a Preset workspace by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the Preset workspace to reference
     * @return reference to a Preset workspace that can be used for defining a relationship to a Preset workspace
     */
    public static PresetWorkspace refByQualifiedName(String qualifiedName) {
        return PresetWorkspace.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Builds the minimal object necessary to create a Preset workspace.
     *
     * @param name of the workspace
     * @param connectionQualifiedName unique name of the connection through which the workspace is accessible
     * @return the minimal object necessary to create the workspace, as a builder
     */
    public static PresetWorkspaceBuilder<?, ?> creator(String name, String connectionQualifiedName) {
        return PresetWorkspace.builder()
                .qualifiedName(generateQualifiedName(connectionQualifiedName, name))
                .name(name)
                .connectionQualifiedName(connectionQualifiedName)
                .connectorType(AtlanConnectorType.PRESET);
    }

    /**
     * Builds the minimal object necessary to update a Preset workspace.
     *
     * @param qualifiedName of the workspace
     * @param name of the workspace
     * @return the minimal object necessary to update the workspace, as a builder
     */
    public static PresetWorkspaceBuilder<?, ?> updater(String qualifiedName, String name) {
        return PresetWorkspace.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a Preset workspace, from a potentially
     * more-complete Preset workspace object.
     *
     * @return the minimal object necessary to update the Preset workspace, as a builder
     */
    @Override
    protected PresetWorkspaceBuilder<?, ?> trimToRequired() {
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Generate a unique Preset workspace name.
     *
     * @param connectionQualifiedName unique name of the connection
     * @param name name for the workspace
     * @return a unique name for the workspace
     */
    private static String generateQualifiedName(String connectionQualifiedName, String name) {
        return connectionQualifiedName + "/" + name;
    }

    /**
     * Update the certificate on a Preset workspace.
     *
     * @param qualifiedName of the workspace
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated workspace, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static PresetWorkspace updateCertificate(
            String qualifiedName, AtlanCertificateStatus certificate, String message) throws AtlanException {
        return (PresetWorkspace) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a Preset workspace.
     *
     * @param qualifiedName of the workspace
     * @param name of the workspace
     * @return the updated workspace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PresetWorkspace removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (PresetWorkspace)
                Asset.removeCertificate(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Update the announcement on a Preset workspace.
     *
     * @param qualifiedName of the workspace
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static PresetWorkspace updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (PresetWorkspace) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a Preset workspace.
     *
     * @param qualifiedName of the workspace
     * @param name of the workspace
     * @return the updated workspace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static PresetWorkspace removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (PresetWorkspace)
                Asset.removeAnnouncement(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Add classifications to a Preset workspace.
     *
     * @param qualifiedName of the workspace
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the workspace
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a Preset workspace.
     *
     * @param qualifiedName of the workspace
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the workspace
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }

    /**
     * Replace the terms linked to the workspace.
     *
     * @param qualifiedName for the workspace
     * @param name human-readable name of the workspace
     * @param terms the list of terms to replace on the workspace, or null to remove all terms from the workspace
     * @return the workspace that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static PresetWorkspace replaceTerms(String qualifiedName, String name, List<GlossaryTerm> terms)
            throws AtlanException {
        return (PresetWorkspace) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the Preset workspace, without replacing existing terms linked to the workspace.
     * Note: this operation must make two API calls — one to retrieve the workspace's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the workspace
     * @param terms the list of terms to append to the workspace
     * @return the workspace that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static PresetWorkspace appendTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (PresetWorkspace) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a Preset workspace, without replacing all existing terms linked to the workspace.
     * Note: this operation must make two API calls — one to retrieve the workspace's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the workspace
     * @param terms the list of terms to remove from the workspace, which must be referenced by GUID
     * @return the workspace that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static PresetWorkspace removeTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (PresetWorkspace) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }
}