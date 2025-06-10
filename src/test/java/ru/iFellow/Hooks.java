package ru.iFellow;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.iFellow.api.RegresInAPI.SpecificationsRegresIn;
import ru.iFellow.api.RickAndMortyAPI.SpecificationsRickAndMorty;

public class Hooks {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before("@RickAndMorty")
    public void setupRickAndMorty() {
        logger.info("Setting up specifications for Rick and Morty API");
        RestAssured.requestSpecification = SpecificationsRickAndMorty.baseRequestSpec();
        RestAssured.responseSpecification = SpecificationsRickAndMorty.baseResponseSpecSuccess();
    }

    @Before("@RegresIn")
    public void setupRegresIn() {
        logger.info("Setting up specifications for RegresIn API");
        RestAssured.requestSpecification = SpecificationsRegresIn.requestSpec();
        RestAssured.responseSpecification = SpecificationsRegresIn.responseSpec();
    }

    @After
    public void tearDown() {
        logger.info("Resetting RestAssured specifications");
        RestAssured.reset();
    }
}
