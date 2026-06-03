package com.cijene.sdk.models.stores.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * Represents statistics on retail chains returned by the Cijene API.
 * <p>
 * Contains chain code, price and store counts on a given date.
 */
@Data
public class ChainStat {

    /** Retail chain code this store belongs to. */
    @JsonProperty("chain_code")
    private String chainCode;

    /** Retail chain code this store belongs to */
    @JsonProperty("price_date")
    private LocalDate priceDate;

    /** Number of prices/products a particular retail chain currently holds. */
    @JsonProperty("price_count")
    private Integer priceCount;

    /** Number of stores the retail chain owns. */
    @JsonProperty("store_count")
    private Integer storeCount;

    /** Date of when the statistics for a particular retail chain were created.
     * <p>
     * In practice, it is the update time of the retail chain statistics
     */
    @JsonProperty("created_at")
    private ZonedDateTime createdAt;
}
