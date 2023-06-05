package baseClasses;

import static com.codeborne.selenide.Selenide.open;
public abstract class AbstractBasePage {

    public void openHomePage() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    public void openCustomerPage() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
    }

    public void openManagerPage() {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
    }
}
