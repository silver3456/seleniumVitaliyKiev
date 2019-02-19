package com.usa.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JobsInChicago {
    private WebDriver driver;
    private static final String CITY = "//*[@id='jobTitle']";

    public JobsInChicago(WebDriver driver) {
        this.driver = driver;
    }

    public void jobsInRightCity(String cityName) {
        Assert.assertTrue(driver.findElement(By.xpath(CITY)).getText().equals(cityName));
    }
}
