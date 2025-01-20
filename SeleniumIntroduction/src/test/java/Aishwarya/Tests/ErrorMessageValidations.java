package Aishwarya.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Aishwarya.Components.BaseTest;
import Aishwarya.Components.retry;

public class ErrorMessageValidations extends BaseTest {

	@Test(groups = {"ErrorMessageforLogin"} , retryAnalyzer = retry.class)
	public void loginErrorMessage() throws IOException, InterruptedException {

		login.LoginToPortal("aishhhhh@gamil.com", "Aishwaryaaaa@123");
		AssertJUnit.assertEquals("Incorrect email or password", login.getErrorMessage());
	}
		
	@Test
	public void successMessage() {
		login.LoginToPortal("aish@gamil.com", "Aishwarya@123");
		AssertJUnit.assertEquals("Login Successfully", login.getloginSuccessfullMessage());
	}

}
