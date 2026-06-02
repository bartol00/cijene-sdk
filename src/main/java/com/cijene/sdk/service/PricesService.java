package com.cijene.sdk.service;

import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.prices.request.PriceSearchRequest;
import com.cijene.sdk.models.prices.response.Prices;

public interface PricesService {
    Prices getPricesByPriceSearchRequest(PriceSearchRequest request)
            throws IllegalArgumentException, ApiException;
}
