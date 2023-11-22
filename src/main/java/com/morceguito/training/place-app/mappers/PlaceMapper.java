package com.morceguito.training.mappers;

import com.morceguito.training.dtos.PlaceResponse;
import com.morceguito.training.entities.Place;
import org.springframework.util.StringUtils;
import com.morceguito.training.dtos.PlaceRequest;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place){
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.city(), place.createdAt(),place.updatedAt());
    }

    public static Place updatePlacefromResponse (PlaceRequest placeRequest, Place place){
        final String name = StringUtils.hasText(placeRequest.name()) ? placeRequest.name() : place.name();
        final String city = StringUtils.hasText(placeRequest.city()) ? placeRequest.city() : place.city();
        final String state = StringUtils.hasText(placeRequest.state()) ? placeRequest.state() : place.state();
        return new Place(place.id(), name, place.slug(), city, state, place.createdAt(), place.updatedAt());
    }
}
