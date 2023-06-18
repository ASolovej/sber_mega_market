package pageComponents;

import io.qameta.allure.Step;
import pages.MainPage;
import pages.ResultsSearchPage;

import static com.codeborne.selenide.Selenide.$;

public class Navigation {
    public void setTextSearchString(String text) {
        $("input[type=search]").setValue(text);
    }

    public void clickButtonSearch() {
        $(".header-search-block button[type=submit]").click();
    }
}
