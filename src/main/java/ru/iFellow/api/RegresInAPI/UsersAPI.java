package ru.iFellow.api.RegresInAPI;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import ru.iFellow.dto.RegresIn.User;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UsersAPI {

    private static final ResourceBundle PROPS = ResourceBundle.getBundle("config");

    private static final String USER_END_POINT = PROPS.getString("user.endpoint");
    private static final String BASE_URI = PROPS.getString("base.url.regres.in");
    private static final String API_KEY_VALUE = PROPS.getString("api.key.value.regres.in");
    private static final String API_KEY = PROPS.getString("api.key.regres.in");

    public ValidatableResponse postUser(User user) {
        return given()
                .baseUri(BASE_URI)
                .header(API_KEY, API_KEY_VALUE)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(user)
                .post(USER_END_POINT)
                .then();
    }
}
