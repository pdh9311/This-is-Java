package sec05.ex01_Stream중간처리_Mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FlatMapXXX {
	public static void main(String[] args) {
		/* flatMapXXX()메소드는 요소를 대체하는 복수 개의 요소들로 구성된 새로운 스트림을 리턴한다.
		 * 매개값으로는 함수적 인터페이스 XXXFunction이 들어간다. */
		List<String> listObj = Arrays.asList("java8 lambda","stream mapping","stream filtering","spring framework","JSP/Servlet");
		List<String> listInt = Arrays.asList("10, 20, 30", "11, 22, 33" , "30, 40, 80, 9");
		List<String> listDouble = Arrays.asList("10.0, 20.0, 30.0", "11.1, 22.2, 33.3" , "30.67, 40.7, 80.7, 9.666");
		List<String> listLong = Arrays.asList("1123123123123 2123123123123 3123123123123", "1234234234234 2234234234234 3234234234234");
		int[] intArray = new int[] {1,2,3,4,5,6,1,2,3,5};
		double[] doubleArray = new double[] {1.2,1.3,5.3,1.2,1.4};
		long[] longArray = new long[] {1231231231231L,2342342342342L,3453453453453L,1231231231231L};
		
		// flatMap( T → Stream<R> )
		Stream<String> stream = listObj.stream();
		stream
		.flatMap(data -> {
			String[] strArr = data.split(" "); 
			System.out.println(Arrays.toString(strArr));
			Stream<String> newStream = Arrays.stream(strArr);
			return newStream;
		})		// .flatMap(data -> Arrays.stream(data.split(" ")))
		.forEach(e -> System.out.println(e));
		System.out.println("------------------");
		// flatMap( int → IntStream ) 
		IntStream intStream = Arrays.stream(intArray);
		intStream
		.distinct()
		.flatMap(i -> Arrays.stream(new int[] {i*3}) )
		.forEach(e -> System.out.print(e + " "));
		
		System.out.println();
		
		// flatMap( double → doubleStream ) 
		DoubleStream doubleStream = Arrays.stream(doubleArray);
		doubleStream
		.flatMap(d -> Arrays.stream(new double[] {d*2.3}))
		.forEach(e -> System.out.printf("%.2f ",e));
		
		System.out.println();
		
		// flatMap( long → longStream ) 
		LongStream longStream = Arrays.stream(longArray);
		longStream
		.flatMap(l -> Arrays.stream(new long[] {l%239}))
		.forEach(e -> System.out.print(e + " "));
	
		System.out.println();
		
		// flatMapToInt( T → IntStream ) 
		Stream<String> streamInt = listInt.stream();
		streamInt
		.flatMapToInt(data -> {
			String[] splitedArr = data.split(",");
			int[] arrayInt = new int[splitedArr.length];
			for(int i=0; i<splitedArr.length; i++) {
				arrayInt[i] = Integer.parseInt(splitedArr[i].trim());
			}
			return Arrays.stream(arrayInt);
		})
		.forEach(e -> System.out.print(e + " "));
		
		System.out.println();
		
		// flatMapToDouble( T → DoubleStream ) 
		Stream<String> streamDouble = listDouble.stream();
		streamDouble
		.flatMapToDouble(data -> {
			String[] splitedArr = data.split(",");
			double[] arrayDouble = new double[splitedArr.length];
			for(int i=0; i<splitedArr.length;i++) {
				arrayDouble[i] = Double.parseDouble(splitedArr[i].trim());
			}
			return Arrays.stream(arrayDouble);
		})
		.forEach(e -> System.out.print(e + " "));
		
		System.out.println();
		
		// flatMapToLong( T → LongStream ) 
		Stream<String> streamLong = listLong.stream();
		streamLong
		.flatMapToLong(data -> {
			String[] splitedArr = data.split(" ");
			long[] arrayLong = new long[splitedArr.length];
			for(int i=0; i<splitedArr.length;i++) {
				arrayLong[i] = Long.parseLong(splitedArr[i].trim());
			}
			return Arrays.stream(arrayLong);
		})
		.forEach(e -> System.out.print(e + " "));
	}
}
