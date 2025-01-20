package Aishwarya.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Aishwarya.AbstractComponents.AbstractComponents;

public class PlaceOrder extends AbstractComponents {
	WebDriver driver;

	public PlaceOrder(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".action__submit")
	WebElement submitButton;

	@FindBy(xpath = "//h1[@class='hero-primary']")
	WebElement confirmMessageText;
	

	By submit = By.cssSelector(".action__submit");
	By confirmMessage = By.xpath("//h1[@class='hero-primary']");

	public void waitforPlaceOrderPageToAppear() {
		waitForElementToappear(submit);
	}
	
	public void waitforConfirmMessagetoAppear() {
		waitForElementToappear(confirmMessage);
	}

	public void ClickonSubmit() {
		waitforPlaceOrderPageToAppear();
		submitButton.click();
	}

	public String PlaceAnOrder() {
		ClickonSubmit();
		waitforConfirmMessagetoAppear();
		String text = confirmMessageText.getText();
		return text;
	}
	
	public void CloseDriver(WebDriver driver) {
		closeDriver(driver);
	}
	
	
}
