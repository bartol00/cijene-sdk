package com.cijene.sdk.service.impl;

import com.segurapass.api.ApiClient;
import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.health.HealthResponse;
import com.cijene.sdk.service.HealthService;

import java.util.Map;

public class HealthServiceImpl implements HealthService {

    private final ApiClient apiClient;
    private final Map<String, String> headers;

    public HealthServiceImpl(ApiClient apiClient) {
        this.headers = Map.of(
                "accept", "application/json"
        );
        this.apiClient = apiClient;
    }

    @Override
    public HealthResponse getHealthResponse() throws ApiException {
        String endpoint = "/health";
        return apiClient.sendGetRequest(
                endpoint,
                null,
                headers,
                HealthResponse.class
        ).body();
    }

}
