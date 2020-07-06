package sec08.ex01_Stream최종처리_매칭;

import java.util.Arrays;
import java.util.stream.IntStream;

public class XXXMatch {
	public static void main(String[] args) {
		/* allMatch(),anyMatch(),noneMatch()메소드는 최종처리 메소드이며
		 * 매개값으로 함수형 인터페이스인 Predicate가 들어오기 때문에 Boolean값을 리턴한다. */
		int[] intArray = {2,4,6};
		
		IntStream intStream1 = Arrays.stream(intArray);
		boolean isTwoTimes = intStream1
				.allMatch(a -> a%2 == 0);
		System.out.println((isTwoTimes == true) ? "모두 2의 배수입니다." : "2의 배수가 아닌값이 있습니다.");
		
		IntStream intStream2 = Arrays.stream(intArray);
		boolean isThreeTimes = intStream2
				.anyMatch(a -> a%3 == 0);
		System.out.println((isThreeTimes == true) ? "한개 이상의 3의 배수가 있습니다." : "3의 배수인 값이 하나도 없습니다.");
		
		IntStream intStream3 = Arrays.stream(intArray);
		isTwoTimes = intStream3
				.noneMatch(a -> a%2 == 0);
		System.out.println((isTwoTimes == true) ? "모두 2의 배수가 아닙니다." : "하나 이상의 2의 배수인 값이 있습니다.");
	}
}
