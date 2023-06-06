package baseClasses;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class BankManagerLoginPage extends AbstractBasePage {

    private static SelenideElement addCustomerLoginBtn = $x("//button[normalize-space()='Add Customer']");

    public void addCustomerLoginButtonClick() {
        addCustomerLoginBtn.click();
    }
}

