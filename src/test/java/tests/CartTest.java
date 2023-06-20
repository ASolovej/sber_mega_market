package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Tag("UI")
@Feature("Проверка корзины")
public class CartTest extends BaseTest{

    @Story("Добавление товара в корзину")
    @DisplayName("Проверка, что товар добавился в корзину")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void checkProductInCart() {
        new MainPage()
                .openMainPage()
                .setTextInSearch("Смартфон")
                .clickButtonSearch()
                .clickBuyProduct()
                .clickButtonGoToCart()
                .checkTitleProductInCart("Смартфон");
    }

}
