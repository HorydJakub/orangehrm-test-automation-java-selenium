package com.jakubhoryd.pages;

import com.jakubhoryd.elements.Navbar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasicPanelPage{

    public Navbar navbar;

    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.navbar = new Navbar(driver);
    }
}