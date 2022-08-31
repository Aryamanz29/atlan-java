/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.search;

import co.elastic.clients.elasticsearch._types.SortOptions;
import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import com.atlan.model.core.AtlanObject;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class IndexSearchDSL extends AtlanObject {
    private static final long serialVersionUID = 2L;

    /** Starting point for paging. */
    Integer from;

    /** Number of results to return per page. */
    Integer size;

    /** (Optional) Aggregation to apply to the query. */
    Aggregation aggregation;

    /** Query to run. */
    Query query;

    /** (Optional) Properties by which to sort the results. */
    @Singular("sortOption")
    List<SortOptions> sort;
}
