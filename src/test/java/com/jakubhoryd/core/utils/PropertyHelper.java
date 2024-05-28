package com.jakubhoryd.utils;

import java.io.IOException;

public class PropertyHelper {

    public static int getWaitingTimeForElements() throws IOException {
        return Integer.parseInt(PropertiesLoader.loadProperty("wait.timeToWaitForElement"));
    }

    public static String getFailedTestsScreenshotDirectory() throws IOException {
        return PropertiesLoader.loadProperty("path.failedTestsScreenshotDirectory");
    }

    public static String getPreferedScreenshotExtension() throws IOException {
        return PropertiesLoader.loadProperty("screenshot.preferedScreenshotExtension");
    }

    public static String getProdEnvironment() throws IOException {
        return PropertiesLoader.loadProperty("environment.prod");
    }

    public static String getDeploymentVersion() throws IOException {
        return PropertiesLoader.loadProperty("deployment.version");
    }
}