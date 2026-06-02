package com.cijene.sdk.service;

import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.stores.response.Chains;
import com.cijene.sdk.models.stores.request.StoreSearchRequest;
import com.cijene.sdk.models.stores.response.Stores;

/**
 * Implementation of store-related API operations.
 * Provides access to:
 * retail chain metadata,
 * stores by chain and
 * store search using filters and geolocation.
 */
public interface StoresService {

    /**
     * Retrieves all available retail chains supported by the API.
     * This is a simple metadata endpoint and does not require input parameters.
     *
     * @return list of available retail chains
     * @throws ApiException if the API request fails
     */
    Chains getChainObject() throws ApiException;

    /**
     * Retrieves all stores belonging to a specific retail chain.
     *
     * @param chainName name of the retail chain
     * @return list of stores belonging to the specified chain
     * @throws ApiException if the API request fails
     */
    Stores getStoresByChain(String chainName) throws ApiException;

    /**
     * Searches for stores using advanced filter criteria.
     * Request fields are translated into query parameters:
     * - chains → comma-separated list of retail chains
     * - city → city filter
     * - address → address filter
     * - lat/lon → geographic coordinates (must be used together)
     * - d → search radius in distance units
     *
     * Example endpoint:
     * /v1/stores/?city=Zagreb&lat=45.8&lon=16.0&d=5
     *
     * Validation rules:
     * - request must not be null
     * - latitude and longitude must be provided together if used
     * - radius must not be negative if provided
     *
     * @param request store search filters
     * @return list of stores matching the search criteria
     * @throws IllegalArgumentException if request or required fields are invalid
     * @throws ApiException if the API request fails or returns an error response
     */
    Stores getStoresBySearchRequest(StoreSearchRequest request)
            throws IllegalArgumentException, ApiException;
}
