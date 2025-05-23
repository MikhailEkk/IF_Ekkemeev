package ru.iFellow.api.RickAndMortyAPI;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public abstract class BaseRickAndMortyAPI {

    protected static final ResourceBundle props = ResourceBundle.getBundle("config");
    public static final String BASE_URL = props.getString("base.url.RickAndMorty");

    public BaseRickAndMortyAPI() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(BASE_URL);
        RestAssured.responseSpecification = Specifications.baseResponseSpecSuccess();
    }

    protected abstract String getEndpoint();

    public ValidatableResponse getByParam(String paramName, String paramValue) {
        return given()
                .when()
                .get(getEndpoint() + "/?" + paramName + "=" + paramValue)
                .then();
    }

    public ValidatableResponse getById(int id) {
        return given()
                .when()
                .get(getEndpoint() + "/" + id)
                .then();
    }
}
