package com.example.litness.controller;

import com.example.litness.dto.GooglePlacesRequest;
import com.example.litness.dto.GooglePlacesResponse;
import com.example.litness.service.GooglePlacesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/places")
public class PlacesController {

    private final GooglePlacesService service;

    public PlacesController(GooglePlacesService service) {
        this.service = service;
    }

    @PostMapping("/search")
    public GooglePlacesResponse search(@RequestBody GooglePlacesRequest googlePlacesRequest) {
        return service.searchPlaces(googlePlacesRequest);
    }
}
