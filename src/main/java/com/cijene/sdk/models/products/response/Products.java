package com.cijene.sdk.models.products.response;

import lombok.Data;

import java.util.List;

/**
 * Response wrapper containing a list of products returned by the API.
 * This is the top-level response for product search operations.
 */
@Data
public class Products {
    /**
     * List of products matching the search criteria.
     */
    List<Product> products;
}
