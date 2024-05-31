package com.jakubhoryd.pages;

import com.jakubhoryd.elements.Navbar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class DashboardPage extends BasicPanelPage{

    public Navbar navbar;
    private WebDriverWait wait;

    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.navbar = new Navbar(driver);
        this.wait = wait;
    }
}