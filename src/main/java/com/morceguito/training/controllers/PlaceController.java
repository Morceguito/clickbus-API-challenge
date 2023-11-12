package com.morceguito.training.controllers;

import com.morceguito.training.dtos.PlaceRequest;
import com.morceguito.training.dtos.PlaceResponse;
import com.morceguito.training.mappers.PlaceMapper;
import com.morceguito.training.services.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<Mono<PlaceResponse>> create(@RequestBody PlaceRequest place) {
        Mono<PlaceResponse> createdPlaceResponse = placeService.createPlace(place).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlaceResponse);
    }
}
