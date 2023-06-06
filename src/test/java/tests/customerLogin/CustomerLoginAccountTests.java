package tests.customerLogin;

import baseClasses.HomePage;
import baseTest.AbstractBaseTest;
import org.testng.annotations.BeforeMethod;

public class CustomerLoginAccountTests extends AbstractBaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void openBankHomePage() {
        homePage = new HomePage();
        homePage.open();
    }

}
