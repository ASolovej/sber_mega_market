package tests;

import attachment.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
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
        Configuration.browserSize = System.getProperty("size", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "112");
        Configuration.baseUrl = "https://sbermegamarket.ru/";
        Configuration.pageLoadTimeout = 60;

        Configuration.remote = System.getProperty("selenoid", "http://localhost:4444/") + "wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));


        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars",
                "disable-translate", "disable-notifications",
                "disable-popup-blocking", "ignore-certificate-errors");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        Configuration.browserCapabilities = capabilities;
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
