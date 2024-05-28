package com.jakubhoryd.elements;

import com.jakubhoryd.core.utils.PropertyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Navbar {

    private final WebDriverWait wait;
    @FindBy(css = "header.oxd-topbar")
    private WebElement navbar;

    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    public WebElement title;

    public Navbar(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyHelper.getWaitingTimeForElements()));
    }

    public String getPageTitle() {
        wait.until(visibilityOf(title));
        return title.getText();
    }
}
