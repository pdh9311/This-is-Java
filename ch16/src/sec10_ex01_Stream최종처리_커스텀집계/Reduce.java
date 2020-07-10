package sec10_ex01_Stream최종처리_커스텀집계;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Reduce {
	public static void main(String[] args) {
		/* reduce()메소드는 사용자가 원하는 대로 다양한 집계를 만들 수 있도록 하기 위해 제공된 메소드이다.
		 * 매개값으로는 함수형 인터페이스 XXXOperator를 넣어준다. */
		
		// reduce()메소드의 매개값이 1개일때는 리턴타입이 OptionalXXX이다.
		IntStream intStream1 = Arrays.stream(new int[] {1,2,3});
		OptionalInt optionalInt1 = intStream1.reduce((a,b) -> a+b);
		int sum1 = optionalInt1.getAsInt();
		System.out.println(sum1);
		
		// reduce()메소드의 매개값이 2개일때는 첫번째 매개값은 초기값이며 리턴타입은 int, double, long이다.
		IntStream intStream2 = Arrays.stream(new int[] {1,2,3});
		int sum2 = intStream2.reduce(10,(a,b)-> {
			System.out.println("a: " + a +  " b: " + b);
			return a+b;
		});
		System.out.println(sum2);
		
	}
}
