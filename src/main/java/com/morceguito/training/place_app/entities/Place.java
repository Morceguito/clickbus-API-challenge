package com.morceguito.training.place_app.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public record Place (
        @Id Long id,
        String name,
        String slug,
        String state,
        String city,
        @CreatedDate LocalDateTime createdAt,
        @LastModifiedDate LocalDateTime updatedAt) {

    public Place withSlug(String slug) {
        return new Place(id, name, slug, state, city, createdAt, updatedAt);
    }
}

