package com.cijene.sdk.models.prices.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Response object containing a list of product prices.
 * Returned by {@link com.cijene.sdk.service.PricesService#getPricesByPriceSearchRequest}
 * and represents the aggregated result of a price search query.
 */
@Data
public class Prices {

    /**
     * List of price entries returned by the API.
     * Each entry represents product pricing for a specific store,
     * chain and point in time.
     */
    @JsonProperty("store_prices")
    private List<Price> prices;
}
