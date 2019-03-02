package com.usa.web;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static com.usa.web.utils.PropertyLoader.*;


public class TestRunner {
    protected WebDriver driver;

    @BeforeClass
    public void beforeSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(getDefaultWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeTest(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterSuiteTearDown() {
        driver.quit();
    }
}
