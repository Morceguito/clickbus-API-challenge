package com.morceguito.training.services;

import com.morceguito.training.dtos.PlaceRequest;
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

    public Mono<Place> createPlace(PlaceRequest placeRequest){
        Place place = new Place(null, placeRequest.name(), placeRequest.slug(), placeRequest.state(),
                placeRequest.createdAt(),placeRequest.updatedAt());
        return placeRepository.save(place);
    }

}
