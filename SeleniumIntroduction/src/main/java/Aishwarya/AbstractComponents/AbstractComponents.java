package Aishwarya.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Aishwarya.PageObjects.OrderHistorypageTest;

public class AbstractComponents  {
	WebDriver driver;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement myorders;
	
	public AbstractComponents(WebDriver driver3) {
		this.driver = driver3;
	}

	public void waitForElementToappear(By byElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
	}

	public void waitForWebElementToappear(WebElement byElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(byElement));
	}

	public void waitForElementToDisappear(By byElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
	}
	
	public OrderHistorypageTest goToOrderHistory() {
		myorders.click();
		OrderHistorypageTest orderhistory = new OrderHistorypageTest(driver);
		return orderhistory;
		
	}

	public void closeDriver(WebDriver driver) {
		driver.close();
	}

}
