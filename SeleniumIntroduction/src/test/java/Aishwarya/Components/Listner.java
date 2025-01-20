package Aishwarya.Components;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Aishwarya.resources.ExtentReportNg;

public class Listner extends BaseTest implements ITestListener {

	public ExtentTest test;
	ExtentReports report = ExtentReportNg.getReportStatus();


	// This will be called before any test execution
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started: " + result.getMethod().getMethodName());
		test = report.createTest(result.getMethod().getMethodName());
	}

	// This will be called when a test passes
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");

	}

	// This will be called when a test fails
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String filePath = null;

		// Take Screenshot
		try {
			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				e.printStackTrace();
			} 
			filePath = takescreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Attach to report
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	// This will be called when a test is skipped
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test is skipped");
	}

	// This will be called after all tests finish
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test failed but within success percentage: " + result.getName());
	}
	@Override
	  public  void onFinish(ITestContext context) {
		report.flush();
		  }

}
