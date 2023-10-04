package com.jakubhoryd.tests;

import com.jakubhoryd.pages.DashboardPage;
import com.jakubhoryd.pages.LoginPage;
import com.jakubhoryd.utils.PropertyHelper;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPageTest extends BaseTest {


    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() throws IOException {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyHelper.getWaitingTimeForElements()));
    }

    @Test(testName = "TC-37", description = "LoginPage: Login with valid data")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithValidDataTest() {

        loginPage.login("Admin", "admin123");

        // Redirected to 'Dashboard' page
        assertThat(dashboardPage.navbar.getPageTitle()).isEqualTo("Dashboard");
    }

    @Test(testName = "TC-38", description = "LoginPage: Login with valid username and wrong password")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithValidUserNameAndWrongPasswordTest() {

        loginPage.login("Admin", "wrong#P@ssw0rd");

        // Not logged into the portal. The login page is still visible. 'Invalid credentials' error message is displayed.
        wait.until(visibilityOf(loginPage.invalidCredentialsWarning));
        String errorMessage = loginPage.invalidCredentialsWarning.getText();

        assertThat(errorMessage).isEqualTo("Invalid credentials");
    }
}
