package TestNgClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener
{
    public ExtentSparkReporter sparkReporter; // User for UI report
    public ExtentReports extents; //Populate common Info of the report
    public ExtentTest test; // Create test case entries in the report

    @Override
    public void onStart(ITestContext context) {

        sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");

        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extents = new ExtentReports();
        extents.attachReporter(sparkReporter);

        extents.setSystemInfo("OS","MAC");
        extents.setSystemInfo("Computer Name","Air.local");
        extents.setSystemInfo("Envt Name","QA");
        extents.setSystemInfo("Tester Name","Karishma");
        extents.setSystemInfo("Browser Name","Chrome");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extents.createTest(result.getName());
        test.log(Status.PASS,"Test Case passed is : "+ result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extents.createTest(result.getTestName());
        test.log(Status.FAIL,"Test Case failed is: "+ result.getName());
        test.log(Status.FAIL,"Test case failed cause: "+ result.getThrowable());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extents.createTest(result.getName());
        test.log(Status.SKIP,"Test Case Skipped is: "+ result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extents.flush();
    }
}
