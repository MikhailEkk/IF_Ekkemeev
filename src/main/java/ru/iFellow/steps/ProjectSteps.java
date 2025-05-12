package ru.iFellow.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.pages.DashboardPage;
import ru.iFellow.pages.ProjectTestPage;

import java.time.Duration;

public class ProjectSteps {

    private DashboardPage dashboardPage = new DashboardPage();
    private final ProjectTestPage projectTestPage = new ProjectTestPage();
    private int initialTaskCount = 0;

    @Когда("пользователь переходит на страницу проекта 'Test'")
    public void userGoToProjectTest() {
        dashboardPage.goToProjectTEST();
    }

    @Тогда("на странице должна быть метка 'Test'")
    public void shouldHaveLabelTest() {
        dashboardPage.isNameProjectVisible();
    }

    @Дано("Запомнили начальное количество задач")
    public void getTotalTasksCountOnProject() {
        initialTaskCount = projectTestPage.getTotalTasksCount();
    }

    @Когда("Создали новую задачу {string}")
    public void createNewTask(String taskName) {
        projectTestPage.createNewTask(taskName);
    }

    @Тогда("Счетчик задач должен увеличиться на 1")
    public void checkingTaskCounter() {
        boolean isUpdated = Selenide.Wait()
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .until(driver -> {
                    projectTestPage.updateTasks();
                    return projectTestPage.getTotalTasksCount() == initialTaskCount + 1;
                });
        int actualCount = projectTestPage.getTotalTasksCount();
        if (!isUpdated) {
            throw new RuntimeException(String.format(
                    "Счетчик задач не обновился за 15 секунд. Ожидалось: %d, Фактическое значение: %d",
                    initialTaskCount + 1,
                    actualCount
            ));
        }
    }

}
