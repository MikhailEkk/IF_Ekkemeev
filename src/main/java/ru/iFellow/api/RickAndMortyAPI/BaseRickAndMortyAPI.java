package ru.iFellow.api.RickAndMortyAPI;

import io.restassured.RestAssured;

public abstract class BaseRickAndMortyAPI {
    public BaseRickAndMortyAPI() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec("https://rickandmortyapi.com/api");
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }
}
