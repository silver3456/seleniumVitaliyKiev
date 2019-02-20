package com.usa.web.pages;

import com.usa.web.utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.String.format;

public class JobsPage {

    private WebDriver driver;
    private Actions action;
    private ElementHelper helper;

    private static final String JOBS_LINK = "//*[@id='TopNav']//a[text() = 'Jobs']";
    //private static final String CHICAGO_CITY = "//*[@id=\"TopNav\"]//following-sibling::li[contains(*, \"Chicago" + " Jobs\")]"; 
    private static final String PATTERN_CITY = "//*[@id=\"TopNav\"]//following-sibling::li[contains(*, \"%s" + " Jobs\")]";  // как построить динамический локатор??
    //private WebElement jobsLink = driver.findElement(By.xpath(JOBS_LINK));

    public JobsPage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        helper = new ElementHelper(driver);
    }

//    public JobsInChicago searchJobsByCity() {
//        action.moveToElement(jobsLink).build().perform();
//        return new JobsInChicago(driver);
//    }

    public JobsInChicago verifyJobs(String cityName)  {
        action.moveToElement(driver.findElement(By.xpath(JOBS_LINK))).build().perform(); //hover over an element
        helper.isElementDisplayed(format(PATTERN_CITY, cityName));
        driver.findElement(By.xpath(format(PATTERN_CITY, cityName))).click();

        return new JobsInChicago(driver);
    }
}
