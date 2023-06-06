package tests.customerLogin;

import baseClasses.HomePage;
import baseTest.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CustomerLoginAccountTests extends AbstractBaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void openBankHomePage() {
        homePage = new HomePage();
        homePage.open();
    }
    @Test
    public void customerLoginAccountButtonTest() {
        homePage.customerLoginButtonClick();
        sleep(3000);
        System.out.println(url());
        Assert.assertTrue(url().contains("customer"));
    }
}
