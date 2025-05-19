package ru.iFellow.api.RickAndMortyAPI;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class CharacterAPI extends BaseRickAndMortyAPI {

    private static final String CHARACTER_END_POINT = "/character";

    public ValidatableResponse getByName(String name) {
        return given()
                .when()
                .get(CHARACTER_END_POINT + "/?name=" + name)
                .then();
    }

    public ValidatableResponse getById(int id) {
        return given()
                .when()
                .get(CHARACTER_END_POINT + "/" + id)
                .then();
    }
}
