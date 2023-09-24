package com.jakubhoryd.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class DriverFactory {


    public static WebDriver getDriver() throws IOException {
        String browserName = PropertiesLoader.loadProperty("browser.name");

        switch (browserName) {
            case "chrome" -> {
                return new ChromeDriver();
            }
            case "firefox" -> {
                return new FirefoxDriver();
            }
        }
        return null;
    }
}
