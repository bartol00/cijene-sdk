package com.cijene.sdk.service;

import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.products.request.ProductEanRequest;
import com.cijene.sdk.models.products.request.ProductSearchRequest;
import com.cijene.sdk.models.products.response.Product;
import com.cijene.sdk.models.products.response.Products;

/**
 * Implementation of product-related API operations.
 * Provides access to
 * product lookup by EAN and
 * product search by query.
 */
public interface ProductsService {

    /**
     * Retrieves a single product using its EAN code
     * along with optional date and store chain filters.
     * @param request product lookup request containing EAN and optional filters
     * @return {@link Product} details for the specified EAN
     * @throws IllegalArgumentException if request or EAN is missing/invalid
     * @throws ApiException if the API request fails or returns an error response
     */
    Product getProductByEan(ProductEanRequest request)
            throws IllegalArgumentException, ApiException;

    /**
     * Searches for products using a mandatory text query and optional filters
     * which include: the date, list of store chains and number of results to return.
     * Fuzzy searching can also be enabled.
     * @param request search parameters including query and optional filters
     * @return {@link Products} list of products matching the search criteria
     * @throws IllegalArgumentException if request or query is missing/invalid
     * @throws ApiException if the API request fails or returns an error response
     */
    Products getProductBySearchRequest(ProductSearchRequest request)
            throws IllegalArgumentException, ApiException;
}
