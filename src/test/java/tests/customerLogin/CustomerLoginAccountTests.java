package tests.customerLogin;

import baseClasses.CustomerLoginPage;
import baseClasses.HomePage;
import baseTest.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;

public class CustomerLoginAccountTests extends AbstractBaseTest {

    private HomePage homePage;
    private CustomerLoginPage customerLoginPage = new CustomerLoginPage();

    @BeforeMethod
    public void openBankHomePage() {
        homePage = new HomePage();
        homePage.open();
    }

    @Test
    public void checkBtnWithdrawn() {
        homePage
                .customerLoginBtnClick();
        customerLoginPage
                .clickFieldSelectUserName()
                .selectUserName()
                .clickBtnLogin()
                .clickBtnWithdrawn()
                .getBtnTextWithdrawn().shouldHave(text("Withdrawl"));

        Assert.assertEquals(customerLoginPage.getBtnTextWithdrawn().getText(), "Withdrawl");
    }

    @Test
    public void checkBtnTransactions() {
        homePage
                .customerLoginBtnClick();
        customerLoginPage
                .clickFieldSelectUserName()
                .selectUserName()
                .clickBtnLogin()
                .getBtnTextTransactions().shouldHave(text("Transactions"));
        customerLoginPage
                .clickBtnDeposit()
                .enterFieldAmountDeposit("100")
                .clickBtnSubmit()
                .clickBtnWithdrawn()
                .enterFieldAmountWithdrawn("50")
                .clickBtnSubmit()
                .clickBtnTransactions()
                .getDepositAmount().shouldHave(exactText("100"));
        customerLoginPage
                .getTransactionTypeCredit().shouldHave(text("Credit"));
        customerLoginPage
                .getDebitAmount().shouldHave(text("50"));
        customerLoginPage
                .getTransactionTypeDebit().shouldHave(text("Debit"));
    }
}
