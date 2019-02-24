package com.usa.web.pages.main_page.component;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.usa.web.utils.ElementHelper.getTypeLocator;

public class JobsByCity {
    private WebDriver driver;
    private static final String CITY_ELEMENT = "//*[@id='jobTitle']";

    public JobsByCity(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyJobsInRightCity(String cityName) {
        Assert.assertTrue(driver.findElement(getTypeLocator(CITY_ELEMENT)).getText().equals(cityName));
    }
}
