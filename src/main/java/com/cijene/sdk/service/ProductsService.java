package com.cijene.sdk.service;

import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.products.request.ProductEanRequest;
import com.cijene.sdk.models.products.request.ProductSearchRequest;
import com.cijene.sdk.models.products.response.Product;
import com.cijene.sdk.models.products.response.Products;

public interface ProductsService {
    Product getProductByEan(ProductEanRequest request)
            throws IllegalArgumentException, ApiException;
    Products getProductBySearchRequest(ProductSearchRequest request)
            throws IllegalArgumentException, ApiException;
}
