package com.cijene.sdk.models.stores.response;

import lombok.Data;

import java.util.List;

/**
 * Response wrapper containing a list of stores.
 * <p>
 * Returned by {@link com.cijene.sdk.service.StoresService#getStoresByChain}
 * and {@link com.cijene.sdk.service.StoresService#getStoresBySearchRequest}.
 */
@Data
public class Stores {

    /** List of store entities matching the request criteria. */
    private List<Store> stores;
}
