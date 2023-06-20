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
        bankManagerLoginPage
                .regNewCustomerAccountMethod("Josh","Browny", "E7777E")
                .chooseCurrencyMethod( "Josh", "Pound" );
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
        bankManagerLoginPage
                .regNewCustomerAccountMethod("James", "Browny", "E8888E")
                .chooseCurrencyMethod("James", "Dollar");
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
        bankManagerLoginPage
                .regNewCustomerAccountMethod("Jordan", "Browny", "E9999E")
                .chooseCurrencyMethod("Jordan", "Rupee");
            homePage
                    .customerLoginBtnClick();
            customerLoginPage
                    .clickFieldSelectUserName()
                    .selectUserByName("Jordan")
                    .clickBtnLogin();
            Assert.assertEquals(customerLoginPage.getCurrencyValue().getText(), "Rupee" );
    }
}
