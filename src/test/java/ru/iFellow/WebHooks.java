package ru.iFellow;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import ru.iFellow.config.AppConfig;

public class WebHooks {
    private static final AppConfig config = ConfigFactory.create(AppConfig.class);

    @BeforeEach
    public void initBrowser() {

        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.pageLoadTimeout = config.pageLoadTimeout();
        Selenide.open(config.baseUrl() + config.endPointLogin());

        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void afterTest() {
        Selenide.closeWebDriver();
    }

    @BeforeAll
    public static void setUpAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().
                screenshots(true).
                savePageSource(false)
        );
    }
}
