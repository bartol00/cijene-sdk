package com.cijene.sdk.models.zip;

import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Data
public class ZipArchive {
    private LocalDate date;
    private String url;
    private Integer size;
    private ZonedDateTime updated;
}
