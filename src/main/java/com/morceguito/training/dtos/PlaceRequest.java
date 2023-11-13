package com.morceguito.training.dtos;


import jakarta.validation.constraints.NotBlank;

public record PlaceRequest (
        @NotBlank String name,
        @NotBlank String state
) {
}
