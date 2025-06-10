package ru.iFellow.api.RickAndMortyAPI;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.ResourceBundle;

public class SpecificationsRickAndMorty {

    private static final ResourceBundle props = ResourceBundle.getBundle("config");
    private static final String BASE_URL = props.getString("base.url.RickAndMorty");

    public static RequestSpecification baseRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .log(LogDetail.BODY)
                .build();
    }

    public static ResponseSpecification baseResponseSpecSuccess() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }
}
