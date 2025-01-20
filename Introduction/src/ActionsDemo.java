import java.awt.RenderingHints.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testsigma.com/");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//p[text()='Resources']"))).build().perform();
		driver.findElement(By.xpath("//a[text()='Try for Free']")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='firstname']")));
	    driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("AISH");
	    driver.findElement(By.cssSelector("input[name='firstname']")).clear();
	    //Other way to go to name and type name is by moving mouse and clicking there and entering data
	    
	    a.moveToElement(driver.findElement(By.cssSelector("input[name='firstname']"))).click().keyDown(Keys.SHIFT).sendKeys("prasad").doubleClick().build().perform();
	    
	}

}
