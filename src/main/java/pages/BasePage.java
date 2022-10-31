package pages;
import helpers.WebHelpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BasePage extends WebHelpers {

    protected Logger log;

    protected BasePage(String title) {
        this.log = LogManager.getLogger(title);
        log.debug("Page is open");
    }
}
