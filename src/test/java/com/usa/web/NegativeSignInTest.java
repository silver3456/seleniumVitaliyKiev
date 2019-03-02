package com.usa.web;

import com.usa.web.pages.main_page.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.usa.web.utils.PropertyLoader.getBaseUrl;

public class NegativeSignInTest extends TestRunner {
    private MainPage mainPage;

    private final static String BROKEN_EMAIL = "dfs@";
    private final static String VALID_PASSWORD = "silver.best";
    private String errorMessage = "Please enter a valid email address.";

    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void loginWithInvalidUsernameTest() {
        mainPage
                .open(getBaseUrl())
                .goToSignInPage()
                .fillSignInForm(BROKEN_EMAIL, VALID_PASSWORD)
                .verifyError(errorMessage);
    }
}
