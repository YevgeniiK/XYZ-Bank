package tests.customerLogin;

import baseClasses.BankManagerLoginPage;
import baseClasses.CustomerLoginPage;
import baseClasses.HomePage;
import baseTest.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.bankManager.Assertions;

import static com.codeborne.selenide.Condition.text;

public class CustomerLoginAccountTests extends AbstractBaseTest {

    private HomePage homePage;
    private CustomerLoginPage customerLoginPage;
    private BankManagerLoginPage bankManagerLoginPage;
    private Assertions assertions;

    @BeforeMethod
    public void openBankHomePage() {
        homePage = new HomePage();
        customerLoginPage = new CustomerLoginPage();
        bankManagerLoginPage = new BankManagerLoginPage();
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
    public void checkLoginBtnCustomerWithoutAccount() {
        homePage
                .bankManagerLoginButtonClick();
        bankManagerLoginPage
                .addCustomerLoginButtonClick()
                .createNewCustomer();
        homePage
                .open()
                .customerLoginBtnClick();
        customerLoginPage
                .clickFieldSelectUserName()
                .selectUserName()
                .clickBtnLogin()
                .getMsgCreateAccount().shouldHave(text("Please open an account with us."));
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
}
