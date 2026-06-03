package com.cijene.sdk.models.health;

import com.cijene.sdk.service.HealthService;
import lombok.Data;

/**
 * Response object representing API health status.
 * <p>
 * Returned by {@link HealthService#getHealthResponse}
 * and is used to verify that the Cijene API is reachable and operational.
 */
@Data
public class HealthResponse {

    /** Health status of the API. */
    private String status;
}
