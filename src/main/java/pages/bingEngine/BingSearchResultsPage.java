package pages.bingEngine;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;


import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.System.getProperty;

public class BingSearchResultsPage extends BasePage {

    private static Logger log;

    public BingSearchResultsPage() {
        super("Bing Search Results Page");
    }

    private final ElementsCollection bingHrefs = $$x("//li/h2/a[1]");
    private final SelenideElement bingHref = $x("//li[1]/h2/a[1]");

    public List<String> getBingSearchedLinks() {
        List<String> bingHrefList = new ArrayList<>();
        for (WebElement href: bingHrefs) {
            bingHrefList.add(href.getAttribute("href"));
        }
//        if (!getProperty("env").equals("chrome")) {
//            getExactUrl(bingHrefList);
//        }
        return bingHrefList;
    }



    public static void getExactUrl(String url) {
        Map<String, String> queryParams = getQueryParamsMap(url);
        
        log.info(queryParams.getOrDefault("r", url));
    }

    public static Map<String, String> getQueryParamsMap(String url) {
        Map<String, String> queryParamsMap = new HashMap<>();
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            List<NameValuePair> queryParams = uriBuilder.getQueryParams();
            queryParamsMap = queryParams.stream().collect(Collectors.toMap(NameValuePair::getName, NameValuePair::getValue));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return queryParamsMap;
    }
}
