package com.cijene.sdk;

import com.cijene.sdk.service.*;
import com.cijene.sdk.service.impl.*;
import com.segurapass.api.ApiClient;

public class CijeneClient {

    private final HealthService healthService;
    private final PricesService pricesService;
    private final ProductsService productsService;
    private final StoresService storesService;
    private final ZipArchivesService zipArchivesService;

    public CijeneClient(String apiKey) {
        String baseUrl = "https://api.cijene.dev";
        ApiClient apiClient = new ApiClient(baseUrl);
        this.healthService = new HealthServiceImpl(apiClient);
        this.pricesService = new PricesServiceImpl(apiClient, apiKey);
        this.productsService = new ProductsServiceImpl(apiClient, apiKey);
        this.storesService = new StoresServiceImpl(apiClient, apiKey);
        this.zipArchivesService = new ZipArchivesServiceImpl(apiClient);
    }

    public HealthService health() {
        return healthService;
    }

    public PricesService prices() {
        return pricesService;
    }

    public ProductsService products() {
        return productsService;
    }

    public StoresService stores() {
        return storesService;
    }

    public ZipArchivesService archives() {
        return zipArchivesService;
    }

}
