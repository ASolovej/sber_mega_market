package ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.MainPage;

@Tag("UI")
@Feature("Поиск товара")
public class SearchTests extends BaseTest {

    @Story("Проверка поиска товара")
    @DisplayName("Проверка работы поиска")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void checkResultsSearch() {
        new MainPage()
                .openMainPage()
                .setTextInSearch("Сахар")
                .clickButtonSearch()
                .checkEachProductContains("Сахар");
    }

    @Story("Очистка строки поиска")
    @DisplayName("Проверка очистки строки поиска")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void checkClearStringSearch() {
        new MainPage()
                .openMainPage()
                .setTextInSearch("Сахар")
                .clearSearch();
    }

}
