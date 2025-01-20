package CoreJava;

import org.testng.annotations.Test;

public class Maths extends math2 {
	int a;

	public Maths(int a) {
		super(a);
		this.a = a; //this keyword sets instance variable to value of global variable
	}

	@Test
	public int sum() {
		a = a + 1;
		return a;
	}

	@Test
	public int sub() {
		a = a - 1;
		return a;
	}
}
