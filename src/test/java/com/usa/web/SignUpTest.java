package com.usa.web;

import com.usa.web.pages.main_page.MainPage;
import com.usa.web.pages.sign_up_page.SignUpPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.usa.web.utils.PropertyLoader.getBaseUrl;

public class SignUpTest extends TestRunner {
    private MainPage mainPage;
    private SignUpPage signUpPage;

    private final static String BROKEN_EMAIL = "dfs@";
    private final static String BROKEN_PASSWORD = "fdfs";
    private String errorMessage = "Email address is not dsfsd";


    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage(driver);
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void verifyNegativeAttemptToSignUp() {
        mainPage.open(getBaseUrl());
        signUpPage
                .login(BROKEN_EMAIL, BROKEN_PASSWORD)
                .verifyEmailErrorMessage(errorMessage);
    }
}
