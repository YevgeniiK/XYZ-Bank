package baseTest;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static void setUpBrowser(String activeProfile) {
        if (activeProfile.equalsIgnoreCase("local")) {
            Configuration.browser = "chrome";
            Configuration.browserVersion = "102.0";
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            Configuration.browserCapabilities = new MutableCapabilities(chromeOptions);
        } else if (activeProfile.equalsIgnoreCase("remote")) {
            Configuration.remote = "http://localhost:4444/wd/hub";
            Configuration.browser = "chrome";
            Configuration.browserVersion = "102.0";
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            Configuration.browserCapabilities = new MutableCapabilities(chromeOptions);
            Configuration.headless = true;
        }
    }
}
