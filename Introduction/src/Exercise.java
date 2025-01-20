public class Exercise {

	public static void main(String[] args) {
		int [] numbers = {10,20,30,40,50};
		System.out.println(numbers[0]);
		System.out.println(numbers[4]);
		System.out.println("==============");

		for (int i=numbers.length-1;i>=0;i--) {
			System.out.println(numbers[i]);
		}
		
		System.out.println(numbers.length + " is the number of elemets in array");
	}
}