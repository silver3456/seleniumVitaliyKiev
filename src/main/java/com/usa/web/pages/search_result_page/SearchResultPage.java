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
<<<<<<< HEAD:src/main/java/com/usa/web/pages/search_result_page/SearchResultPage.java
        Assert.assertTrue(helper.waitTillElementDisplayed(PAGE_CONTENT_BLOCK));
=======
        Assert.assertTrue(helper.waitUntilElementDisplayed(PAGE_CONTENT_BLOCK));
>>>>>>> 5931801dfe7e64639bb95fa068f1432753501372:src/main/java/com/usa/web/pages/search_result_page/SearchResultPage.java
    }
}
