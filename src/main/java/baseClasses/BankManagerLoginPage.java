package baseClasses;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BankManagerLoginPage extends AbstractBasePage {

    private static SelenideElement addCustomerLoginBtn = $x("//button[normalize-space()='Add Customer']");
    private static SelenideElement customersBtn = $x("//button[normalize-space()='Customers']");
    private static SelenideElement openAccountBtn =$x("//button[normalize-space()='Open Account']");
    private static SelenideElement setFirstNameInp = $x("//input[@placeholder=\"First Name\"]");
    private static SelenideElement setLastNameInp = $x("//input[@placeholder=\"Last Name\"]");
    private static SelenideElement setPostCode = $x("//input[@placeholder=\"Post Code\"]");
    private static SelenideElement searchCustomersInp = $x("//input[@placeholder=\"Search Customer\"]");
    private static SelenideElement firstNameCustomerTd = $x("//td[@class=\"ng-binding\"][1]");
    private static SelenideElement deleteCustomerBtn = $x("//button[@ng-click=\"deleteCust(cust)\"]");
    private static SelenideElement addCustomerBtn = $x("//button[@class=\"btn btn-default\"]");
    private static SelenideElement customerNameSlc = $x("//select[@name=\"userSelect\"]");
    private static SelenideElement customerCurrencySlc = $x("//select[@name=\"currency\"]");
    private static SelenideElement addAccountNumberBtn = $x("//button[@type=\"submit\"]");

    private String accountNumber;



    public BankManagerLoginPage addCustomerLoginButtonClick() {
        addCustomerLoginBtn.shouldBe(visible, Duration.ofSeconds(3)).click();
        return this;
    }

    public BankManagerLoginPage customersButtonClick() {
        logger.info("Click field select Customers ");
        customersBtn.shouldBe(visible, Duration.ofSeconds(3)).click();
        return this;
    }

    public BankManagerLoginPage deleteCustomersButtonClick() {
        logger.info("Click delete select Customers ");
        deleteCustomerBtn.click();
        return this;
    }


    public BankManagerLoginPage getFirstNameCustomer() {
        logger.info("Get text First Name Customer");
        // add contains("")
        firstNameCustomerTd.shouldBe(visible, Duration.ofSeconds(3)).getText();
        return this;
    }


    public BankManagerLoginPage setSearchCustomersInput(String value) {
        logger.info("Set text on Search Customers Input");
        searchCustomersInp.shouldBe(visible, Duration.ofSeconds(3)).setValue(value);
        return this;
    }

    public BankManagerLoginPage addNewCustomer(String firstName, String lastName, String postCode) {
        logger.info("Set text on First Name aadCustomers Input");
        setFirstNameInp.shouldBe(visible, Duration.ofSeconds(3)).setValue(firstName);
        logger.info("Set text on Last Name aadCustomers Input");
        setLastNameInp.shouldBe(visible, Duration.ofSeconds(3)).setValue(lastName);
        logger.info("Set text on Post Code aadCustomers Input");
        setPostCode.shouldBe(visible, Duration.ofSeconds(3)).setValue(postCode);
        logger.info("Click add select Customers ");
        addCustomerBtn.click();
        Alert alert = getWebDriver().switchTo().alert();
        alert.accept();
        return this;
    }

    public BankManagerLoginPage addCurrencyToAccount(String customerName, String Currency) {

        logger.info("Click  Open Account ");
        openAccountBtn.click();
        logger.info("Choose line Customer Name in select");
        customerNameSlc.selectOptionContainingText(customerName);
        logger.info("Choose line Customer Currency in select");
        customerCurrencySlc.selectOptionContainingText(Currency);
        addAccountNumberBtn.click();
        logger.info("Get Account Number with alert");
        Alert alert = getWebDriver().switchTo().alert();
        String alertText = alert.getText();
        accountNumber = alertText.substring(alertText.length() - 4);
        alert.accept();
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BankManagerLoginPage assertPresenceCustomer() {
        logger.info("Customer not found");
        firstNameCustomerTd.shouldNot(exist);
        return this;
    }


}

