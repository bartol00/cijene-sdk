package com.cijene.sdk.models.prices.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents store information associated with a price entry.
 * Contains identifying and location data for the retail location
 * where the product price was recorded.
 */
@Data
public class PriceStore {

    /**
     * Internal identifier of the retail chain
     */
    @JsonProperty("chain_id")
    private Integer chainId;

    /** Store code or internal store identifier */
    private String code;

    /** Type or category of store */
    private String type;

    /** Street address of the store */
    private String address;

    /** City where the store is located */
    private String city;

    /** Postal or ZIP code */
    private String zipcode;

    /**
     * Geographic latitude of the store location (if available)
     */
    @JsonProperty("lat")
    private Double latitude;

    /**
     * Geographic longitude of the store location (if available)
     */
    @JsonProperty("lon")
    private Double longitude;

    /** Contact phone number of the store (if available) */
    private String phone;
}
