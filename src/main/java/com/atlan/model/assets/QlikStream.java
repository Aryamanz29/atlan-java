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
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * TBC
 */
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class QlikStream extends QlikSpace {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "QlikStream";

    /** Fixed typeName for QlikStreams. */
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /**
     * Reference to a QlikStream by GUID.
     *
     * @param guid the GUID of the QlikStream to reference
     * @return reference to a QlikStream that can be used for defining a relationship to a QlikStream
     */
    public static QlikStream refByGuid(String guid) {
        return QlikStream.builder().guid(guid).build();
    }

    /**
     * Reference to a QlikStream by qualifiedName.
     *
     * @param qualifiedName the qualifiedName of the QlikStream to reference
     * @return reference to a QlikStream that can be used for defining a relationship to a QlikStream
     */
    public static QlikStream refByQualifiedName(String qualifiedName) {
        return QlikStream.builder()
                .uniqueAttributes(
                        UniqueAttributes.builder().qualifiedName(qualifiedName).build())
                .build();
    }

    /**
     * Builds the minimal object necessary to update a QlikStream.
     *
     * @param qualifiedName of the QlikStream
     * @param name of the QlikStream
     * @return the minimal request necessary to update the QlikStream, as a builder
     */
    public static QlikStreamBuilder<?, ?> updater(String qualifiedName, String name) {
        return QlikStream.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a QlikStream, from a potentially
     * more-complete QlikStream object.
     *
     * @return the minimal object necessary to update the QlikStream, as a builder
     * @throws InvalidRequestException if any of the minimal set of required properties for QlikStream are not found in the initial object
     */
    @Override
    public QlikStreamBuilder<?, ?> trimToRequired() throws InvalidRequestException {
        List<String> missing = new ArrayList<>();
        if (this.getQualifiedName() == null || this.getQualifiedName().length() == 0) {
            missing.add("qualifiedName");
        }
        if (this.getName() == null || this.getName().length() == 0) {
            missing.add("name");
        }
        if (!missing.isEmpty()) {
            throw new InvalidRequestException(
                    ErrorCode.MISSING_REQUIRED_UPDATE_PARAM, "QlikStream", String.join(",", missing));
        }
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Retrieves a QlikStream by its GUID, complete with all of its relationships.
     *
     * @param guid of the QlikStream to retrieve
     * @return the requested full QlikStream, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the QlikStream does not exist or the provided GUID is not a QlikStream
     */
    public static QlikStream retrieveByGuid(String guid) throws AtlanException {
        Asset asset = Asset.retrieveFull(guid);
        if (asset == null) {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_GUID, guid);
        } else if (asset instanceof QlikStream) {
            return (QlikStream) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_TYPE_REQUESTED, guid, "QlikStream");
        }
    }

    /**
     * Retrieves a QlikStream by its qualifiedName, complete with all of its relationships.
     *
     * @param qualifiedName of the QlikStream to retrieve
     * @return the requested full QlikStream, complete with all of its relationships
     * @throws AtlanException on any error during the API invocation, such as the {@link NotFoundException} if the QlikStream does not exist
     */
    public static QlikStream retrieveByQualifiedName(String qualifiedName) throws AtlanException {
        Asset asset = Asset.retrieveFull(TYPE_NAME, qualifiedName);
        if (asset instanceof QlikStream) {
            return (QlikStream) asset;
        } else {
            throw new NotFoundException(ErrorCode.ASSET_NOT_FOUND_BY_QN, qualifiedName, "QlikStream");
        }
    }

    /**
     * Restore the archived (soft-deleted) QlikStream to active.
     *
     * @param qualifiedName for the QlikStream
     * @return true if the QlikStream is now active, and false otherwise
     * @throws AtlanException on any API problems
     */
    public static boolean restore(String qualifiedName) throws AtlanException {
        return Asset.restore(TYPE_NAME, qualifiedName);
    }

    /**
     * Remove the system description from a QlikStream.
     *
     * @param qualifiedName of the QlikStream
     * @param name of the QlikStream
     * @return the updated QlikStream, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikStream removeDescription(String qualifiedName, String name) throws AtlanException {
        return (QlikStream) Asset.removeDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the user's description from a QlikStream.
     *
     * @param qualifiedName of the QlikStream
     * @param name of the QlikStream
     * @return the updated QlikStream, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikStream removeUserDescription(String qualifiedName, String name) throws AtlanException {
        return (QlikStream) Asset.removeUserDescription(updater(qualifiedName, name));
    }

    /**
     * Remove the owners from a QlikStream.
     *
     * @param qualifiedName of the QlikStream
     * @param name of the QlikStream
     * @return the updated QlikStream, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikStream removeOwners(String qualifiedName, String name) throws AtlanException {
        return (QlikStream) Asset.removeOwners(updater(qualifiedName, name));
    }

    /**
     * Update the certificate on a QlikStream.
     *
     * @param qualifiedName of the QlikStream
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated QlikStream, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static QlikStream updateCertificate(String qualifiedName, AtlanCertificateStatus certificate, String message)
            throws AtlanException {
        return (QlikStream) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a QlikStream.
     *
     * @param qualifiedName of the QlikStream
     * @param name of the QlikStream
     * @return the updated QlikStream, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikStream removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (QlikStream) Asset.removeCertificate(updater(qualifiedName, name));
    }

    /**
     * Update the announcement on a QlikStream.
     *
     * @param qualifiedName of the QlikStream
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static QlikStream updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (QlikStream) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a QlikStream.
     *
     * @param qualifiedName of the QlikStream
     * @param name of the QlikStream
     * @return the updated QlikStream, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static QlikStream removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (QlikStream) Asset.removeAnnouncement(updater(qualifiedName, name));
    }

    /**
     * Add classifications to a QlikStream.
     *
     * @param qualifiedName of the QlikStream
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the QlikStream
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a QlikStream.
     *
     * @param qualifiedName of the QlikStream
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the QlikStream
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }

    /**
     * Replace the terms linked to the QlikStream.
     *
     * @param qualifiedName for the QlikStream
     * @param name human-readable name of the QlikStream
     * @param terms the list of terms to replace on the QlikStream, or null to remove all terms from the QlikStream
     * @return the QlikStream that was updated (note that it will NOT contain details of the replaced terms)
     * @throws AtlanException on any API problems
     */
    public static QlikStream replaceTerms(String qualifiedName, String name, List<GlossaryTerm> terms)
            throws AtlanException {
        return (QlikStream) Asset.replaceTerms(updater(qualifiedName, name), terms);
    }

    /**
     * Link additional terms to the QlikStream, without replacing existing terms linked to the QlikStream.
     * Note: this operation must make two API calls — one to retrieve the QlikStream's existing terms,
     * and a second to append the new terms.
     *
     * @param qualifiedName for the QlikStream
     * @param terms the list of terms to append to the QlikStream
     * @return the QlikStream that was updated  (note that it will NOT contain details of the appended terms)
     * @throws AtlanException on any API problems
     */
    public static QlikStream appendTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (QlikStream) Asset.appendTerms(TYPE_NAME, qualifiedName, terms);
    }

    /**
     * Remove terms from a QlikStream, without replacing all existing terms linked to the QlikStream.
     * Note: this operation must make two API calls — one to retrieve the QlikStream's existing terms,
     * and a second to remove the provided terms.
     *
     * @param qualifiedName for the QlikStream
     * @param terms the list of terms to remove from the QlikStream, which must be referenced by GUID
     * @return the QlikStream that was updated (note that it will NOT contain details of the resulting terms)
     * @throws AtlanException on any API problems
     */
    public static QlikStream removeTerms(String qualifiedName, List<GlossaryTerm> terms) throws AtlanException {
        return (QlikStream) Asset.removeTerms(TYPE_NAME, qualifiedName, terms);
    }
}