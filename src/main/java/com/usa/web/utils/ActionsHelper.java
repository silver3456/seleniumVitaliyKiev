package com.usa.web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

<<<<<<< HEAD
import static com.usa.web.utils.ElementHelper.*;

public class ActionsHelper {
    public static void hoverToElement(WebDriver driver, String locator){
        new Actions(driver)
                           .moveToElement(driver.findElement(getTypeLocator(locator)))
                           .build()
                           .perform();
=======
import static com.usa.web.utils.ElementHelper.getTypeLocator;


public class ActionsHelper {
    public static void hoverToElement(WebDriver driver, String locator) {
        new Actions(driver)
                .moveToElement(driver.findElement(getTypeLocator(locator)))
                .build()
                .perform();
>>>>>>> 5931801dfe7e64639bb95fa068f1432753501372
    }
}
