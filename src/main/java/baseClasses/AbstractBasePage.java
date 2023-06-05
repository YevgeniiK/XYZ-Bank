package baseClasses;

import static com.codeborne.selenide.Selenide.open;

public abstract class AbstractBasePage {

    public void openURL(String URL) {
        open(URL);
    }
}
