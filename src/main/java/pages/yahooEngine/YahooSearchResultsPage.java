package pages.yahooEngine;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class YahooSearchResultsPage extends BasePage {
    public YahooSearchResultsPage() {
        super("Yahoo Search Results Page");
    }

    private final ElementsCollection yahooHrefs = $$x("//h3/a");

    public List<String> getYahooSearchedLinks() {
        ArrayList<String> yahooHrefList = new ArrayList<>();
        for (WebElement href: yahooHrefs) {
            yahooHrefList.add(href.getAttribute("href"));
        }
        return yahooHrefList;
    }

}