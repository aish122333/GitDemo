import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableColumnFilter {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.findElement(By.id("search-field")).sendKeys("Tomato");
		List<WebElement> veggie = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredlist = veggie.stream().filter(s -> s.getText().contains("Tomato"))
				.collect(Collectors.toList());
		Assert.assertEquals(veggie.size(), filteredlist.size());
	}

}
