import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		SoftAssert sa = new SoftAssert();

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.connect();
			int respCode = conn.getResponseCode();
//			if (respCode < 404) {
//				continue;
//			}
//			else
//			{
//				System.out.println("The link with name "+link.getText().toUpperCase()+" is a broken link");
//			}
			
			//More sophistaced way to write this would be soft assert
			sa.assertTrue(respCode<404, "The link with name "+link.getText().toUpperCase()+" is a broken link");
		}
			sa.assertAll();
		}
	}


