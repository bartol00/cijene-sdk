package com.cijene.sdk.models.stores.request;

import lombok.Data;

import java.util.List;

@Data
public class StoreSearchRequest {
    private List<String> chains;
    private String city;
    private String address;
    private Double latitude;
    private Double longitude;
    private Double radius;
}
