package com.jakubhoryd.tests;

import com.jakubhoryd.pages.LoginPage;
import com.jakubhoryd.utils.PropertiesLoader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageTest extends BaseTest {


    private LoginPage loginPage;
    private WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() throws IOException {
        loginPage = new LoginPage(driver);
        int timeToWaitForElement = Integer.parseInt(PropertiesLoader.loadProperty("wait.timeToWaitForElement"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitForElement));
    }

    @Test(testName = "TC-37", description = "LoginPage: Login with valid data")
    public void loginWithValidDataTest() {

        loginPage.login("Admin", "admin123");
    }

    @Test(testName = "TC-38", description = "LoginPage: Login with valid username and wrong password")
    public void loginWithValidUserNameAndWrongPasswordTest() {

        loginPage.login("Admin", "wrong#P@ssw0rd");

        // Not logged into the portal. The login page is still visible. 'Invalid credentials' error message is displayed.
        wait.until(ExpectedConditions.visibilityOf(loginPage.invalidCredentialsWarning));
        String errorMessage = loginPage.invalidCredentialsWarning.getText();

        assertThat(errorMessage).isEqualTo("Invalid credentials");
    }
}
