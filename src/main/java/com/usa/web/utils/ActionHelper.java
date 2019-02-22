package com.usa.web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;

public class ActionHelper {
    public static void hoverToElement (WebDriver driver, String locator) {
        new Actions(driver)
                .moveToElement(driver.findElement(xpath(locator)))
                .build()
                .perform(); //hover over an element
    }
}
