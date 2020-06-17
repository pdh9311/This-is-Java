package sec04.ex01_Objectscompare;

import java.util.Comparator;
import java.util.Objects;

public class Compare {
	public static void main(String[] args) {
		Student s1 = new Student(1);
		Student s2 = new Student(2);
		Student s3 = new Student(1);
		
		int result = Objects.compare(s1, s2, new StudentComparator());
		System.out.println(result);
		
		result = Integer.compare(s1.sno, s2.sno);
		System.out.println(result);
		System.out.println("-------");
		result = Objects.compare(s1, s3, new StudentComparator());
		System.out.println(result);
		
		result = Integer.compare(s1.sno,s3.sno);
		System.out.println(result);
	}
	
	static class Student {
		int sno;
	
		public Student(int sno) {
			this.sno = sno;
		}
	}
	
	static class StudentComparator implements Comparator<Student> {
	
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.sno < o2.sno) { return -1; }
			else if(o1.sno == o2.sno) { return 0; }
			else { return -1; }
			// return Integer.compare(o1.sno,o2.sno);	// if~else문 대신 대체 가능함.
		}
		
	}
}
