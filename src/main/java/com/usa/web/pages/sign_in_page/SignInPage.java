package com.usa.web.pages.sign_in_page;

import com.usa.web.utils.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class SignInPage {
    private WebDriver driver;
    private ElementHelper helper;

    private static final String USERNAME = "//input[@name = 'username']";
    private static final String PASSWORD = "//input[@name = 'password']";
    private static final String SIGN_IN_BUTTON = "//div[@class = 'emailSignInForm']//button[@type = 'submit']";
    private static final String ERROR_MESSAGE = "//div[@class = 'errorLabel']";


    public SignInPage(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    public SignInPage fillSignInForm(String email, String password){
        helper.enterText(USERNAME, email);
        helper.enterText(PASSWORD,password );
        helper.clickOnElement(SIGN_IN_BUTTON);
        return this;
    }

    public void verifyError(String errorMessage){
        String error = driver.findElement(By.xpath((ERROR_MESSAGE))).getText();
        Assert.assertEquals(error, errorMessage);
    }
}
