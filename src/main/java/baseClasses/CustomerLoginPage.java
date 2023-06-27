package baseClasses;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.getSelectedText;

public class CustomerLoginPage extends AbstractBasePage {

    private static SelenideElement fieldUserSelect = $x("//select[@name='userSelect']");
    private static SelenideElement selectUser = $x("//option[@value='3']");
    private static SelenideElement btnLogin = $x("//button[@type='submit']");
    private static SelenideElement btnWithdrawl = $x("//button[@ng-class='btnClass3']");
    private static SelenideElement btnDeposit = $x("//button[@ng-click=\"deposit()\"]");
    private static SelenideElement inpDeposit = $x("//div[@class=\"form-group\"]/input");
    private static SelenideElement buttonSendDeposit = $x("//button[@class=\"btn btn-default\"]");
    private static SelenideElement massageDepositSuccessful = $x("//span[@class=\"error ng-binding\"]");






    public CustomerLoginPage clickSendDeposit(){
        logger.info("Send Deposit");
        buttonSendDeposit.shouldBe(visible, Duration.ofSeconds(3)).click();
        return this;
    }

    public CustomerLoginPage getMassageDeposit() {
        logger.info("Get massage");

        String resultMassageDeposit;

        if (massageDepositSuccessful.exists()) {
            String text = massageDepositSuccessful.getText();
            if (text.equals("Deposit Successful")) {
                resultMassageDeposit = "text true";
            } else {
                resultMassageDeposit = "text false";
            }
        } else {
            resultMassageDeposit = "element not found";
        }

        return this;
    }



    public CustomerLoginPage selectAccount(String customerName){
        logger.info("Select line USer Name in select");
        fieldUserSelect.selectOptionContainingText(customerName);
        return this;
    }

    public CustomerLoginPage clickButtonDeposit() {
        logger.info("click button Deposit");
        btnDeposit.click();
        return this;
    }

    public CustomerLoginPage setValueDeposit(String deposit) {
        logger.info("Set text on First Name aadCustomers Input");
        inpDeposit.shouldBe(visible, Duration.ofSeconds(3)).setValue(deposit);
        return this;
    }

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
