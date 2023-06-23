package tests.bankManager;

import baseClasses.BankManagerLoginPage;
import baseClasses.HomePage;
import baseTest.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankManagerAccountTests extends AbstractBaseTest {

    private HomePage homePage;
    private BankManagerLoginPage bankManagerLoginPage;
    private Assertions assertions;


    @BeforeMethod
    public void openBankHomePage() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        assertions = new Assertions();
        homePage.open();
    }

    @Test
    public void bankManagerAccountButtonTest() {
        homePage.bankManagerLoginButtonClick();
        assertions.assertUrlContains("manager");
    }

    @Test
    public void homePageButtonTest() {
        homePage
                .bankManagerLoginButtonClick()
                .homePageButtonClick();
        assertions.assertUrlContains("login");
    }

    @Test
    public void addCustomerButtonTest() {
        homePage.bankManagerLoginButtonClick();
        bankManagerLoginPage.addCustomerLoginButtonClick();
        assertions.assertUrlContains("addCust");
    }

    @Test
    public void checkTheAccountSearchAndDelete() {
        List<BankManagerLoginPage> customerNames = new ArrayList<>();
        List<String> expectedCustomerNames = Arrays.asList("Ivan", "Ivan", "Ivan", "Ivan");
        String accountNumber = bankManagerLoginPage.getAccountNumber();

        homePage.
                bankManagerLoginButtonClick();
        bankManagerLoginPage
                .addCustomerLoginButtonClick()
                .addNewCustomer("Ivan", "Ivanenko", "E5512")
                .addCurrencyToAccount("Ivan Ivanenko", "Dollar")
                .customersButtonClick()
                .setSearchCustomersInput("Ivan");
        customerNames.add(bankManagerLoginPage.getFirstNameCustomer());

        bankManagerLoginPage
                .setSearchCustomersInput("Ivanenko");
        customerNames.add(bankManagerLoginPage.getFirstNameCustomer());

        bankManagerLoginPage
                .setSearchCustomersInput("E5512");
        customerNames.add(bankManagerLoginPage.getFirstNameCustomer());

        bankManagerLoginPage.
                setSearchCustomersInput(accountNumber);
        customerNames.add(bankManagerLoginPage.getFirstNameCustomer());

        bankManagerLoginPage
                .setSearchCustomersInput("Ivanenko");
        bankManagerLoginPage
                .deleteCustomersButtonClick();



        bankManagerLoginPage.assertPresenceCustomer();
        Assert.assertFalse(customerNames.containsAll(expectedCustomerNames));
    }


}
