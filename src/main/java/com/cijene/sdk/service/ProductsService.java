package com.cijene.sdk.service;

import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.products.request.ProductEanRequest;
import com.cijene.sdk.models.products.request.ProductSearchRequest;
import com.cijene.sdk.models.products.response.Product;
import com.cijene.sdk.models.products.response.Products;

/**
 * Implementation of product-related API operations.
 * <p>
 * Provides access to:
 * <ul>
 *     <li>Product lookup by EAN</li>
 *     <li>Product search by query</li>
 * </ul>
 */
public interface ProductsService {

    /**
     * Retrieves a single product using its EAN code
     * along with optional date and store chain filters.
     * <p>
     * Validation rules:
     * <ul>
     *     <li>Request must not be null</li>
     *     <li>Product EAN list must not be null or blank</li>
     * </ul>
     *
     * @param request product lookup request containing EAN and optional filters
     * @return product details for the specified EAN
     * @throws IllegalArgumentException if request or EAN is missing/invalid
     * @throws ApiException if the API request fails or returns an error response
     */
    Product getProductByEan(ProductEanRequest request)
            throws IllegalArgumentException, ApiException;

    /**
     * Searches for products using a mandatory text query and optional parameters.
     * <p>
     * Validation rules:
     * <ul>
     *     <li>Request must not be null</li>
     *     <li>Product query must not be null or blank</li>
     * </ul>
     *
     * @param request search parameters including query and optional filters
     * @return list of products matching the search criteria
     * @throws IllegalArgumentException if request or query is missing/invalid
     * @throws ApiException if the API request fails or returns an error response
     */
    Products getProductBySearchRequest(ProductSearchRequest request)
            throws IllegalArgumentException, ApiException;
}
