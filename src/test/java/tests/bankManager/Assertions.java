package tests.bankManager;

import com.codeborne.selenide.WebDriverConditions;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.webdriver;

public class Assertions {
    public void assertUrlContains(String s) {
        try {
            webdriver().shouldHave(WebDriverConditions.urlContaining(s));
            System.out.println("URL contains: " + s);
        } catch (Exception e) {
            Assert.fail("No such URL found " + s);
        }
    }
}
