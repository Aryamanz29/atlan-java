/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import java.util.SortedSet;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Base class for Monte Carlo assets.
 */
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = MCIncident.class, name = MCIncident.TYPE_NAME),
    @JsonSubTypes.Type(value = MCMonitor.class, name = MCMonitor.TYPE_NAME),
})
@Slf4j
public abstract class MonteCarlo extends DataQuality {

    public static final String TYPE_NAME = "MonteCarlo";

    /** TBC */
    @Attribute
    @Singular
    SortedSet<String> mcLabels;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<String> mcAssetQualifiedNames;
}