package com.jakubhoryd.core.listeners;

import com.jakubhoryd.core.properties.ConstantValues;
import com.jakubhoryd.core.testrail.TestRail;
import com.jakubhoryd.core.testrail.TestRailManager;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class TestListener implements ITestListener {

    private String getIdFromAnnotation(ITestResult result) {
        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        TestRail annotation = method.getAnnotation(TestRail.class);

        if (annotation == null || annotation.id() == null) {
            throw new IllegalArgumentException("Error: The test does not have a TestRail ID assigned.");
        }

        return annotation.id();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String successMessage = String.format("Test: %s passed successfully", result.getName());
        TestRailManager.addResultForTestCase(getIdFromAnnotation(result), ConstantValues.TESTRAIL_CODE_PASSED, successMessage);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String failureMessage = String.format("Test: %s failed because of %s", result.getName(), result.getThrowable());
        TestRailManager.addResultForTestCase(getIdFromAnnotation(result), ConstantValues.TESTRAIL_CODE_FAILED, failureMessage);
    }
}