package Aishwarya.Tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandaloneTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String email = "aish@gamil.com";
		String Password = "Aishwarya@123";
		String productName = "ADIDAS ORIGINAL";
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Register here")).click();
		driver.findElement(By.id("firstName")).sendKeys("Aishwarya");
		driver.findElement(By.cssSelector("[type='lastname']")).sendKeys("Patil");
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='userMobile']")).sendKeys("1111111111");
		Select dropdown = new Select(driver.findElement(By.cssSelector("[formcontrolname='occupation']")));
		dropdown.selectByVisibleText("Engineer");
		driver.findElement(By.xpath("//span[text()='Female']")).click();
		driver.findElement(By.id("userPassword")).sendKeys(Password);
		driver.findElement(By.id("confirmPassword")).sendKeys(Password);
		driver.findElement(By.cssSelector("[type='checkbox']")).click();
		driver.findElement(By.className("login-btn")).click();
		driver.findElement(By.linkText("Login here")).click();
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userPassword")).sendKeys(Password);
		driver.findElement(By.id("login")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='card']/div[@class='card-body']/h5/b")));

		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card']/div[@class='card-body']/h5/b"));
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getText().equalsIgnoreCase(productName)) {
				System.out.println(products.get(i).getText());
				System.out.println(i);
				products.get(i).findElement(By.xpath("//div[@class='card']/div[@class='card-body']/button[2]")).click();
			}

		}
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));

		List<WebElement> cartfinalProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean value = cartfinalProducts.stream()
				.anyMatch(cartfinalproduct -> cartfinalproduct.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(value);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Select Country']")));
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		String finalText = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(finalText, "THANKYOU FOR THE ORDER.");
	}

}
