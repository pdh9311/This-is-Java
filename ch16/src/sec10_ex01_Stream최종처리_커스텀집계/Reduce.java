package sec10_ex01_Stream����ó��_Ŀ��������;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Reduce {
	public static void main(String[] args) {
		/* reduce()�޼ҵ�� ����ڰ� ���ϴ� ��� �پ��� ���踦 ���� �� �ֵ��� �ϱ� ���� ������ �޼ҵ��̴�.
		 * �Ű������δ� �Լ��� �������̽� XXXOperator�� �־��ش�. */
		
		// reduce()�޼ҵ��� �Ű����� 1���϶��� ����Ÿ���� OptionalXXX�̴�.
		IntStream intStream1 = Arrays.stream(new int[] {1,2,3});
		OptionalInt optionalInt1 = intStream1.reduce((a,b) -> a+b);
		int sum1 = optionalInt1.getAsInt();
		System.out.println(sum1);
		
		// reduce()�޼ҵ��� �Ű����� 2���϶��� ù��° �Ű����� �ʱⰪ�̸� ����Ÿ���� int, double, long�̴�.
		IntStream intStream2 = Arrays.stream(new int[] {1,2,3});
		int sum2 = intStream2.reduce(10,(a,b)-> {
			System.out.println("a: " + a +  " b: " + b);
			return a+b;
		});
		System.out.println(sum2);
		
	}
}
