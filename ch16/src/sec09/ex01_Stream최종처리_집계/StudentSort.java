package sec09.ex01_Stream최종처리_집계;

import java.util.Comparator;

public class StudentSort implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getAge() < o2.getAge()) return -1;
		else if(o1.getAge() > o2.getAge()) return 1;
		else return 0;
	}
}
