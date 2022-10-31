package helpers;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.webdriver;
import static helpers.Loader.loadProperty;
import static java.lang.Integer.parseInt;

public class WebHelpers {

    public void waitPageToLoad(){
        webdriver().driver().getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(parseInt(loadProperty("timeout.pageload"))));
    }

}
