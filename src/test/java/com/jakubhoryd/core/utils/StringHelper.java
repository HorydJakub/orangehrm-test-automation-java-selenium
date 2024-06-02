package com.jakubhoryd.core.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class StringHelper {

    public static String getUniqueStringFromCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.HH.mm.ss");
        String formattedDate = LocalDateTime.now().format(formatter);
        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 8); // Losowy ciąg znaków o długości 8
        return formattedDate + "." + randomString;
    }
}
