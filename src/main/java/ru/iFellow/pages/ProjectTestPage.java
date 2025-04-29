package ru.iFellow.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProjectTestPage {

    private final SelenideElement createTaskBtn = $x("//a[@id='create_link']").as("Кнопка создания задачи");

    private final SelenideElement taskCounter = $x("//div[@class='showing']").as("Номер задачи из всего количества");

    private final SelenideElement inputFieldSubject = $x("//input[@class='text long-field']").as("Поле ввода темы");

    private final SelenideElement submitTaskCreationForm = $x("//input[@name='Edit']").as("Кнопка 'Создать' на форме создания задачи");

    private final SelenideElement updateBtn = $x("//span[@class='aui-icon aui-icon-small aui-iconfont-refresh-small']");

    private final SelenideElement searchInput = $x("//input[@id='quickSearchInput']").as("Строка поиска");

    private final SelenideElement frame1 = $x("//label[@for='description']/following-sibling::div//iframe[@class='tox-edit-area__iframe']");

    private final SelenideElement visualModeBtns1 = $x("//div[@field-id='description']//button[contains(text(),'Визуальный')]");

    private final SelenideElement visualModeBtns2 = $x("//div[@field-id='environment']//button[contains(text(),'Визуальный')]");

    private final ElementsCollection versions = $$x("//option[@value='10001' and contains(text(),'Version 2.0')]");

    private final SelenideElement inputTags = $x("//div/textarea[@id='labels-textarea']");

    private final SelenideElement frame2 = $x("//label[@for='environment']/following-sibling::div//iframe[@class='tox-edit-area__iframe']");

    private final SelenideElement seriousness = $x("//select[@class='select cf-select']").as("Выбор серьезности");

    private final SelenideElement s1Minor = $x("//option[@value='10102']");

    private final SelenideElement comboboxEpic = $x("//div[@class='field-group aui-field-labelpicker']//input[@role='combobox']");

    private final SelenideElement comboboxSprint = $x("//label[contains(text(),'Спринт')]/following-sibling::div//input[@role='combobox']");

    private final SelenideElement comboboxTask = $x("//div[@id='issuelinks-issues-multi-select']//textarea");

    private final SelenideElement inWorkBtn = $x("//a[@id='action_id_21']");

    private final SelenideElement tasks = $x("//a[@id='find_link']");

    private final SelenideElement reportedByMeTabs = $x("//li[@id='filter_lnk_reported']");

    private final SelenideElement bisinessProcess = $x("//div[@class='command-bar']/descendant::span[contains(text(), 'Бизнес-процесс')]/parent::a");

    private final SelenideElement completedBtn = $x("//div[@class='aui-dropdown2-item-group']//span[contains(text(), 'Выполнено')]/parent::a");

    private final SelenideElement fulfilledBtn = $x("//div[@class='aui-dropdown2-item-group']//span[contains(text(), 'Исполнено')]/parent::a");

    private final SelenideElement fulfilledBtnInForm = $x("//input[@id='issue-workflow-transition-submit']");

    public int getTotalTasksCount() {
        String totalCount = taskCounter.getText();
        return Integer.parseInt(totalCount.split("из")[1].trim());
    }

    public void createNewTask(String taskTopic) {
        createTaskBtn.shouldBe(visible).click();
        inputFieldSubject.shouldBe(visible).setValue(taskTopic);
        submitTaskCreationForm.shouldBe(visible).click();
    }

    public void createNewTask2(String taskTopic) {
        createTaskBtn.shouldBe(visible).click();
        inputFieldSubject.shouldBe(visible).setValue(taskTopic);

        visualModeBtns1.shouldBe(visible).click();

        switchTo().frame(frame1);

        $x("//body[@id='tinymce']").shouldBe(visible).setValue("123");

        switchTo().defaultContent();

        versions.forEach(SelenideElement::click);

        visualModeBtns2.shouldBe(visible).click();

        inputTags.scrollTo().setValue("qwerty");

        switchTo().frame(frame2);

        $x("//body[@id='tinymce']").shouldBe(visible).setValue("123q");

        switchTo().defaultContent();

        comboboxEpic.click();
        comboboxEpic.sendKeys(Keys.DOWN, Keys.ENTER);

        comboboxTask.setValue("TEST-181896").sendKeys(Keys.DOWN, Keys.ENTER);

        comboboxSprint.click();
        comboboxSprint.sendKeys(Keys.DOWN, Keys.ENTER);

        seriousness.click();
        s1Minor.shouldBe(visible).click();
        submitTaskCreationForm.shouldBe(visible).click();
    }

    public void completeTask() {
        tasks.click();
        reportedByMeTabs.shouldBe(visible).click();
        inWorkBtn.click();
        fulfilledBtn.should(exist, Duration.ofSeconds(15));
        bisinessProcess.shouldBe(visible, Duration.ofSeconds(15)).click();
        fulfilledBtn.should(appear, Duration.ofSeconds(15))
                .shouldBe(interactable)
                .click();
        fulfilledBtnInForm.shouldBe(visible, Duration.ofSeconds(15))
                .click();
        completedBtn.should(exist, Duration.ofSeconds(15));
        bisinessProcess.shouldBe(visible, Duration.ofSeconds(15))
                .click();
        completedBtn.should(appear, Duration.ofSeconds(15))
                .shouldBe(interactable)
                .click();
    }

    public void updateTasks() {
        updateBtn.click();
    }

    public void search(String searchRequest) {
        searchInput.shouldBe(visible).setValue(searchRequest).pressEnter();
    }
}
