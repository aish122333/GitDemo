import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablePagination {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
		List<String> price;
		do{
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		price = elements.stream().filter(s->s.getText().contentEquals("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
		price.stream().forEach(s->System.out.println("Rice : "+s));

		 if(price.size()<1) 
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}
		while(price.size()<1);
		driver.close();
	}

	private static String getPrice(WebElement s) {
		String actualPrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return actualPrice;
	}

}
