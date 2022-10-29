package ui;

import org.assertj.core.api.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.bingEngine.BingMainPage;
import pages.bingEngine.BingSearchResultsPage;
import pages.yahooEngine.YahooSearchResultsPage;
import pages.yahooEngine.YahooMainPage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static helpers.Loader.loadProperty;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Test
public class SearchTest extends BaseTest {

    protected Logger log = LoggerFactory.getLogger(SearchTest.class);

    private YahooMainPage yahooMainPage = new YahooMainPage();
    private YahooSearchResultsPage yahooSearchResultsPage = new YahooSearchResultsPage();
    private BingSearchResultsPage bingSearchResultsPage = new BingSearchResultsPage();
    private BingMainPage bingMainPage = new BingMainPage();

    public void searchTest() {
        open(loadProperty("search.engine.yahoo"));
        this.yahooMainPage
                .enterSearchedValue()
                .pressSearchButton();
        List<String> yahooLinks = new ArrayList<>(yahooSearchResultsPage.getYahooSearchedLinks());

        open(loadProperty("search.engine.bing"));
        this.bingMainPage
                .enterSearchedValue()
                .pressSearchButton();

        List<String> bingLinks = new ArrayList<>(bingSearchResultsPage.getBingSearchedLinks());

        yahooLinks.retainAll(bingLinks);

        assertThat(yahooLinks.size()).isNotNull();

        System.out.println("Common links \n" +yahooLinks);
    }
}