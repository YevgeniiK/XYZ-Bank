package baseClasses;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BankManagerLoginPage extends AbstractBasePage {

    final String firstName = "TestFN";
    final String lastName = "TestLN";
    final String postCode = "TestPC";
    private static SelenideElement fieldFirstName = $x("//input [@ng-model='fName']");
    private static SelenideElement fieldLastName = $x("//input [@ng-model='lName']");
    private static SelenideElement fieldPostCode = $x("//input [@ng-model='postCd']");
    public static SelenideElement addCustomerLoginBtn = $x("//button[normalize-space()='Add Customer']");
    private static SelenideElement btnFormAddCustomer = $x("//button [@ng-class='btnClass1']");
    private static SelenideElement btnCreateAddCustomer = $x("//button [@type='submit']");


    public BankManagerLoginPage addCustomerLoginButtonClick() {
        addCustomerLoginBtn.shouldBe(visible, Duration.ofSeconds(3)).click();
        return this;
    }

    public BankManagerLoginPage open() {
        openURL("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        return this;
    }
    public BankManagerLoginPage createNewCustomer() {
        btnFormAddCustomer.click();
        fieldFirstName.sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        fieldPostCode.sendKeys(postCode);
        btnCreateAddCustomer.click();
        return this;
    }
}

