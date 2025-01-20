package Aishwarya.stepDefinitions;

import java.io.IOException;

import org.testng.AssertJUnit;

import Aishwarya.Components.BaseTest;
import Aishwarya.PageObjects.AddPaymentDetails;
import Aishwarya.PageObjects.AddProducts;
import Aishwarya.PageObjects.LoginPage;
import Aishwarya.PageObjects.PlaceOrder;
import Aishwarya.PageObjects.checkoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseOrderStepDefinition extends BaseTest {

	public LoginPage loginpage;
	public AddProducts ap;
	public checkoutPage cp;
	public AddPaymentDetails payment;
	public PlaceOrder pc;

	@Given("I landed on website")
	public void I_landed_on_website() throws IOException {
		loginpage = LaunchUrl();

	}

	@Given("^Logged in to website with username (.+) and password (.+)$")
	public void Logged_in_to_website_with_username_and_password(String name, String password) {
		ap = login.LoginToPortal(name, password);
	}

	@When("^I want to add product (.+) to cart$")
	public void I_want_to_add_product_to_cart(String productName) throws InterruptedException {
		ap.findproductandAddtoCart(productName);
		cp = ap.clickOnCartIcon();
	}

	@And("Click on submit button")
	public void Click_on_submit_button() {
		payment = cp.clickOnCheckout();
		pc = payment.AddPaymentDetails();

	}

	@Then("Message {string} is displayed on confirmation page")
	public void Message_is_dispalyed_on_confirmation_page(String string) {
		String confirmMessage = pc.PlaceAnOrder();
		AssertJUnit.assertEquals(confirmMessage, string);
		driver.close();
	}

}
