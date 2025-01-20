package Aishwarya.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Aishwarya.AbstractComponents.AbstractComponents;

public class checkoutPage extends AbstractComponents {
	WebDriver driver;

	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;

	By checkoutPage = By.cssSelector(".cartSection h3");

	public void waitforCheckoutPageVisibility() {
		waitForElementToappear(checkoutPage);
	}

	public AddPaymentDetails clickOnCheckout() {
		waitforCheckoutPageVisibility();
		checkoutButton.click();
		AddPaymentDetails payment = new AddPaymentDetails(driver);
		return payment;
	}

}
