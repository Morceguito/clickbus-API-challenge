package com.morceguito.training.place_app.dtos;


import jakarta.validation.constraints.NotBlank;

public record PlaceRequest (
        @NotBlank String name,
        @NotBlank String state,
        @NotBlank String city
) {
}
