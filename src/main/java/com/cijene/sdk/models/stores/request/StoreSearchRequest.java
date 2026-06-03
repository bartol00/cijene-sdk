package com.cijene.sdk.models.stores.request;

import lombok.Data;

import java.util.List;

/**
 * Request object used to search for stores using multiple optional filters.
 * <p>
 * Stores can be filtered by:
 * <ul>
 *     <li>Retail chains</li>
 *     <li>Location (city or address)</li>
 *     <li>Geographic coordinates (lat/lon and radius)</li>
 * </ul>
 */
@Data
public class StoreSearchRequest {

    /**
     * List of retail chains to filter stores (optional).
     * <p>
     * Used as API query param: {@code chains}
     */
    private List<String> chains;

    /**
     * City filter for store search.
     * <p>
     * Used as API query param: {@code city}
     */
    private String city;

    /**
     * Address filter for more specific store lookup.
     * <p>
     * Used as API query param: {@code address}
     */
    private String address;

    /**
     * Geographic latitude for location-based filtering.
     * <p>
     * Used as API query param: {@code lat}
     * <p>
     * Must be provided together with longitude if provided.
     */
    private Double latitude;

    /**
     * Geographic longitude for location-based filtering.
     * <p>
     * Used as API query param: {@code lon}
     * <p>
     * Must be provided together with latitude if provided.
     */
    private Double longitude;

    /**
     * Search radius (distance around coordinates).
     * <p>
     * Used as API query param: {@code d}
     * <p>
     * Must be non-negative if provided.
     */
    private Double radius;
}
