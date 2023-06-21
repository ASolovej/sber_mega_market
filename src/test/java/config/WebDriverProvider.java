package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProvider {
    public static void createWebDriver() {
        Configuration.browserSize = System.getProperty("size", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("version", "112");
        Configuration.baseUrl = "https://sbermegamarket.ru/";
        Configuration.pageLoadTimeout = 60000;

        Configuration.remote = System.getProperty("selenoid", "http://localhost:4444/") + "wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        if (WebDriverRunner.getWebDriver() instanceof FirefoxDriver) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars",
                    "disable-translate", "disable-notifications",
                    "disable-popup-blocking", "ignore-certificate-errors");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }

        if (WebDriverRunner.getWebDriver() instanceof ChromeDriver) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("disable-infobars",
                    "disable-translate", "disable-notifications",
                    "disable-popup-blocking", "ignore-certificate-errors");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }

        Configuration.browserCapabilities = capabilities;
    }
}
