package com.example.litness.dto;

import lombok.Data;

import java.util.List;

@Data
public class GooglePlacesResponse {
    private List<Place> places;
}
