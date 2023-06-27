package tests.customerLogin;

import baseClasses.BankManagerLoginPage;
import baseClasses.CustomerLoginPage;
import baseClasses.HomePage;
import baseTest.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.bankManager.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;

public class CustomerLoginAccountTests extends AbstractBaseTest {

    private HomePage homePage;
    private CustomerLoginPage customerLoginPage;
    private Assertions assertions;
    private BankManagerLoginPage bankManagerLoginPage;

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
    public void selectedCustomerAccountTest(){
        homePage
                .customerLoginBtnClick();
        customerLoginPage
                .clickFieldSelectUserName()
                .selectUserName()
                .getBtnLogin()
                .clickBtnLogin();
        assertions.assertUrlContains("account");
    }

    @Test
    public void check_the_deposit_not_successful(){

        List<CustomerLoginPage> arrayMassage = new ArrayList<>();
        List<String> arrayMassageTest = Arrays.asList("element not found", "element not found");

        bankManagerLoginPage
                .addCustomerLoginButtonClick()
                .addNewCustomer("Ivan", "Ivanenko", "E5512")
                .addCurrencyToAccount("Ivan Ivanenko", "Dollar")
                .clickGoHomePage();
        homePage
                .customerLoginBtnClick();
        customerLoginPage
                .selectAccount("Ivan Ivanenko")
                .clickBtnLogin()
                .clickButtonDeposit()
                .setValueDeposit("0")
                .clickSendDeposit();
        arrayMassage.add(customerLoginPage.getMassageDeposit());

        customerLoginPage
                .setValueDeposit("-5")
                .clickSendDeposit();
        arrayMassage.add(customerLoginPage.getMassageDeposit());

        Assert.assertFalse(arrayMassageTest.containsAll(arrayMassage));

    }

}
