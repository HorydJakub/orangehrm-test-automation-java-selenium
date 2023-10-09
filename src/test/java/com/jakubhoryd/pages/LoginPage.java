package com.jakubhoryd.pages;

import com.jakubhoryd.utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class LoginPage {

    private final WebDriverWait wait;
    @FindBy(css = "input[name='username']")
    public WebElement usernameInput;

    @FindBy(css = "input[name='password']")
    public WebElement passwordInput;

    @FindBy(css = "button.orangehrm-login-button")
    public WebElement loginBtn;

    @FindBy(css = "div.orangehrm-login-error p.oxd-alert-content-text")
    public WebElement invalidCredentialsWarning;

    @FindBy(css = "span.oxd-input-field-error-message")
    public List<WebElement> requiredFieldErrorMessages;

    @FindBy(css = "div.orangehrm-login-branding img")
    public WebElement orangeHrmLogo;

    @FindBy(css = "p.orangehrm-login-forgot-header")
    public WebElement forgotPasswordOption;

    @FindBy(css = "p.orangehrm-login-forgot-header")
    public List<WebElement> socialMediaBtns;

    @FindBy(css = "div.orangehrm-copyright-wrapper p:nth-child(1)")
    public WebElement orangeHrmVersionInfo;

    @FindBy(css = "div.orangehrm-copyright-wrapper p:nth-child(2)")
    public WebElement orangeHrmCopyrightInfo;

    @FindBy(xpath = "//a[contains(@href, 'www.linkedin.com')]")
    public WebElement linkedinBtn;

    @FindBy(xpath = "//a[contains(@href, 'www.facebook.com')]")
    public WebElement facebookBtn;

    @FindBy(xpath = "//a[contains(@href, 'www.twitter.com')]")
    public WebElement twitterBtn;

    @FindBy(xpath = "//a[contains(@href, 'www.youtube.com')]")
    public WebElement youtubeBtn;

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
