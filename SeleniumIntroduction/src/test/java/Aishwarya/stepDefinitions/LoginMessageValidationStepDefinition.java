package Aishwarya.stepDefinitions;

import java.io.IOException;

import org.testng.AssertJUnit;

import Aishwarya.Components.BaseTest;
import Aishwarya.PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginMessageValidationStepDefinition extends BaseTest {

	public LoginPage login;

	@Given("I land on website")
	public void I_land_on_website() throws IOException {
		login = LaunchUrl();

	}

	@When("^I add the details username (.+) and password (.+) and click on login button$")
	public void I_add_the_details_username_and_password_and_click_on_login_button(String username, String password) {
		login.LoginToPortal(username, password);
	}

	@Then("{string} message should be displayed")
	public void message_should_be_displayed(String string) {
		AssertJUnit.assertEquals(string, login.getloginSuccessfullMessage());
		driver.close();

	}

}
