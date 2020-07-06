package sec05.ex02_Stream�߰�ó��_Mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapXXX {
	public static void main(String[] args) {
		/* mapXXX()�޼ҵ�� ��Ҹ� ��ü�ϴ� ��ҷ� ������ ���ο� ��Ʈ���� �����Ѵ�.
		 * �Ű������δ� �Լ��� �������̽� XXXFunction, XXXOperator�� ����. */
		List<String> list = Arrays.asList("ȫ�浿1","ȫ�浿2","ȫ�浿3","ȫ�浿4");
		
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
