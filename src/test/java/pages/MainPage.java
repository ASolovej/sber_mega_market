package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageComponents.Navigation;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class MainPage {
    private Navigation navigation;
    private static final SelenideElement LOGOTIP = $(".copyright-block__logo");
    public MainPage() {
        navigation = new Navigation();
    }

    @Step("Открыть сайт https://sbermegamarket.ru/")
    public MainPage openMainPage() {
        open("https://sbermegamarket.ru/");
        return this;
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

    @Step("Проверика, логотип имеет название 'СберМегаМаркет'")
    public MainPage checkNameLogo() {
        LOGOTIP.shouldHave(Condition.attribute("alt", "СберМегаМаркет"));
        return this;
    }

    @Step("Прокрутка страницы вниз до логотипа")
    public MainPage scrollDownToLogo() {
        LOGOTIP.scrollTo();
        return this;
    }

}
