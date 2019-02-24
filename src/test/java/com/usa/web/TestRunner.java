package com.usa.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
=======
import org.openqa.selenium.chrome.ChromeOptions;
>>>>>>> 5931801dfe7e64639bb95fa068f1432753501372
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class TestRunner {
    protected WebDriver driver;

<<<<<<< HEAD

    @BeforeClass
    public void beforeSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();

=======
    @BeforeClass
    public void beforeSetUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
>>>>>>> 5931801dfe7e64639bb95fa068f1432753501372
    }

    @AfterClass
    public void afterSuiteTearDown() {
        driver.quit();
    }
}
