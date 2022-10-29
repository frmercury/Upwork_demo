package pages.bingEngine;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;
import pages.BasePage;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class BingSearchResultsPage extends BasePage {

    public BingSearchResultsPage() {
        super("Bing Search Results Page");
    }

    private final ElementsCollection bingHrefs = $$x("//li/h2/a");

    public List<String> getBingSearchedLinks() {
        ArrayList<String> bingHrefList = new ArrayList<>();
        for (WebElement href: bingHrefs) {
            bingHrefList.add(href.getAttribute("href"));
        }
        return bingHrefList;
    }

}
