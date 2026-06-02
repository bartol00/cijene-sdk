package com.cijene.sdk.models.stores.response;

import lombok.Data;

import java.util.List;

/**
 * Response wrapper containing a list of stores.
 *
 * Returned by store search and chain-based store lookup endpoints.
 */
@Data
public class Stores {

    /**
     * List of store entities matching the request criteria.
     */
    private List<Store> stores;
}
