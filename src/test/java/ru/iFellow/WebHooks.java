//package ru.iFellow;
//
//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.Selenide;
//import com.codeborne.selenide.WebDriverRunner;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.PageLoadStrategy;
//
//public class WebHooks {
//
//    @Before
//    public void initBrowser() {
//
//        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
//        Configuration.pageLoadTimeout = 15000;
//        Selenide.open("https://edujira.ifellow.ru/login.jsp");
//
//        WebDriverRunner.getWebDriver().manage().window().maximize();
//    }
//
//    @After
//    public void afterTest() {
//        Selenide.closeWebDriver();
//    }
//}
