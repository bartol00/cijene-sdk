package com.cijene.sdk.models.stores.request;

import lombok.Data;

import java.util.List;

/**
 * Request object used to search for stores using multiple optional filters.
 * Stores can be filtered by:
 * retail chains,
 * location (city or address) and
 * geographic coordinates (lat/lon + radius)
 */
@Data
public class StoreSearchRequest {

    /**
     * List of retail chains to filter stores.
     */
    private List<String> chains;

    /**
     * City filter for store search.
     */
    private String city;

    /**
     * Address filter for more specific store lookup.
     */
    private String address;

    /**
     * Geographic latitude for location-based filtering.
     * Must be provided together with longitude if provided.
     */
    private Double latitude;

    /**
     * Geographic longitude for location-based filtering.
     * Must be provided together with latitude if provided.
     */
    private Double longitude;

    /**
     * Search radius (distance around coordinates).
     * Must be non-negative if provided.
     */
    private Double radius;
}
