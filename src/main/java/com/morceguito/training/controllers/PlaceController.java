package com.morceguito.training.controllers;

import com.morceguito.training.entities.Place;
import com.morceguito.training.services.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("places")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Mono<Place>> create(Place place) {
        Mono<Place> createdPlace = placeService.createPlace(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlace);
    }
}
