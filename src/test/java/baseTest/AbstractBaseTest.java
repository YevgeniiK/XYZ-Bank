package baseTest;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;

public abstract class AbstractBaseTest {

    @BeforeClass
    public static void setUp() {
        String activeProfile = System.getProperty("activeProfile", "local");
        DriverFactory.setUpBrowser(activeProfile);
        Selenide.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }
}
