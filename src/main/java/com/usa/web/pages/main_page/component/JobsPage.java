package com.usa.web.pages.main_page.component;

import com.usa.web.utils.ElementHelper;
import org.openqa.selenium.WebDriver;

import static com.usa.web.utils.ActionsHelper.hoverToElement;
import static java.lang.String.format;

public class JobsPage {
    private WebDriver driver;
    private ElementHelper helper;

    private static final String JOBS_LINK = "//*[@id='TopNav']//a[text() = 'Jobs']";
    private static final String PATTERN_CITY = "//*[@id='TopNav']//following-sibling::li[contains(*, '%s Jobs')]";

    public JobsPage(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    public JobsByCity selectJobByCityName(String cityName)  {
        hoverToElement(driver, JOBS_LINK);
        helper.waitUntilElementDisplayed(format(PATTERN_CITY, cityName));
        helper.clickOnElement(format(PATTERN_CITY, cityName));

        return new JobsByCity(driver);
    }
}
