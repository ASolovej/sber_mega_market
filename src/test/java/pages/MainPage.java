package pages;

import io.qameta.allure.Step;
import pageComponents.Navigation;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class MainPage {
    Navigation navigation;
    public MainPage() {
        navigation = new Navigation();
        step("Открыть сайт sbermegamarket.ru",
                () -> {open("https://sbermegamarket.ru/");});
    }

    @Step("Ввести в строку поиска: {text}")
    public MainPage setTextInSearch(String text) {
        navigation.setTextSearchString(text);
        return this;
    }

    @Step("Нажать на кнопку поиска")
    public ResultsSearchPage clickButtonSearch() {
        navigation.clickButtonSearch();
        return new ResultsSearchPage();
    }

    @Step("Очистить строку поиска и проверить, что строка поиска пуста")
    public MainPage clearSearch() {
        navigation.clearSearch();
        navigation.checkExistsButtonClear();
        return this;
    }

}
