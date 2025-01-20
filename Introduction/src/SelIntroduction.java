import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		System.out.println("Helloooo!!!");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.apple.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();
		//quit closes all windows opened in testing
	}

}
