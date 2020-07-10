package sec06.ex01_와일드카드타입;

public class Course<T> {
	private String name;	// 과정명
	private T[] students;
	
	// 생성자의 매개값으로 과정명과 수강가능 인원 수(배열의 크기)를 받는다.
	public Course(String name, int capacity) {
		this.name = name;
		this.students = (T[])(new Object[capacity]);
	}

	public String getName() {
		return name;
	}

	public T[] getStudents() {
		return students;
	}
	
	// 과정에 수강생들을 등록
	public void add(T t) {
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = t; break;
			}
		}
	}
	
	
	
}
