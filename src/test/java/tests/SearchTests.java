package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Tag("UI")
@Link(name = "Test", value = "https://sbermegamarket.ru/")
@Feature("Поиск товара")
@Owner("Alexandr Solovyov")
public class SearchTests extends BaseTest {

    @Story("Проверка поиска товара")
    @DisplayName("Проверка работы поиска")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void checkResultsSearch() {
        new MainPage()
                .setTextInSearch("Сахар")
                .clickButtonSearch()
                .checkEachProductContains("Сахар");
    }

    @Story("Проверка поиска товара")
    @DisplayName("Проверка работы поиска")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void checkAddProductToCart() {
        new MainPage()
                .setTextInSearch("Сахар")
                .clickButtonSearch();
    }

}
