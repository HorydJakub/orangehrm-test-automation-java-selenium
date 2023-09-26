package com.jakubhoryd.utils;

import java.io.IOException;

public class PropertyHelper {

    public static int getWaitingTimeForElements() throws IOException {
        return Integer.parseInt(PropertiesLoader.loadProperty("wait.timeToWaitForElement"));
    }
}