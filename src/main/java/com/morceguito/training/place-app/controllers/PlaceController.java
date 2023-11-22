package com.morceguito.training.controllers;

import com.morceguito.training.dtos.PlaceRequest;
import com.morceguito.training.dtos.PlaceResponse;
import com.morceguito.training.mappers.PlaceMapper;
import com.morceguito.training.services.PlaceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("places")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    // Create a place
    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest place) {
        Mono<PlaceResponse> createdPlaceResponse = placeService.createPlace(place).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlaceResponse);
    }

    @PatchMapping("/{slug}")
    public Mono<PlaceResponse> edit(@PathVariable String slug, @RequestBody PlaceRequest request) {
        return placeService.edit(slug, request).map(PlaceMapper::fromPlaceToResponse);
    }

    // Get all the places
    @GetMapping
    public ResponseEntity<Flux<PlaceResponse>> allPlaces() {
        Flux<PlaceResponse> allPlacesResponse = placeService.getAllPlaces().map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.OK).body(allPlacesResponse);
    }

    // Get place with a specific slug
    @GetMapping("/{slug}")
    public ResponseEntity<Mono<PlaceResponse>> placeBySlug(@PathVariable String slug) {
        Mono<PlaceResponse> getSlugPlaceResponse = placeService.getBySlug(slug).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.FOUND).body(getSlugPlaceResponse);
    }

}
