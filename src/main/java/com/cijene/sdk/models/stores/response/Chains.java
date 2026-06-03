package com.cijene.sdk.models.stores.response;

import com.cijene.sdk.service.StoresService;
import lombok.Data;

import java.util.List;

/**
 * Response object containing a list of supported retail chains.
 * <p>
 * Returned by {@link StoresService#getChains}
 * and is a list of the available retail chain names.
 */
@Data
public class Chains {

    /** List of retail chain identifiers supported by the API. */
    private List<String> chains;
}
