package com.usa.web.pages.search_result_page;

import com.usa.web.pages.main_page.MainPage;
import com.usa.web.utils.ElementHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchResultPage {
    private WebDriver driver;
    private ElementHelper helper;

    private static Logger LOG = Logger.getLogger(SearchResultPage.class.getName());

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    private static final String PAGE_CONTENT_BLOCK = "#JobResults";

    public void verifyPageLoaded(){
        Assert.assertTrue(helper.waitUntilElementDisplayed(PAGE_CONTENT_BLOCK));
    }
}
