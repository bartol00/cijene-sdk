package com.cijene.sdk.models.health;

import lombok.Data;

/**
 * Response object representing API health status.
 * Used to verify that the Cijene API is reachable and operational.
 */
@Data
public class HealthResponse {

    /**
     * Health status of the API.
     */
    private String status;
}
