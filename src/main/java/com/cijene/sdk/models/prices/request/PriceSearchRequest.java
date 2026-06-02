package com.cijene.sdk.models.prices.request;

import lombok.Data;

import java.util.List;

/**
 * Request object used to query product prices.
 * Contains required EAN codes and optional filters such as:
 * store chains,
 * location (city/address or coordinates)
 * and search radius
 */
@Data
public class PriceSearchRequest {

    /**
     * List of product EAN codes.
     * This field is required and must contain at least one value.
     */
    private List<String> eanList;

    /**
     * Filter for store chains (optional)
     */
    private List<String> chains;

    /** City filter (optional) */
    private String city;

    /** Address filter (optional) */
    private String address;

    /**
     * Latitude for geographic filtering (optional).
     * Must be provided together with longitude.
     */
    private Double latitude;

    /**
     * Longitude for geographic filtering (optional).
     * Must be provided together with latitude.
     */
    private Double longitude;

    /**
     * Search radius in kilometers (optional).
     * Must be non-negative if provided.
     */
    private Double radius;
}
