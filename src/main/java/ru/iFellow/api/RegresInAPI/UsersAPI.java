package ru.iFellow.api.RegresInAPI;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.iFellow.dto.RegresIn.User;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UsersAPI {

    private static final ResourceBundle PROPS = ResourceBundle.getBundle("config");

    private static final String USER_END_POINT = PROPS.getString("user.endpoint");

    @Step("Отправить POST запрос на создание пользователя")
    public ValidatableResponse postUser(User user) {
        return given()
                .when()
                .body(user)
                .post(USER_END_POINT)
                .then();
    }
}
