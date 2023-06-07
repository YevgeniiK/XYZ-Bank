package baseClasses;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class HomePage extends AbstractBasePage{

    private static SelenideElement btnCustomerLogin = $x("//button [@ng-click='customer()']");
    private static SelenideElement btnBankManagerLogin = $x("//button [@ng-click='manager()']");
    private static SelenideElement btnHome = $x("//button [@ng-click='home()']");
    private static SelenideElement fieldHeading = $x("//strong [@class='mainHeading']");

    public static void main(String[] args) {
        WebDriverRunner.getWebDriver().manage().window();
       Selenide. switchTo().alert().accept();
    }
}
