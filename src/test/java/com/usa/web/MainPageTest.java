package com.usa.web;


import com.usa.web.pages.JobsByCity;
import com.usa.web.pages.MainPage;
import com.usa.web.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class MainPageTest extends TestRunner {
    protected MainPage mainPage;


    private static final String EXPECTED_TITLE = "Glassdoor Job Search | Find the job that fits your life";
    private static final String BASE_URL = "https://www.glassdoor.com/index.htm";
    private static final String SEARCH_REQUEST = "QA Automaion";
    private static final String LOCATION_REQUEST = "San Francisco";


    @Test
    public void verifyTitleTest() {
        mainPage.open(BASE_URL);
        mainPage.verifyTitle(EXPECTED_TITLE);

        Assert.assertEquals(mainPage.getTitle(), EXPECTED_TITLE);
        Assert.assertTrue(mainPage.isTitleEqual(EXPECTED_TITLE));

    }

    @Test
    public void verifySearchFunction() {
        mainPage.open(BASE_URL);
        SearchResultPage resultPage = mainPage
                                              .getSearchBar()
                                              .search(SEARCH_REQUEST, LOCATION_REQUEST);
        resultPage.verifyPageLoaded();

    }

    @Test
    public void verifyJobsByCityTest()  {
        mainPage.open(BASE_URL);
        JobsByCity jobsPage = mainPage
                                         .getJobsPage()
                                         .verifyJobs("Chicago");
        jobsPage.jobsInRightCity("Jobs in Chicago, IL");
    }

    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage(driver);

    }
}
