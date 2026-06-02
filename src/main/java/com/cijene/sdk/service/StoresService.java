package com.cijene.sdk.service;

import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.stores.response.Chains;
import com.cijene.sdk.models.stores.request.StoreSearchRequest;
import com.cijene.sdk.models.stores.response.Stores;

public interface StoresService {
    Chains getChainObject() throws ApiException;
    Stores getStoresByChain(String chainName) throws ApiException;
    Stores getStoresBySearchRequest(StoreSearchRequest request)
            throws IllegalArgumentException, ApiException;
}
