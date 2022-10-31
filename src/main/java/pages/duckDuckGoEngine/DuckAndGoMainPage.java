package pages.duckDuckGoEngine;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static helpers.Loader.loadProperty;

public class DuckAndGoMainPage extends BasePage {

    public DuckAndGoMainPage() {
        super("Duck'N'Go Main Page");
    }

    private final SelenideElement dngSearchField = $x("//input[@id = 'search_form_input_homepage']");
    private final SelenideElement dngSearchButton = $x("//input[@id = 'search_button_homepage']");


    public DuckAndGoMainPage enterSearchedValue() {
        dngSearchField.shouldBe(Condition.visible).sendKeys(loadProperty("search.value"));
        return this;
    }

    public DnGSearchResultsPage pressSearchButton() {
        dngSearchButton.shouldBe(Condition.visible).click();
        return new DnGSearchResultsPage();
    }
}
