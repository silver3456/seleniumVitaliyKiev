package com.usa.web;

import com.usa.web.utils.PropertyLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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

    @AfterClass
    public void afterSuiteTearDown() {
        driver.quit();
    }
}
