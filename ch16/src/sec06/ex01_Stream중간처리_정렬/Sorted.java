package sec06.ex01_Stream중간처리_정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sorted {
	public static void main(String[] args) {
		IntStream intStream = Arrays.stream(new int[] {32,4523,785,324,890,3524});
		intStream
		.sorted()		// 숫자를 오름차순으로 정렬한다.
		.forEach(e -> System.out.print(e + " "));
		
		System.out.println();
		
		List<Student> list1 = Arrays.asList(
				new Student("만식이",30),
				new Student("븝미짱",28),
				new Student("토끼짱",25),
				new Student("초밥짱",29));
		System.out.print("나이순: ");
		Stream<Student> studentStream =  list1.stream();
		studentStream
		// Student에 Comparable을 구현 해둔 기본 방법으로 정렬(3가지 방법)
		.sorted()	
		.sorted( (a,b) -> a.compareTo(b))
		.sorted(Comparator.naturalOrder())
		// Student에 Comparable을 구현 해둔 기본 방법과 반대로 정렬(2가지 방법)
		.sorted( (a,b) -> b.compareTo(a))
		.sorted(Comparator.reverseOrder())
		// Student에 Comparable을 구현 하지않았다면 람다식으로 익명구현객체를 생성하면 된다.
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