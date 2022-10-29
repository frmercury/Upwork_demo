package pages.bingEngine;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static helpers.Loader.loadProperty;

public class BingMainPage extends BasePage {

    public BingMainPage() {
        super("Bing Search Page");
    }

    private final SelenideElement bingSearchField = $x("//input[@id = 'sb_form_q']");
    private final SelenideElement bingDropdownSearchButton = $x("//label[@id='search_icon']");


    public BingMainPage enterSearchedValue() {
        bingSearchField.shouldBe(Condition.visible).sendKeys(loadProperty("search.value"));
        return this;
    }

    public BingSearchResultsPage pressSearchButton() {
        bingDropdownSearchButton.shouldBe(Condition.visible).click();
        webdriver().shouldHave(urlContaining("search"));
        return new BingSearchResultsPage();
    }
}
