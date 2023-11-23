package com.morceguito.training.place_app.services;

import com.github.slugify.Slugify;
import com.morceguito.training.place_app.dtos.PlaceRequest;
import com.morceguito.training.place_app.entities.Place;
import com.morceguito.training.place_app.repositories.PlaceRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.morceguito.training.place_app.mappers.PlaceMapper;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final Slugify slg;

    public PlaceService(PlaceRepository placeRepository, Slugify slg) {
        this.placeRepository = placeRepository;
        this.slg = slg;
    }

    public Mono<Place> createPlace(PlaceRequest placeRequest){
        Place place = new Place(null, placeRequest.name(), slg.slugify(placeRequest.name()), placeRequest.state(), placeRequest.city(),
                null,null);
        return placeRepository.save(place);
    }

    public Flux<Place> getAllPlaces(){
        return placeRepository.findAll();
    }

    public Mono<Place> getBySlug(String slug){
        return placeRepository.findBySlug(slug);
    }

    public Mono<Place> edit(String slug, PlaceRequest placeRequest) {
        return placeRepository.findBySlug(slug)
                .map(place -> PlaceMapper.updatePlacefromResponse(placeRequest,place))
                .map(place -> place.withSlug(slg.slugify(place.name())))
                .flatMap(placeRepository::save);
    }

}
