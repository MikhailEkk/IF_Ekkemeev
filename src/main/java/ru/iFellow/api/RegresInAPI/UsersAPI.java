package ru.iFellow.api.RegresInAPI;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import ru.iFellow.dto.RegresIn.User;

import static io.restassured.RestAssured.given;

public class UsersAPI {

    private static final String USER_END_POINT = "/api/users";
    private static final String BASE_URI = "https://reqres.in";
    private static final String API_KEY = "reqres-free-v1";

    public ValidatableResponse postUser(User user) {
        return given()
                .baseUri(BASE_URI)
                .header("x-api-key", API_KEY)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(user)
                .post(USER_END_POINT)
                .then();
    }
}
