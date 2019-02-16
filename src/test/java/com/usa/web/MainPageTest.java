package com.usa.web;


import com.usa.web.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

public class MainPageTest extends TestRunner {
    protected MainPage mainPage;

    private static final String EXPECTED_TITLE = "Google";
    private static final String BASE_URL = "https://www.google.com";


    @Test
    public void verifyTitleTest() {
        mainPage.open(BASE_URL);
        mainPage.verifyTitle(EXPECTED_TITLE);

        Assert.assertEquals(mainPage.getTitle(), EXPECTED_TITLE);
        Assert.assertTrue(mainPage.isTitleEqual(EXPECTED_TITLE));

    }

    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage(driver);
    }

}
