package Tests;

import baseClasses.BankManangerLoginPage;
import baseTest.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;


public class testBankManangerLogin extends AbstractBaseTest {

    private BankManangerLoginPage bankManangerLoginPage;

    @BeforeMethod
    public void openBankManangerLoginPage() {
        bankManangerLoginPage = new BankManangerLoginPage();
        bankManangerLoginPage.open();
    }

    @Test()
    public void testBtnDeleteCustomer() {
        openBankManangerLoginPage();
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
}
