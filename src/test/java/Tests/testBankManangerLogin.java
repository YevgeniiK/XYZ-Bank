package Tests;

import baseClasses.BankManangerLoginPage;
import baseTest.AbstractBaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;


public class testBankManangerLogin extends AbstractBaseTest {

    private BankManangerLoginPage bankManangerLoginPage;

    @BeforeMethod
    public void openBankManangerLoginPage() {
        bankManangerLoginPage = new BankManangerLoginPage();
        bankManangerLoginPage.open();
    }

    @Test
    public void testBtnDeleteCustomer() {
        bankManangerLoginPage
                .clickBtnCustomers()
                .tableCustomerIsDisplay();
        int customerSizeBefore = bankManangerLoginPage.sizeListCustomer();
        bankManangerLoginPage
                .createNewCustomer()
                .clickBtnCustomers()
                .listCustomers().shouldHave(size(customerSizeBefore + 3));
        Assert.assertTrue(bankManangerLoginPage.newCustomerIsVisibleInTable());
        bankManangerLoginPage
                .searchNewCustomerInSearchField();
        Assert.assertTrue(bankManangerLoginPage.newCustomerIsVisibleInTable());
        bankManangerLoginPage
                .listCustomers().shouldHave(size(3));
        bankManangerLoginPage
                .clearFieldSearchNewCustomer()
                .clickBtnDeleteCustomer()
                .listCustomers().shouldHave(size(customerSizeBefore));
        bankManangerLoginPage
                .searchNewCustomerInSearchField()
                .listCustomers().shouldHave(size(0));
        Assert.assertFalse(bankManangerLoginPage.newCustomerIsVisibleInTable());
    }

    @Test
    public void testScrollDownTableCustomers() {
        bankManangerLoginPage
                .createNewCustomer()
                .clickBtnCustomers();
        Assert.assertFalse(bankManangerLoginPage.listCustomers().last().isDisplayed());
        bankManangerLoginPage
                .moveCursorToFirstCustomer()
                .scrollToLastCustomer();
        Assert.assertTrue(bankManangerLoginPage.listCustomers().last().isDisplayed());
    }

    @Test
    public void testCreateNewCustomerWithoutFillingAllFields() {
        bankManangerLoginPage
                .enterFirstNameAndLastNameNewCustomer();
        Assert.assertFalse(bankManangerLoginPage.newCustomerIsVisibleInTable());
        bankManangerLoginPage
                .enterFirstNameAndPostCodeNewCustomer();
        Assert.assertFalse(bankManangerLoginPage.newCustomerIsVisibleInTable());
        bankManangerLoginPage
                .enterLastNameAndPostCodeNewCustomer();
        Assert.assertFalse(bankManangerLoginPage.newCustomerIsVisibleInTable());
    }

    @Test
    public void testChanceCreateDuplicateNewCustomer() {
        bankManangerLoginPage
                .clickBtnCustomers()
                .tableCustomerIsDisplay();
        int customerSizeBefore = bankManangerLoginPage.sizeListCustomer();
        bankManangerLoginPage
                .createNewCustomer()
                .clickBtnCustomers()
                .listCustomers().shouldHave(size(customerSizeBefore + 3));
        Assert.assertTrue(bankManangerLoginPage.newCustomerIsVisibleInTable());
        bankManangerLoginPage
                .createNewCustomer();
        Assert.assertTrue(bankManangerLoginPage.switchToAlert());
        Assert.assertEquals(bankManangerLoginPage.getTextToAlert(), "Please check the details. Customer may be duplicate.");
        bankManangerLoginPage
                .acceptAlert()
                .clickBtnCustomers()
                .listCustomers().shouldHave(size(customerSizeBefore + 3));
    }

    @Test
    public void testCheckNotSelectingAllCriteriaOpenAccount() {
        bankManangerLoginPage
                .clickBtnCustomers()
                .tableCustomerIsDisplay();
        int accountNumberBefore = bankManangerLoginPage.sizeListAccountNumber();
        bankManangerLoginPage
                .createNewCustomer()
                .clickBtnCustomers()
                .listAccountNumber().shouldHave(size(accountNumberBefore));
        bankManangerLoginPage
                .clickBtnOpenAccount()
                .clickFieldSelectCurrency().selectCurrencyDollar()
                .clickBtnProcess()
                .clickBtnCustomers()
                .listAccountNumber().shouldHave(size(accountNumberBefore));
        bankManangerLoginPage
                .clickBtnOpenAccount()
                .clickFieldSelectCustomerName()
                .selectCustomerFirstName()
                .clickBtnProcess()
                .clickBtnCustomers()
                .listAccountNumber().shouldHave(size(accountNumberBefore));
    }

}




