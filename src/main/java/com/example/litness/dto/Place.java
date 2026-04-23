package com.example.litness.dto;

import lombok.Data;

@Data
public class Place {

    private String formattedAddress;
    private Integer rating;
    private DisplayName displayName;
}
