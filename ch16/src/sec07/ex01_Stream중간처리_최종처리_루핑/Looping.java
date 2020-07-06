package sec07.ex01_Stream�߰�ó��_����ó��_����;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Looping {
	public static void main(String[] args) {
		/* peek()�޼ҵ�� �߰�ó������ �����ϴ� �޼ҵ�ν� ����ó�� �޼ҵ尡 ȣ��Ǳ������� ������� �ʴ´�.
		 * forEach()�޼ҵ�� ����ó�� �޼ҵ��̹Ƿ� �ڿ� �ٸ� ����ó�� �޼ҵ尡 �� �� ����. */
		int[] intArray = {1,2,3,4,5,6,7,8,9,10};
		
		IntStream intStream1 = Arrays.stream(intArray);
		int sum = intStream1
				.filter(a-> a%2==0)
				.peek(a->System.out.print(a + " "))
				.sum();
		System.out.println("| 1~10���� 2�� ����� ��: " + sum);
		
		IntStream intStream2 = Arrays.stream(intArray);
		intStream2
		.filter(a->a%2==0)
		.forEach(a->System.out.print(a + " "));
	}
}
