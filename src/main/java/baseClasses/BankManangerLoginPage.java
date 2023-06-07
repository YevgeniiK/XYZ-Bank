package baseClasses;

import com.codeborne.selenide.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class BankManangerLoginPage extends AbstractBasePage {

    final String firstName = "TestFN";
    final String lastName = "TestLN";
    final String postCode = "TestPC";
    private static SelenideElement fieldFirstName = $x("//input [@ng-model='fName']");
    private static SelenideElement fieldLastName = $x("//input [@ng-model='lName']");
    private static SelenideElement fieldPostCode = $x("//input [@ng-model='postCd']");
    private static SelenideElement fieldSearchCustomer = $x("//input[@type='text']");
    private static SelenideElement btnCreateAddCustomer = $x("//button [@type='submit']");
    private static SelenideElement btnFormAddCustomer = $x("//button [@ng-class='btnClass1']");
    private static SelenideElement btnFormOpenAccount = $x("//button [@ng-class='btnClass2']");
    private static SelenideElement btnFormCustomers = $x("//button [@ng-class='btnClass3']");
    private static SelenideElement btnDeleteCustomer = $x("//tr/td [text() = 'TestFN']/following-sibling::td/button[@ng-click='deleteCust(cust)']");
    private static SelenideElement tableCustomers = $x("//table[@class='table table-bordered table-striped']");
    private static ElementsCollection listCustomers = $$x("//tr[@class='ng-scope']");
//table[@class="table table-bordered table-striped"]

    public BankManangerLoginPage open() {
        openURL("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        return this;
    }

    public BankManangerLoginPage createNewCustomer() {
        btnFormAddCustomer.click();
        fieldFirstName.sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        fieldPostCode.sendKeys(postCode);
        btnCreateAddCustomer.click();
        return this;
    }

    public BankManangerLoginPage clickBtnCustomers() {
        btnFormCustomers.click();
        return this;
       }

    public ElementsCollection listCustomers() {
        return listCustomers = $$x("//tr[@class='ng-scope']/td[@class='ng-binding']");
    }

    public int sizeListCustomer() {
        return listCustomers().size();
    }
    public BankManangerLoginPage clickBtnDeleteCustomer (){
        btnDeleteCustomer.click();
        return this;
    }
    public BankManangerLoginPage searchNewCustomerInSearchField (){
        fieldSearchCustomer.sendKeys(firstName);
        return this;
    }
    public BankManangerLoginPage clearFieldSearchNewCustomer (){
        fieldSearchCustomer.clear();
        return this;
    }
    public boolean newCustomerIsVisibleInTable() {
        for (SelenideElement elementsTable:listCustomers) {
            if (elementsTable.getText().equals(firstName)) {
                return true;
            }
        }
        return false;
    }
    public BankManangerLoginPage tableCustomerIsDisplay () {
        tableCustomers.shouldBe(visible);
        return this;
    }



}
