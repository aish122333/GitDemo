package Aishwarya.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Aishwarya.AbstractComponents.AbstractComponents;

public class AddPaymentDetails extends AbstractComponents {

	WebDriver driver;

	public AddPaymentDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "//button[@class='ta-item list-group-item ng-star-inserted']")
	List<WebElement> countries;

	By payment = By.xpath("//input[@placeholder='Select Country']");
	By dropdownCountries = By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']");

//	driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
//	w.until(ExpectedConditions
//			.visibilityOfElementLocated(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']")));
	//
//	List<WebElement> options = driver
//			.findElements(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']"));
//	for (WebElement option : options) {
//		if (option.getText().equalsIgnoreCase("India")) {
//			option.click();
//		}
//	}

	public void waitForvisibilityofPaymentPage() {
		waitForElementToappear(payment);
	}

	public List<WebElement> sendCountryName() {
		waitForvisibilityofPaymentPage();
		country.sendKeys("INDIA");
		waitForElementToappear(dropdownCountries);
		return countries;
	}

	public PlaceOrder AddPaymentDetails() {
		List<WebElement> countries = sendCountryName();
		for (WebElement country : countries) {
			if (country.getText().equalsIgnoreCase("India")) {
				country.click();
			}
		}
		PlaceOrder pc = new PlaceOrder(driver);
		return pc;
	}
}
