package com.usa.web;


<<<<<<< HEAD
=======
import com.usa.web.pages.main_page.component.JobsByCity;
>>>>>>> 5931801dfe7e64639bb95fa068f1432753501372
import com.usa.web.pages.main_page.MainPage;
import com.usa.web.pages.search_result_page.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class MainPageTest extends TestRunner {
    protected MainPage mainPage;

    private static final String EXPECTED_TITLE = "Glassdoor Job Search | Find the job that fits your life";
<<<<<<< HEAD
    private static final String BASE_URL = "https://www.glassdoor.com";
=======
    private static final String BASE_URL = "https://www.glassdoor.com/index.html";
>>>>>>> 5931801dfe7e64639bb95fa068f1432753501372
    private static final String SEARCH_REQUEST = "QA Automaion";
    private static final String LOCATION_REQUEST = "San Francisco";

    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage(driver);
<<<<<<< HEAD

    }

=======
    }

    @AfterClass
    public void afterClass() {
    }
>>>>>>> 5931801dfe7e64639bb95fa068f1432753501372

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

    private static final String CITY = "Chicago";
    private static final String EXPECTED_CITY = "Jobs in Chicago, IL";

    @Test
<<<<<<< HEAD
    public void verifyJobsByCityTest() {
        mainPage
                .open(BASE_URL)
                .getJobsPage()
                .selectByCityName("Chicago")
                .verifyJobsInRightCity("Jobs in Chicago, IL");
    }

=======
    public void verifyJobsByCityTest()  {
        mainPage.open(BASE_URL)
                .getJobsPage()
                .selectJobByCityName(CITY)
                .verifyJobsInRightCity(EXPECTED_CITY);
    }
>>>>>>> 5931801dfe7e64639bb95fa068f1432753501372
}
