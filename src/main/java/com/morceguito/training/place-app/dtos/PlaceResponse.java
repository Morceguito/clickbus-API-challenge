package com.morceguito.training.dtos;

import java.time.LocalDateTime;

public record PlaceResponse (
        String name,
        String slug,
        String state,
        String city,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
