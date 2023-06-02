package baseTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public abstract class AbstractBaseTest {
    @BeforeClass
    public static void setUp() {
        String activeProfile = System.getProperty("activeProfile", "local");
        if (activeProfile.equalsIgnoreCase("local")) {
            // Set up local WebDriver
            Configuration.browser = "chrome";
            Configuration.browserVersion = "102.0";
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            Configuration.browserCapabilities = new MutableCapabilities(chromeOptions);
        } else if (activeProfile.equalsIgnoreCase("remote")) {
            // Set up remote WebDriver
            Configuration.remote = "http://localhost/:4444/wd/hub/";
            Configuration.browser = "chrome";
            Configuration.browserVersion = "102.0";
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            Configuration.browserCapabilities = new MutableCapabilities(chromeOptions);
        }
        Selenide.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }
}
//mvn test -Plocal
//mvn test -Premote