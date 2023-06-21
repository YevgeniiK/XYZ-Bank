package baseClasses;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.getSelectedText;

public class CustomerLoginPage extends AbstractBasePage {

    private static SelenideElement fieldUserSelect = $x("//select[@name='userSelect']");
    private static SelenideElement msgCreateAccount = $x("//*[contains(text(),'Please open an account with us.')]");
    private static SelenideElement selectUser = $x("//option[@value='6']");
    private static SelenideElement btnLogin = $x("//button[@type='submit']");
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

    public CustomerLoginPage getBtnLogin(){
        logger.info("Get button text Login");
        btnLogin.getText().contains("Login");
        return this;
    }

    public CustomerLoginPage clickBtnLogin() {
        logger.info("Click button Login");
        btnLogin.click();
        return this;
    }

    public SelenideElement getMsgCreateAccount() {
        logger.info("Get text Please open an account with us.");
        return msgCreateAccount;
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
