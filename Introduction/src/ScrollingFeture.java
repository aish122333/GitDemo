import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingFeture {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		// this .tableFixhead is the css selector with classname
		// class="tableFixHead"
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		int sum = 0;
		List<WebElement> numbers = driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i).getText());
			sum = sum + Integer.parseInt(numbers.get(i).getText());
		}
		System.out.println("Total sum is ==> " + sum);
		String Finalsum = driver.findElement(By.cssSelector("div[class='totalAmount']")).getText().split(":")[1]
				.trim();
		int expectedSum = Integer.parseInt(Finalsum);
		Assert.assertEquals(sum, expectedSum);
	}

}
