package com.jakubhoryd.pages;

import com.jakubhoryd.elements.Navbar;
import com.jakubhoryd.utils.PropertyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class DashboardPage {

    private final WebDriverWait wait;

    public Navbar navbar;

    public DashboardPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyHelper.getWaitingTimeForElements()));
        this.navbar = new Navbar(driver);
    }
}