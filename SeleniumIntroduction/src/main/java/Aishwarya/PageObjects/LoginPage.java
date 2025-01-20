package Aishwarya.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Aishwarya.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {

	WebDriver driver;

	public LoginPage(WebDriver driver2) {
		super(driver2);
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement usermail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement login;

	@FindBy (css ="[class*='flyInOut']")
	WebElement errormessage;
	
	@FindBy (css ="[class*='flyInOut']")
	WebElement successMessage;

	public AddProducts LoginToPortal(String email, String Passwored) {
		usermail.sendKeys(email);
		password.sendKeys(Passwored);
		login.click();
		AddProducts ap = new AddProducts(driver);
		return ap;
	}

	public String getErrorMessage() {
		waitForWebElementToappear(errormessage);
		return errormessage.getText();
	}
	
	public String getloginSuccessfullMessage() {
		waitForWebElementToappear(successMessage);
		return successMessage.getText();
	}

	public void GoToUrl() {
		driver.get("https://rahulshettyacademy.com/client/");

	}
}
