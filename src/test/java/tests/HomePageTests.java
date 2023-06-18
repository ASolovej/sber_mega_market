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
@Feature("Элементы главной страницы")
public class HomePageTests extends BaseTest{

    @Story("Присутствие на главной страницы названия логотипа")
    @DisplayName("Проверка очистки строки поиска")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void checkExistsLogo() {
        new MainPage()
                .scrollDownToLogo()
                .checkNameLogo();
    }
}
