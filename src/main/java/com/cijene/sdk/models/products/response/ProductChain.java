package com.cijene.sdk.models.products.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductChain {
    private String chain;
    private String code;
    private String name;
    private String brand;
    private String category;
    private String unit;
    private String quantity;
    @JsonProperty("min_price")
    private String minPrice;
    @JsonProperty("max_price")
    private String maxPrice;
    @JsonProperty("avg_price")
    private String averagePrice;
    @JsonProperty("price_date")
    private LocalDate priceDate;
}
