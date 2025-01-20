package Aishwarya.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.NewSessionPayload;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Aishwarya.Components.BaseTest;
import Aishwarya.PageObjects.AddPaymentDetails;
import Aishwarya.PageObjects.AddProducts;
import Aishwarya.PageObjects.LoginPage;
import Aishwarya.PageObjects.OrderHistorypageTest;
import Aishwarya.PageObjects.PlaceOrder;
import Aishwarya.PageObjects.checkoutPage;

public class StandaloneTest2 extends BaseTest {

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		// Login to URL
		AddProducts ap = login.LoginToPortal(input.get("email"), input.get("password"));

		// GO to product Catalogue and add product to cart
		ap.findproductandAddtoCart(input.get("productName"));
		checkoutPage cp = ap.clickOnCartIcon();

		// Go to checkout page
		AddPaymentDetails payment = cp.clickOnCheckout();

		// Add Payment Details
		PlaceOrder pc = payment.AddPaymentDetails();

		// Place an Order
		String confirmMessage = pc.PlaceAnOrder();
		AssertJUnit.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");

		// close driver
	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void verifyItemsinMyOrdersPage() {
		AddProducts ap = login.LoginToPortal("aish@gamil.com", "Aishwarya@123");
		OrderHistorypageTest order = ap.goToOrderHistory();
		order.verifyOrderHistory("Adidas Original");
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = readJson(
				"/home/pelatro/aish/selenium/SeleniumIntroduction/src/test/java/Aishwarya/data/Data.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

//		HashMap<String, String> map = new HashMap<String,String>();
//		map.put("email", "aish@gamil.com");
//		map.put("password", "Aishwarya@123");
//		map.put("productName","Adidas Original");
//
//		HashMap<String, String> map1 = new HashMap<String,String>();
//		map1.put("email", "aish2@gmail.com");
//		map1.put("password", "Aishwarya@1234");
//		map1.put("productName","Adidas Original");
//		return new Object[][] {{map},{map1}};

	}

//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] { { "aish@gamil.com", "Aishwarya@123", "Adidas Original" },
//				{ "aish2@gmail.com", "Aishwarya@1234", "Adidas Original" } };
//
//	}

}
