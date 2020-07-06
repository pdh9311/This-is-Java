package sec05.ex03_Stream중간처리;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class AsDoubleLongStreamBoxed {
	public static void main(String[] args) {
		int[] intArray = new int[] {1,2,3,4,5,6,1,2,3,5};
		double[] doubleArray = new double[] {1.2,1.3,5.3,1.2,1.4};
		long[] longArray = new long[] {1231231231231L,2342342342342L,3453453453453L,1231231231231L};
		
		IntStream intStream1 = Arrays.stream(intArray);
		intStream1
		.asDoubleStream()	// IntStream의 int요소를 double요소로 바꾸고 DoubleStream을 리턴
		.forEach(e -> System.out.print(e+ " "));
		
		System.out.println();
		
		LongStream longStream1 = Arrays.stream(longArray);
		longStream1
		.asDoubleStream()	// LongStream의 long요소를 double요소로 바꾸고 DoubleStream을 리턴
		.forEach(e -> System.out.print(e + " "));
		
		System.out.println();
		
		IntStream intStream2 = Arrays.stream(intArray);
		intStream2
		.asLongStream()	// IntStream의 int요소를 long요소로 바꾸고 LongStream을 리턴
		.forEach(e -> System.out.print(e + " "));

		System.out.println("\n"); 

		IntStream intStream3 = Arrays.stream(intArray);
		intStream3
		.boxed()	// Stream<Integer> 생성
		.forEach(IntegerObj -> System.out.print(IntegerObj + " "));
		System.out.println(); 
		
		DoubleStream doubleStream = Arrays.stream(doubleArray);
		doubleStream
		.boxed()	// Stream<Double> 생성
		.forEach(DoubleObj -> System.out.print(DoubleObj + " "));
		System.out.println(); 
		
		LongStream longStream2 = Arrays.stream(longArray);
		longStream2
		.boxed()	// Stream<Long> 생성
		.forEach(LongObj -> System.out.print(LongObj + " "));
		
		
		
	}
}
