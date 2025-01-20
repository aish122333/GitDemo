package CoreJava;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParentClass {


	@Test
	public void pc() {
		System.out.println("this is parentclass");
	}

	@BeforeTest
	public void test1() {
		System.out.println("this is before test");
	}

	@AfterTest
	public void test2() {
		System.out.println("this is after test");
	}


}
