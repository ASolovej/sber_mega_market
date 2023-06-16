package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class ResultsSearchPage {
    @Step("Проверка, что в описании каждого продукта на странице поиска присутствует {text}")
    public ResultsSearchPage checkEachProductContains(String text) {

        for (SelenideElement element : $$ (".inner .item-title")) {
            element.shouldHave(Condition.text(text));
        }
        return this;
    }
}
