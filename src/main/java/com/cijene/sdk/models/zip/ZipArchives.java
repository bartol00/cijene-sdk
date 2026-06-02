package com.cijene.sdk.models.zip;

import lombok.Data;

import java.util.List;

/**
 * Response wrapper containing a list of available ZIP archives.
 *
 * Each archive represents a snapshot of scraped price data
 * that can be downloaded and processed externally.
 */
@Data
public class ZipArchives {

    /**
     * List of available archive entries.
     */
    private List<ZipArchive> archives;
}
