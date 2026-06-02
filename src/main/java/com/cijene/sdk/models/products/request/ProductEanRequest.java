package com.cijene.sdk.models.products.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * Request object used to retrieve a single product by its EAN code.
 * Supports optional filtering such as:
 * historical price date
 * and store chain filtering
 */
@Data
public class ProductEanRequest {

    /**
     * Product EAN code (required).
     * Used as the identifier in the API path:
     * /v1/products/{ean}/
     */
    private String productEan;

    /**
     * Date filter for retrieving product data at a specific point in time (optional)
     */
    private LocalDate date;

    /**
     * List of store chains to filter product availability/prices (optional)
     */
    private List<String> chains;
}
