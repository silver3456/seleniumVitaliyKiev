package com.usa.web.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;

public class ElementHelper {
    private WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public String getText(String locator) {
        return driver.findElement(getTypeLocator(locator)).getText().trim();
    }

    public void enterText(String locator, String text) {
        System.out.println(format("Clear and set text: %s to an element with locator: %s", text, locator));
        driver.findElement(getTypeLocator(locator)).clear();
        driver.findElement(getTypeLocator(locator)).sendKeys(text);
    }

    public void clickOnElement(String locator) {
        System.out.println("CLick on element with locator: " + locator);
        driver.findElement(getTypeLocator(locator)).click();
    }

    //method overloading. wait by default 8 seconds
    public boolean waitUntilElementDisplayed(String locator) {
      return waitUntilElementDisplayed(locator, 8);
    }

    //use this method when we want ot specify how many seconds to wait
    public boolean waitUntilElementDisplayed(String locator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        try {
            wait.until(driver -> driver.findElement(getTypeLocator(locator)).isDisplayed());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static By getTypeLocator(String locator){
        if (locator.startsWith("//") || locator.startsWith("/")){
            return By.xpath(locator);
        }

        return By.cssSelector(locator);
    }
}
