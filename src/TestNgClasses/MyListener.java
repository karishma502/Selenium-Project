package TestNgClasses;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    //execute only oncd
    public void onStart(ITestContext context) {
        System.out.println("Test Execution statred");
    }
    //execute everytime whenever new test case calls
    public void onTestStart(ITestResult result) {
        System.out.println("Test statred");
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed");
    }
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");
    }
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped");
    }
    public void onFinish(ITestContext context) {
        System.out.println("Test Finished!");
    }
}
