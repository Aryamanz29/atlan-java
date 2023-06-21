/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.lineage;

import com.atlan.api.LineageEndpoint;
import com.atlan.exception.AtlanException;
import com.atlan.exception.ErrorCode;
import com.atlan.exception.InvalidRequestException;
import com.atlan.model.core.AtlanObject;
import com.atlan.model.enums.AtlanLineageDirection;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = false)
public class LineageListRequest extends AtlanObject {

    /** Unique identifier of the asset for which to retrieve lineage. */
    String guid;

    /**
     * Number of degrees of separation (hops) across which lineage should be fetched.
     * A depth of {@code 1} will fetch the immediate upstream and/or downstream assets,
     * while {@code 2} will also fetch the immediate upstream and/or downstream assets
     * of those assets, and so on. A large integer value (for example, 1000000) will
     * therefore in effect fetch <em>all</em> upstream and/or downstream assets.
     * (BEWARE! This could take a long time and result in a very large response payload.)
     */
    @Builder.Default
    Integer depth = 1000000;

    /**
     * Indicates whether to fetch upstream lineage only, downstream lineage only, or both.
     */
    @Builder.Default
    AtlanLineageDirection direction = AtlanLineageDirection.DOWNSTREAM;

    /**
     * Filters to apply on entities.
     * Note that if the values in the properties of {@code entityFilters} are not valid, then the
     * filter will not be applied and you will receive all values in the response. If your filter
     * seems to be ignored, check that it is valid (if it is invalid it WILL be ignored).
     */
    FilterList entityFilters;

    /**
     * Filters to apply for skipping traversal based on entities.
     * Any sub-graphs beyond the entities filtered out by these filters will not be included in
     * the lineage result.
     */
    FilterList entityTraversalFilters;

    /**
     * Filters to apply for skipping traversal based on relationships.
     * Any sub-graphs beyond the relationships filtered out by these filters will not be included
     * in the lineage result.
     */
    FilterList relationshipTraversalFilters;

    /** List of attributes to be returned for each asset. */
    @Singular
    List<String> attributes;

    /** Starting point for pagination. */
    @Builder.Default
    Integer from = 0;

    /** How many results to include in each page of results. */
    @Builder.Default
    Integer size = 10;

    /** Whether to include assigned terms for assets (false) or not (true). */
    @Builder.Default
    Boolean excludeMeanings = true;

    /** Whether to include Atlan tags for assets (false) or not (true). */
    @Builder.Default
    @JsonProperty("excludeClassifications")
    Boolean excludeAtlanTags = true;

    /** Fetch the lineage defined by this object. */
    public LineageListResponse fetch() throws AtlanException {
        if (direction == AtlanLineageDirection.BOTH) {
            throw new InvalidRequestException(ErrorCode.INVALID_LINEAGE_DIRECTION);
        }
        return LineageEndpoint.fetch(this);
    }
}