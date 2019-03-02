package com.usa.web.test_data;
import org.testng.annotations.DataProvider;

import static com.usa.web.utils.StringRandomGenerator.*;

public class DataGenerator {

    @DataProvider(name = "Authentication")

    public static Object[][] credentials() {

        return new Object[][]{
                {"Test@123", "testuser_1ree", "Please enter a valid email address."},
                {generateEmail(), generatePassword(), "The username and password you specified are invalid. Please try again."},
                {generateEmail(), generatePassword(), "The username and password you specified are invalid. Please try again."}
        };

    }
}
