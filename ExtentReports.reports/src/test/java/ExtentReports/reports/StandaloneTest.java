package ExtentReports.reports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class StandaloneTest {

	ExtentReports report;
	@BeforeTest
	public void config() {
		String file = "//home//pelatro//aish//selenium//ExtentReports.reports//reports//report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		reporter.config().setDocumentTitle("Aishwarya automation report");
		reporter.config().setReportName("WebAutomation Report");
		
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Aishwarya");
		
	}
	@Test
	public void sampleTest() {
		ExtentTest test = report.createTest("Sample Test");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("this is failed");
		report.flush();
	
}

}