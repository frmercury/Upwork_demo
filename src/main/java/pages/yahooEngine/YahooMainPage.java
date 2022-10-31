package pages.yahooEngine;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static helpers.Loader.loadProperty;

public class YahooMainPage extends BasePage {

    public YahooMainPage() {
        super("Yahoo Main Page");
    }

    private final SelenideElement yahooSearchField = $x("//input[@id = 'ybar-sbq']");
    private final SelenideElement yahooDropdownSearchButton = $x("//button[@id='ybar-search']");


    public YahooMainPage enterSearchedValue() {
        yahooSearchField.shouldBe(Condition.visible).sendKeys(loadProperty("search.value"));
        return this;
    }

    public YahooSearchResultsPage pressSearchButton() {
        yahooDropdownSearchButton.shouldBe(Condition.visible).click();
        waitPageToLoad();
        webdriver().shouldHave(urlContaining("search"));
        return new YahooSearchResultsPage();
    }
}