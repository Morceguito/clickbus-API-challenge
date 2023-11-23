package com.morceguito.training.place_app.repositories;

import com.morceguito.training.place_app.entities.Place;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PlaceRepository extends ReactiveCrudRepository<Place,Long> {

    Mono<Place> findBySlug(String slug);
}
