package com.cijene.sdk.models.stores.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Represents a retail store returned by the Cijene API.
 *
 * Contains store identity, location, and contact information.
 */
@Data
public class Store {

    /** Retail chain code this store belongs to */
    @JsonProperty("chain_code")
    private String chainCode;

    /** Internal store identifier */
    private String code;

    /** Store type */
    private String type;

    /** Street address of the store */
    private String address;

    /** City where the store is located */
    private String city;

    /** Postal/ZIP code */
    private String zipcode;

    /** Latitude coordinate of the store location (if available) */
    @JsonProperty("lat")
    private double latitude;

    /** Longitude coordinate of the store location (if available) */
    @JsonProperty("lon")
    private double longitude;

    /** Contact phone number (if available) */
    private String phone;
}
