package com.jakubhoryd.tests;

import com.jakubhoryd.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {


    private LoginPage loginPage;
    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(driver);
    }
    @Test(testName = "TC-37", description = "LoginPage: Login with valid data")
    public void loginWithValidDataTest() {

        loginPage.login("Admin", "admin123");
    }
}
