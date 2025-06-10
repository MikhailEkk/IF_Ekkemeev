package ru.iFellow.api.RegresInAPI;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

public class SpecificationsRegresIn {
    private static final Logger logger = LoggerFactory.getLogger(SpecificationsRegresIn.class);
    private static final ResourceBundle props = ResourceBundle.getBundle("config");
    private static final String BASE_URL = props.getString("base.url.regres.in");
    private static final String API_KEY = props.getString("api.key.regres.in");
    private static final String API_KEY_VALUE = props.getString("api.key.value.regres.in");

    public static RequestSpecification requestSpec() {
        logger.info("Applying RegresIn API request specification with base URL: {}", BASE_URL);
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader(API_KEY, API_KEY_VALUE)
                .setContentType(ContentType.JSON)
                .log(LogDetail.BODY)
                .addFilter(new AllureRestAssured())
                .build();
    }

    public static ResponseSpecification responseSpec() {
        logger.info("Applying RegresIn API response specification expecting status code 201");
        return new ResponseSpecBuilder()
                .log(LogDetail.BODY)
                .build();
    }
}

