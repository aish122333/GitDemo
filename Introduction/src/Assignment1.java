import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("a")).size());

		// find link only in footer

		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// Now in footer section in second row find the no links

		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td/ul[1]"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		int length = columndriver.findElements(By.tagName("a")).size();
		List<WebElement> links = columndriver.findElements(By.tagName("a"));

		Actions a = new Actions(driver);

		for (WebElement link : links) {
			a.moveToElement(link).keyDown(Keys.CONTROL).click().build().perform();
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		it.next();

		for (int i = 0; i < length; i++) {

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

		// this above is one way, other way also can be done

	}

}
