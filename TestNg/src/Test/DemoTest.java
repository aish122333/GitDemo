package Test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTest {
	@Parameters({"URL","username"})
	@Test
	public void Demo1(String url,String username) {
		System.out.println("This is demo1");
		System.out.println(url);
		System.out.println(username);
	}
	
	@Test(groups= {"Smoke"})
	public void Demo2() {
		System.out.println("This is demo2");
	}
	
	@Test
	public void Demo3() {
		System.out.println("This is demo3");
	}
	
	@Test(enabled=false)
	public void failurecasesoignoredruingrun() {
		System.out.println("Dont run this case as it will fail");
	}
	
	@Test(timeOut = 4000)
	public void timeoutcase() {
		System.out.println("this case might take 40 seconds to run so given timeout");
	}
	
}
