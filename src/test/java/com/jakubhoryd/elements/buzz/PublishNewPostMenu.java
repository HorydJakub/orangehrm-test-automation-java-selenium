package com.jakubhoryd.elements.buzz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PublishNewPostMenu {

    private WebDriverWait wait;

    private static final By POST_TEXT_CONTENT_TEXTAREA_LOCATOR = By.cssSelector("div.oxd-buzz-post--active textarea");
    private static final By POST_BUTTON_LOCATOR = By.cssSelector("div.oxd-buzz-post-slot button");

    public PublishNewPostMenu(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public PublishNewPostMenu enterPostText(String text) {
        WebElement textArea = wait.until(visibilityOfElementLocated(POST_TEXT_CONTENT_TEXTAREA_LOCATOR));
        textArea.sendKeys(text);
        return this;
    }

    public void clickPostButton() {
        WebElement postButton = wait.until(visibilityOfElementLocated(POST_BUTTON_LOCATOR));
        postButton.click();
    }
}
