package ru.iFellow.steps;

import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import ru.iFellow.api.RegresInAPI.UsersAPI;
import ru.iFellow.dto.RegresIn.User;
import ru.iFellow.utils.MapperUtils;

public class UserSteps {

    private static final UsersAPI usersApi = new UsersAPI();

    public JsonPath createNewUserFromFile() {
        User user = MapperUtils.readFromFile("src/test/resources/user.json", User.class);
        user.setName("Tomato");
        user.setJob("Eat maket");
        return usersApi.postUser(user)
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .body()
                .jsonPath();
    }
}
