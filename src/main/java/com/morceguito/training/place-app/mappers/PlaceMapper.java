package com.morceguito.training.mappers;

import com.morceguito.training.dtos.PlaceResponse;
import com.morceguito.training.entities.Place;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place){
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(),place.updatedAt());
    }
}
