package com.usa.web.utils;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomCondition {
    public static ExpectedCondition<Alert> customAlert() {
        return new ExpectedCondition<Alert>() {
            @NullableDecl
            @Override
            public Alert apply(@NullableDecl WebDriver driver) {
                try {
                    return driver.switchTo().alert();
                } catch (Exception e) {
                    return null;
                }
            }
        };
    }
}
