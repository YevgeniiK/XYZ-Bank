package baseClasses;

import com.codeborne.selenide.*;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BankManangerLoginPage extends AbstractBasePage {

    final String firstName = "TestFN";
    final String lastName = "TestLN";
    final String postCode = "TestPC";
    final String currencyDollar = "Dollar";
    final String currencyPound = "Pound";
    final String currencyRupee = "Rupee";

    private static SelenideElement fieldFirstName = $x("//input [@ng-model='fName']");
    private static SelenideElement fieldLastName = $x("//input [@ng-model='lName']");
    private static SelenideElement fieldPostCode = $x("//input [@ng-model='postCd']");
    private static SelenideElement fieldSearchCustomer = $x("//input[@type='text']");
    private static SelenideElement fieldSelectCustomerName = $x("//select [@id='userSelect']");
    private static SelenideElement fieldSelectCurrency = $x("//select [@id='currency']");
    private static SelenideElement btnCreateAddCustomer = $x("//button [@type='submit']");
    private static SelenideElement btnFormAddCustomer = $x("//button [@ng-class='btnClass1']");
    private static SelenideElement btnProcess = $x("//button [@type='submit']");
    private static SelenideElement btnFormOpenAccount = $x("//button [@ng-class='btnClass2']");
    private static SelenideElement btnFormCustomers = $x("//button [@ng-class='btnClass3']");
    private static SelenideElement btnDeleteCustomer = $x("//tr/td [text() = 'TestFN']/following-sibling::td/button[@ng-click='deleteCust(cust)']");
    private static SelenideElement tableCustomers = $x("//table[@class='table table-bordered table-striped']");
    private static ElementsCollection listCustomers = $$x("//tr[@class='ng-scope']");
    private static ElementsCollection listAccountNumber;


    public BankManangerLoginPage open() {
        openURL("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        return this;
    }

    public BankManangerLoginPage createNewCustomer() {
        btnFormAddCustomer.click();
        fieldFirstName.sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        fieldPostCode.sendKeys(postCode);
        btnCreateAddCustomer.click();
        return this;
    }

    public BankManangerLoginPage enterFirstNameAndLastNameNewCustomer() {
        btnFormAddCustomer.click();
        fieldFirstName.sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        btnCreateAddCustomer.click();
        return this;
    }

    public BankManangerLoginPage enterFirstNameAndPostCodeNewCustomer() {
        btnFormAddCustomer.click();
        fieldFirstName.sendKeys(firstName);
        fieldPostCode.sendKeys(postCode);
        btnCreateAddCustomer.click();
        return this;
    }

    public BankManangerLoginPage enterLastNameAndPostCodeNewCustomer() {
        btnFormAddCustomer.click();
        fieldFirstName.sendKeys(firstName);
        fieldPostCode.sendKeys(postCode);
        btnCreateAddCustomer.click();
        return this;
    }


    public BankManangerLoginPage clickBtnCustomers() {
        btnFormCustomers.click();
        return this;
    }

    public BankManangerLoginPage clickBtnAddCustomer() {
        btnFormAddCustomer.click();
        return this;
    }

    public BankManangerLoginPage clickBtnOpenAccount() {
        btnFormOpenAccount.click();
        return this;
    }

    public BankManangerLoginPage clickFieldSelectCurrency() {
        fieldSelectCurrency.click();
        return this;
    }

    public BankManangerLoginPage selectCurrencyDollar() {
        fieldSelectCurrency.selectOptionByValue(currencyDollar);
        return this;
    }

    public BankManangerLoginPage selectCurrencyPound() {
        fieldSelectCurrency.selectOptionByValue(currencyPound);
        return this;
    }

    public BankManangerLoginPage selectCurrencyRupee() {
        fieldSelectCurrency.selectOptionByValue(currencyRupee);
        return this;
    }
    public BankManangerLoginPage clickFieldSelectCustomerName() {
        fieldSelectCustomerName.click();
        return this;
    }
    public BankManangerLoginPage selectCustomerFirstName() {
        fieldSelectCustomerName.selectOptionContainingText(firstName);
        return this;
    }
    public BankManangerLoginPage clickBtnProcess() {
        btnProcess.click();
        return this;
    }

    public ElementsCollection listCustomers() {
        return listCustomers = $$x("//tr[@class='ng-scope']/td[@class='ng-binding']");
    }

    public ElementsCollection listAccountNumber() {
        return listAccountNumber = $$x("//span [@class='ng-binding ng-scope']");
    }

    public int sizeListAccountNumber() {
        return listAccountNumber().size();
    }

    public int sizeListCustomer() {
        return listCustomers().size();
    }

    public BankManangerLoginPage clickBtnDeleteCustomer() {
        btnDeleteCustomer.click();
        return this;
    }

    public BankManangerLoginPage searchNewCustomerInSearchField() {
        fieldSearchCustomer.sendKeys(firstName);
        return this;
    }

    public BankManangerLoginPage clearFieldSearchNewCustomer() {
        fieldSearchCustomer.clear();
        return this;
    }

    public boolean newCustomerIsVisibleInTable() {
        for (SelenideElement elementsTable : listCustomers) {
            if (elementsTable.getText().equals(firstName)) {
                return true;
            }
            if (elementsTable.getText().equals(lastName)) {
                return true;
            }
            if (elementsTable.getText().equals(postCode)) {
                return true;
            }
        }
        return false;
    }

    public BankManangerLoginPage tableCustomerIsDisplay() {
        tableCustomers.shouldBe(visible);
        return this;
    }

    public BankManangerLoginPage moveCursorToFirstCustomer() {
        listCustomers().first().hover();
        return this;
    }

    public BankManangerLoginPage scrollToLastCustomer() {
        listCustomers().last().scrollIntoView(false);
        return this;
    }

    public BankManangerLoginPage acceptAlert() {
        //Alert alert;
        switchTo().alert().accept();
        return this;
    }

    public boolean switchToAlert() {
        switchTo().alert();
        return true;
    }

    public String getTextToAlert() {
        String alertMessage = switchTo().alert().getText();
        return alertMessage;
    }
}
