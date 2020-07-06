package sec09.ex01_Stream최종처리_집계;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Aggregate {
	public static void main(String[] args) {
		/* 기본 집계 메소드로는 count(), findFirst(), max(), min(), average(), sum()이 있다.
		 * OptionalXXX클래스는 값 기반 클래스이며, get(), getAsInt(), getAsDouble(), getAsLong() 메소드로 호출할 수 있다. */
		int[] intArray = {1,2,3,4,5,6,7,8,9};
		
		IntStream intStream1 = Arrays.stream(intArray);
		long count = intStream1.filter(a -> a%2 ==0).count();
		System.out.println("2의 배수 개수: " + count);
		
		IntStream intStream2 = Arrays.stream(intArray);
		OptionalInt optionalInt1 = intStream2.filter(a -> a%6 == 0).findFirst();
		System.out.println("6의 배수인 첫번째 값: " + optionalInt1.getAsInt());
		
		IntStream intStream3 = Arrays.stream(intArray);
		OptionalInt optionalInt2 = intStream3.max();
		System.out.println("최대값: " + optionalInt2.getAsInt());
		
		IntStream intStream4 = Arrays.stream(intArray);
		OptionalInt optionalInt3 = intStream4.min();
		System.out.println("최소값: " + optionalInt3.getAsInt());
		
		IntStream intStream5 = Arrays.stream(intArray);
		OptionalDouble optionalDouble = intStream5.average();
		System.out.println("평균값: " + optionalDouble.getAsDouble());
		
		IntStream intStream6 = Arrays.stream(intArray);
		int sum = intStream6.sum();
		System.out.println("총합: " + sum);
		
		// 객체의 최대·최소 값을 구할때는 max(),min()의 매개값으로 Comparator인터페이스를 구현한 객체를 넣어주면 된다.
		List<Student> list = Arrays.asList(new Student("만식짱",30), new Student("븝미짱",28),new Student("초밥짱",30),new Student("토끼짱",25));
		Stream<Student> stream1 = list.stream();
		Optional<Student> optionalStudent1 = stream1.max(new StudentSort());
		System.out.println(optionalStudent1.get().getName());
		
		Stream<Student> stream2 = list.stream();
		Optional<Student> optionalStudent2 = stream2.min(new StudentSort());
		System.out.println(optionalStudent2.get().getName());
	}
}

