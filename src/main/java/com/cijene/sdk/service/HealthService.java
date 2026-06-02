package com.cijene.sdk.service;

import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.health.HealthResponse;

public interface HealthService {
    HealthResponse getHealthResponse() throws ApiException;
}
