package tests.bankManager;

import baseClasses.HomePage;
import baseTest.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class BankManagerAccountTests extends AbstractBaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void openBankHomePage() {
        homePage = new HomePage();
        homePage.open();
    }

    @Test
    public void bankManagerAccountButtonTest() {
        homePage.bankManagerLoginButtonClick();
        sleep(3000);
        Assert.assertTrue(url().contains("manager"));
    }
    @Test
    public void homePageButtonTest() {
        homePage.bankManagerLoginButtonClick();
        homePage.homePageButtonClick();
        sleep(3000);
        Assert.assertTrue(url().contains("login"));
    }

}
