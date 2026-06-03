package com.cijene.sdk.service;

import com.cijene.sdk.models.stores.response.ChainStats;
import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.stores.response.Chains;
import com.cijene.sdk.models.stores.request.StoreSearchRequest;
import com.cijene.sdk.models.stores.response.Stores;

/**
 * Implementation of store-related API operations.
 * <p>
 * Provides access to:
 * <ul>
 *     <li>Retail chain metadata</li>
 *     <li>Stores by chain</li>
 *     <li>Store search using filters and geolocation</li>
 *     <li>Currently available data per chain</li>
 * </ul>
 *
 * @author Damjan Bartol Benjak
 */
public interface StoresService {

    /**
     * Retrieves all available retail chains supported by the API.
     * <p>
     * This is a simple metadata endpoint and does not require input parameters.
     *
     * @return list of available retail chains
     * @throws ApiException if the API request fails
     */
    Chains getChains() throws ApiException;

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
     * <p>
     * Validation rules:
     * <ul>
     *     <li>Request must not be null</li>
     *     <li>Latitude and longitude must be provided together if used</li>
     *     <li>Radius must not be negative if provided</li>
     * </ul>
     *
     * @param request store search filters
     * @return list of stores matching the search criteria
     * @throws IllegalArgumentException if request or required fields are invalid
     * @throws ApiException if the API request fails or returns an error response
     */
    Stores getStoresBySearchRequest(StoreSearchRequest request)
            throws IllegalArgumentException, ApiException;

    /**
     * Retrieves information such as price/product and store counts
     * on the available retail chains.
     * <p>
     * This is a simple metadata endpoint and does not require input parameters.
     *
     * @return statistics on available retail chains
     * @throws ApiException if the API request fails
     */
    ChainStats getChainStats() throws ApiException;
}
