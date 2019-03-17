package com.usa.web.proxy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.HttpRequest;

import java.util.List;
import java.util.Set;

public class ProxyDriver implements WebDriver {
    private WebDriver driver;

    public ProxyDriver(WebDriver driver) {
        this.driver = driver;
    }

    // http request ->

    @Override
    public void get(String url) {
        System.out.println("METHOD GET WAS CALLED, DO SMTH BEFORE");
        String formatedUrl = url.trim().toLowerCase();
        driver.get(formatedUrl);//original method invocation
        System.out.println("METHOD GET WAS CALLED, DO SMTH AFTER");
    }

    @Override
    public String getCurrentUrl() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public String getPageSource() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return null;
    }
}
