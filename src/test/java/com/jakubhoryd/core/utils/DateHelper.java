package com.jakubhoryd.utils;

import java.text.SimpleDateFormat;

public class DateHelper {

    public static String getCurrentTimeStamp() {
        return new SimpleDateFormat("dd.MM.yyyy.HH.mm").format(new java.util.Date());
    }

    public static String getCurrentYear() {
        return new SimpleDateFormat("yyyy").format(new java.util.Date());
    }
}
