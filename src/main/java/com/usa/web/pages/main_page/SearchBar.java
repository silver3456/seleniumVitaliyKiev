package com.usa.web.pages.main_page;

import com.usa.web.pages.search_result_page.SearchResultPage;
import com.usa.web.utils.ElementHelper;
import org.openqa.selenium.WebDriver;

public class SearchBar {

    private WebDriver driver;
    private ElementHelper helper;


    public SearchBar(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    private static final String KEYWORD_INPUT = "#KeywordSearch";
    private static final String LOCATION_INPUT = "#LocationSearch";
    private static final String SEARCH_BUTTON = "#HeroSearchButton";

    public SearchResultPage search(String searchRequest, String location){
        helper.enterText(KEYWORD_INPUT, searchRequest);
        helper.enterText(LOCATION_INPUT, location);
        helper.clickOnElement(SEARCH_BUTTON);

        return new SearchResultPage(driver);
    }
}
