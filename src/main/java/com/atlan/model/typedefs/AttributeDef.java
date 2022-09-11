/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.typedefs;

import com.atlan.model.core.AtlanObject;
import com.atlan.model.enums.AtlanCustomAttributeCardinality;
import com.atlan.model.enums.AtlanCustomAttributePrimitiveType;
import java.util.Map;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Defines the structure of a single attribute for a type definition in Atlan.
 */
@Getter
@Setter
@Jacksonized
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class AttributeDef extends AtlanObject {
    private static final long serialVersionUID = 2L;

    /**
     * Instantiate an attribute definition from the provided parameters.
     *
     * @param displayName human-readable name of the attribute
     * @param type primitive type of the attribute
     * @param optionsName name of the options (enumeration) if the primitive type is an enumeration (can be null otherwise)
     * @param multiValued true if multiple values are allowed for the attribute, otherwise false
     * @return the attribute definition
     */
    public static AttributeDef of(
            String displayName, AtlanCustomAttributePrimitiveType type, String optionsName, boolean multiValued) {
        AttributeDefBuilder<?, ?> builder =
                AttributeDef.builder().name(displayName).displayName(displayName);
        String baseType;
        switch (type) {
            case OPTIONS:
                baseType = optionsName;
                break;
            case USERS:
            case GROUPS:
            case URL:
            case SQL:
                baseType = AtlanCustomAttributePrimitiveType.STRING.getValue();
                break;
            default:
                baseType = type.getValue();
                break;
        }
        if (multiValued) {
            builder = builder.typeName("array<" + baseType + ">")
                    .options(AttributeDefOptions.of(type, optionsName).toBuilder()
                            .multiValueSelect(true)
                            .build());
        } else {
            builder = builder.typeName(baseType).options(AttributeDefOptions.of(type, optionsName));
        }
        return builder.build();
    }

    /** Internal hashed-string name for the attribute. */
    String name;

    /** Human-readable name of the attribute. */
    String displayName;

    /** Explanation of the attribute. */
    String description;

    /**
     * Type of the attribute.
     * <ul>
     *   <li>This can either be a primitive Atlan type or the name of a custom metadata enumeration (options).</li>
     *   <li>The primitive Atlan types' values are defined in the {@link AtlanCustomAttributePrimitiveType} enumeration.</li>
     *   <li>Note: there are a number of custom types there as well ({@code users}, {@code groups}, {@code url}, and {@code SQL}). The {@code typeName} for all of these custom types is {@code STRING}, and the more detailed type only appears in the {@link #options}.</li>
     *   <li>For fields that can be multivalued, use {@code array<type>} for the typeName.</li>
     * </ul>
     */
    String typeName;

    /** Indicates whether the attribute is mandatory (false) or optional (true). */
    @Builder.Default
    Boolean isOptional = true;

    /** Specifies whether the attribute is single or multivalued. */
    @Builder.Default
    AtlanCustomAttributeCardinality cardinality = AtlanCustomAttributeCardinality.SINGLE;

    /** Specifies the minimum number of values the attribute can have. */
    @Builder.Default
    Long valuesMinCount = 0L;

    /** Specifies the maximum number of values the attribute can have. */
    @Builder.Default
    Long valuesMaxCount = 1L;

    /** Specifies whether the attribute must have unique values (true) or not (false). */
    @Builder.Default
    Boolean isUnique = false;

    /** Specifies whether the attribute can be searched (true) or not (false). */
    @Builder.Default
    Boolean isIndexable = true;

    /** Whether changes to this attribute's value generate an event (true) or not (false). */
    @Builder.Default
    Boolean includeInNotification = false;

    /** TBC */
    final Boolean skipScrubbing;

    /** TBC */
    final Long searchWeight;

    /** TBC */
    final String indexType;

    /** Options for the attribute. */
    AttributeDefOptions options;

    /** Whether the attribute is being newly created (true) or not (false). */
    @Builder.Default
    Boolean isNew = true;

    /** TBC */
    final Map<String, String> indexTypeESConfig;

    /** TBC */
    final Map<String, Map<String, String>> indexTypeESFields;
}
