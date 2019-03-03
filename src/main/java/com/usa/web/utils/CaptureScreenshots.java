package com.usa.web.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static com.google.common.io.Files.*;

public class CaptureScreenshots {
    private WebDriver driver;

    public CaptureScreenshots(WebDriver driver) {
        this.driver = driver;
    }

    public static void captureScreen(WebDriver driver, String status) {

        try {
            File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            if (status.equals("FAILURE")) {
                File srcFile = new File("/Users/alexander/workspace/selenium/src/test/java/screenshots_failure/screen-"
                        + System.currentTimeMillis() + ".png");
                copy(tmp, srcFile);
            } else if (status.equals("SUCCESS")) {
                File srcFile = new File("/Users/alexander/workspace/selenium/src/test/java/screenshots_success/screen-"
                        + System.currentTimeMillis() + ".png");
                copy(tmp, srcFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
