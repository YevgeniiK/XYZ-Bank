package tests.bankManager;

import baseClasses.BankManagerLoginPage;
import baseClasses.HomePage;
import baseTest.AbstractBaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        bankManagerLoginPage.addCustomerLoginBtnClick();
        assertions.assertUrlContains("addCust");
    }

    @Test
    public void addNewCustomerTest() {
        homePage.bankManagerLoginButtonClick();
        bankManagerLoginPage
                .addCustomerLoginBtnClick()
                .firstNameFieldFilling()
                .lastNameFieldFilling()
                .postCodeFieldFilling()
                .addCustomerSmallBtnClick()
                .openAccountBtnClick()
                .dropdownCustomerMenuClick()
                .dropdownCurrencyMenuClick(1)
                .processBtnClick()
                .dropdownCustomerMenuClick()
                .dropdownCurrencyMenuClick(2)
                .processBtnClick()
                .dropdownCustomerMenuClick()
                .dropdownCurrencyMenuClick(3)
                .processBtnClick()
                .customersBtnClick()
                .accountNumberCheck("1016")
                .accountNumberCheck("1017")
                .accountNumberCheck("1018");
    }

}
