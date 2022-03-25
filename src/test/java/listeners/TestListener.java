package listeners;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testngtests.AbstractTest;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    private static final Logger logger = Logger.getLogger(SuiteListener.class);

    static final String SOURCE_FOLDER = "target/screenshots/";

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info("---TEST STARTED!!!---");
        logger.info("Test class: " + iTestResult.getInstanceName() + "; Method: " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("---TEST PASSED!!!---");
        logger.info("Test class: " + iTestResult.getInstanceName() + "; Method: " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((AbstractTest) currentClass).getDriver();
        takeScreenShot(driver, iTestResult.getInstanceName(), iTestResult.getName(), iTestResult.getParameters());
        logger.error("---TEST FAILED!!!---");
        logger.error("Test class: " + iTestResult.getInstanceName() + "; Method: " + iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((AbstractTest) currentClass).getDriver();
        takeScreenShot(driver, iTestResult.getInstanceName(), iTestResult.getName(), iTestResult.getParameters());
        logger.error("---TEST SKIPPED!!!---");
        logger.error("Test class: " + iTestResult.getInstanceName() + "; Method: " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((AbstractTest) currentClass).getDriver();
        takeScreenShot(driver, iTestResult.getInstanceName(), iTestResult.getName(), iTestResult.getParameters());
        logger.error("---TEST FAILED BUT WITHIN SUCCESS PERCENTAGE!!!---");
        logger.error("Test class: " + iTestResult.getInstanceName() + "; Method: " + iTestResult.getName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void takeScreenShot(WebDriver driver, String testClassName, String methodName, Object[] parameters) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotMethodPath = SOURCE_FOLDER + testClassName + "_" + methodName;
        try {
            if (parameters.length == 0) {
                FileUtils.copyFile(scrFile, new File(screenShotMethodPath + ".jpg"));
            } else {
                String paramsDesc = parameters[0].toString();
                if (paramsDesc.length() > 6) {
                    paramsDesc = paramsDesc.substring(0, 6);
                }
                FileUtils.copyFile(scrFile, new File(screenShotMethodPath + "-" + paramsDesc + ".jpg"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
