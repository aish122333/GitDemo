import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// Sibling - Child to parent traverse

		// header/div/button[1]/following-sibling::button[1]

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.apple.com/");
		driver.navigate().back();
		driver.navigate().forward();
		
	}

}
