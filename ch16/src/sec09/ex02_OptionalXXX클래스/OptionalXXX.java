package sec09.ex02_OptionalXXX클래스;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class OptionalXXX {
	public static void main(String[] args) {
		/* 기본집계 메소드를 사용할때 Stream에 요소가 없으면 NoSuchElementException이 발생한다.
		 * 이를 예방하기 위해 집계값이 존재하는지 확인, 존재하지 않을경우 디폴트값을 설정, 집계값이 존재할때만 처리하는 Consumer 등록의 세 가지 방법을 예방할 수 있다. */
		
		// isPresent()메소드는 집계값이 있는지 확인하고 Boolean값을 리턴한다.
		IntStream intStream1 = Arrays.stream(new int[] {});
		OptionalDouble optionalDouble1 = intStream1.average();
		if(optionalDouble1.isPresent()) {
			System.out.println("평균: " + optionalDouble1.getAsDouble());
		}else { 
			System.out.println("평균: 0.0");
		}

		// orElse()메소드는 집계값이 없으면 디폴트값을 매개값으로 설정한다.
		IntStream intStream2 = Arrays.stream(new int[] {});
		OptionalDouble optionalDouble2 = intStream2.average();
		double avg = optionalDouble2.orElse(0.0);
		System.out.println("평균: " + avg);
		
		// ifPresent()메소드는 집계값이 있으면 매개값으로 함수형 인터페이스 Consumer를 처리한다.
		IntStream intStream3 = Arrays.stream(new int[] {});
//		IntStream intStream3 = Arrays.stream(new int[] {1,2,2,34,5,2});
		intStream3
		.average()
		.ifPresent(a -> System.out.println("평균: " + a));
	}
}
