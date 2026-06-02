package com.cijene.sdk.models.products.response;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private String ean;
    private String brand;
    private String name;
    private String quantity;
    private String unit;
    private List<ProductChain> chains;
}
