package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement loginField = $x("//*[contains(@id, 'login-form-username')]").as("Поле ввода логина");

    private final SelenideElement passwdField = $x("//*[contains(@id, 'login-form-password')]").as("Поле ввода пароля");

    private final SelenideElement loginBtn = $x("//*[contains(@id, 'login-form-submit')]").as("Кнопка Вход");

    public void inputLogin(String login) {
        loginField.shouldBe(Condition.visible).sendKeys(login);
    }

    public void inputPassword(String passwd) {
        passwdField.shouldBe(Condition.visible).sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void logOn(String login, String passwd) {
        inputLogin(login);
        inputPassword(passwd);
        clickLoginBtn();
    }

}

