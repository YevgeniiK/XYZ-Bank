package baseClasses;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BankManagerLoginPage extends AbstractBasePage {

    private static SelenideElement addCustomerLoginBtn = $x("//button[normalize-space()='Add Customer']");

    public BankManagerLoginPage addCustomerLoginButtonClick() {
        addCustomerLoginBtn.shouldBe(visible, Duration.ofSeconds(3)).click();
        return this;
    }
}

