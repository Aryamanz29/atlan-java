/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.structs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * Detailed information about a Google tag.
 */
@Getter
@Jacksonized
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class GoogleTag extends AtlanStruct {

    public static final String TYPE_NAME = "GoogleTag";

    /** Fixed typeName for GoogleTag. */
    @JsonIgnore
    @Getter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Key of the Google tag. */
    String googleTagKey;

    /** Value for the Google tag. */
    String googleTagValue;

    /**
     * Quickly create a new GoogleTag.
     * @param googleTagKey Key of the Google tag.
     * @param googleTagValue Value for the Google tag.
     * @return a GoogleTag with the provided information
     */
    public static GoogleTag of(String googleTagKey, String googleTagValue) {
        return GoogleTag.builder()
                .googleTagKey(googleTagKey)
                .googleTagValue(googleTagValue)
                .build();
    }
}