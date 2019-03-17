package com.usa.web;

import com.usa.web.pages.main_page.MainPage;
import com.usa.web.pages.search_result_page.SearchResultPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CollectionTest extends TestRunner {
    protected MainPage mainPage;
    String JOBS_URL = "https://www.glassdoor.com/Job/san-francisco-qa-automation-jobs-SRCH_IL.0,13_IC1147401_KO14,27.htm";

    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage(driver);
    }

    @Test
    private void test() {
        mainPage.open(JOBS_URL);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        searchResultPage.verifyJobsBlockContainsTitle("QA Automation");
    }
}
