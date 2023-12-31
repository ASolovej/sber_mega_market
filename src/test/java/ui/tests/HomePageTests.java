package ui.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.MainPage;

@Tag("UI")
@Feature("Элементы главной страницы")
public class HomePageTests extends BaseTest{

    @Story("Присутствие на главной странице названия логотипа")
    @DisplayName("Проверка присутствия названия логотипа в конце страницы")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void checkExistsLogo() {
        new MainPage()
                .openMainPage()
                .scrollDownToLogo()
                .checkNameLogo();
    }
}
