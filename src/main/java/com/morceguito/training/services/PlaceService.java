package com.morceguito.training.services;

import com.github.slugify.Slugify;
import com.morceguito.training.dtos.PlaceRequest;
import com.morceguito.training.entities.Place;
import com.morceguito.training.repositories.PlaceRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final Slugify slg;

    public PlaceService(PlaceRepository placeRepository, Slugify slg) {
        this.placeRepository = placeRepository;
        this.slg = slg;
    }

    public Mono<Place> createPlace(PlaceRequest placeRequest){
        Place place = new Place(null, placeRequest.name(), slg.slugify(placeRequest.name()), placeRequest.state(),
                null,null);
        return placeRepository.save(place);
    }

}
