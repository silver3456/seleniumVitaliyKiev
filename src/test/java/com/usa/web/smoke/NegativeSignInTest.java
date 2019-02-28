package com.usa.web.smoke;

import com.usa.web.TestRunner;
import com.usa.web.pages.main_page.MainPage;
import com.usa.web.pages.sign_in_page.SignInPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.usa.web.utils.PropertyLoader.*;

public class NegativeSignInTest extends TestRunner {
    private MainPage mainPage;
    private SignInPage signInPage;

    private final static String BROKEN_EMAIL = "dfs@";
    private final static String VALID_PASSWORD = "silver.best";
    private String errorMessage = "Please enter a valid email address.";

    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void loginWithInvalidUsernameTest() {
        mainPage
                .open(getBaseUrl())
                .getSignInPage()
                .fillSignInForm(BROKEN_EMAIL, VALID_PASSWORD)
                .verifyError(errorMessage);
    }
}
