package sec08.ex01_Stream����ó��_��Ī;

import java.util.Arrays;
import java.util.stream.IntStream;

public class XXXMatch {
	public static void main(String[] args) {
		/* allMatch(),anyMatch(),noneMatch()�޼ҵ�� ����ó�� �޼ҵ��̸�
		 * �Ű������� �Լ��� �������̽��� Predicate�� ������ ������ Boolean���� �����Ѵ�. */
		int[] intArray = {2,4,6};
		
		IntStream intStream1 = Arrays.stream(intArray);
		boolean isTwoTimes = intStream1
				.allMatch(a -> a%2 == 0);
		System.out.println((isTwoTimes == true) ? "��� 2�� ����Դϴ�." : "2�� ����� �ƴѰ��� �ֽ��ϴ�.");
		
		IntStream intStream2 = Arrays.stream(intArray);
		boolean isThreeTimes = intStream2
				.anyMatch(a -> a%3 == 0);
		System.out.println((isThreeTimes == true) ? "�Ѱ� �̻��� 3�� ����� �ֽ��ϴ�." : "3�� ����� ���� �ϳ��� �����ϴ�.");
		
		IntStream intStream3 = Arrays.stream(intArray);
		isTwoTimes = intStream3
				.noneMatch(a -> a%2 == 0);
		System.out.println((isTwoTimes == true) ? "��� 2�� ����� �ƴմϴ�." : "�ϳ� �̻��� 2�� ����� ���� �ֽ��ϴ�.");
	}
}
