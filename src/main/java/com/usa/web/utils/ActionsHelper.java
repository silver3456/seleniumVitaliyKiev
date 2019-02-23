package com.usa.web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.usa.web.utils.ElementHelper.getTypeLocator;


public class ActionsHelper {
    public static void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver)
                .moveToElement(driver.findElement(getTypeLocator(locator)))
                .build()
                .perform();
    }
}
