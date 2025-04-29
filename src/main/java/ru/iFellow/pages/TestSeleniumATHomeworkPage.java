package ru.iFellow.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class TestSeleniumATHomeworkPage {

    private final SelenideElement status = $x("//div[@class='wrap']/strong[@title='Статус']").as("Заголовок 'Статус'");
    private final SelenideElement statusValue = $x("//div[@class='wrap']/span[@id='status-val']/span").as("Значение статуса");
    private final SelenideElement title = $x("//div[@class='wrap']/strong[@title='Исправить в версиях']").as("Заголовок 'Исправить в версиях'");
    private final SelenideElement version = $x("//div[@class='wrap']/span[@id='fixfor-val']/span[@class='shorten']").as("Версия");
}
