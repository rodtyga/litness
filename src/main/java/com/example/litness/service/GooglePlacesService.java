package com.example.litness.service;

import com.example.litness.dto.GooglePlacesRequest;
import com.example.litness.dto.GooglePlacesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GooglePlacesService {

    @Value("${google.places.api.key}")
    private String apiKey;

    private final WebClient webClient = WebClient.create();

    public GooglePlacesResponse searchPlaces(GooglePlacesRequest googlePlacesRequest) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("places.googleapis.com")
                        .path("v1/places:searchText")
                        .queryParam("key", apiKey)
                        .build())
                .header("Content-Type", "application/json")
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask", "places.displayName,places.formattedAddress,places.rating") // hard coding for now
                .bodyValue(googlePlacesRequest)
                .retrieve()
                .bodyToMono(GooglePlacesResponse.class)
                .block();
    }
}
