package framework.Listener;

import framework.base.TestBase;
import framework.extentFactory.ReportFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static framework.extentFactory.ReportFactory.getChildTest;

/**
 * This is the Listener class which verifies the success or failure of tests
 *
 */

public class Listener extends TestBase implements ITestListener {

    public static String testMethodNameOnTestStart;

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am on TestStart method " + getTestMethodName(iTestResult) + " start");
        testMethodNameOnTestStart = getTestMethodName(iTestResult);
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am on Test Success method " + getTestMethodName(iTestResult) + " succeed");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am on TestFailure method " + getTestMethodName(iTestResult) + " failed");
        getChildTest().fail(iTestResult.getThrowable().getMessage());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am on TestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        iTestResult.setStatus(ITestResult.SKIP);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("I am on Start method " + iTestContext.getName());
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am on Finish method " + iTestContext.getName());
        ReportFactory.saveReport();
    }

    public static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
}
