package com.usa.web.utils;

import java.util.Random;

public class StringRandomGenerator {

    private static String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toLowerCase();

    public static String generateEmail() {
        return generateString() + "@gmail.com";

    }


    public static String generatePassword() {
        return generateString();

    }

    public static String generateString() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(allChars.length());
            builder.append(allChars.charAt(index));
        }
        return builder.toString();
    }


}
