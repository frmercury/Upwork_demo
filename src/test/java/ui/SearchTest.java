package ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.duckDuckGoEngine.DnGSearchResultsPage;
import pages.duckDuckGoEngine.DuckAndGoMainPage;
import pages.yahooEngine.YahooSearchResultsPage;
import pages.yahooEngine.YahooMainPage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static helpers.Loader.loadProperty;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



public class SearchTest extends BaseTest {

    protected Logger log = LoggerFactory.getLogger(SearchTest.class);

    private YahooMainPage yahooMainPage = new YahooMainPage();
    private YahooSearchResultsPage yahooSearchResultsPage = new YahooSearchResultsPage();
    private DnGSearchResultsPage dngSearchResultsPage = new DnGSearchResultsPage();
    private DuckAndGoMainPage dngMainPage = new DuckAndGoMainPage();

    @Test(description = "Compare and find common links for different searching engines",
    testName = "Common links")
    public void searchTest() {
        open(loadProperty("search.engine.yahoo"));
        this.yahooMainPage
                .enterSearchedValue()
                .pressSearchButton();
        List<String> firstEngineLinks = new ArrayList<>(yahooSearchResultsPage.getYahooSearchedLinks());
        log.info(String.valueOf(firstEngineLinks));

        open(loadProperty("search.engine.dng"));
        this.dngMainPage
                .enterSearchedValue()
                .pressSearchButton();

        List<String> secondEngineLinks = new ArrayList<>(dngSearchResultsPage.getBingSearchedLinks());

        log.info(String.valueOf(secondEngineLinks));

        firstEngineLinks.retainAll(secondEngineLinks);

        assertThat(firstEngineLinks.size() > 0).isTrue();

        System.out.println("Common links \n" + firstEngineLinks);
    }
}