package com.cijene.sdk.models.products.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * Represents product information specific to a store chain.
 * Contains chain-level pricing, categorization and metadata.
 * This allows comparison of product prices across retailers.
 */
@Data
public class ProductChain {

    /** Store chain identifier */
    private String chain;

    /** Internal product code used by the chain */
    private String code;

    /** Product name as defined by the chain */
    private String name;

    /** Brand name as listed by the chain */
    private String brand;

    /** Product category as listed by the chain */
    private String category;

    /** Unit of measurement in this chain context */
    private String unit;

    /** Quantity as defined by the chain */
    private String quantity;

    /** Minimum observed price for the chain */
    @JsonProperty("min_price")
    private String minPrice;

    /** Maximum observed price for the chain */
    @JsonProperty("max_price")
    private String maxPrice;

    /** Average price across observations for the chain */
    @JsonProperty("avg_price")
    private String averagePrice;

    /** Date of price observation */
    @JsonProperty("price_date")
    private LocalDate priceDate;
}
