package ui.drivers;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.config.WebDriverConfig;

import java.util.Map;

public class WebDriverProvider {
    private WebDriverConfig config;
    public WebDriverProvider() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }
    public void createWebDriver() {
        Configuration.browserSize = config.getSize();
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getVersion();
        Configuration.baseUrl = "https://sbermegamarket.ru/";
        Configuration.pageLoadTimeout = 60000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        if (System.getProperty("env").equals(null)) {
            Configuration.remote = config.getRemote() + "/wd/hub";
        }


        if (Configuration.browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars",
                    "disable-translate", "disable-notifications",
                    "disable-popup-blocking", "ignore-certificate-errors");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }

        Configuration.browserCapabilities = capabilities;
    }
}
