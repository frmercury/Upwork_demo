package pages.bingEngine;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import java.util.*;
import static com.codeborne.selenide.Selenide.$$x;


public class BingSearchResultsPage extends BasePage {

    public BingSearchResultsPage() {
        super("Bing Search Results Page");
    }

    private final ElementsCollection bingHrefs = $$x("//li/h2/a[1]");

    public List<String> getBingSearchedLinks() {
        List<String> bingHrefList = new ArrayList<>();
        for (WebElement href: bingHrefs) {
            bingHrefList.add(href.getAttribute("href"));
        }
        return bingHrefList;
    }
}
