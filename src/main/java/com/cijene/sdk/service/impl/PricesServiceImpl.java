package com.cijene.sdk.service.impl;

import com.segurapass.api.ApiClient;
import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.prices.request.PriceSearchRequest;
import com.cijene.sdk.models.prices.response.Prices;
import com.cijene.sdk.service.PricesService;

import java.util.HashMap;
import java.util.Map;

import static com.cijene.sdk.helpers.StringHelper.getQueryParamFromList;

public class PricesServiceImpl implements PricesService {

    private final ApiClient apiClient;
    private final Map<String, String> headers;

    public PricesServiceImpl(ApiClient apiClient, String apiToken) {
        this.headers = Map.of(
                "accept", "application/json",
                "Authorization", String.format("Bearer %s", apiToken)
        );
        this.apiClient = apiClient;
    }

    @Override
    public Prices getPricesByPriceSearchRequest(PriceSearchRequest request)
            throws IllegalArgumentException, ApiException {

        if (request == null) {
            throw new IllegalArgumentException("Price Search Request cannot be null");
        }
        if (request.getEanList() == null || request.getEanList().isEmpty()) {
            throw new IllegalArgumentException("EAN list cannot be null or empty");
        }
        boolean latPresent = request.getLatitude() != null;
        boolean lonPresent = request.getLongitude() != null;
        if (latPresent ^ lonPresent) {
            throw new IllegalArgumentException("Latitude and longitude must be provided together");
        }
        if (request.getRadius() != null && request.getRadius() < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }

        String endpoint = "/v1/prices/";

        Map<String, String> queryParams = new HashMap<>();

        queryParams.put("eans", getQueryParamFromList(request.getEanList()));

        if (request.getChains() != null && !request.getChains().isEmpty()) {
            queryParams.put("chains", getQueryParamFromList(request.getChains()));
        }

        if (request.getCity() != null) {
            queryParams.put("city", request.getCity());
        }

        if (request.getAddress() != null) {
            queryParams.put("address", request.getAddress());
        }

        if (request.getLatitude() != null) {
            queryParams.put("lat", request.getLatitude().toString());
        }

        if (request.getLongitude() != null) {
            queryParams.put("lon", request.getLongitude().toString());
        }

        if (request.getRadius() != null) {
            queryParams.put("d", request.getRadius().toString());
        }

        return apiClient.sendGetRequest(
                endpoint,
                queryParams,
                headers,
                Prices.class
        ).body();
    }

}
