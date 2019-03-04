package com.usa.web.pages.sign_up_page;


import com.usa.web.utils.ElementHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static java.lang.String.format;

public class SignUpPage {
    private WebDriver driver;
    private ElementHelper helper;
    private static Logger LOG = Logger.getLogger(SignUpPage.class.getName());


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        helper = new ElementHelper(driver);
    }

    private static final String EMAIL_INPUT = "#userEmail";
    private static final String PASSWORD_INPUT = "#userPassword";
    private static final String SUBMIT_BUTTON = ".signUpForm button";


    public SignUpPage login(String email, String password) {
        helper.enterText(EMAIL_INPUT, email);
        helper.enterText(PASSWORD_INPUT, password);
        helper.clickOnElement(SUBMIT_BUTTON);

        return this;
    }

    private static final String ERROR_MESSAGE_LOCATOR = "//div[contains(text(), '%s')]";

    public void verifyEmailErrorMessage(String errorMessage) {
        Assert.assertTrue(helper.waitUntilElementDisplayed(format(ERROR_MESSAGE_LOCATOR, errorMessage)));
    }
}

