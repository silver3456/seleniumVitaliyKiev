package com.usa.web.pages.sign_in_page;

import com.usa.web.utils.ElementHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class SignInPage {
    private WebDriver driver;
    private ElementHelper helper;
    private static Logger LOG = Logger.getLogger(SignInPage.class.getName());

    private static final String USERNAME = "//input[@name = 'username']";
    private static final String PASSWORD = "//input[@name = 'password']";
    private static final String SIGN_IN_BUTTON = "//div[@class = 'emailSignInForm']//button[@type = 'submit']";
    private static final String ERROR_MESSAGE = "//div[@class = 'errorLabel']";


    public SignInPage(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    public SignInPage fillSignInForm(String email, String password){
        LOG.info("Fill form on Sign Page");
        helper.enterText(USERNAME, email);
        helper.enterText(PASSWORD,password );
        helper.clickOnElement(SIGN_IN_BUTTON);
        return this;
    }

    public void verifyError(String expectedErrorMessage){
        LOG.info("verify error");
        Assert.assertEquals(helper.getText(ERROR_MESSAGE), expectedErrorMessage);
    }
}
