package sec05.ex02_Stream중간처리_Mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapXXX {
	public static void main(String[] args) {
		/* mapXXX()메소드는 요소를 대체하는 요소로 구성된 새로운 스트림을 리턴한다.
		 * 매개값으로는 함수적 인터페이스 XXXFunction, XXXOperator가 들어간다. */
		List<String> list = Arrays.asList("홍길동1","홍길동2","홍길동3","홍길동4");
		
		Stream<String> stream1 = list.stream();
		stream1
		.map(a -> Integer.parseInt(a.substring(3)))
		.forEach(e -> System.out.print(e + " "));
		
		System.out.println();
		
		Stream<String> stream = list.stream();
		stream
		.mapToInt(a -> {
			return Integer.parseInt(a.substring(3));
		})
		.forEach(e -> System.out.print(e + " "));

		System.out.println();
		
		
	}
}
