package com.cijene.sdk.models.products.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * Request object used to search for products using a text query.
 * <p>
 * Supports filtering by:
 * <ul>
 *     <li>Search query (required)</li>
 *     <li>Date (historical snapshot)</li>
 *     <li>Store chains</li>
 *     <li>Fuzzy matching</li>
 *     <li>Result limit</li>
 * </ul>
 */
@Data
public class ProductSearchRequest {

    /**
     * Search query string (required).
     * <p>
     * Used as API query parameter: {@code q}
     */
    private String query;

    /**
     * Date filter for historical product data (optional).
     * <p>
     * Used as API query parameter: {@code date}
     * <p>
     * If not provided, defaults to today's date.
     */
    private LocalDate date;

    /**
     * List of store chains to restrict search scope (optional)
     * <p>
     * Used as API query parameter: {@code chains}
     * <p>
     * If not provided, returns price data for all store chains that sell
     * the products that fall within search scope.
     */
    private List<String> chains;

    /**
     * Enables fuzzy matching for broader search results. If true, API may return approximate
     * instead of exact matches.
     * <p>
     * Used as API query parameter: {@code fuzzy}
     * <p>
     * If not provided, defaults to false (exact matches only).
     */
    private Boolean fuzzy;

    /**
     * Maximum number of results to return
     * <p>
     * Used as API query parameter: {@code limit}
     * <p>
     * If not provided, defaults to 20 (maximum is 100).
     */
    private Integer limit;
}
