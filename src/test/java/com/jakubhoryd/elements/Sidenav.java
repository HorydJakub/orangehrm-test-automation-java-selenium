package com.jakubhoryd.elements;

import com.jakubhoryd.core.utils.PropertyHelper;
import com.jakubhoryd.enums.NavmenuOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Sidenav {

    private final WebDriverWait wait;

    public Sidenav(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyHelper.getWaitingTimeForElements()));
    }

    public Sidenav goToMenu(NavmenuOption menuOption) {
        String menuXPath = String.format("//li[@class='oxd-main-menu-item-wrapper']//span[text()='%s']", menuOption.getOption());
        WebElement menuElement = wait.until(driver -> driver.findElement(By.xpath(menuXPath)));
        menuElement.click();
        return this;
    }
}
