package com.usa.web.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {
    private WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String locator, String text) {
        driver.findElement(getTypeLocator(locator)).clear();
        driver.findElement(getTypeLocator(locator)).sendKeys(text);
    }

    public void clickOnElement(String locator) {
        driver.findElement(getTypeLocator(locator)).click();
    }

    //method overloading. wait by default 8 seconds
<<<<<<< HEAD
    public boolean waitTillElementDisplayed(String locator) {
      return waitTillElementDisplayed(locator, 8);
    }

    //use this method when we want ot specify how many seconds to wait

    public boolean waitTillElementDisplayed(String locator, int timeOutInSeconds) {
=======
    public boolean waitUntilElementDisplayed(String locator) {
      return waitUntilElementDisplayed(locator, 8);
    }

    //use this method when we want ot specify how many seconds to wait
    public boolean waitUntilElementDisplayed(String locator, int timeOutInSeconds) {
>>>>>>> 5931801dfe7e64639bb95fa068f1432753501372
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            wait.until(driver -> driver.findElement(getTypeLocator(locator)).isDisplayed());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

<<<<<<< HEAD
    public static By getTypeLocator(String locator){
        if (locator.startsWith("//") || locator.startsWith("/")){
            return By.xpath(locator);
        }
=======
    public static By getTypeLocator(String locator) {
        if (locator.startsWith("//") || locator.startsWith("/")) {
            return By.xpath(locator);
        }

>>>>>>> 5931801dfe7e64639bb95fa068f1432753501372
        return By.cssSelector(locator);
    }
}
