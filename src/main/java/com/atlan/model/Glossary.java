/* SPDX-License-Identifier: Apache-2.0 */
package com.atlan.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Glossary extends Asset {

    public static final String TYPE_NAME = "AtlasGlossary";

    /** Fixed typeName for glossaries. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Attributes for this glossary. */
    @Getter(onMethod_ = {@Override})
    GlossaryAttributes attributes;

    /** Map of the relationships to this glossary. */
    @Getter(onMethod_ = {@Override})
    GlossaryRelationshipAttributes relationshipAttributes;

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof Glossary;
    }

    /**
     * Builds the minimal request necessary to create a glossary.
     *
     * @param name of the glossary
     * @return the minimal request necessary to create the glossary
     */
    public static Glossary createRequest(String name) {
        return Glossary.builder()
                .attributes(GlossaryAttributes.builder()
                        .qualifiedName(name)
                        .name(name)
                        .build())
                .build();
    }

    /**
     * Builds the minimal request necessary to update a glossary.
     *
     * @param guid unique identifier of the glossary
     * @param name of the glossary
     * @return the minimal request necessary to update the glossary
     */
    public static Glossary updateRequest(String guid, String name) {
        return Glossary.builder()
                .guid(guid)
                .attributes(GlossaryAttributes.builder()
                        .qualifiedName(name)
                        .name(name)
                        .build())
                .build();
    }
}
