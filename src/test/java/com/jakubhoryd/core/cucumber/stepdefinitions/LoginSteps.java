package com.jakubhoryd.core.cucumber.stepdefinitions;

import com.jakubhoryd.core.utils.DriverFactory;
import com.jakubhoryd.core.utils.PropertyHelper;
import com.jakubhoryd.pages.LoginPage;
import com.jakubhoryd.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginSteps extends BaseTest {
    private LoginPage loginPage;

    @Before
    public void setUpLoginPage() throws IOException {
        driver = DriverFactory.getDriver();
        driver.get(PropertyHelper.getProdEnvironment());
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyHelper.getWaitingTimeForElements()));
        loginPage = new LoginPage(driver, wait);
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        // Login page already opened in @BeforeMethod from BaseTest
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should see {string} error message")
    public void iShouldSeeErrorMessage(String errorMessage) {
        assertThat(loginPage.getInvalidCredentialsWarning().getText()).isEqualTo(errorMessage);
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}