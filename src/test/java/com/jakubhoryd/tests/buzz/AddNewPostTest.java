package com.jakubhoryd.tests.buzz;

import com.jakubhoryd.core.testrail.TestRail;
import com.jakubhoryd.enums.NavmenuOption;
import com.jakubhoryd.pages.BuzzPage;
import com.jakubhoryd.pages.DashboardPage;
import com.jakubhoryd.pages.LoginPage;
import com.jakubhoryd.tests.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewPostTest extends BaseTest {


    private LoginPage loginPage;
    private BuzzPage buzzPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(driver, wait);
        buzzPage = new BuzzPage(driver, wait);
        dashboardPage = new DashboardPage(driver, wait);
    }

    @Test(description = "BuzzPage: Share new post without attachments")
    @TestRail(id = "5")
    @Severity(SeverityLevel.NORMAL)
    public void publishNewPostWithoutAttachmentsTest() {

        // Login into portal as admin
        loginPage.login("Admin", "admin123");

        // Redirected to 'Dashboard' page, go to 'Buzz' page
        dashboardPage.sidenav.goToMenu(NavmenuOption.BUZZ);

        // Publish new post without attachments
        buzzPage.publishNewPost("Hello world!!!");
    }
}
