/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.search;

import co.elastic.clients.elasticsearch._types.SortOptions;
import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import com.atlan.model.core.AtlanObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@SuperBuilder(toBuilder = true, builderMethodName = "_internal")
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("cast")
public class IndexSearchDSL extends AtlanObject {
    private static final long serialVersionUID = 2L;

    /**
     * Build a search using the provided query and default options.
     *
     * @param query to use for the search
     * @return the search DSL for that query, with default options
     */
    public static IndexSearchDSL of(Query query) {
        return builder(query).build();
    }

    /**
     * Build a search using the provided query and default options.
     *
     * @param query to use for the search
     * @return a search DSL builder for that query, with default options
     */
    public static IndexSearchDSLBuilder<?, ?> builder(Query query) {
        return IndexSearchDSL._internal().query(query);
    }

    /**
     * Starting point for paging. Defaults to 0 (very first result) if not overridden.
     */
    @Builder.Default
    Integer from = 0;

    /**
     * Number of results to return per page. Defaults to 20 results per page if not overridden.
     */
    @Builder.Default
    Integer size = 20;

    /**
     * When true, specify the precise number of results in the response, otherwise estimate and max-out at 10,000.
     * (Defaults to true.)
     */
    @Builder.Default
    @JsonProperty("track_total_hits")
    Boolean trackTotalHits = true;

    /** (Optional) Aggregation to apply to the query. */
    @Singular
    Map<String, Aggregation> aggregations;

    /** Query to run. */
    Query query;

    /** (Optional) Properties by which to sort the results. */
    @Singular("sortOption")
    List<SortOptions> sort;
}
