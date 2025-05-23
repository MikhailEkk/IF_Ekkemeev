package ru.iFellow.steps;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import ru.iFellow.api.RegresInAPI.UsersAPI;
import ru.iFellow.dto.RegresIn.User;
import ru.iFellow.utils.MapperUtils;

import java.util.ResourceBundle;

public class UserSteps {

    private static final ResourceBundle PROPS = ResourceBundle.getBundle("config");
    private static final String USER_JSON_PATH = PROPS.getString("user.json.path");
    private static final String USER_NAME = PROPS.getString("user.name");
    private static final String USER_JOB = PROPS.getString("user.job");

    private static final UsersAPI usersApi = new UsersAPI();

    public JsonPath createNewUserFromFile() {
        User user = MapperUtils.readFromFile(USER_JSON_PATH, User.class);
        user.setName(USER_NAME);
        user.setJob(USER_JOB);
        return usersApi.postUser(user)
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .body()
                .jsonPath();
    }
}
