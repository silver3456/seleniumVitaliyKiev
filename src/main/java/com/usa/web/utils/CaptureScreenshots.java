package com.usa.web.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static com.google.common.io.Files.*;

public class CaptureScreenshots {

    private static Logger LOG = Logger.getLogger(CaptureScreenshots.class.getName());

    public static void captureScreen(WebDriver driver, String status) {

        File tmp = null;

        final String baseDir = System.getProperty("user.dir");

        try {
            tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File srcFile = new File(String.format("%s/screenshots_%s/screen-%s.png", baseDir, status.toLowerCase(), System.currentTimeMillis()));
            copy(tmp, srcFile);
        } catch (IOException e) {
            LOG.info(e.getMessage());
        } finally {

            if (tmp != null) {
                tmp.deleteOnExit();
            }
        }
    }

    public static byte[] captureScreenByte(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
