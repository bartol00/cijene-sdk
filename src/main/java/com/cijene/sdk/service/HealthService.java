package com.cijene.sdk.service;

import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.health.HealthResponse;

/**
 * Service providing access to health check endpoints.
 * The health endpoint can be used to verify API availability and
 * ensure the service is operational.
 */
public interface HealthService {

    /**
     * Returns the current health status of the Cijene API.
     * This endpoint can be used to verify that:
     * the API is reachable,
     * authentication is working (if required by deployment)
     * and the service is operational
     *
     * @return HealthResponse containing API state information
     * @throws ApiException if the request fails, times out or returns a non-2xx response
     */
    HealthResponse getHealthResponse() throws ApiException;

}
