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

public class AddProducts extends AbstractComponents {

	WebDriver driver;

	public AddProducts(WebDriver driver2) {
		super(driver2);
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".col-lg-4")
	List<WebElement> products;

	@FindBy(css = "[routerlink*='cart']")
	WebElement Cart;

	By productsElement = By.cssSelector(".col-lg-4");
	By spinner = By.cssSelector(".ng-animating");

	public List<WebElement> getProductsList() {
		waitForElementToappear(productsElement);
		return products;
	}

	public void findproductandAddtoCart(String productName) {
		List<WebElement> productslist = getProductsList();
		int i = 0;
		for (i = 0; i < products.size(); i++) {
			String prodName = productslist.get(i).findElement(By.cssSelector(".card-body b")).getText();
			if (prodName.equalsIgnoreCase(productName)) {
				products.get(i).findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
				break;
			}
		}
	}

	public checkoutPage clickOnCartIcon() throws InterruptedException {
		waitForElementToDisappear(spinner);
		Thread.sleep(5000);
		Cart.click();
		checkoutPage cp = new checkoutPage(driver);
		return cp;
	}

}
