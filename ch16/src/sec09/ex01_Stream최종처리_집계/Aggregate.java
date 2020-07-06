package sec09.ex01_Stream����ó��_����;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Aggregate {
	public static void main(String[] args) {
		/* �⺻ ���� �޼ҵ�δ� count(), findFirst(), max(), min(), average(), sum()�� �ִ�.
		 * OptionalXXXŬ������ �� ��� Ŭ�����̸�, get(), getAsInt(), getAsDouble(), getAsLong() �޼ҵ�� ȣ���� �� �ִ�. */
		int[] intArray = {1,2,3,4,5,6,7,8,9};
		
		IntStream intStream1 = Arrays.stream(intArray);
		long count = intStream1.filter(a -> a%2 ==0).count();
		System.out.println("2�� ��� ����: " + count);
		
		IntStream intStream2 = Arrays.stream(intArray);
		OptionalInt optionalInt1 = intStream2.filter(a -> a%6 == 0).findFirst();
		System.out.println("6�� ����� ù��° ��: " + optionalInt1.getAsInt());
		
		IntStream intStream3 = Arrays.stream(intArray);
		OptionalInt optionalInt2 = intStream3.max();
		System.out.println("�ִ밪: " + optionalInt2.getAsInt());
		
		IntStream intStream4 = Arrays.stream(intArray);
		OptionalInt optionalInt3 = intStream4.min();
		System.out.println("�ּҰ�: " + optionalInt3.getAsInt());
		
		IntStream intStream5 = Arrays.stream(intArray);
		OptionalDouble optionalDouble = intStream5.average();
		System.out.println("��հ�: " + optionalDouble.getAsDouble());
		
		IntStream intStream6 = Arrays.stream(intArray);
		int sum = intStream6.sum();
		System.out.println("����: " + sum);
		
		// ��ü�� �ִ롤�ּ� ���� ���Ҷ��� max(),min()�� �Ű������� Comparator�������̽��� ������ ��ü�� �־��ָ� �ȴ�.
		List<Student> list = Arrays.asList(new Student("����¯",30), new Student("���¯",28),new Student("�ʹ�¯",30),new Student("�䳢¯",25));
		Stream<Student> stream1 = list.stream();
		Optional<Student> optionalStudent1 = stream1.max(new StudentSort());
		System.out.println(optionalStudent1.get().getName());
		
		Stream<Student> stream2 = list.stream();
		Optional<Student> optionalStudent2 = stream2.min(new StudentSort());
		System.out.println(optionalStudent2.get().getName());
	}
}

