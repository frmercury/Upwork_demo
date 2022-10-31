package ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.bingEngine.BingMainPage;
import pages.bingEngine.BingSearchResultsPage;
import pages.duckDuckGoEngine.DnGSearchResultsPage;
import pages.duckDuckGoEngine.DuckAndGoMainPage;
import pages.yahooEngine.YahooSearchResultsPage;
import pages.yahooEngine.YahooMainPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;
import static helpers.Loader.loadProperty;
import static java.lang.System.getProperty;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pages.SearchEngines.*;


public class SearchCommonLinksTest extends BaseTest {

    protected Logger log = LoggerFactory.getLogger(SearchCommonLinksTest.class);

    private YahooMainPage yahooMainPage = new YahooMainPage();
    private YahooSearchResultsPage yahooSearchResultsPage = new YahooSearchResultsPage();
    private DnGSearchResultsPage dngSearchResultsPage = new DnGSearchResultsPage();
    private DuckAndGoMainPage dngMainPage = new DuckAndGoMainPage();
    private BingMainPage bingMainPage = new BingMainPage();
    private BingSearchResultsPage bingSearchResultsPage = new BingSearchResultsPage();

    @Test(description = "Compare and find common links between Yahoo and DuckAndGo searching engines",
    testName = "Yahoo/DuckAndGo common links")
    public void searchYahooDnGTest() {
        open(loadProperty(YAHOO_ENGINE));
        this.yahooMainPage
                .enterSearchedValue()
                .pressSearchButton();
        List<String> firstEngineLinks = new ArrayList<>(yahooSearchResultsPage.getYahooSearchedLinks());
        log.info("First engine resulted links: " + firstEngineLinks);

        assertThat(firstEngineLinks.size() > 0).isTrue();

        open(loadProperty(DNG_ENGINE));
        this.dngMainPage
                .enterSearchedValue()
                .pressSearchButton();

        List<String> secondEngineLinks = new ArrayList<>(dngSearchResultsPage.getBingSearchedLinks());

        log.info("Second engine resulted links: " + secondEngineLinks);

        firstEngineLinks.retainAll(secondEngineLinks);

        assertThat(firstEngineLinks.size() > 0).isTrue();

        System.out.printf("Search results have %s links in common in %s browser: " + firstEngineLinks + "\n", firstEngineLinks.size(), getProperty("browser").toUpperCase(Locale.ROOT));
    }

    @Test(description = "Compare and find common links between Yahoo and Bing searching engines",
    testName = "Yahoo/Bing common links")
    public void searchYahooBingTest() {
        open(loadProperty(YAHOO_ENGINE));
        this.yahooMainPage
                .enterSearchedValue()
                .pressSearchButton();
        List<String> firstEngineLinks = new ArrayList<>(yahooSearchResultsPage.getYahooSearchedLinks());
        log.info("First engine resulted links: " + firstEngineLinks);

        assertThat(firstEngineLinks.size() > 0).isTrue();

        open(loadProperty(BING_ENGINE));
        this.bingMainPage
                .enterSearchedValue()
                .pressSearchButton();

        List<String> secondEngineLinks = new ArrayList<>(bingSearchResultsPage.getBingSearchedLinks());

        log.info("Second engine resulted links: " + secondEngineLinks);

        firstEngineLinks.retainAll(secondEngineLinks);

        assertThat(firstEngineLinks.size() > 0).isTrue();

        System.out.printf("Search results have %s links in common in %s browser: " + firstEngineLinks + "\n", firstEngineLinks.size(), getProperty("browser").toUpperCase(Locale.ROOT));
    }
}