package ru.iFellow;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import ru.iFellow.pages.DashboardPage;
import ru.iFellow.pages.LoginPage;
import ru.iFellow.pages.ProjectTestPage;
import ru.iFellow.pages.TestSeleniumATHomeworkPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EduJiraTest extends WebHooks {

    private final LoginPage loginPage = new LoginPage();

    private final DashboardPage dashboardPage = new DashboardPage();

    private final ProjectTestPage projectTestPage = new ProjectTestPage();

    private final TestSeleniumATHomeworkPage seleniumATHomeworkPage = new TestSeleniumATHomeworkPage();

    @Test
    public void successfulLoginTest() {
        String login = "AT9";
        String password = "Qwerty123";

        loginPage.logOn(login, password);

        String currentUrl = WebDriverRunner.url();
        assertTrue(currentUrl.contains("Dashboard.jspa"),
                "Текущий URL не соответствует странице после входа");
    }

    @Test
    public void goToProjectTest() {
        successfulLoginTest();
        dashboardPage.goToProjectTEST();
        boolean isLabelPresent = $x("//a[@id='project-name-val']").exists();
        assertTrue(isLabelPresent, "Страница с проектом TEST не открыта. (Метка 'Test' не найдена)");
    }

    @Test
    public void taskCounterTest() {
        goToProjectTest();

        int initialCount = projectTestPage.getTotalTasksCount();
        projectTestPage.createNewTask("MyTask_Ekk");

        boolean isUpdated = Selenide.Wait()
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .until(driver -> {
                    projectTestPage.updateTasks();
                    return projectTestPage.getTotalTasksCount() == initialCount + 1;
                });
        int actualCount = projectTestPage.getTotalTasksCount();
        assert isUpdated : String.format(
                "Счетчик задач не обновился за 15 секунд. Ожидалось: %d, Фактическое значение: %d",
                initialCount + 1,
                actualCount
        );
    }

    @Test
    public void checkTestSeleniumATHomeworkTest() {
        taskCounterTest();
        projectTestPage.search("TestSeleniumATHomework");

        String statusText = seleniumATHomeworkPage.getStatus().getText();
        String status = seleniumATHomeworkPage.getStatusValue().getText();
        assertEquals("Статус: СДЕЛАТЬ", statusText + ' ' + status);

        String title = seleniumATHomeworkPage.getTitle().getText();
        String version = seleniumATHomeworkPage.getVersion().getText();
        assertEquals("Исправить в версиях: Version 2.0", title + ' ' + version);
    }

    @Test
    public void createNewBugTestAndComplete() {
        checkTestSeleniumATHomeworkTest();
        projectTestPage.createNewTask2("MyTestFinal");
        projectTestPage.completeTask();

        seleniumATHomeworkPage.getStatusValue().shouldHave(exactText("ГОТОВО"), Duration.ofSeconds(10));

        String statusText = seleniumATHomeworkPage.getStatus().getText();
        String status = seleniumATHomeworkPage.getStatusValue().getText();

        assertEquals("Статус: ГОТОВО", statusText + ' ' + status);
    }
}
