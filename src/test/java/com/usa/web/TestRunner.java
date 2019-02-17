package com.usa.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestRunner {
    protected WebDriver driver;


    @BeforeSuite
    public void beforeSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterSuite
    public void afterSuiteTearDown() {
        driver.quit();
    }
}
