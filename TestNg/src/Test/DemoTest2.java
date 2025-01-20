package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTest2 {

	@Test
	@Parameters({ "URL" })
	public void Test1(String url) {
		System.out.println("this is demo2 test1");
		System.out.println(url);
	}

	@Test(groups = { "Smoke" })
	public void Test2() {
		System.out.println("this is demo2 test2");
	}

	@Test(dataProvider = "getData")
	public void Test3(String username, String password) {
		System.out.println("this is demo2 test3");
		System.out.println(username + "and" + password);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "firstusername";
		data[0][1] = "firstpassword";

		data[1][0] = "secondusername";
		data[1][1] = "secondpassword";

		data[2][0] = "thirdusername";
		data[2][1] = "thirdpassword";
		return data;

	}
}
