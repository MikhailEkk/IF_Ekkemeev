package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    private final SelenideElement projectsTab = $x("//a[@id='browse_link']").as("Вкладка Проекты");

    private final SelenideElement projectTestTab = $x("//li[@id='admin_main_proj_link']").as("Вкладка проекта Test");

    private final SelenideElement navTasks = $x("//li[@class='aui-nav-selected']/a[@class='aui-nav-item ']");

    public void goToProjectTEST() {
        projectsTab.shouldBe(Condition.visible).click();
        projectTestTab.shouldBe(Condition.visible).click();
        navTasks.shouldBe(Condition.visible).click();
        $x("//a[@id='project-name-val']").should(exist, Duration.ofSeconds(2000));
    }
}
