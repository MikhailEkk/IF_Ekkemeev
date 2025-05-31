package ru.iFellow.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import ru.iFellow.config.AppConfig;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.SetValueOptions.withText;

public class LoginPage {
    private static final AppConfig config = ConfigFactory.create(AppConfig.class);

    private final SelenideElement loginField = $x("//*[contains(@id, 'login-form-username')]").as("Поле ввода логина");
    private final SelenideElement passwdField = $x("//*[contains(@id, 'login-form-password')]").as("Поле ввода пароля");
    private final SelenideElement loginBtn = $x("//*[contains(@id, 'login-form-submit')]").as("Кнопка 'Вход'");

    @Step("Ввод логина")
    private void inputLogin() {
        loginField.shouldBe(Condition.visible).sendKeys(config.login());
    }

    @Step("Ввод пароля")
    private void inputPassword() {
        passwdField.shouldBe(Condition.visible).setValue(withText(config.password()).sensitive());
    }

    @Step("Авторизация пользователя")
    public DashboardPage  login() {
        inputLogin();
        inputPassword();
        loginBtn.click();
        return new DashboardPage();
    }
}

