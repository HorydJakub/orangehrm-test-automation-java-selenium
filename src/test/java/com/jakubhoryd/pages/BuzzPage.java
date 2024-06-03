package com.jakubhoryd.pages;

import com.jakubhoryd.elements.buzz.PublishNewPostMenu;
import com.jakubhoryd.elements.buzz.PublishedPostArea;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuzzPage extends BasicPanelPage {

    public final PublishNewPostMenu publishNewPostMenu;
    public final PublishedPostArea publishedPostArea;

    public BuzzPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
        publishNewPostMenu = new PublishNewPostMenu(driver, wait);
        publishedPostArea = new PublishedPostArea(driver, wait);
    }
}
