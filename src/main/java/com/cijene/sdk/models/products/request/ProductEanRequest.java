package com.cijene.sdk.models.products.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * Request object used to retrieve a single product by its EAN code.
 * <p>
 * Supports optional filtering such as:
 * <ul>
 *     <li>Historical price date</li>
 *     <li>Store chain filtering</li>
 * </ul>
 */
@Data
public class ProductEanRequest {

    /**
     * Product EAN code (required).
     * <p>
     * Used as the identifier in the API path:
     * {@code /v1/products/{ean}/}
     */
    private String productEan;

    /**
     * Date filter for retrieving product data at a specific point in time (optional).
     * <p>
     * Used as API query param: {@code date}
     * <p>
     * If not provided, defaults to today's date.
     */
    private LocalDate date;

    /**
     * List of store chains to filter product availability/prices (optional).
     * <p>
     * Used as API query param: {@code chains}
     * <p>
     * If not provided, returns the price data for all store chains that sell it.
     */
    private List<String> chains;
}
