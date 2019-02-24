package com.usa.web.smoke;

import com.usa.web.TestRunner;
import com.usa.web.pages.login_page.SignUpPage;
import com.usa.web.pages.main_page.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.usa.web.utils.PropertyLoader.*;

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
