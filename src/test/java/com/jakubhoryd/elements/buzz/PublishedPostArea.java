package com.jakubhoryd.elements.buzz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class PublishedPostArea {

    private WebDriverWait wait;

    private static final By POSTS_BODY_TEXT_LOCATOR = By.cssSelector("p.orangehrm-buzz-post-body-text");

    public PublishedPostArea(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public WebElement getNewestPost() {
        return wait.until(visibilityOfElementLocated(POSTS_BODY_TEXT_LOCATOR));
    }

    public String getTextPostContentFromNewestPost() {
        return getNewestPost().getText();
    }
}
