package com.cijene.sdk.models.stores.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Store {
    @JsonProperty("chain_code")
    private String chainCode;
    private String code;
    private String type;
    private String address;
    private String city;
    private String zipcode;
    @JsonProperty("lat")
    private double latitude;
    @JsonProperty("lon")
    private double longitude;
    private String phone;
}
