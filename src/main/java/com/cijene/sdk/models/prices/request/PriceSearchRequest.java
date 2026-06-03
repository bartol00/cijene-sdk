package com.cijene.sdk.models.prices.request;

import lombok.Data;

import java.util.List;

/**
 * Request object used to query product prices.
 * <p>
 * Contains required EAN codes and optional filters such as:
 * <ul>
 *     <li>Store chains</li>
 *     <li>Location (city/address or coordinates)</li>
 *     <li>Search radius</li>
 * </ul>
 */
@Data
public class PriceSearchRequest {

    /**
     * List of product EAN codes (required).
     * <p>
     * Used as API query param: {@code eans}
     */
    private List<String> eanList;

    /**
     * Filter for store chains (optional).
     * <p>
     * Used as API query param: {@code chains}
     * <p>
     * If not provided, returns prices for all chains and their stores.
     * This should be avoided though, due to the large size of such responses.
     */
    private List<String> chains;

    /**
     * City filter (optional).
     * <p>
     * Used as API query param: {@code city}
     * <p>
     * If not provided, returns prices for all chains and their stores in the whole country.
     */
    private String city;

    /**
     * Address filter (optional).
     * <p>
     * Used as API query param: {@code address}
     */
    private String address;

    /**
     * Latitude for geographic filtering (optional).
     * <p>
     * Used as API query param: {@code lat}
     * <p>
     * Must be provided together with longitude.
     */
    private Double latitude;

    /**
     * Longitude for geographic filtering (optional).
     * <p>
     * Used as API query param: {@code lon}
     * <p>
     * Must be provided together with latitude.
     */
    private Double longitude;

    /**
     * Search radius in kilometers (optional).
     * <p>
     * Used as API query param: {@code d}
     * <p>
     * Must be non-negative if provided.
     */
    private Double radius;
}
