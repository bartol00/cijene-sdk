package com.cijene.sdk.service.impl;

import com.segurapass.api.ApiClient;
import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.zip.ZipArchives;
import com.cijene.sdk.service.ZipArchivesService;

import java.util.Map;

public class ZipArchivesServiceImpl implements ZipArchivesService {

    private final ApiClient apiClient;
    private final Map<String, String> headers;

    public ZipArchivesServiceImpl(ApiClient apiClient) {
        this.headers = Map.of(
                "accept", "application/json"
        );
        this.apiClient = apiClient;
    }

    @Override
    public ZipArchives getZipArchives() throws ApiException {
        String endpoint = "/v0/list";
        return apiClient.sendGetRequest(
                endpoint,
                null,
                headers,
                ZipArchives.class
        ).body();
    }

}
