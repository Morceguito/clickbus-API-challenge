package com.morceguito.training.services;

import com.morceguito.training.entities.Place;
import com.morceguito.training.repositories.PlaceRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Mono<Place> createPlace(Place place){
        return placeRepository.save(place);
    }

}
