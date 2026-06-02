package com.cijene.sdk.models.prices.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Prices {
    @JsonProperty("store_prices")
    private List<Price> prices;
}
