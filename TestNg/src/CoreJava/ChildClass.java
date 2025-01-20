package CoreJava;

import org.testng.annotations.Test;

public class ChildClass extends ParentClass {
	int a = 3;

	@Test
	public void cc() {
		System.out.println("this is child class");
		Maths m = new Maths(a);// parametrized constructor as we are sending parametrs in constructor
		System.out.print("sum is " + m.sum());
		System.out.println("  Sub is " + m.sub());
		System.out.println(m.multiplethree());
	}

}
