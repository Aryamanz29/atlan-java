/* SPDX-License-Identifier: Apache-2.0 */
package com.atlan.model;

import com.atlan.model.relations.Reference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
}
