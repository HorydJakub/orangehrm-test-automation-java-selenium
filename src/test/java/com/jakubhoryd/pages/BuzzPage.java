package com.jakubhoryd.pages;

import com.jakubhoryd.elements.buzz.PublishNewPostMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuzzPage {

    private final PublishNewPostMenu publishNewPostMenu;

    public BuzzPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        publishNewPostMenu = new PublishNewPostMenu(driver, wait);
    }

    public BuzzPage publishNewPost(String text) {
        publishNewPostMenu.enterPostText(text);
        publishNewPostMenu.clickPostButton();
        return this;
    }
}