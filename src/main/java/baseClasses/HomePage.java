package baseClasses;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$x;



public class HomePage extends AbstractBasePage{

    private static SelenideElement btnCustomerLogin = $x("//button [@ng-click='customer()']");
    private static SelenideElement btnBankManagerLogin = $x("//button [@ng-click='manager()']");
    private static SelenideElement btnHome = $x("//button [@ng-click='home()']");
    private static SelenideElement fieldHeading = $x("//strong [@class='mainHeading']");

    public HomePage open() {
        openURL("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        return this;
    }

    public void bankManagerLoginButtonClick(){
        btnBankManagerLogin.click();
    }
}
