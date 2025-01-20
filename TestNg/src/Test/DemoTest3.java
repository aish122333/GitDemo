package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest3 {

	@Test
	public void Test1() {
		System.out.println("this is demo3 test1");
	}
	
	@Test(groups= {"Smoke"})
	public void Test2() {
		System.out.println("this is demo3 test2");
	}
	
	@AfterTest
	public void Test3() {
		System.out.println("this is after test run");
	}
	
	//The scope of befortest and aftertest is only applicate upto test folder
	//that means if we see testng4xml file 1st test folder has two classes demo1 and demo2 so that will
	//run analtered, but in before and after annotations are in demo3 and 4 which are present in test2 folder
	//hence that will be applicable only for those class in that particular test module

@BeforeMethod
public void beforeMethod() {
	System.out.println("this is before method example");
}

@AfterMethod
public void afterMethod() {
	System.out.println("this is after method example");
}
}
