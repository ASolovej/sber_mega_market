package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Tag("UI")
public class SearchTests extends BaseTest {

    @Feature("Поиск товара")
    @Story("Проверка поиска товара")
    @DisplayName("Проверка работы поиска")
    @Owner("Alexandr Solovyov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "Test", value = "https://sbermegamarket.ru/")
    @Test
    public void checkSearchResults() {
        new MainPage()
                .setTextSearchString("Сахар")
                .clickButtonSearch()
                .checkEachProductContains("Сахар");
    }
}
