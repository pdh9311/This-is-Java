package sec04.ex01_Stream중간처리_Filtering;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Filtering {
	public static void main(String[] args) {
		/** (중간스트림과 중간처리를 같다고 착각할 수 있지만 다른 의미임.)
		 * 중간 스트림이 생성될때 요소들이 바로 중간처리되는것이 아니라 최종처리가 시작되기 전까지 중간처리는 지연(lazy)되고,
		 * 최종처리가 시작되면 비로소 컬렉션의 요소가 하나씩 중간 스트림에서 처리되고 최종처리까지 오게 된다. */
		/* distinct()메소드는 중복을 제거하는데, Object.equals(Object)가 true이면 동일한 객체로 판단한다.
		 * filter()메소드는 매개값으로 함수적 인터페이스 Predicate가 주어지며 true를 리턴하는 요소만 필터링한다. */
		List<String> listObj = Arrays.asList("1번","2번","3번","4번","1번","5번");
		int[] intArray = new int[] {1,2,3,4,5,6,1,2,3,5};
		double[] doubleArray = new double[] {1.2,1.3,5.3,1.2,1.4};
		long[] longArray = new long[] {1231231231231L,2342342342342L,3453453453453L,1231231231231L};
		
		Stream<String> stream = listObj.stream();
		stream
		.distinct()		// 중복제거
		.filter(a -> a.startsWith("1"))	// 1로 시작하는 것만 필터링
		.forEach(System.out :: println);
		
		IntStream intStream = Arrays.stream(intArray);
		intStream.distinct().filter(i -> i > 3).forEach(i -> System.out.print(i + " "));
		
		System.out.println();
		
		DoubleStream doubleStream = Arrays.stream(doubleArray); 
		doubleStream.distinct().filter(d -> d < 3).forEach(d -> System.out.print(d + " "));
		
		System.out.println();
		
		LongStream longStream = Arrays.stream(longArray);
		longStream.distinct().filter(l -> l > 2342342342341L ).forEach(l -> System.out.print(l + " "));
	}
}
