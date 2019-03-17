package com.usa.web.pages.search_result_page;

import com.usa.web.utils.ElementHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.usa.web.utils.ElementHelper.getTypeLocator;
import static java.lang.String.format;

public class SearchResultPage {
    private WebDriver driver;
    private ElementHelper helper;

    private static Logger LOG = Logger.getLogger(SearchResultPage.class.getName());

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    private static final String PAGE_CONTENT_BLOCK = "#JobResults";

    public SearchResultPage verifyPageLoaded(){
        Assert.assertTrue(helper.waitUntilElementDisplayed(PAGE_CONTENT_BLOCK));
        return this;
    }

    private static final String JOB_BLOCK = "//article[@id = 'MainCol']//li[@class='jl']";
    private static final String JOB_TITLE_BLOCK =  ".//div[contains(@class, 'jobTitle')]";

    public SearchResultPage verifyJobsBlockContainsTitle(String title) {
        List<WebElement> blocks = driver.findElements(getTypeLocator(JOB_BLOCK));
        List<String> actualJobsTitle = new ArrayList<>();

        for (WebElement block: blocks) {
            String blockTitle = block.findElement(getTypeLocator(JOB_TITLE_BLOCK)).getText().trim();
            actualJobsTitle.add(blockTitle);
        }

        for (int i = 0; i < actualJobsTitle.size(); i++)  {
            Assert.assertTrue(actualJobsTitle.get(i).toLowerCase().contains(title.toLowerCase()),
                    format("Current: %s, Expected: %s, index: %s", actualJobsTitle.get(i), title, i + 1));
        }

        return this;
    }
}
