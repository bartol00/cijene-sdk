package com.cijene.sdk.models.prices.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Price {
    private String chain;
    private String ean;
    @JsonProperty("price_date")
    private LocalDate priceDate;
    @JsonProperty("regular_price")
    private String regularPrice;
    @JsonProperty("special_price")
    private String specialPrice;
    @JsonProperty("unit_price")
    private String unitPrice;
    @JsonProperty("best_price_30")
    private String bestPrice30;
    @JsonProperty("anchor_price")
    private String anchorPrice;
    private PriceStore store;
}
