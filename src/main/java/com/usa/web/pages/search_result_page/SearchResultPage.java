package com.usa.web.pages.search_result_page;

import com.usa.web.utils.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchResultPage {
    private WebDriver driver;
    private ElementHelper helper;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    private static final String PAGE_CONTENT_BLOCK = "#JobResults";

    public void verifyPageLoaded(){
        Assert.assertTrue(helper.waitTillElementDisplayed(PAGE_CONTENT_BLOCK));
    }
}
