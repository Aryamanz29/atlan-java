/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model;

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
 * Instance of a term in Atlan, with its detailed information.
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class GlossaryTerm extends Asset {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "AtlasGlossaryTerm";

    /** Fixed typeName for terms. */
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
    List<String> examples;

    @JsonIgnore
    String abbreviation;

    @JsonIgnore
    String usage;

    @JsonIgnore
    Map<String, String> additionalAttributes;

    /** Glossary in which the term is located. */
    @Attribute
    Reference anchor;

    /** Assets that are attached to this term. */
    @Singular
    @Attribute
    Set<Reference> assignedEntities;

    /** Categories within which this term is organized. */
    @Singular
    @Attribute
    Set<Reference> categories;

    /** Linked glossary terms that may also be of interest. */
    @Singular("addToSeeAlso")
    @Attribute
    Set<Reference> seeAlso;

    /** Glossary terms that have the same, or a very similar meaning in the same language. */
    @Singular
    @Attribute
    Set<Reference> synonyms;

    /** Glossary terms that have the opposite (or near opposite) meaning in the same language. */
    @Singular
    @Attribute
    Set<Reference> antonyms;

    /** These terms are preferred in place of this term. */
    @Singular
    @Attribute
    Set<Reference> preferredTerms;

    /** These terms should be used instead of this term. */
    @Singular("addToReplacedBy")
    @Attribute
    Set<Reference> replacedBy;

    /** These terms represent the same meaning, but each is in a different language. */
    @Singular
    @Attribute
    Set<Reference> translatedTerms;

    /** Unused relationships. */
    @JsonIgnore
    Set<Reference> classifies;

    /**
     * These terms each represent one of the valid values that could be assigned to a data item that has the meaning
     * described by this term.
     */
    @Singular("addToValidValuesFor")
    @Attribute
    Set<Reference> validValuesFor;

    /** Remove the linked assets from the term, if any are set on the term. */
    public void removeAssignedEntities() {
        addNullField("assignedEntities");
    }

    /**
     * Builds the minimal object necessary for creating a term. At least one of glossaryGuid or
     * glossaryQualifiedName must be provided.
     *
     * @param name of the term
     * @param glossaryGuid unique identifier of the term's glossary
     * @param glossaryQualifiedName unique name of the term's glossary
     * @return the minimal request necessary to create the term, as a builder
     */
    public static GlossaryTermBuilder<?, ?> creator(String name, String glossaryGuid, String glossaryQualifiedName) {
        return GlossaryTerm.builder()
                .qualifiedName(name)
                .name(name)
                .anchor(Glossary.anchorLink(glossaryGuid, glossaryQualifiedName));
    }

    /**
     * Builds the minimal object necessary to update a term. At least one of glossaryGuid or
     * glossaryQualifiedName must be provided.
     *
     * @param qualifiedName of the term
     * @param name of the term
     * @param glossaryGuid unique identifier of the term's glossary
     * @return the minimal object necessary to update the term, as a builder
     */
    public static GlossaryTermBuilder<?, ?> updater(String qualifiedName, String name, String glossaryGuid) {
        // Turns out that updating a term requires the glossary GUID, and will not work
        // with the qualifiedName of the glossary
        return GlossaryTerm.builder()
                .qualifiedName(qualifiedName)
                .name(name)
                .anchor(Glossary.anchorLink(glossaryGuid, null));
    }

    /**
     * Builds the minimal object necessary to apply an update to a term, from a potentially
     * more-complete term object.
     *
     * @return the minimal object necessary to update the term, as a builder
     */
    @Override
    protected GlossaryTermBuilder<?, ?> trimToRequired() {
        return updater(this.getQualifiedName(), this.getName(), this.getAnchor().getGuid());
    }

    /**
     * Update the certificate on a term.
     *
     * @param qualifiedName of the term
     * @param name of the term
     * @param glossaryGuid unique ID (GUID) of the term's glossary
     * @param certificate to use
     * @param message (optional) message, or null if no message
     * @return the updated term, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static GlossaryTerm updateCertificate(
            String qualifiedName, String name, String glossaryGuid, AtlanCertificateStatus certificate, String message)
            throws AtlanException {
        return (GlossaryTerm) Asset.updateCertificate(updater(qualifiedName, name, glossaryGuid), certificate, message);
    }

    /**
     * Remove the certificate from a term.
     *
     * @param qualifiedName of the term
     * @param name of the term
     * @param glossaryGuid unique ID (GUID) of the term's glossary
     * @return the updated term, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static GlossaryTerm removeCertificate(String qualifiedName, String name, String glossaryGuid)
            throws AtlanException {
        return (GlossaryTerm) Asset.removeCertificate(updater(qualifiedName, name, glossaryGuid));
    }

    /**
     * Update the announcement on a term.
     *
     * @param qualifiedName of the term
     * @param name of the term
     * @param glossaryGuid unique ID (GUID) of the term's glossary
     * @param type type of announcement to set
     * @param title (optional) title of the announcement to set (or null for no title)
     * @param message (optional) message of the announcement to set (or null for no message)
     * @return the result of the update, or null if the update failed
     * @throws AtlanException on any API problems
     */
    public static GlossaryTerm updateAnnouncement(
            String qualifiedName,
            String name,
            String glossaryGuid,
            AtlanAnnouncementType type,
            String title,
            String message)
            throws AtlanException {
        return (GlossaryTerm)
                Asset.updateAnnouncement(updater(qualifiedName, name, glossaryGuid), type, title, message);
    }

    /**
     * Remove the announcement from a term.
     *
     * @param qualifiedName of the term
     * @param name of the term
     * @param glossaryGuid unique ID (GUID) of the term's glossary
     * @return the updated term, or null if the removal failed
     * @throws AtlanException on any API problems
     */
    public static GlossaryTerm removeAnnouncement(String qualifiedName, String name, String glossaryGuid)
            throws AtlanException {
        return (GlossaryTerm) Asset.removeAnnouncement(updater(qualifiedName, name, glossaryGuid));
    }

    /**
     * Add classifications to a term.
     *
     * @param qualifiedName of the term
     * @param classificationNames human-readable names of the classifications to add
     * @throws AtlanException on any API problems, or if any of the classifications already exist on the term
     */
    public static void addClassifications(String qualifiedName, List<String> classificationNames)
            throws AtlanException {
        Asset.addClassifications(TYPE_NAME, qualifiedName, classificationNames);
    }

    /**
     * Remove a classification from a term.
     *
     * @param qualifiedName of the term
     * @param classificationName human-readable name of the classification to remove
     * @throws AtlanException on any API problems, or if the classification does not exist on the term
     */
    public static void removeClassification(String qualifiedName, String classificationName) throws AtlanException {
        Asset.removeClassification(TYPE_NAME, qualifiedName, classificationName);
    }
}
