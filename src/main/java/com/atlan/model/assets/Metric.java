/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import java.util.SortedSet;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Base class for metrics assets.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = DbtMetric.class, name = DbtMetric.TYPE_NAME),
})
@Slf4j
public abstract class Metric extends DataQuality {

    public static final String TYPE_NAME = "Metric";

    /** TBC */
    @Attribute
    String metricType;

    /** TBC */
    @Attribute
    String metricSQL;

    /** TBC */
    @Attribute
    String metricFilters;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<String> metricTimeGrains;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<Asset> assets;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<Column> metricDimensionColumns;

    /** TBC */
    @Attribute
    Column metricTimestampColumn;
}
