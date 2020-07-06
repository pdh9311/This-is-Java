package sec04.ex01_Stream�߰�ó��_Filtering;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Filtering {
	public static void main(String[] args) {
		/** (�߰���Ʈ���� �߰�ó���� ���ٰ� ������ �� ������ �ٸ� �ǹ���.)
		 * �߰� ��Ʈ���� �����ɶ� ��ҵ��� �ٷ� �߰�ó���Ǵ°��� �ƴ϶� ����ó���� ���۵Ǳ� ������ �߰�ó���� ����(lazy)�ǰ�,
		 * ����ó���� ���۵Ǹ� ��μ� �÷����� ��Ұ� �ϳ��� �߰� ��Ʈ������ ó���ǰ� ����ó������ ���� �ȴ�. */
		/* distinct()�޼ҵ�� �ߺ��� �����ϴµ�, Object.equals(Object)�� true�̸� ������ ��ü�� �Ǵ��Ѵ�.
		 * filter()�޼ҵ�� �Ű������� �Լ��� �������̽� Predicate�� �־����� true�� �����ϴ� ��Ҹ� ���͸��Ѵ�. */
		List<String> listObj = Arrays.asList("1��","2��","3��","4��","1��","5��");
		int[] intArray = new int[] {1,2,3,4,5,6,1,2,3,5};
		double[] doubleArray = new double[] {1.2,1.3,5.3,1.2,1.4};
		long[] longArray = new long[] {1231231231231L,2342342342342L,3453453453453L,1231231231231L};
		
		Stream<String> stream = listObj.stream();
		stream
		.distinct()		// �ߺ�����
		.filter(a -> a.startsWith("1"))	// 1�� �����ϴ� �͸� ���͸�
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
