package sec01.ex01_Stream반복자;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorStream {
	public static void main(String[] args) {
		/* Stream은 컬렉션의 저장 요소를 하나씩 참조해서 람다식으로 처리해주는 반복자이다.
		 * 내부 반복자를 사용하므로 병렬 처리가 쉽고, 중간처리와 최종처리 작업을 수행한다. 
		 * 중간처리에서는 매핑, 필터링, 정렬을 수행하고,
		 * 최종처리에서는 반복, 카운팅, 평균, 종합등의 집계처리를 수행한다. */
		List<String> list = Arrays.asList("홍길동","고길동","양주동","백칠동","신기평");
		
		// Iterator
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next() + " " + Thread.currentThread().getName());
		}
		
		System.out.println();
		
		// stream() 
		Stream<String> stream = list.stream();
		stream.forEach(s -> System.out.println(s + " " + Thread.currentThread().getName()));
		
		System.out.println();
		
		// parallelStream()
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(IteratorStream :: threadPrint);
		
		System.out.println();
		
		// parallel()
		Stream<String> parallel = list.stream().parallel();
		parallel.forEach(s -> System.out.println(s + " " + Thread.currentThread().getName()));
		
	}
	
	public static void threadPrint(String str) {
		System.out.println(str + " " + Thread.currentThread().getName());
	}
}