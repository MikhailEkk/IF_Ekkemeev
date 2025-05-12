package ru.iFellow.steps;


import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.iFellow.pages.LoginPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class AuthorizationSteps {

    private LoginPage loginPage = new LoginPage();

    @Дано("Пользователь авторизован с логином {string} и паролем {string}")
    @Когда("Пользователь вводит логин {string} и пароль {string}")
    public void enterCredentials(String login, String password) {
        loginPage.logOn(login, password);
    }

    @Дано("Пользователь находится на странице Dashboard")
    @Тогда("Происходит переход на страницу Dashboard")
    public void verifyDashboardPage() {
        webdriver().shouldHave(urlContaining("Dashboard.jspa"));
    }
}
