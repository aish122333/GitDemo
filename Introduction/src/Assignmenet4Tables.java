import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmenet4Tables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		int rowsCount = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size();
		System.out.println("Number of rows are ==> " + rowsCount);
		int columnsCount = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size();
		System.out.println("Number of Columns are ==> " + columnsCount);
		List<WebElement> secondrowItems = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[2]/td"));
		System.out.println("Items in second row are shown below : ");
		for (int i = 0; i < secondrowItems.size(); i++) {
			System.out.println(secondrowItems.get(i).getText());
		}
	}

}
