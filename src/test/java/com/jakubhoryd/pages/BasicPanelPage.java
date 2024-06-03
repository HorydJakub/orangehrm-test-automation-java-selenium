package com.jakubhoryd.pages;

import com.jakubhoryd.elements.Sidenav;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasicPanelPage {

    public Sidenav sidenav;
    private WebDriverWait wait;
    private static final By SUCCESS_INDICATOR = By.cssSelector(".oxd-toast--success ");
    public BasicPanelPage(WebDriver driver, WebDriverWait wait) {
        this.sidenav = new Sidenav(driver);
        this.wait = wait;
    }

    public void waitForSuccessIndicator() {
        wait.until(visibilityOfElementLocated(SUCCESS_INDICATOR));
    }
}
