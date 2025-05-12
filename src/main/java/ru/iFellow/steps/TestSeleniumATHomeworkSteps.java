package ru.iFellow.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.pages.ProjectTestPage;
import ru.iFellow.pages.TestSeleniumATHomeworkPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class TestSeleniumATHomeworkSteps {
    private final TestSeleniumATHomeworkPage taskPage = new TestSeleniumATHomeworkPage();
    private final ProjectTestPage projectTestPage = new ProjectTestPage();

    @Когда("Пользователь ищет задачу {string}")
    public void searchTask(String taskName) {
        projectTestPage.search(taskName);
    }

    @Тогда("Статус задачи должен быть {string}")
    public void verifyTaskStatus(String expectedStatus) {
        taskPage.getStatus()
                .shouldBe(visible, Duration.ofSeconds(25))
                .shouldHave(exactText("Статус:"));
        taskPage.getStatusValue().shouldBe(visible, Duration.ofSeconds(25))
                .shouldHave(exactText(expectedStatus));
    }

    @Тогда("Версия задачи должна быть {string}")
    public void verifyTaskVersion(String expectedVersion) {
        taskPage.getTitle()
                .shouldBe(visible, Duration.ofSeconds(25))
                .shouldHave(text("Исправить в версиях:"));
        taskPage.getVersion()
                .shouldBe(visible, Duration.ofSeconds(25))
                .shouldHave(text(expectedVersion));
    }

    @Когда("Пользователь создает новый баг {string}")
    public void createNewBug(String bugName) {
        projectTestPage.createNewTask2(bugName);
    }

    @Когда("Переводит задачу в статус {string}")
    public void completeTask(String status) {
        projectTestPage.completeTask();
        taskPage.getStatusValue().shouldHave(exactText(status), Duration.ofSeconds(25));
    }

    @Тогда("Статус задачи должен измениться на {string}")
    public void verifyFinalStatus(String expectedStatus) {
        taskPage.getStatus()
                .shouldBe(visible, Duration.ofSeconds(25))
                .shouldHave(exactText("Статус:"));
        taskPage.getStatusValue().shouldBe(visible, Duration.ofSeconds(25))
                .shouldHave(exactText(expectedStatus));
    }
}
