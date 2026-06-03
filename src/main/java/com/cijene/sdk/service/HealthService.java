package com.cijene.sdk.service;

import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.health.HealthResponse;

/**
 * Service providing access to health check endpoints.
 * <p>
 * The health endpoint can be used to verify API availability and
 * ensure the service is operational.
 *
 * @author Damjan Bartol Benjak
 */
public interface HealthService {

    /**
     * Returns the current health status of the Cijene API.
     * <p>
     * This endpoint can be used to verify that:
     * <ul>
     *     <li>The API is reachable</li>
     *     <li>Authentication is working (if required by deployment)</li>
     *     <li>The service is operational</li>
     * </ul>
     *
     * @return response containing API state information
     * @throws ApiException if the request fails, times out or returns a non-2xx response
     */
    HealthResponse getHealthResponse() throws ApiException;

}
