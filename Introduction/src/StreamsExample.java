import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamsExample {

	// print names starttng with A
	@Test()
	public void test1() {
		List<String> names = Arrays.asList("Aishuu", "prasad", "Adam", "don", "Akhil", "Rama");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).startsWith("A")) {
				count++;

			}
		}
		System.out.println("Count is " + count);
	}

	// Do the same with streams
	@Test
	public void test2() {
		List<String> names = Arrays.asList("Aishuu", "prasad", "Adam", "don", "Akhil", "Rama");
		long num = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(num);
	}

	// Do the above and print the values
	@Test
	public void test3() {
		List<String> names = Arrays.asList("Aishuu", "prasad", "Adam", "don", "Akhil", "Rama");
		names.stream().filter(s -> s.startsWith("A")).forEach(s -> System.out.println(s));
	}

	// Print same but in capital letters
	@Test
	public void test4() {
		List<String> names = Arrays.asList("Aishuu", "prasad", "Adam", "don", "Akhil", "Rama");
		names.stream().filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
	}

	// Print only one result not all 3

	@Test()
	public void Test5() {

		Stream.of("Aishuu", "prasad", "Adam", "don", "Akhil", "Rama").filter(s -> s.startsWith("A")).limit(1)
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
	}
	
	//Concatinating of two streams
	@Test()
	public void Test6() {
		List<String> list1 = Arrays.asList("aa","bb");
		List<String> list2 = Arrays.asList("cc","dd");
		Stream<String> finalList = Stream.concat(list1.stream(), list2.stream());
		finalList.forEach(s->System.out.println(s));
	}
	
	//We can add the data in collector of any type as well say list, array list etc
	
	@Test()
	public void Test7() {
		
	List<String> names = Stream.of("aish","prasad","gourav").filter(s->s.length()>3).sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
	System.out.println(names.get(0));
	System.out.println(names.get(1));
	}
	
	@Test()
	public void Test8() {
		List<Integer> numbers = Arrays.asList(1,2,3,3,2,4,5,6,6);
		//get the unique numbers and sort the array and get the middle number in array
		
		List<Integer> sortedNums = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("Middle number is "+sortedNums.get(2));
		
	}

}
