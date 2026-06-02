package com.cijene.sdk.models.prices.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PriceStore {
    @JsonProperty("chain_id")
    private Integer chainId;
    private String code;
    private String type;
    private String address;
    private String city;
    private String zipcode;
    @JsonProperty("lat")
    private Double latitude;
    @JsonProperty("lon")
    private Double longitude;
    private String phone;
}
