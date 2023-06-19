package tests.bankManager;

import baseClasses.BankManagerLoginPage;
import baseClasses.CustomerLoginPage;
import baseClasses.HomePage;
import baseTest.AbstractBaseTest;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankManagerAccountTests extends AbstractBaseTest {

    private HomePage homePage;
    private BankManagerLoginPage bankManagerLoginPage;
    private CustomerLoginPage customerLoginPage;
    private Assertions assertions;


    @BeforeMethod
    public void openBankHomePage() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        assertions = new Assertions();
        homePage.open();
    }
    public void regNewCustomerAccount(String firstName, String lastName, String postCode, String nameOfSelectedToEnter, String currency){
        homePage
                .bankManagerLoginButtonClick();
        bankManagerLoginPage
                .addCustomerLoginButtonClick()
                .fillFirstNameField(firstName)
                .fillLastNameField(lastName)
                .fillPostCode(postCode)
                .addCustomerConfirmButtonClick()
                .openAccountButtonClick()
                .selectCustomerFieldClick()
                .selectingCustomerFromList(nameOfSelectedToEnter)
                .selectCurrencyFieldClick()
                .selectingCurrencyFromList(currency)
                .processButtonClick()
                .returnOnHomePageClick();
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
    public void registrationNewCustomerTest1() {
        regNewCustomerAccount("Josh","Browny", "E7777E", "Josh", "Pound" );
        homePage
                .customerLoginBtnClick();
        customerLoginPage
                .clickFieldSelectUserName()
                .selectUserByName("Josh")
                .clickBtnLogin();
        Assert.assertEquals(customerLoginPage.getCurrencyValue().getText(), "Pound" );
    }
        @Test
        public void registrationNewCustomerTest2() {
            regNewCustomerAccount("James", "Browny", "E8888E", "James", "Dollar");
            homePage
                    .customerLoginBtnClick();
            customerLoginPage
                    .clickFieldSelectUserName()
                    .selectUserByName("James")
                    .clickBtnLogin();
            Assert.assertEquals(customerLoginPage.getCurrencyValue().getText(), "Dollar" );
        }
        @Test
        public void registrationNewCustomerTest3(){
            regNewCustomerAccount("Jordan", "Browny", "E9999E", "Jordan", "Rupee");
            homePage
                    .customerLoginBtnClick();
            customerLoginPage
                    .clickFieldSelectUserName()
                    .selectUserByName("Jordan")
                    .clickBtnLogin();
            Assert.assertEquals(customerLoginPage.getCurrencyValue().getText(), "Rupee" );
    }
}
