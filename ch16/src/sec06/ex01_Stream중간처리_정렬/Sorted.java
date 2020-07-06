package sec06.ex01_Stream�߰�ó��_����;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sorted {
	public static void main(String[] args) {
		IntStream intStream = Arrays.stream(new int[] {32,4523,785,324,890,3524});
		intStream
		.sorted()		// ���ڸ� ������������ �����Ѵ�.
		.forEach(e -> System.out.print(e + " "));
		
		System.out.println();
		
		List<Student> list1 = Arrays.asList(
				new Student("������",30),
				new Student("���¯",28),
				new Student("�䳢¯",25),
				new Student("�ʹ�¯",29));
		System.out.print("���̼�: ");
		Stream<Student> studentStream =  list1.stream();
		studentStream
		// Student�� Comparable�� ���� �ص� �⺻ ������� ����(3���� ���)
		.sorted()	
		.sorted( (a,b) -> a.compareTo(b))
		.sorted(Comparator.naturalOrder())
		// Student�� Comparable�� ���� �ص� �⺻ ����� �ݴ�� ����(2���� ���)
		.sorted( (a,b) -> b.compareTo(a))
		.sorted(Comparator.reverseOrder())
		// Student�� Comparable�� ���� �����ʾҴٸ� ���ٽ����� �͸�����ü�� �����ϸ� �ȴ�.
		.sorted( (a,b) -> {
			if(a.getAge() < b.getAge()) { return -1; }
			else if(a.getAge() > b.getAge()) { return 1; }
			else { return 0; }
		})
		.forEach(e -> System.out.print(e.getName() + " "));
		
	}
}

class Student implements Comparable<Student>{
	private String name;
	private int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	@Override
	public int compareTo(Student o) {
		return Integer.compare(this.age,o.age);
	}
}