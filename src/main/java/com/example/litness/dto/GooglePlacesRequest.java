package com.example.litness.dto;

import lombok.Data;

@Data
public class GooglePlacesRequest {
    private String textQuery;
    private String includedType;
    private Integer maxResultCount;
}
