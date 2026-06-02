package com.cijene.sdk.models.products.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProductEanRequest {
    private String productEan;
    private LocalDate date;
    private List<String> chains;
}
