package sec04.ex03_ObjectshashCode;

import java.util.Objects;

public class HashCode {
	public static void main(String[] args) {
		Student s1 = new Student(1,"홍길동");
		Student s2 = new Student(1,"홍길동");
		Student s3 = new Student(1,"홍일점");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(Objects.hashCode(s1));
		System.out.println(Objects.hashCode(s2));
		System.out.println(Objects.hashCode(null));		//null일때 0을 리턴한다.
		System.out.println(s3.hashCode());
		System.out.println(Objects.hashCode(s3));
	}
	static class Student {
		int sno;
		String name;
		
		public Student(int sno, String name) {
			this.sno = sno;
			this.name = name;
		}

		@Override
		public int hashCode() {
			/* Objects.hash(Object... values)
			 * Arrays.hashCode(Object[])를 호출해서 해시 코드값을 얻고 그 값을 리턴한다.*/
			return Objects.hash(sno,name);		
		}
		
	}
	
	
}
