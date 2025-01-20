package Aishwarya.Components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Aishwarya.PageObjects.AddProducts;
import Aishwarya.PageObjects.LoginPage;

public class BaseTest {

	public WebDriver driver;
	public LoginPage login;

	public WebDriver InitializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Aishwarya//resources//global.properties");
		prop.load(file);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				:prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900)); // helps to run in full screen mode we can use this instead of maximize options as well
		}

		else if (browserName.contains("firefox")) {
			// Initialise firefox browser
		}

		else if (browserName.contains("edge")) {
			// Initialise edge browser
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}

	// get data from json and passing to test
	public List<HashMap<String, String>> readJson(String filepath) throws IOException {
		// Convert json file to string
		String jsonfile = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		// Convert string file to hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonfile,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	@BeforeMethod(alwaysRun = true)
	public LoginPage LaunchUrl() throws IOException {
		driver = InitializeDriver();
		login = new LoginPage(driver);
		login.GoToUrl();
		return login;

	}

	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		driver.close();

	}

	public String takescreenshot(String fileName) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File sourcefile = sc.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir") + "//reports//" + fileName + ".png");
		FileUtils.copyFile(sourcefile, destFile);
		return System.getProperty("user.dir") + "//reports//" + fileName + ".png";
	}
}
