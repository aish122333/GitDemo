import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("checkBoxOption2")).click();
		String name = driver.findElement(By.id("checkBoxOption2")).getAttribute("value");
		System.out.println(name);
		Select dropdown = new Select(driver.findElement(By.cssSelector("select[id='dropdown-class-example']")));
		dropdown.selectByValue(name);
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.cssSelector("input[value='Alert']")).click();
		String alertMessage = driver.switchTo().alert().getText();
		if (alertMessage.contains(name)) {
			System.out.println("alert message has name = "+ name);
		}
	}

}
