package com.cijene.sdk.models.products.response;

import lombok.Data;

import java.util.List;

/**
 * Represents a product returned by the Cijene API.
 * <p>
 * Contains general product metadata such as its:
 * <ul>
 *     <li>EAN code</li>
 *     <li>Brand and name</li>
 *     <li>Quantity and unit</li>
 *     <li>Pricing information per store chain</li>
 * </ul>
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
