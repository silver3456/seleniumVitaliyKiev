package com.usa.web.pages.main_page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainPage {
    private WebDriver driver;
    private SearchBar searchBar;
    private JobsPage jobsPage;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        searchBar = new SearchBar(driver);
        jobsPage = new JobsPage(driver);
    }

    public MainPage open(String url) {
        driver.get(url);
        return this;
    }

    public void verifyTitle(String title) {
        Assert.assertTrue(driver.getTitle().equals(title));
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isTitleEqual(String expectedTitle) {
        return driver.getTitle().equals(expectedTitle);
    }

    public SearchBar getSearchBar() {
        return searchBar;
    }

    public JobsPage getJobsPage() {
        return jobsPage;
    }
}
