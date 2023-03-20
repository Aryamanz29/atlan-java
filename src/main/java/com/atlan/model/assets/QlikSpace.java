/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.exception.AtlanException;
import com.atlan.exception.ErrorCode;
import com.atlan.exception.InvalidRequestException;
import com.atlan.exception.NotFoundException;
import com.atlan.model.enums.*;
import com.atlan.model.relations.UniqueAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * TBC
 */
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class QlikSpace extends Qlik {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "QlikSpace";

    /** Fixed typeName for QlikSpaces. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** TBC */
    @Attribute
    String qlikSpaceType;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<QlikDataset> qlikDatasets;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<QlikApp> qlikApps;

    /**
     * Reference to a QlikSpace by GUID.
     *
     * @param guid the GUID of the QlikSpace to reference
     * @return reference to a QlikSpace that can be used for defining a relationship to a QlikSpace
     */
    public static QlikSpace refByGuid(String guid) {
        return QlikSpace.builder().guid(guid).build();
    }

    /**
     * Reference to a QlikSpace by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the QlikSpace to reference
     * @return reference to a QlikSpace that can be used for defining a relationship to a QlikSpace
     */
    public static QlikSpace refByQualifiedName(String qualifiedName) {
        return QlikSpace.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Builds the minimal object necessary to update a QlikSpace.
     *
     * @param qualifiedName of the QlikSpace
     * @param name of the QlikSpace
     * @return the minimal request necessary to update the QlikSpace, as a builder
     */
    public static QlikSpaceBuilder<?, ?> updater(String qualifiedName, String name) {
        return QlikSpace.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a QlikSpace, from a potentially
     * more-complete QlikSpace object.
     *
     * @return the minimal object necessary to update the QlikSpace, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for QlikSpace are not found in the initial object
     */
    @Override
    public QlikSpaceBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "QlikSpace", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Retrieves a QlikSpace by its GUID, complete with all of its relationships.
     *
     * @param guid of the QlikSpace to retrieve
     * @return the requested full QlikSpace, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the QlikSpace does not exist or the provided GUID is not a QlikSpace
     */
    public static QlikSpace retrieveByGuid(String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof QlikSpace) {
            return (QlikSpace) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "QlikSpace");
        }
    }

    /**
     * Retrieves a QlikSpace by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the QlikSpace to retrieve
     * @return the requested full QlikSpace, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the QlikSpace does not exist
     */
    public static QlikSpace retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(TYPE_NAME, qualifiedName);
        if (asset instanceof QlikSpace) {
            return (QlikSpace) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "QlikSpace");
        }
    }

    /**
     * Restore the archived (soft-deleted) QlikSpace to active.
     *
     * @param qualifiedName for the QlikSpace
     * @return true if the QlikSpace is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return Asset.restore(TYPE_NAME, qualifiedName);
    }

    /**
     * Remove the system description from a QlikSpace.
     *
     * @param qualifiedName of the QlikSpace
     * @param name of the QlikSpace
     * @return the updated QlikSpace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikSpace removeDescription(String qualifiedName, String name) throws AtlanException {
        return (QlikSpace) Asset.removeDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a QlikSpace.
     *
     * @param qualifiedName of the QlikSpace
     * @param name of the QlikSpace
     * @return the updated QlikSpace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikSpace removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return (QlikSpace) Asset.removeUserDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a QlikSpace.
     *
     * @param qualifiedName of the QlikSpace
     * @param name of the QlikSpace
     * @return the updated QlikSpace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikSpace removeOwners(String qualifiedName, String name) throws AtlanException {
        return (QlikSpace) Asset.removeOwners(updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a QlikSpace.
     *
     * @param qualifiedName of the QlikSpace
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated QlikSpace, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static QlikSpace updateCertificate(String qualifiedName, AtlanCertificateStatus certificate, String message)
            throws AtlanException {
        return (QlikSpace) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a QlikSpace.
     *
     * @param qualifiedName of the QlikSpace
     * @param name of the QlikSpace
     * @return the updated QlikSpace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikSpace removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (QlikSpace) Asset.removeCertificate(updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a QlikSpace.
     *
     * @param qualifiedName of the QlikSpace
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static QlikSpace updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (QlikSpace) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a QlikSpace.
     *
     * @param qualifiedName of the QlikSpace
     * @param name of the QlikSpace
     * @return the updated QlikSpace, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikSpace removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (QlikSpace) Asset.removeAnnouncement(updater(qualifiedName, name));
    }

    /**
     * Add classifications to a QlikSpace.
     *
     * @param qualifiedName of the QlikSpace
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the QlikSpace
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a QlikSpace.
     *
     * @param qualifiedName of the QlikSpace
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the QlikSpace
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }

    /**
     * Replace the terms linked to the QlikSpace.
     *
     * @param qualifiedName for the QlikSpace
     * @param name human-readable name of the QlikSpace
     * @param terms the list of terms to replace on the QlikSpace, or null to remove all terms from the QlikSpace
     * @return the QlikSpace that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static QlikSpace replaceTerms(String qualifiedName, String name, List<GlossaryTerm> terms)
            throws AtlanException {
        return (QlikSpace) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the QlikSpace, without replacing existing terms linked to the QlikSpace.
     * Note: this operation must make two API calls — one to retrieve the QlikSpace's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the QlikSpace
     * @param terms the list of terms to append to the QlikSpace
     * @return the QlikSpace that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static QlikSpace appendTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (QlikSpace) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a QlikSpace, without replacing all existing terms linked to the QlikSpace.
     * Note: this operation must make two API calls — one to retrieve the QlikSpace's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the QlikSpace
     * @param terms the list of terms to remove from the QlikSpace, which must be referenced by GUID
     * @return the QlikSpace that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static QlikSpace removeTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (QlikSpace) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }
}