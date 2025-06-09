package ru.iFellow.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import ru.iFellow.api.RegresInAPI.UsersAPI;
import ru.iFellow.dto.RegresIn.User;
import ru.iFellow.utils.MapperUtils;

import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Пользователи")
@Feature("Создание")
public class UserSteps {

    private static final ResourceBundle PROPS = ResourceBundle.getBundle("config");
    private static final String USER_JSON_PATH = PROPS.getString("user.json.path");
    private static final String USER_NAME = PROPS.getString("user.name");
    private static final String USER_JOB = PROPS.getString("user.job");

    private static final UsersAPI usersApi = new UsersAPI();

    private User user;
    private JsonPath response;

    @Дано("Получены данные о пользователе из файла JSON")
    @Step("Чтение пользователя из JSON")
    public void getUserDataFromJSON() {
        user = MapperUtils.readFromFile(USER_JSON_PATH, User.class);
    }

    @Когда("Устанавливаем имя {string} пользователю")
    @Step("Устанавливаем имя: {name}")
    public void setUserName(String name) {
        user.setName(USER_NAME);
    }

    @Когда("Устанавливаем место работы {string} пользователю")
    @Step("Устанавливаем место работы: {job}")
    public void setUserJob(String job) {
        user.setJob(job);
    }

    @Когда("Создаем нового пользователя")
    @Step("Отправка POST-запроса на создание пользователя")
    public void createNewUser() {
        response = usersApi.postUser(user)
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .body()
                .jsonPath();
    }

    @Тогда("Ответ должен вернуть пользователя с именем: {string} и местом работы: {string}")
    @Step("Проверка, что имя = {expectedName}, место работы = {expectedJob}")
    public void checkUserNameAndJob(String expectedName, String expectedJob) {
        String actualName = response.getString("name");
        String actualJob = response.getString("job");

        assertEquals(expectedName, actualName, "Имя пользователя не совпадает");
        assertEquals(expectedJob, actualJob, "Место работы пользователя не совпадает");
    }
}
