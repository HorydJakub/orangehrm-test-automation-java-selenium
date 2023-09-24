package com.jakubhoryd.pages;

import com.jakubhoryd.utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginPage {

    private final WebDriverWait wait;
    @FindBy(css = "input[name='username']")
    private WebElement usernameInput;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "button.orangehrm-login-button")
    private WebElement loginBtn;

    @FindBy(css = "div.orangehrm-login-error p.oxd-alert-content-text")
    public WebElement invalidCredentialsWarning;

    public LoginPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
        int timeToWaitForElement = Integer.parseInt(PropertiesLoader.loadProperty("wait.timeToWaitForElement"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitForElement));
    }

    public void login(String username, String password) {
        wait.until(elementToBeClickable(usernameInput)).sendKeys(username);
        wait.until(elementToBeClickable(passwordInput)).sendKeys(password);
        wait.until(elementToBeClickable(loginBtn)).click();
    }

}
