package tests.customerLogin;

import baseClasses.CustomerLoginPage;
import baseClasses.HomePage;
import baseTest.AbstractBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerLoginAccountTests extends AbstractBaseTest {

    private HomePage homePage;
    private CustomerLoginPage customerLoginPage;
    @BeforeMethod
    public void openBankHomePage() {
        homePage = new HomePage();
        homePage.open();
    }

    @Test
    public void customerLoginAccountButtonTest() {
            homePage
                    .customerLoginBtnClick();

    }
}

