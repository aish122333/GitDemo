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

public class OrderHistorypageTest extends AbstractComponents {
	WebDriver driver;

	public OrderHistorypageTest(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> orderhistoryproducts;

	public boolean verifyOrderHistory(String productName) {
		boolean value = orderhistoryproducts.stream()
				.anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return value;
	}

}
