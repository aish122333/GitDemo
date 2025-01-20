import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddmobiletoCartAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[name=password]")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Okay']")));
		driver.findElement(By.xpath("//button[text()='Okay']")).click();
		Select dropdown = new Select(driver.findElement(By.cssSelector("select[data-style='btn-info']")));
		dropdown.selectByVisibleText("Consultant");
		driver.findElement(By.cssSelector("input[type=checkbox]")).click();
		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Category 1']")));
		System.out.println("came to next page");
		List<WebElement> items = driver.findElements(By.xpath("//button[text()='Add ']"));
		for (int i = 0; i < items.size(); i++) {
			System.out.println("came inside");
			items.get(i).click();
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Total']")));
		System.out.println("came to last page");
		driver.findElement(By.xpath("//button[contains(@class, 'btn') and contains(@class, 'btn-success')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("country")));
		driver.findElement(By.id("country")).sendKeys("IND");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("suggestions")));
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='suggestions']/ul"));
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
			if (options.get(i).getText().equalsIgnoreCase("INDIA")) {
				options.get(i).click();
				break;
			}
		}
		driver.findElement(By.cssSelector("label[for='checkbox2']")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();

	}

}
