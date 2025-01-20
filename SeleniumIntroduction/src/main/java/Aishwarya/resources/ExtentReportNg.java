package Aishwarya.resources;

import org.testng.Reporter;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportNg {

	public static ExtentReports getReportStatus() {
		String filepath = "//home//pelatro//aish//selenium//SeleniumIntroduction//reports//report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(filepath);
		reporter.config().setDocumentTitle("Aishwarya automation report");
		reporter.config().setReportName("WebAutomation Report");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Aishwarya");	
		return report;
		}
	

}
