package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement loginField = $x("//*[contains(@id, 'login-form-username')]").as("Поле ввода логина");
    private final SelenideElement passwdField = $x("//*[contains(@id, 'login-form-password')]").as("Поле ввода пароля");
    private final SelenideElement loginBtn = $x("//*[contains(@id, 'login-form-submit')]").as("Кнопка Вход");

    @Step("Ввод логина {login}")
    private void inputLogin(String login) {
        loginField.shouldBe(Condition.visible).sendKeys(login);
    }

    @Step("Ввод пароля {passwd}")
    private void inputPassword(String passwd) {
        passwdField.shouldBe(Condition.visible).sendKeys(passwd);
    }

    @Step("Нажатие на кнопку 'Вход'")
    private void clickLoginBtn() {
        loginBtn.click();
    }

    @Step("Авторизация пользователя с логином {login}")
    public void logOn(String login, String passwd) {
        inputLogin(login);
        inputPassword(passwd);
        clickLoginBtn();
    }

}

