package com.cijene.sdk.models.prices.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * Represents a product price entry returned by the Cijene API.
 * <p>
 * Contains pricing information for a specific EAN code, store and chain
 * at a given point in time.
 */
@Data
public class Price {

    /** Retail chain identifier where the price was recorded. */
    private String chain;

    /** Product EAN code associated with this price entry. */
    private String ean;

    /** Date when this price was recorded or valid. */
    @JsonProperty("price_date")
    private LocalDate priceDate;

    /** Regular (non-discounted) product price. */
    @JsonProperty("regular_price")
    private String regularPrice;

    /** Promotional or discounted price, if available. */
    @JsonProperty("special_price")
    private String specialPrice;

    /** Price normalized per unit (e.g. per kg, per liter). */
    @JsonProperty("unit_price")
    private String unitPrice;

    /** Lowest observed price in the last 30 days. */
    @JsonProperty("best_price_30")
    private String bestPrice30;

    /** Reference or baseline price used for comparison purposes. */
    @JsonProperty("anchor_price")
    private String anchorPrice;

    /** Store where this price was recorded. */
    private PriceStore store;
}
