package com.cijene.sdk.models.products.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProductSearchRequest {
    private String query;
    private LocalDate date;
    private List<String> chains;
    private Boolean fuzzy;
    private Integer limit;
}
