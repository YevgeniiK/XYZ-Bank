package baseTest;

import org.testng.annotations.BeforeSuite;

public abstract class AbstractBaseTest {

    @BeforeSuite
    public static void setUp() {
        String activeProfile = System.getProperty("activeProfile", "local");
//        DriverFactory.setUpBrowser(activeProfile);
    }
}
