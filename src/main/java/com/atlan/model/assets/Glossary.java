/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.exception.AtlanException;
import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.AtlanCertificateStatus;
import com.atlan.model.relations.Reference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Instance of a glossary in Atlan, with its detailed information.
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Glossary extends Asset {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "AtlasGlossary";

    /** Fixed typeName for glossaries. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Unused attributes. */
    @JsonIgnore
    String shortDescription;

    @JsonIgnore
    String longDescription;

    @JsonIgnore
    String language;

    @JsonIgnore
    String usage;

    @JsonIgnore
    Map<String, String> additionalAttributes;

    /** Terms within this glossary. */
    @Singular
    @Attribute
    Set<Reference> terms;

    /** Categories within this glossary. */
    @Singular
    @Attribute
    Set<Reference> categories;

    /**
     * Builds the minimal object necessary for creating a glossary.
     *
     * @param name of the glossary
     * @return the minimal object necessary to create the glossary, as a builder
     */
    public static GlossaryBuilder<?, ?> creator(String name) {
        return Glossary.builder().qualifiedName(name).name(name);
    }

    /**
     * Builds the minimal object necessary to update a glossary.
     *
     * @param guid unique identifier of the glossary
     * @param name of the glossary
     * @return the minimal object necessary to update the glossary, as a builder
     */
    public static GlossaryBuilder<?, ?> updater(String guid, String name) {
        return Glossary.builder().guid(guid).qualifiedName(name).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to a glossary, from a potentially
     * more-complete glossary object.
     *
     * @return the minimal object necessary to update the glossary, as a builder
     */
    @Override
    protected GlossaryBuilder<?, ?> trimToRequired() {
        return updater(this.getGuid(), this.getName());
    }

    /**
     * Set up the minimal object required to reference a glossary. Only one of the following is required.
     *
     * @param glossaryGuid unique identifier of the glossary for the term
     * @param glossaryQualifiedName unique name of the glossary
     * @return a builder that can be further extended with other metadata
     */
    static Reference anchorLink(String glossaryGuid, String glossaryQualifiedName) {
        Reference anchor = null;
        if (glossaryGuid == null && glossaryQualifiedName == null) {
            return null;
        } else if (glossaryGuid != null) {
            anchor = Reference.to(TYPE_NAME, glossaryGuid);
        } else {
            anchor = Reference.by(TYPE_NAME, glossaryQualifiedName);
        }
        return anchor;
    }

    /**
     * Update the certificate on a glossary.
     *
     * @param qualifiedName of the glossary
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated glossary, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static Glossary updateCertificate(String qualifiedName, AtlanCertificateStatus certificate, String message)
            throws AtlanException {
        return (Glossary) Asset.updateCertificate(builder(), TYPE_NAME, qualifiedName, certificate, message);
    }

    /**
     * Remove the certificate from a glossary.
     *
     * @param qualifiedName of the glossary
     * @param name of the glossary
     * @return the updated glossary, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Glossary removeCertificate(String qualifiedName, String name) throws AtlanException {
        return (Glossary)
                Asset.removeCertificate(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Update the announcement on a glossary.
     *
     * @param qualifiedName of the glossary
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static Glossary updateAnnouncement(
            String qualifiedName, AtlanAnnouncementType type, String title, String message) throws AtlanException {
        return (Glossary) Asset.updateAnnouncement(builder(), TYPE_NAME, qualifiedName, type, title, message);
    }

    /**
     * Remove the announcement from a glossary.
     *
     * @param qualifiedName of the glossary
     * @param name of the glossary
     * @return the updated glossary, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static Glossary removeAnnouncement(String qualifiedName, String name) throws AtlanException {
        return (Glossary)
                Asset.removeAnnouncement(builder().qualifiedName(qualifiedName).name(name));
    }

    /**
     * Add classifications to a glossary.
     *
     * @param qualifiedName of the glossary
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the glossary
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a glossary.
     *
     * @param qualifiedName of the glossary
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the glossary
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }
}