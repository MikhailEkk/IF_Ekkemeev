package ru.iFellow;

import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.steps.UserSteps;

public class UserTests {

    private static final UserSteps userSteps = new UserSteps();

    @Test
    @DisplayName("Проверить валидность данных ответа при создании пользователя")
    public void checkNameAndJobAfterCreateUser() {
        JsonPath body = userSteps.createNewUserFromFile();
        Assertions.assertEquals("Tomato", body.get("name"));
        Assertions.assertEquals("Eat maket", body.get("job"));
    }
}
