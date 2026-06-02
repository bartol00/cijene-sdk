package com.cijene.sdk.models.products.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * Request object used to search for products using a text query.
 * Supports filtering by:
 * search query (required),
 * date (historical snapshot),
 * store chains,
 * fuzzy matching and
 * result limit
 */
@Data
public class ProductSearchRequest {

    /**
     * Search query string (required).
     * Used as API query parameter: q
     */
    private String query;

    /**
     * Date filter for historical product data (optional)
     */
    private LocalDate date;

    /**
     * List of store chains to restrict search scope (optional)
     */
    private List<String> chains;

    /**
     * Enables fuzzy matching for broader search results.
     * If true, API may return approximate matches
     */
    private Boolean fuzzy;

    /**
     * Maximum number of results to return
     */
    private Integer limit;
}
