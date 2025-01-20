import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddVegetableToCart {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String[] vegetables = { "Carrot", "Beans", "Cucumber", "Tomato" };
		int j = 0;
		List<String> vegetablelist = Arrays.asList(vegetables);
		List<WebElement> names = driver.findElements(By.cssSelector("h4[class='product-name']"));

		for (int i = 0; i < names.size(); i++) {
			String[] splittednames = names.get(i).getText().split("-");
			String formatedVegetableName = splittednames[0].trim();
			System.out.println(formatedVegetableName);

			if (vegetablelist.contains(formatedVegetableName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;

				if (j == vegetables.length) {
					break;
				}
			}

		}

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();

		// Explicit wait
		// WebDriverWait w = new WebDriverWait(driver,5);
//		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		Select dropdown = new Select(driver.findElement(By.cssSelector("select[style='width: 200px;']")));
		dropdown.selectByValue("Brazil");
		driver.findElement(By.cssSelector("input[class='chkAgree']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();

	}

}
