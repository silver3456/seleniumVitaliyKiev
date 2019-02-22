package com.usa.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.util.concurrent.TimeUnit.SECONDS;


public class TestRunner {
    protected WebDriver driver;
    private static final int IMPLICITLY_WAIT = 4;

    @BeforeSuite
    public void beforeSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, SECONDS);

    }

    @AfterSuite
    public void afterSuiteTearDown() {
        driver.quit();
    }
}
