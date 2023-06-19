package pageComponents;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.MainPage;
import pages.ResultsSearchPage;

import static com.codeborne.selenide.Selenide.$;

public class Navigation {
    private static final SelenideElement BUTTON_CLEAR = $(".header-search-form__cancel-button");
    private static final SelenideElement SEARCH = $("input[type=search]");
    private static final SelenideElement BUTTON_SEARCH = $(".header-search-block button[type=submit]");
    public void setTextSearchString(String text) {
        SEARCH.click();
        SEARCH.setValue(text).shouldHave(Condition.value(text));
    }

    public void clickButtonSearch() {
        BUTTON_SEARCH.click();
    }

    public void clearSearch() {
        BUTTON_CLEAR.click();
    }

    public void checkExistsButtonClear() {
        BUTTON_CLEAR.shouldNotHave(Condition.exist);
    }
}
