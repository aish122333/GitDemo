
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MMTbooking {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/flights/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("span[data-cy='closeModal']")).click();
		driver.findElement(By.className("chFlights")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("searchCity")).click();
		driver.findElement(By.cssSelector("input[placeholder='From']")).sendKeys("MUM");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Mumbai']")).click();
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//p[text()='Bangkok']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@aria-label, 'Thu Dec 05 2024')]")).click();
		driver.findElement(By.className("reDates")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@aria-label,'Tue Dec 10 2024')]")).click();
		driver.findElement(By.className("flightTravllers")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("li[data-cy='adults-2']")).click();
		driver.findElement(By.cssSelector("li[data-cy='children-2']")).click();
		driver.findElement(By.cssSelector("li[data-cy='infants-1']")).click();
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		driver.findElement(By.xpath("//div[text()='Regular']")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
	}

}
