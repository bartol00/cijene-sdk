package com.cijene.sdk.models.stores.response;

import com.cijene.sdk.service.StoresService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Response wrapper containing a list of statistics per retail chain.
 * <p>
 * Returned by {@link StoresService#getChains}.
 */
@Data
public class ChainStats {

    /** List of chain statistics entities matching the request criteria. */
    @JsonProperty("chain_stats")
    private List<ChainStat> chainStats;
}
