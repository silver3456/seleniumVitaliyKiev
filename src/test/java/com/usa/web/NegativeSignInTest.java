package com.usa.web;

import com.usa.web.pages.main_page.MainPage;
import com.usa.web.test_data.DataGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.usa.web.utils.PropertyLoader.getBaseUrl;

public class NegativeSignInTest extends TestRunner {
    private MainPage mainPage;


    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage(driver);
    }

    @Test(dataProvider = "Authentication", dataProviderClass = DataGenerator.class)
    public void loginWithInvalidUsernameTest(String email, String password, String expectedErrorMessage) {
        mainPage
                .open(getBaseUrl())
                .goToSignInPage()
                .fillSignInForm(email, password)
                .verifyError(expectedErrorMessage);
    }
}
