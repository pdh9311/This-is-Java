package sec09.ex02_OptionalXXXŬ����;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class OptionalXXX {
	public static void main(String[] args) {
		/* �⺻���� �޼ҵ带 ����Ҷ� Stream�� ��Ұ� ������ NoSuchElementException�� �߻��Ѵ�.
		 * �̸� �����ϱ� ���� ���谪�� �����ϴ��� Ȯ��, �������� ������� ����Ʈ���� ����, ���谪�� �����Ҷ��� ó���ϴ� Consumer ����� �� ���� ����� ������ �� �ִ�. */
		
		// isPresent()�޼ҵ�� ���谪�� �ִ��� Ȯ���ϰ� Boolean���� �����Ѵ�.
		IntStream intStream1 = Arrays.stream(new int[] {});
		OptionalDouble optionalDouble1 = intStream1.average();
		if(optionalDouble1.isPresent()) {
			System.out.println("���: " + optionalDouble1.getAsDouble());
		}else { 
			System.out.println("���: 0.0");
		}

		// orElse()�޼ҵ�� ���谪�� ������ ����Ʈ���� �Ű������� �����Ѵ�.
		IntStream intStream2 = Arrays.stream(new int[] {});
		OptionalDouble optionalDouble2 = intStream2.average();
		double avg = optionalDouble2.orElse(0.0);
		System.out.println("���: " + avg);
		
		// ifPresent()�޼ҵ�� ���谪�� ������ �Ű������� �Լ��� �������̽� Consumer�� ó���Ѵ�.
		IntStream intStream3 = Arrays.stream(new int[] {});
//		IntStream intStream3 = Arrays.stream(new int[] {1,2,2,34,5,2});
		intStream3
		.average()
		.ifPresent(a -> System.out.println("���: " + a));
	}
}
