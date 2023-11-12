package com.morceguito.training.repositories;

import com.morceguito.training.entities.Place;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends ReactiveCrudRepository<Place,Long> {
}
