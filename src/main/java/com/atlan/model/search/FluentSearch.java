/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2023 Atlan Pte. Ltd. */
package com.atlan.model.search;

import co.elastic.clients.elasticsearch._types.SortOptions;
import co.elastic.clients.elasticsearch._types.aggregations.Aggregation;
import com.atlan.AtlanClient;
import com.atlan.exception.AtlanException;
import com.atlan.exception.ErrorCode;
import com.atlan.exception.InvalidRequestException;
import com.atlan.model.assets.Asset;
import com.atlan.model.fields.AtlanField;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

/**
 * Search abstraction mechanism, to simplify the most common searches against Atlan
 * (removing the need to understand the guts of Elastic).
 */
@SuperBuilder(builderMethodName = "_internal")
@SuppressWarnings("cast")
public class FluentSearch extends CompoundQuery {

    /**
     * Build a fluent search against the provided Atlan tenant.
     *
     * @param client connectivity to an Atlan tenant
     * @return the start of a fluent search against the tenant
     */
    public static FluentSearchBuilder<?, ?> builder(AtlanClient client) {
        return _internal().client(client);
    }

    /** Client through which to retrieve the assets. */
    AtlanClient client;

    /** Criteria by which to sort the results. */
    @Singular
    List<SortOptions> sorts;

    /**
     * Aggregations to run against the results of the search.
     * You provide any key you want to the map (you'll use it to look at the results of a specific aggregation).
     */
    @Singular("aggregate")
    Map<String, Aggregation> aggregations;

    /** Number of results to retrieve per underlying API request. */
    Integer pageSize;

    /** Attributes to retrieve for each asset. */
    @Singular("includeOnResults")
    List<AtlanField> includesOnResults;

    /** Attributes to retrieve for each asset (for internal use, unchecked!). */
    @Singular("_includeOnResults")
    List<String> _includesOnResults;

    /** Attributes to retrieve for each asset related to the assets in the results. */
    @Singular("includeOnRelations")
    List<AtlanField> includesOnRelations;

    /** Attributes to retrieve for each asset related to the assets in the results (for internal use, unchecked!). */
    @Singular("_includeOnRelations")
    List<String> _includesOnRelations;

    /**
     * Translate the Atlan compound query into an Atlan search DSL builder.
     *
     * @return an Atlan search DSL builder that encapsulates the compound query
     */
    protected IndexSearchDSL.IndexSearchDSLBuilder<?, ?> _dsl() {
        return IndexSearchDSL.builder(toQuery());
    }

    /**
     * Translate the Atlan compound query into an Atlan search request builder.
     *
     * @return an Atlan search request builder that encapsulates the compound query
     */
    protected IndexSearchRequest.IndexSearchRequestBuilder<?, ?> _requestBuilder() {
        IndexSearchDSL.IndexSearchDSLBuilder<?, ?> dsl = _dsl();
        if (pageSize != null) {
            dsl.size(pageSize);
        }
        if (sorts != null) {
            dsl.sort(sorts);
        }
        if (aggregations != null) {
            dsl.aggregations(aggregations);
        }
        IndexSearchRequest.IndexSearchRequestBuilder<?, ?> request = IndexSearchRequest.builder(dsl.build());
        if (_includesOnRelations != null) {
            request.attributes(_includesOnResults);
        }
        if (includesOnResults != null) {
            request.attributes(includesOnResults.stream()
                    .map(AtlanField::getAtlanFieldName)
                    .collect(Collectors.toList()));
        }
        if (_includesOnRelations != null) {
            request.relationAttributes(_includesOnRelations);
        }
        if (includesOnRelations != null) {
            request.relationAttributes(includesOnRelations.stream()
                    .map(AtlanField::getAtlanFieldName)
                    .collect(Collectors.toList()));
        }
        return request;
    }

    public abstract static class FluentSearchBuilder<C extends FluentSearch, B extends FluentSearchBuilder<C, B>>
            extends CompoundQueryBuilder<C, B> {

        /**
         * Translate the Atlan compound query into an Atlan search request builder.
         *
         * @return an Atlan search request builder that encapsulates the compound query
         */
        public IndexSearchRequest.IndexSearchRequestBuilder<?, ?> toRequestBuilder() {
            return build()._requestBuilder();
        }

        /**
         * Translate the Atlan compound query into an Atlan search request.
         *
         * @return an Atlan search request that encapsulates the compound query
         */
        public IndexSearchRequest toRequest() {
            return toRequestBuilder().build();
        }

        /**
         * Return the total number of assets that will match the supplied criteria,
         * using the most minimal query possible (retrieves minimal data).
         *
         * @return the count of assets that will match the supplied criteria
         * @throws AtlanException on any issues interacting with the Atlan APIs
         */
        public long count() throws AtlanException {
            if (client == null) {
                throw new InvalidRequestException(ErrorCode.NO_ATLAN_CLIENT);
            }
            // As long as there is a client, build the search request for just a single result (with count)
            // and then just return the count
            return toRequest().search(client).getApproximateCount();
        }

        /**
         * Run the set of filters to retrieve assets that match the supplied criteria.
         *
         * @return a stream of assets that match the specified criteria, lazily-fetched
         * @throws AtlanException on any issues interacting with the Atlan APIs
         */
        public Stream<Asset> stream() throws AtlanException {
            return stream(false);
        }

        /**
         * Run the set of filters to retrieve assets that match the supplied criteria.
         *
         * @param parallel if true, returns a parallel stream
         * @return a stream of assets that match the specified criteria, lazily-fetched
         * @throws AtlanException on any issues interacting with the Atlan APIs
         */
        public Stream<Asset> stream(boolean parallel) throws AtlanException {
            if (client == null) {
                throw new InvalidRequestException(ErrorCode.NO_ATLAN_CLIENT);
            }
            IndexSearchRequest request = toRequest();
            if (parallel) {
                return request.search(client).parallelStream();
            } else {
                return request.search(client).stream();
            }
        }
    }
}
