import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locatore2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		String name = "rahul";
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.getCurrentUrl();
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//label[@for='chkboxTwo']")).click();
		driver.findElement(By.className("submit")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello rahul,");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");     
		System.out.println("assert done");
//		driver.findElement(By.cssSelector(".logout-btn")).click();
//		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.findElement(By.xpath("//button[@class='logout-btn']")).click();
		driver.close();
	}
	
	public String getPassword(String password) {
		String[] splitString = password.split("'");
		String[] splitString2 = splitString[1].split("'");
		String latestPassword = splitString2[0];
		return latestPassword;			
	}
	
	public String getPasswordWithDiffrentWay(WebDriver driver) {
		String sentence = driver.findElement(By.className("infoMsg")).getText();
		String splittedString = sentence.split("'")[1].split(",")[0];
		return splittedString;
	}
}
