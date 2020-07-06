package sec01.ex01_Stream�ݺ���;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorStream {
	public static void main(String[] args) {
		/* Stream�� �÷����� ���� ��Ҹ� �ϳ��� �����ؼ� ���ٽ����� ó�����ִ� �ݺ����̴�.
		 * ���� �ݺ��ڸ� ����ϹǷ� ���� ó���� ����, �߰�ó���� ����ó�� �۾��� �����Ѵ�. 
		 * �߰�ó�������� ����, ���͸�, ������ �����ϰ�,
		 * ����ó�������� �ݺ�, ī����, ���, ���յ��� ����ó���� �����Ѵ�. */
		List<String> list = Arrays.asList("ȫ�浿","��浿","���ֵ�","��ĥ��","�ű���");
		
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