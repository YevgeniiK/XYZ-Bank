package baseClasses;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class CustomerLoginPage extends AbstractBasePage {

    private static SelenideElement fieldUserSelect = $x("//select[@name='userSelect']");
    private static SelenideElement selectUser = $x("//option[@value='6']");
    private static SelenideElement btnLogin = $x("//button[@type='submit']");
    private static SelenideElement btnLogout = $x("//button[@class='btn logout']");
    private static SelenideElement btnWithdrawl = $x("//button[@ng-class='btnClass3']");

    public CustomerLoginPage clickFieldSelectUserName() {
        logger.info("Click field select UserName");
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

    public CustomerLoginPage clickBtnLogout() {
        logger.info("Click button Logout");
        btnLogout.click();
        return this;
    }

    public SelenideElement getBtnTextWithdawn() {
        logger.info("Get button text Withdawn");
        return btnWithdrawl;
    }

    public CustomerLoginPage clickBtnWithdrawn() {
        logger.info("Click button Withdrawn");
        btnWithdrawl.click();
        return this;
    }
}
