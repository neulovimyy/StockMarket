package com.gtormo.StockMarket.util;

import org.springframework.scheduling.annotation.Async;

import java.util.Random;

public class StringUtil {


    private static final String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static StringUtil stringUtil;
    private StringUtil() {

    }

    public static StringUtil getInstance() {
        if(stringUtil == null) {
            stringUtil = new StringUtil();
        }
        return stringUtil;
    }

    public String randomString(int length) {
        StringBuilder output = new StringBuilder();
        Random random = new Random(capitalLetters.length());
        for(int i=1;i<=length;i++) {
            output.append(capitalLetters.charAt(random.nextInt(capitalLetters.length())));
        }
        return output.toString();
    }

}
