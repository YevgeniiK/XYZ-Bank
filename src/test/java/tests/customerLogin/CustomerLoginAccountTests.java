package tests.customerLogin;

import baseClasses.CustomerLoginPage;
import baseClasses.HomePage;
import baseTest.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.bankManager.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class CustomerLoginAccountTests extends AbstractBaseTest {

    private HomePage homePage;
    private CustomerLoginPage customerLoginPage;
    private Assertions assertions;

    @BeforeMethod
    public void openBankHomePage() {
        homePage = new HomePage();
        customerLoginPage = new CustomerLoginPage();
        assertions = new Assertions();
        homePage.open();
    }

    @Test
    public void customerLoginAccountButtonTest() {
        homePage
                .customerLoginBtnClick();
        assertions.assertUrlContains("customer");
    }
    @Test
    public void checkBtnWithdrown() {
        homePage
                .customerLoginBtnClick();
        customerLoginPage
                .clickFieldSelectUserName()
                .selectUserName()
                .clickBtnLogin()
                .clickBtnWithdrawn()
                .getBtnTextWithdawn().shouldHave(text("Withdrawl"));

        Assert.assertEquals(customerLoginPage.getBtnTextWithdawn().getText(), "Withdrawl");
    }

    @Test
    public void depositAndWithdrawlTest(){
        customerLoginPage
                .loginCustomerMethod("Harry")
                .depositMethod(100);
        Assert.assertEquals(customerLoginPage.getBalanceValue().getText(), "100");
        customerLoginPage
                .withdrawlMethod(90);
        Assert.assertEquals(customerLoginPage.getBalanceValue().getText(), "10");
    }
}
