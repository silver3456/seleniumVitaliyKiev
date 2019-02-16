package com.usa.web.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
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

}
