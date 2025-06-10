package ru.iFellow.api.RickAndMortyAPI;


import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public abstract class BaseRickAndMortyAPI {

    protected static final ResourceBundle props = ResourceBundle.getBundle("config");

    protected abstract String getEndpoint();

    @Step("Получить значение по параметру")
    public ValidatableResponse getByParam(String paramName, String paramValue) {
        return given()
                .when()
                .get(getEndpoint() + "/?" + paramName + "=" + paramValue)
                .then();
    }

    @Step("Получить значение по id")
    public ValidatableResponse getById(int id) {
        return given()
                .when()
                .get(getEndpoint() + "/" + id)
                .then();
    }
}
