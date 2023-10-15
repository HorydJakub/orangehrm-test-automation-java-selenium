package com.jakubhoryd.tests;

import com.jakubhoryd.pages.DashboardPage;
import com.jakubhoryd.pages.LoginPage;
import com.jakubhoryd.utils.DateHelper;
import com.jakubhoryd.utils.PropertyHelper;
import io.netty.util.internal.StringUtil;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPageTest extends BaseTest {


    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void beforeMethod() throws IOException {
        loginPage = new LoginPage(driver, wait);
        dashboardPage = new DashboardPage(driver, wait);
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

        assertThat(loginPage.invalidCredentialsWarning.getText()).isEqualTo("Invalid credentials");
    }

    @Test(testName = "TC-39", description = "LoginPage: Login with valid password and wrong username")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithValidPasswordAndWrongUsernameTest() {

        loginPage.login("WrongUsername", "admin123");

        // Not logged into the portal. The login page is still visible. 'Invalid credentials' error message is displayed.
        wait.until(visibilityOf(loginPage.invalidCredentialsWarning));

        assertThat(loginPage.invalidCredentialsWarning.getText()).isEqualTo("Invalid credentials");
    }

    @Test(testName = "TC-41", description = "LoginPage: Login with empty password and username")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithEmptyPasswordAndUsernameTest() {

        loginPage.login(StringUtil.EMPTY_STRING, StringUtil.EMPTY_STRING);

        //  Not logged into the portal. The login page is still visible. 'Required' error message is displayed under 'Password' and 'Username' input.
        loginPage.requiredFieldErrorMessages.forEach(el -> wait.until(ExpectedConditions.visibilityOf(el)));
        assertThat(loginPage.requiredFieldErrorMessages.stream().allMatch(el -> el.getText().equals("Required"))).isTrue();
    }

    @Test(testName = "TC-40", description = "LoginPage: Login page - Overview", groups = "smokeTests")
    @Severity(SeverityLevel.NORMAL)
    public void loginPageOverviewTest() throws IOException {

        SoftAssertions softAssertions = new SoftAssertions();

        // Verify the visibility of the logo.
        softAssertions.assertThat(loginPage.orangeHrmLogo.isDisplayed()).isTrue();

        // Validate the presence of the password input field.
        softAssertions.assertThat(loginPage.passwordInput.isDisplayed()).isTrue();

        // Confirm the presence of the username input field.
        softAssertions.assertThat(loginPage.usernameInput.isDisplayed()).isTrue();

        // Check the visibility of the login button.
        softAssertions.assertThat(loginPage.loginBtn.isEnabled()).isTrue();

        // Verify the presence of the "Forgot password" option.
        softAssertions.assertThat(loginPage.forgotPasswordOption.isDisplayed()).isTrue();

        // Validate the display of social media buttons.
        assertThat(loginPage.socialMediaBtns.stream().allMatch(WebElement::isDisplayed)).isTrue();

        // Ensure the presence of the "All rights reserved" information.
        // The exact text is formatted as follows: OrangeHRM OS {$OS_Version_Number} © 2005 - {$Current_Year} OrangeHRM, Inc. All rights reserved
        softAssertions.assertThat(loginPage.orangeHrmVersionInfo.getText()).isEqualTo(String.format("OrangeHRM OS %s", PropertyHelper.getDeploymentVersion()));
        softAssertions.assertThat(loginPage.orangeHrmCopyrightInfo.getText()).isEqualTo(String.format("© 2005 - %s OrangeHRM, Inc. All rights reserved.", DateHelper.getCurrentYear()));

        softAssertions.assertAll();
    }
}
