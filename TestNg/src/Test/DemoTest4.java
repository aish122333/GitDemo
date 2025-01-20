package Test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest4 {

	@Test
	public void Test1() {
		System.out.println("this is demo4 test1");
	}

	@Test(groups= {"Smoke"})
	public void Test2() {
		System.out.println("this is demo4 test2");
	}

	@BeforeTest
	public void Test3() {
		System.out.println("This is before test");
	}

	@BeforeSuite
	public void beforesuite() {
		System.out.println("this is before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("this is after suite");
	}
// The scope of befortest and aftertest is only applicate upto test folder
// that means if we see testng4xml file 1st test folder has two classes demo1
// and demo2 so that will
// run analtered, but in before and after annotations are in demo3 and 4 which
// are present in test2 folder
// hence that will be applicable only for those class in that particular test
// module

}
