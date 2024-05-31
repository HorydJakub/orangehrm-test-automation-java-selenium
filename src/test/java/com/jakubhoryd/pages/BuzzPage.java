package com.jakubhoryd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeSelected;

public class BuzzPage {

    private final WebDriverWait wait;

    @FindBy(css = "div.oxd-buzz-post--active textarea")
    public WebElement postTextContentTextarea;

    @FindBy(css = "div.oxd-buzz-post-slot button")
    public WebElement postButton;

    public BuzzPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public BuzzPage publishNewPost(String text) {
        wait.until(elementToBeClickable(postTextContentTextarea)).sendKeys(text);
        wait.until(elementToBeClickable(postButton)).click();
        return this;
    }
}
