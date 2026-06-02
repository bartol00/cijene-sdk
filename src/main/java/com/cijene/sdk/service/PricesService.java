package com.cijene.sdk.service;

import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.prices.request.PriceSearchRequest;
import com.cijene.sdk.models.prices.response.Prices;

/**
 * Service for retrieving product price information from the Cijene API.
 * Provides methods to query prices using EAN codes and optional filters
 * such as store chains and geographic location.
 */
public interface PricesService {

    /**
     * Retrieves product prices using the provided search parameters.
     * See {@link PriceSearchRequest} for request constraints.
     *
     * @param request search criteria for price lookup
     * @return {@link Prices} containing a list of {@link com.cijene.sdk.models.prices.response.Price} entries
     * @throws IllegalArgumentException if the request or required fields are invalid
     * @throws ApiException if the API request fails or returns an error response
     */
    Prices getPricesByPriceSearchRequest(PriceSearchRequest request)
            throws IllegalArgumentException, ApiException;
}
