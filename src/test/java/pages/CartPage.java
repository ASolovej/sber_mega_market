package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    private ElementsCollection PRODUCTS_TITLE = $$(".good__title");
    @Step("Проверить, что первый добавленный товар содержит в названии: {text}")
    public CartPage checkTitleProductInCart(String text) {
        PRODUCTS_TITLE.first().shouldHave(Condition.text(text), Duration.ofSeconds(8));
        return this;
    }
}
