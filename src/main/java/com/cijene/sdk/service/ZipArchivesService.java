package com.cijene.sdk.service;

import com.segurapass.exception.ApiException;
import com.cijene.sdk.models.zip.ZipArchives;

public interface ZipArchivesService {
    ZipArchives getZipArchives() throws ApiException;
}
