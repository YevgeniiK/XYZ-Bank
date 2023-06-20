package baseClasses;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BankManagerLoginPage extends AbstractBasePage {

    private static SelenideElement addCustomerLoginBtn = $x("//button[normalize-space()='Add Customer']");
    private static SelenideElement firstNameField = $x("//input[contains (@placeholder, 'First Name')]");
    private static SelenideElement lastNameField = $x("//input[contains (@placeholder, 'Last Name')]");
    private static SelenideElement postCodeField = $x("//input[contains (@placeholder, 'Post Code')]");
    private static SelenideElement addCustomerConfirmButton = $x("//button[@type= 'submit' and normalize-space()= 'Add Customer']");
    private static SelenideElement openAccountButton = $x("//button[@ng-click = 'openAccount()']");
    private static SelenideElement selectCustomerField = $x("//select[@name ='userSelect']");
    private static SelenideElement selectCurrency = $x("//select[@name ='currency']");
    private static SelenideElement processButton = $x("//button[@type= 'submit' and normalize-space()= 'Process']");
    private static SelenideElement returnOnHomePageButton = $x("//button[@class ='btn home']");
    public BankManagerLoginPage regNewCustomerAccountMethod(String firstName, String lastName, String postCode){
        new HomePage()
                .bankManagerLoginButtonClick();
        new BankManagerLoginPage()
                .addCustomerLoginButtonClick()
                .fillFirstNameField(firstName)
                .fillLastNameField(lastName)
                .fillPostCode(postCode)
                .addCustomerConfirmButtonClick();
        return this;
    }

    public BankManagerLoginPage chooseCurrencyMethod(String nameToEnter, String currency){
        new BankManagerLoginPage()
                .openAccountButtonClick()
                .selectCustomerFieldClick()
                .selectCustomerToEnter(nameToEnter)
                .selectCurrencyFieldClick()
                .selectCurrency(currency)
                .processButtonClick()
                .returnOnHomePageClick();
        return this;
    }


    public BankManagerLoginPage addCustomerLoginButtonClick() {
        addCustomerLoginBtn.shouldBe(visible, Duration.ofSeconds(3)).click();
        return this;
    }

    public BankManagerLoginPage fillFirstNameField(String text){
        logger.info("Fill first name field");
        firstNameField.setValue(text);
        return this;
    }

    public BankManagerLoginPage fillLastNameField(String text){
        logger.info("Fill last name field");
        lastNameField.setValue(text);
        return this;
    }

    public BankManagerLoginPage fillPostCode(String text){
        logger.info("Fill post code field");
        postCodeField.setValue(text);
        return this;
    }

    public BankManagerLoginPage addCustomerConfirmButtonClick(){
        logger.info("Confirming registration new customer");
        addCustomerConfirmButton.click();
        return this;
    }

    public BankManagerLoginPage openAccountButtonClick(){
        openAccountButton.click();
        return this;
    }

    public BankManagerLoginPage selectCustomerFieldClick(){
        selectCustomerField.pressEnter();
        return this;
    }

    public BankManagerLoginPage selectCustomerToEnter(String text){
        selectCustomerField.selectOptionContainingText(text);
        return this;
    }

    public BankManagerLoginPage selectCurrencyFieldClick(){
        selectCurrency.click();
        return this;
    }

    public BankManagerLoginPage selectCurrency(String text){
        selectCurrency.selectOptionContainingText(text);
        return this;
    }

    public BankManagerLoginPage processButtonClick(){
        processButton.click();
        return this;
    }

    public BankManagerLoginPage returnOnHomePageClick(){
        returnOnHomePageButton.click();
        return this;
    }
}

