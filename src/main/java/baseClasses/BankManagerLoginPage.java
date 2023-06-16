package baseClasses;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class BankManagerLoginPage extends AbstractBasePage {

    private static SelenideElement addCustomerBtn = $x("//button[normalize-space()='Add Customer']");
    private static SelenideElement firstNameField = $x("//input[@placeholder='First Name']");
    private static SelenideElement lastNameField = $x("//input[@placeholder='Last Name']");
    private static SelenideElement postCodeField = $x("//input[@placeholder='Post Code']");
    private static SelenideElement addCustomerSmallBtn = $x("//button[@type='submit']");
    private static SelenideElement openAccountBtn = $x("//button[@ng-click='openAccount()']");
    private static SelenideElement customerNameField = $x("//select[@ng-model='custId']");
    private static SelenideElement customersBtn = $x("//button[@ng-click='showCust()']");
    private static SelenideElement currencyField = $x("//select[@ng-model='currency']");
    private static SelenideElement processBtn = $x("//button[normalize-space()='Process']");
    private static SelenideElement processBtnn = $("button[type='submit']");
    private static SelenideElement accountNumber = $x("//tbody/tr[6]/td[4]");


    public BankManagerLoginPage addCustomerLoginBtnClick() {
        addCustomerBtn.shouldBe(visible, Duration.ofSeconds(3)).click();
        return this;
    }

    public BankManagerLoginPage firstNameFieldFilling() {
        firstNameField.shouldBe(visible, Duration.ofSeconds(3)).setValue("User");
        return this;
    }

    public BankManagerLoginPage lastNameFieldFilling() {
        lastNameField.shouldBe(visible, Duration.ofSeconds(3)).setValue("New");
        return this;
    }

    public BankManagerLoginPage postCodeFieldFilling() {
        postCodeField.shouldBe(visible, Duration.ofSeconds(3)).setValue("77");
        return this;
    }

    public BankManagerLoginPage addCustomerSmallBtnClick() {
        addCustomerSmallBtn.shouldBe(visible, Duration.ofSeconds(3)).click();
        return this;
    }

    public BankManagerLoginPage openAccountBtnClick() {
        openAccountBtn.shouldBe(visible, Duration.ofSeconds(3)).doubleClick();
        return this;
    }

    public BankManagerLoginPage customerNameFieldClick() {
        customerNameField.shouldBe(visible, Duration.ofSeconds(3)).getSelectedOption().press("e");
        return this;
    }

    public BankManagerLoginPage customersBtnClick() {
        customersBtn.shouldBe(visible, Duration.ofSeconds(3)).click();
        return this;
    }

    public BankManagerLoginPage dropdownCustomerMenuClick() {
        customerNameField.shouldBe(visible, Duration.ofSeconds(3));
        actions().moveToElement(customerNameField).click().perform();
        int repeatCount = 6;
        for (int i = 0; i < repeatCount; i++) {
            actions().sendKeys(Keys.DOWN).perform();
        }
        actions().sendKeys(Keys.ENTER).perform();
        return this;
    }

    public BankManagerLoginPage dropdownCurrencyMenuClick(int repeatCount) {
        currencyField.shouldBe(visible, Duration.ofSeconds(3));
        actions().moveToElement(currencyField).click().perform();
        for (int i = 0; i < repeatCount; i++) {
            actions().sendKeys(Keys.DOWN).perform();
        }
        actions().sendKeys(Keys.ENTER).perform();
        return this;
    }

    public BankManagerLoginPage processBtnClick() {
        processBtn.shouldBe(visible, Duration.ofSeconds(3));
        actions().moveToElement(processBtn).click().perform();
        return this;
    }

    public BankManagerLoginPage accountNumberCheck(String s) {

        try {
            boolean result = accountNumber.getText().contains(s);
            System.out.println(result);
            if (!result) {
                Assert.fail("No such Customer Account Numbers has " + s);
            }
            System.out.println("Customer Account Numbers are: " + s);
        } catch (Exception e) {
            Assert.fail("An exception occurred: " + e.getMessage());
        }
        return this;
    }
}

