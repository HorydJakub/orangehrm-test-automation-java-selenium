package com.jakubhoryd.core.utils;

public class PropertyHelper {

    public static Integer getWaitingTimeForElements() {
        return PropertiesLoader.loadProperty("wait.timeToWaitForElement", Integer.class);
    }

    public static String getFailedTestsScreenshotDirectory() {
        return PropertiesLoader.loadProperty("path.failedTestsScreenshotDirectory");
    }

    public static String getPreferredScreenshotExtension() {
        return PropertiesLoader.loadProperty("screenshot.preferredScreenshotExtension");
    }

    public static String getProdEnvironment() {
        return PropertiesLoader.loadProperty("environment.prod");
    }

    public static String getDeploymentVersion() {
        return PropertiesLoader.loadProperty("deployment.version");
    }

    public static String getTestrailUri() {
        return PropertiesLoader.loadProperty("testrail.uri");
    }

    public static String getTestrailUsername() {
        return PropertiesLoader.loadProperty("testrail.username");
    }

    public static String getTestrailApiKey() {
        return PropertiesLoader.loadProperty("testrail.apiKey");
    }

    public static Boolean getTestrailEnabled() {
        return PropertiesLoader.loadProperty("testrail.enabled", Boolean.class);
    }

    public static Integer getTestrailRunId() {
        return PropertiesLoader.loadProperty("testrail.runId", Integer.class);
    }
}
