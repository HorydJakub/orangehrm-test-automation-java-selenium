package com.jakubhoryd.tests.login;

import com.jakubhoryd.core.testrail.TestRail;
import com.jakubhoryd.pages.DashboardPage;
import com.jakubhoryd.pages.LoginPage;
import com.jakubhoryd.core.utils.DateHelper;
import com.jakubhoryd.core.utils.PropertyHelper;
import com.jakubhoryd.tests.BaseTest;
import io.netty.util.internal.StringUtil;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(driver, wait);
        dashboardPage = new DashboardPage(driver, wait);
    }

    @Test(description = "LoginPage: Login with valid data")
    @TestRail(id = "4")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithValidDataTest() {
        loginPage.login("Admin", "admin123");

        // Redirected to 'Dashboard' page
        assertThat(dashboardPage.navbar.getPageTitle()).isEqualTo("Dashboard");
    }

    @Test(description = "LoginPage: Login with valid username and wrong password")
    @TestRail(id = "3")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithValidUsernameAndWrongPasswordTest() {
        loginPage.login("Admin", "wrong#P@ssw0rd");

        // Not logged into the portal. The login page is still visible. 'Invalid credentials' error message is displayed.
        assertThat(loginPage.getInvalidCredentialsWarning().getText()).isEqualTo("Invalid credentials");
    }

    @Test(description = "LoginPage: Login with empty password and username")
    @TestRail(id = "2")
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithEmptyPasswordAndUsernameTest() {
        loginPage.login(StringUtil.EMPTY_STRING, StringUtil.EMPTY_STRING);

        // Not logged into the portal. The login page is still visible. 'Required' error message is displayed under 'Password' and 'Username' input.
        loginPage.getRequiredFieldErrorMessages().forEach(el -> wait.until(visibilityOf(el)));
        assertThat(loginPage.getRequiredFieldErrorMessages().stream().allMatch(el -> el.getText().equals("Required"))).isTrue();
    }

    @Test(description = "LoginPage: Login page - Overview", groups = "smokeTests")
    @TestRail(id = "1")
    @Severity(SeverityLevel.NORMAL)
    public void loginPageOverviewTest() {
        SoftAssertions softAssertions = new SoftAssertions();

        // Verify the visibility of the logo.
        softAssertions.assertThat(loginPage.getOrangeHrmLogo().isDisplayed()).isTrue();

        // Validate the presence of the password input field.
        softAssertions.assertThat(loginPage.getPasswordInput().isDisplayed()).isTrue();

        // Confirm the presence of the username input field.
        softAssertions.assertThat(loginPage.getUsernameInput().isDisplayed()).isTrue();

        // Check the visibility of the login button.
        softAssertions.assertThat(loginPage.getLoginBtn().isEnabled()).isTrue();

        // Verify the presence of the "Forgot password" option.
        softAssertions.assertThat(loginPage.getForgotPasswordOption().isDisplayed()).isTrue();

        // Validate the display of social media buttons.
        softAssertions.assertThat(loginPage.getSocialMediaButtons().stream().allMatch(WebElement::isDisplayed)).isTrue();

        // Ensure the presence of the "All rights reserved" information.
        softAssertions.assertThat(loginPage.getOrangeHrmVersionInfo().getText()).isEqualTo(String.format("OrangeHRM OS %s", PropertyHelper.getDeploymentVersion()));
        softAssertions.assertThat(loginPage.getOrangeHrmCopyrightInfo().getText()).isEqualTo(String.format("© 2005 - %s OrangeHRM, Inc. All rights reserved.", DateHelper.getCurrentYear()));

        softAssertions.assertAll();
    }
}
