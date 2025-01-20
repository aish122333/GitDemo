package CoreJava;

import org.testng.annotations.Test;

public class math2 extends ParentClass {

	int a;

	public math2(int i) {

		this.a = i;
	}

	@Test()
	public int multipletwo() {
		a = a * 2;
		return a;

	}

	@Test()
	public int multiplethree() {
		a = a * 3;
		return a;

	}
}
