package ru.iFellow.api.RickAndMortyAPI;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class EpisodeAPI extends BaseRickAndMortyAPI {
    private static final String EPISODE_END_POINT = "/episode";

    public ValidatableResponse getById(int id) {
        return given()
                .when()
                .get(EPISODE_END_POINT + "/" + id)
                .then();
    }
}
