package baseClasses;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.open;

public abstract class AbstractBasePage {
    protected final Logger logger;

    protected AbstractBasePage() {
        this.logger = LogManager.getLogger(this.getClass());
    }

    public void openURL(String URL) {
        open(URL);
    }
}
