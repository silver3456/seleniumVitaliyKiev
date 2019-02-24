package com.usa.web.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static Properties properties = loadProperties();

    public static String getProperty(String key) {
        return properties.getProperty(key);

    }

    public static String getBaseUrl(){
        return getProperty("base.url");
    }

    public static int getDefaultWait(){
        return Integer.parseInt(getProperty("default.wait"));
    }

    public static void main(String[] args) {
        System.out.println(getProperty("base.url"));
    }



    private static Properties loadProperties() {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("application.properties")) {
            prop.load(input);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return prop;
    }
}
