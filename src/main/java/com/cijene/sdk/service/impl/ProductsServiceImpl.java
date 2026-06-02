package com.cijene.sdk.service.impl;

import com.segurapass.api.ApiClient;
import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.products.request.ProductEanRequest;
import com.cijene.sdk.models.products.request.ProductSearchRequest;
import com.cijene.sdk.models.products.response.Product;
import com.cijene.sdk.models.products.response.Products;
import com.cijene.sdk.service.ProductsService;

import java.util.HashMap;
import java.util.Map;

import static com.cijene.sdk.helpers.StringHelper.getQueryParamFromList;

public class ProductsServiceImpl implements ProductsService {

    private final ApiClient apiClient;
    private final Map<String, String> headers;

    public ProductsServiceImpl(ApiClient apiClient, String apiToken) {
        this.headers = Map.of(
                "accept", "application/json",
                "Authorization", String.format("Bearer %s", apiToken)
        );
        this.apiClient = apiClient;
    }

    @Override
    public Product getProductByEan(ProductEanRequest request)
            throws IllegalArgumentException, ApiException {

        if (request == null) {
            throw new IllegalArgumentException("Product EAN Request cannot be null");
        }
        if (request.getProductEan() == null || request.getProductEan().isBlank()) {
            throw new IllegalArgumentException("EAN cannot be null");
        }

        String endpoint = String.format("/v1/products/%s/", request.getProductEan());

        Map<String, String> queryParams = new HashMap<>();

        if (request.getDate() != null) {
            queryParams.put("date", request.getDate().toString());
        }

        if (request.getChains() != null && !request.getChains().isEmpty()) {
            queryParams.put("chains", getQueryParamFromList(request.getChains()));
        }

        return apiClient.sendGetRequest(
                endpoint,
                queryParams,
                headers,
                Product.class
        ).body();
    }

    @Override
    public Products getProductBySearchRequest(ProductSearchRequest request)
            throws IllegalArgumentException, ApiException {

        if (request == null) {
            throw new IllegalArgumentException("Product Search Request cannot be null");
        }
        if (request.getQuery() == null || request.getQuery().isBlank()) {
            throw new IllegalArgumentException("Query cannot be null");
        }

        String endpoint = "/v1/products/";

        Map<String, String> queryParams = new HashMap<>();

        queryParams.put("q", request.getQuery());

        if (request.getDate() != null) {
            queryParams.put("date", request.getDate().toString());
        }

        if (request.getChains() != null && !request.getChains().isEmpty()) {
            queryParams.put("chains", getQueryParamFromList(request.getChains()));
        }

        if (request.getFuzzy() != null) {
            queryParams.put("fuzzy", request.getFuzzy().toString());
        }

        if (request.getLimit() != null) {
            queryParams.put("limit", request.getLimit().toString());
        }

        return apiClient.sendGetRequest(
                endpoint,
                queryParams,
                headers,
                Products.class
        ).body();
    }

}
