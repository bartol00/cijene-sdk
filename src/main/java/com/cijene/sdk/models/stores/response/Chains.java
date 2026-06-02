package com.cijene.sdk.models.stores.response;

import lombok.Data;

import java.util.List;

/**
 * Response object containing a list of supported retail chains.
 */
@Data
public class Chains {

    /**
     * List of retail chain identifiers supported by the API.
     */
    private List<String> chains;
}
