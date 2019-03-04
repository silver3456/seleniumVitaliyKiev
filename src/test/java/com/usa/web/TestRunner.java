package com.usa.web;


import com.usa.web.listeners.LogListener;
import com.usa.web.utils.CaptureScreenshots;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.usa.web.utils.PropertyLoader.*;


@Listeners(value = {LogListener.class})
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
    public void beforeTest() {
        driver.manage().deleteAllCookies();
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        String status = ITestResult.FAILURE == result.getStatus() ? "FAILURE" : "SUCCESS";
        CaptureScreenshots.captureScreen(driver, status.toLowerCase());
    }

    @AfterClass
    public void afterSuiteTearDown() {
        driver.quit();
    }
}
