import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		String date= "15";
		String month = "6";
		String year = "2027";
		String[] totalList = {month,date,year};
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		driver.findElement(By.className("react-date-picker__calendar-button")).click();
		driver.findElement(By.xpath("//span[text()='December 2024']")).click();
		driver.findElement(By.xpath("//span[text()='2024']")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElement(By.xpath("//abbr[text()='June']")).click();
		driver.findElement(By.xpath("//abbr[@aria-label='15 June 2027']")).click();
		List<WebElement> list = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getAttribute("value"));
			Assert.assertEquals(list.get(i).getAttribute("value"),totalList[i] );
			
		}
	}

}
