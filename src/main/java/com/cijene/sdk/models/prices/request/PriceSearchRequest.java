package com.cijene.sdk.models.prices.request;

import lombok.Data;

import java.util.List;

@Data
public class PriceSearchRequest {
    private List<String> eanList;
    private List<String> chains;
    private String city;
    private String address;
    private Double latitude;
    private Double longitude;
    private Double radius;
}
