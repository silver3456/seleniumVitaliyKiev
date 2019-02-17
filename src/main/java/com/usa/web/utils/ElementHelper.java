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
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(text);
    }

    public void clickButton(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }


    //method overloading. wait by default 8 seconds
    public boolean isElementDisplayed(String locator) {
      return isElementDisplayed(locator, 8);
    }

    //use this method when we want ot specify how many seconds to wait

    public boolean isElementDisplayed(String locator, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

        try {
            wait.until(driver -> driver.findElement(By.cssSelector(locator)).isDisplayed());
            return true;

        } catch (TimeoutException e) {
            return false;
        }
    }
}
