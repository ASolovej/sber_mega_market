package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class MainPage {

    public MainPage() {
        step("Открытю сайт sbermegamarket.ru",
                () -> {open("https://sbermegamarket.ru/");});
    }

    @Step("Ввести в строку поиска: {text}")
    public MainPage setTextSearchString(String text) {
        $("input[type=search]").setValue(text);
        return this;
    }

    @Step("Нажать на кнопку поиска")
    public void clickButtonSearch() {
        $(".header-search-block button[type=submit]").click();
    }
}
