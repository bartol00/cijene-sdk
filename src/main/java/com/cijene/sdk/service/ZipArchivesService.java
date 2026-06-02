package com.cijene.sdk.service;

import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.zip.ZipArchives;

/**
 * Implementation of the ZIP archive metadata API.
 *
 * Provides access to downloadable archives containing raw price data
 * collected by the Cijene data ingestion pipeline.
 *
 * This endpoint is typically used for:
 * - downloading historical scraped datasets
 * - offline processing of price data
 * - bulk data analysis workflows
 */
public interface ZipArchivesService {

    /**
     * Retrieves metadata for all available ZIP archives containing price data.
     *
     * Each archive entry includes:
     * - download URL
     * - archive size
     * - last update timestamp
     * - snapshot date of the data
     *
     * @return list of available ZIP archives with metadata
     * @throws ApiException if the API request fails or returns an error response
     */
    ZipArchives getZipArchives() throws ApiException;
}
