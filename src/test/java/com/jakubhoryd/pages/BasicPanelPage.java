package com.jakubhoryd.pages;

import com.jakubhoryd.elements.Sidenav;
import org.openqa.selenium.WebDriver;

public class BasicPanelPage {

    public Sidenav sidenav;
    public BasicPanelPage(WebDriver driver) {
        this.sidenav = new Sidenav(driver);
    }
}
