package com.cijene.sdk.models.products.response;

import lombok.Data;

import java.util.List;

/**
 * Represents a product returned by the Cijene API.
 * Contains general product metadata such as its
 * EAN code,
 * brand and name,
 * quantity and unit,
 * and pricing information per store chain
 */
@Data
public class Product {

    /** Product EAN code */
    private String ean;

    /** Brand name of the product */
    private String brand;

    /** Product name or description */
    private String name;

    /** Quantity information (e.g. weight, volume, count) */
    private String quantity;

    /** Unit of measurement (e.g. kg, L, pcs) */
    private String unit;

    /**
     * List of chain-specific product information,
     * including pricing and availability per store chain.
     */
    private List<ProductChain> chains;
}
