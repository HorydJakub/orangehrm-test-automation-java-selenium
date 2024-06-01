package com.jakubhoryd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class LoginPage {

    private final WebDriverWait wait;

    private static final By USERNAME_INPUT_LOCATOR = By.cssSelector("input[name='username']");
    private static final By PASSWORD_INPUT_LOCATOR = By.cssSelector("input[name='password']");
    private static final By LOGIN_BTN_LOCATOR = By.cssSelector("button.orangehrm-login-button");
    private static final By INVALID_CREDENTIALS_WARNING_LOCATOR = By.cssSelector("div.orangehrm-login-error p.oxd-alert-content-text");
    private static final By REQUIRED_FIELD_ERROR_MESSAGES_LOCATOR = By.cssSelector("span.oxd-input-field-error-message");
    private static final By ORANGE_HRM_LOGO_LOCATOR = By.cssSelector("div.orangehrm-login-branding img");
    private static final By FORGOT_PASSWORD_OPTION_LOCATOR = By.cssSelector("p.orangehrm-login-forgot-header");
    private static final By SOCIAL_MEDIA_BTNS_LOCATOR = By.cssSelector("p.orangehrm-login-forgot-header");
    private static final By ORANGE_HRM_VERSION_INFO_LOCATOR = By.cssSelector("div.orangehrm-copyright-wrapper p:nth-child(1)");
    private static final By ORANGE_HRM_COPYRIGHT_INFO_LOCATOR = By.cssSelector("div.orangehrm-copyright-wrapper p:nth-child(2)");
    private static final By LINKEDIN_BTN_LOCATOR = By.xpath("//a[contains(@href, 'www.linkedin.com')]");
    private static final By FACEBOOK_BTN_LOCATOR = By.xpath("//a[contains(@href, 'www.facebook.com')]");
    private static final By TWITTER_BTN_LOCATOR = By.xpath("//a[contains(@href, 'www.twitter.com')]");
    private static final By YOUTUBE_BTN_LOCATOR = By.xpath("//a[contains(@href, 'www.youtube.com')]");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        wait.until(visibilityOfElementLocated(USERNAME_INPUT_LOCATOR)).sendKeys(username);
        wait.until(visibilityOfElementLocated(PASSWORD_INPUT_LOCATOR)).sendKeys(password);
        wait.until(visibilityOfElementLocated(LOGIN_BTN_LOCATOR)).click();
    }

    public WebElement getUsernameInput() {
        return wait.until(visibilityOfElementLocated(USERNAME_INPUT_LOCATOR));
    }

    public WebElement getPasswordInput() {
        return wait.until(visibilityOfElementLocated(PASSWORD_INPUT_LOCATOR));
    }

    public WebElement getLoginBtn() {
        return wait.until(visibilityOfElementLocated(LOGIN_BTN_LOCATOR));
    }

    public WebElement getInvalidCredentialsWarning() {
        return wait.until(visibilityOfElementLocated(INVALID_CREDENTIALS_WARNING_LOCATOR));
    }

    public List<WebElement> getRequiredFieldErrorMessages() {
        return wait.until(visibilityOfAllElementsLocatedBy(REQUIRED_FIELD_ERROR_MESSAGES_LOCATOR));
    }

    public WebElement getOrangeHrmLogo() {
        return wait.until(visibilityOfElementLocated(ORANGE_HRM_LOGO_LOCATOR));
    }

    public WebElement getForgotPasswordOption() {
        return wait.until(visibilityOfElementLocated(FORGOT_PASSWORD_OPTION_LOCATOR));
    }

    public List<WebElement> getSocialMediaButtons() {
        return wait.until(visibilityOfAllElementsLocatedBy(SOCIAL_MEDIA_BTNS_LOCATOR));
    }

    public WebElement getOrangeHrmVersionInfo() {
        return wait.until(visibilityOfElementLocated(ORANGE_HRM_VERSION_INFO_LOCATOR));
    }

    public WebElement getOrangeHrmCopyrightInfo() {
        return wait.until(visibilityOfElementLocated(ORANGE_HRM_COPYRIGHT_INFO_LOCATOR));
    }

    public WebElement getLinkedinBtn() {
        return wait.until(visibilityOfElementLocated(LINKEDIN_BTN_LOCATOR));
    }

    public WebElement getFacebookBtn() {
        return wait.until(visibilityOfElementLocated(FACEBOOK_BTN_LOCATOR));
    }

    public WebElement getTwitterBtn() {
        return wait.until(visibilityOfElementLocated(TWITTER_BTN_LOCATOR));
    }

    public WebElement getYoutubeBtn() {
        return wait.until(visibilityOfElementLocated(YOUTUBE_BTN_LOCATOR));
    }
}
