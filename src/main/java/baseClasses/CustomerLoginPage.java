package baseClasses;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class CustomerLoginPage extends AbstractBasePage {

    private static SelenideElement fieldUserSelect = $x("//select[@name='userSelect']");
    private static SelenideElement selectUser = $x("//option[@value='3']");
    private static SelenideElement btnLogin = $x("//button[@type='submit']");
    private static SelenideElement btnWithdrawl = $x("//button[@ng-class='btnClass3']");
    private static SelenideElement btnDeposit = $x("//button[@ng-class = 'btnClass2']");
    private static SelenideElement confirmDepositBtn = $x("//button[normalize-space() = 'Deposit' and @type]");

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

    public CustomerLoginPage selectUserByName(String text){
        fieldUserSelect.selectOptionContainingText(text);
        return this;
    }

    public CustomerLoginPage clickBtnLogin() {
        logger.info("Click button Login");
        btnLogin.click();
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

    public CustomerLoginPage clickBtnDeposit(){
        logger.info("Click button Deposit");
        btnDeposit.click();
        return this;
    }

    public SelenideElement getTextConfirmDepositBtn(){
        logger.info("Get text confirming deposit button");
        return confirmDepositBtn;
    }
}
