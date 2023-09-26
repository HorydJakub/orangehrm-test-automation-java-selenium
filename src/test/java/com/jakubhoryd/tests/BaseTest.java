package com.jakubhoryd.tests;

import com.jakubhoryd.utils.DateHelper;
import com.jakubhoryd.utils.DriverFactory;
import com.jakubhoryd.utils.PropertyHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        if (ITestResult.FAILURE == result.getStatus()) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(PropertyHelper.getFailedTestsScreenshotDirectory() + DateHelper.getCurrentTimeStamp() + PropertyHelper.getPreferedScreenshotExtension()));
            // ToDo: Implement log message about failed test: TimeStamp + LocationOfTheFIle
        }
        driver.quit();
    }
}