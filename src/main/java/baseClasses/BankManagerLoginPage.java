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
    private static SelenideElement openAccountBtn = $x("//button[normalize-space()='Open Account']");
    private static SelenideElement setFirstNameInp = $x("//input[@placeholder=\"First Name\"]");
    private static SelenideElement setLastNameInp = $x("//input[@placeholder=\"Last Name\"]");
    private static SelenideElement setPostCode = $x("//input[@placeholder=\"Post Code\"]");
    private static SelenideElement addCustomerBtn = $x("//button[@class=\"btn btn-default\"]");
    private static SelenideElement customerNameSlc = $x("//select[@name=\"userSelect\"]");
    private static SelenideElement customerCurrencySlc = $x("//select[@name=\"currency\"]");
    private static SelenideElement addAccountNumberBtn = $x("//button[@type=\"submit\"]");
    private static SelenideElement goHomeBtn = $x("//button[@class=\"btn home\"]");

    private String accountNumber;


    public BankManagerLoginPage addCustomerLoginButtonClick() {
        addCustomerLoginBtn.shouldBe(visible, Duration.ofSeconds(3)).click();
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

    public BankManagerLoginPage clickGoHomePage() {

        logger.info("Click go Home ");
        goHomeBtn.click();
        return this;
    }


    public String getAccountNumber() {
        return accountNumber;
    }


}

