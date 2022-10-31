package pages.duckDuckGoEngine;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class DnGSearchResultsPage extends BasePage {
    public DnGSearchResultsPage() {
        super("D'n'G Search Page");
    }

    private final ElementsCollection bingHrefs = $$x("//h2/a");

    public List<String> getBingSearchedLinks() {
        List<String> bingHrefList = new ArrayList<>();
        for (WebElement href: bingHrefs) {
            bingHrefList.add(href.getAttribute("href"));
        }
        return bingHrefList;
    }


}
