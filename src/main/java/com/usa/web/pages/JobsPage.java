package com.usa.web.pages;

import com.usa.web.utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class JobsPage {

    private WebDriver driver;
    private Actions action;
    protected ElementHelper helper;

    private static final String JOBS_LINK = "//*[@id='TopNav']//a[text() = 'Jobs']";
   // private static final String CHICAGO_CITY = "//*[@id='TopNav']//a[text() = 'Chicago']";
    private static final String CHICAGO_CITY = "//*[@id=\"TopNav\"]/nav/div[2]/ul[2]/li[2]/div/ul[2]/li[2]/a";
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

    public JobsInChicago verifyJobs()  {
        action.moveToElement(driver.findElement(By.xpath(JOBS_LINK))).build().perform(); //hover over an element
        helper.isElementDisplayed(CHICAGO_CITY);
        driver.findElement(By.xpath(CHICAGO_CITY)).click();
        return new JobsInChicago(driver);
    }
}
