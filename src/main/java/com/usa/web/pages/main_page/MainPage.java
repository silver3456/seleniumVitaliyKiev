package com.usa.web.pages.main_page;

import com.usa.web.pages.main_page.component.JobsPage;
import com.usa.web.pages.main_page.component.SearchBar;
import com.usa.web.pages.sign_in_page.SignInPage;
import com.usa.web.utils.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.usa.web.utils.ElementHelper.*;

public class MainPage {
    private WebDriver driver;
    private SearchBar searchBar;
    private JobsPage jobsPage;

    private static final String SignInLink = "//li[@class = 'sign-in']//a[text()= 'Sign In']";

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

    public SignInPage getSignInPage() {
        driver.findElement(getTypeLocator(SignInLink)).click();
        return new SignInPage(driver);
    }
}
