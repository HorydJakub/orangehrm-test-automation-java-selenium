package com.jakubhoryd.tests;

import com.jakubhoryd.core.listeners.TestListener;
import com.jakubhoryd.core.utils.DateHelper;
import com.jakubhoryd.core.utils.DriverFactory;
import com.jakubhoryd.core.utils.PropertyHelper;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger();
    protected static WebDriverWait wait;

    @BeforeMethod
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
        driver.get(PropertyHelper.getProdEnvironment());
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(PropertyHelper.getWaitingTimeForElements()));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {

        if (ITestResult.FAILURE == result.getStatus()) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(PropertyHelper.getFailedTestsScreenshotDirectory() + DateHelper.getCurrentTimeStamp() + PropertyHelper.getPreferredScreenshotExtension()));
            logger.error(String.format("Test failed, saving screenshot in: %s", PropertyHelper.getFailedTestsScreenshotDirectory()));
        }
        driver.quit();
    }
}