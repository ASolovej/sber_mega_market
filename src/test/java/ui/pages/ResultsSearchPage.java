package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ui.pageComponents.Navigation;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultsSearchPage {
    private Navigation navigation;
    private ElementsCollection BUTTONS_BUY = $$(".catalog-buy-button .catalog-buy-button__button");
    private SelenideElement BUTTON_GO_TO_CART = $(Selectors.byText("Перейти в корзину"));
    public ResultsSearchPage() {
        navigation = new Navigation();
    }
    @Step("Проверка, что в описании каждого продукта на странице поиска присутствует: {text}")
    public ResultsSearchPage checkEachProductContains(String text) {

        for (SelenideElement element : $$ (".inner .item-title")) {
            element.shouldHave(Condition.text(text));
        }
        return this;
    }

    @Step("Нажать на кнопку 'купить' первого товара")
    public ResultsSearchPage clickBuyProduct() {
        BUTTONS_BUY.first().click();
        return this;
    }

    @Step("Нажать на корзину")
    public CartPage clickButtonGoToCart() {
        BUTTON_GO_TO_CART.click();
        return new CartPage();

    }

}
