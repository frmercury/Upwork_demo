package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Locale;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static helpers.Loader.loadProperty;
import static java.lang.Integer.parseInt;
import static java.lang.System.getProperty;

public abstract class BaseTest {

    protected Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true, description = "Driver props init")

    public void initProps() {

        //browser settings
        browser = getProperty("browser");
        timeout = parseInt(loadProperty("timeout.global"));
    }

    @AfterMethod(alwaysRun = true, description = "End browser session")
    public void closeWebBrowser() {
        Selenide.closeWebDriver();
        log.info("Browser has been closed");
    }
}
