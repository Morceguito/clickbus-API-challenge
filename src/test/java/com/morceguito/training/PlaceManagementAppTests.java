package com.morceguito.training;

import com.morceguito.training.dtos.PlaceRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlaceManagementAppTests {

    @Autowired
    WebTestClient webTestClient;

    @BeforeAll
    public static void setup(){

    }

    @Test
    public void testCreatePlaceSuccess() {
        String name = "Valid Name";
        String state = "Valid state";
        String slug = "valid-name";

        webTestClient
                .post()
                .uri("places")
                .bodyValue(
                        new PlaceRequest(name,state)
                )
                .exchange()
                .expectBody()
                .jsonPath("name").isEqualTo(name)
                .jsonPath("state").isEqualTo(state)
                .jsonPath("slug").isEqualTo(slug)
                .jsonPath("createdAt").isNotEmpty()
                .jsonPath("updatedAt").isNotEmpty();
    }

    @Test
    public void testGetAllPlacesSuccess() {
        webTestClient
                .get()
                .uri("places")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testCreatePlaceFailure() {
        String name = "";
        String state = "";

        webTestClient
                .post()
                .uri("places")
                .bodyValue(
                        new PlaceRequest(name,state)
                )
                .exchange()
                .expectStatus().isBadRequest();
    }
}
