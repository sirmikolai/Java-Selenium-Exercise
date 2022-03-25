package listeners;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
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
    protected static final String SOURCE_FOLDER = "target/screenshots/";

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((AbstractTest) currentClass).getDriver();
        String methodName = iTestResult.getName().trim();
        String testClassName = iTestResult.getInstanceName().substring(StringUtils.lastIndexOf(iTestResult.getInstanceName(), ".") + 1);
        Object[] parameters = iTestResult.getParameters();
        takeScreenShot(driver, testClassName, methodName, parameters);
    }


    public void takeScreenShot(WebDriver driver, String testClassName, String methodName, Object[] parameters) {
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

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((AbstractTest) currentClass).getDriver();
        String methodName = iTestResult.getName().trim();
        String testClassName = iTestResult.getInstanceName().substring(StringUtils.lastIndexOf(iTestResult.getInstanceName(), ".") + 1);
        Object[] parameters = iTestResult.getParameters();
        takeScreenShot(driver, testClassName, methodName, parameters);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((AbstractTest) currentClass).getDriver();
        String methodName = iTestResult.getName().trim();
        String testClassName = iTestResult.getInstanceName().substring(StringUtils.lastIndexOf(iTestResult.getInstanceName(), ".") + 1);
        Object[] parameters = iTestResult.getParameters();
        takeScreenShot(driver, testClassName, methodName, parameters);
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
