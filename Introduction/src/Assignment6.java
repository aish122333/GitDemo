import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment6 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[text()='Fashion']"))).build().perform();
		
		//finding links within fashion tab
		
		WebElement fashionDriver = driver.findElement(By.cssSelector("._1UgUYI._2eN8ye"));
		List<WebElement> fashionlinkitems = fashionDriver.findElements(By.tagName("a"));
		System.out.println("+++++++++FASHION+++++++++++++++++++++");
		System.out.println(fashionlinkitems.size());
		for (WebElement fashionLink : fashionlinkitems) {
			System.out.println(fashionLink.getText());
		}
		System.out.println("+++++++++++++DONE++++++++++++++++++++++");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int numberofLinks = driver.findElements(By.tagName("a")).size();
		System.out.println("Number of links are " + numberofLinks);
		for (WebElement link : links) {
			System.out.println(link.getText());
		}

	}

}
