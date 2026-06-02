package com.cijene.sdk.service.impl;

import com.segurapass.api.ApiClient;
import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.stores.response.Chains;
import com.cijene.sdk.models.stores.request.StoreSearchRequest;
import com.cijene.sdk.models.stores.response.Stores;
import com.cijene.sdk.service.StoresService;

import java.util.HashMap;
import java.util.Map;

import static com.cijene.sdk.helpers.StringHelper.getQueryParamFromList;

public class StoresServiceImpl implements StoresService {

    private final ApiClient apiClient;
    private final Map<String, String> headers;

    public StoresServiceImpl(ApiClient apiClient, String apiToken) {
        this.headers = Map.of(
                "accept", "application/json",
                "Authorization", String.format("Bearer %s", apiToken)
        );
        this.apiClient = apiClient;
    }

    @Override
    public Chains getChainObject() throws ApiException {
        String endpoint = "/v1/chains/";
        return apiClient.sendGetRequest(
                endpoint,
                null,
                headers,
                Chains.class
        ).body();
    }

    @Override
    public Stores getStoresByChain(String chainName) throws ApiException {
        String endpoint = String.format("/v1/%s/stores/", chainName);
        return apiClient.sendGetRequest(
                endpoint,
                null,
                headers,
                Stores.class
        ).body();
    }

    @Override
    public Stores getStoresBySearchRequest(StoreSearchRequest request)
            throws IllegalArgumentException, ApiException {

        if (request == null) {
            throw new IllegalArgumentException("Store Search Request cannot be null");
        }
        boolean latPresent = request.getLatitude() != null;
        boolean lonPresent = request.getLongitude() != null;
        if (latPresent ^ lonPresent) {
            throw new IllegalArgumentException("Latitude and longitude must be provided together");
        }
        if (request.getRadius() != null && request.getRadius() < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }

        String endpoint = "/v1/stores/";

        Map<String, String> queryParams = new HashMap<>();

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
                Stores.class
        ).body();
    }

}
