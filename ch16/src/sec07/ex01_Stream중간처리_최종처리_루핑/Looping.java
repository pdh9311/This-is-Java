package sec07.ex01_Stream중간처리_최종처리_루핑;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Looping {
	public static void main(String[] args) {
		/* peek()메소드는 중간처리에서 루핑하는 메소드로써 최종처리 메소드가 호출되기전에는 실행되지 않는다.
		 * forEach()메소드는 최종처리 메소드이므로 뒤에 다른 최종처리 메소드가 올 수 없다. */
		int[] intArray = {1,2,3,4,5,6,7,8,9,10};
		
		IntStream intStream1 = Arrays.stream(intArray);
		int sum = intStream1
				.filter(a-> a%2==0)
				.peek(a->System.out.print(a + " "))
				.sum();
		System.out.println("| 1~10에서 2의 배수의 합: " + sum);
		
		IntStream intStream2 = Arrays.stream(intArray);
		intStream2
		.filter(a->a%2==0)
		.forEach(a->System.out.print(a + " "));
	}
}
