package baseClasses;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CustomerLoginPage extends AbstractBasePage {

    private static SelenideElement fieldUserSelect = $x("//select[@name='userSelect']");
    private static SelenideElement selectUser = $x("//option[@value='3']");
    private static SelenideElement btnLogin = $x("//button[@type='submit']");
    private static SelenideElement btnWithdrawl = $x("//button[@ng-class='btnClass3']");
    private static SelenideElement btnTransactions = $x("//button[@ng-class='btnClass1']");
    private static SelenideElement btnDeposit = $x("//button[@ng-class='btnClass2']");
    private static SelenideElement fieldAmount = $x("//input[@type='number']");
    private static SelenideElement transactionTypeCredit = $x("//tr[@id='anchor0']//td[@* and .='Credit']");
    private static SelenideElement transactionTypeDebit = $x("//tr[@id='anchor1']//td[@* and .='Debit']");
    private static SelenideElement depositAmount = $x("//tr[@id='anchor0']//td[@* and .='100']");
    private static SelenideElement debitAmount = $x("//tr[@id='anchor1']//td[@* and .='50']");
    private static SelenideElement btnSubmit = $x("//button[@type='submit']");

    public CustomerLoginPage clickFieldSelectUserName() {
        logger.info("Click on the field to select Username");
        fieldUserSelect.pressEnter();
        return this;
    }

    public CustomerLoginPage selectUserName() {
        logger.info("Select UserName");
        selectUser.click();
        return this;
    }

    public CustomerLoginPage clickBtnLogin() {
        logger.info("Click button Login");
        btnLogin.click();
        return this;
    }

    public SelenideElement getBtnTextWithdrawn() {
        logger.info("Get button text Withdrawn");
        return btnWithdrawl;
    }

    public CustomerLoginPage clickBtnWithdrawn() {
        logger.info("Click button Withdrawn");
        btnWithdrawl.shouldBe(visible).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public CustomerLoginPage clickBtnTransactions() {
        logger.info("Click button Transactions");
        btnTransactions.shouldBe(visible).click();
        return this;
    }

    public SelenideElement getBtnTextTransactions() {
        logger.info("Get button text Transactions");
        return btnTransactions.shouldBe(visible);
    }

    public CustomerLoginPage clickBtnDeposit() {
        logger.info("Click button Deposit");
        btnDeposit.shouldBe(visible).click();
        return this;
    }

    public CustomerLoginPage enterFieldAmountDeposit(String amountDeposit) {
        logger.info("Enter the amount of the deposit in the field");
        fieldAmount.val(amountDeposit).shouldBe(visible);
        return this;
    }

    public CustomerLoginPage enterFieldAmountWithdrawn(String amountWithdrawn) {
        logger.info("Enter the amount to withdraw the deposit into the field");
        fieldAmount.setValue(amountWithdrawn).shouldBe(visible);
        return this;
    }

    public CustomerLoginPage clickBtnSubmit() {
        btnSubmit.shouldBe(visible).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public SelenideElement getDepositAmount() {
        return depositAmount.shouldBe(visible);
    }

    public SelenideElement getTransactionTypeCredit() {
        return transactionTypeCredit.shouldBe(visible);
    }

    public SelenideElement getDebitAmount() {
        return debitAmount.shouldBe(visible);
    }

    public SelenideElement getTransactionTypeDebit() {
        return transactionTypeDebit.shouldBe(visible);
    }
}
