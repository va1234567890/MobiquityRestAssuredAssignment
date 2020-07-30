package framework.base;

import framework.Listener.Listener;
import framework.Utilities.ReTryTestCase;
import framework.extentFactory.ReportFactory;
import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import static framework.extentFactory.ReportFactory.createReportFile;

/**
 * This is test base where testNG annotation sequence are defined and
 * which controls the flow of scripts
 */

@Listeners({Listener.class})
public class TestBase {

    public static int RETRY;
    public String testNameFromXML = null;
    public static Logger log = Logger.getLogger("rootLogger");

    public void initializeConfig(String reTry) throws Throwable {
        RETRY = Integer.parseInt(reTry);
    }

    @Parameters(value = {"reTry"})
    @BeforeSuite
    public void beforeSuite(ITestContext context,
                            @Optional String reTry) throws Throwable {

        initializeConfig(reTry);
        System.out.println("before creating report");
        createReportFile();
        System.out.println("after creating report");

        for(ITestNGMethod method : context.getSuite().getAllMethods()) {
            method.setRetryAnalyzer(new ReTryTestCase());
        }
    }

    @BeforeClass
    public void beforeClass() {
        org.apache.log4j.PropertyConfigurator.configure("log4j.properties");
        testNameFromXML = this.getClass().getName();
        ReportFactory.createTest(testNameFromXML);
    }

    @BeforeMethod
    public void beforeMethod(Method method) throws RuntimeException {
        ReportFactory.createChildTest(testNameFromXML, method.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        IRetryAnalyzer retry = result.getMethod().getRetryAnalyzer();
        if (retry == null) {
            return;
        }
        result.getTestContext().getSkippedTests().removeResult(result.getMethod());
    }
}
