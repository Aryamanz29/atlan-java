/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * TBC
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Google.class, name = Google.TYPE_NAME),
    @JsonSubTypes.Type(value = Azure.class, name = Azure.TYPE_NAME),
    @JsonSubTypes.Type(value = AWS.class, name = AWS.TYPE_NAME),
})
@Slf4j
public abstract class Cloud extends Asset implements ICloud, IAsset, IReferenceable {

    public static final String TYPE_NAME = "Cloud";
}
