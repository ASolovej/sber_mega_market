package tests;

import attachment.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverProvider;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Map;

@Link(name = "Test", value = "https://sbermegamarket.ru/")
@Owner("Alexandr Solovyov")
public class BaseTest {
    @BeforeAll
    public static void setUp() {
        WebDriverProvider driverProvider = new WebDriverProvider();
        driverProvider.createWebDriver();
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (!Configuration.browser.equals("firefox")) {
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
    }
}
