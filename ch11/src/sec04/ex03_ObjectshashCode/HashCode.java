package sec04.ex03_ObjectshashCode;

import java.util.Objects;

public class HashCode {
	public static void main(String[] args) {
		Student s1 = new Student(1,"ȫ�浿");
		Student s2 = new Student(1,"ȫ�浿");
		Student s3 = new Student(1,"ȫ����");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(Objects.hashCode(s1));
		System.out.println(Objects.hashCode(s2));
		System.out.println(Objects.hashCode(null));		//null�϶� 0�� �����Ѵ�.
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
			 * Arrays.hashCode(Object[])�� ȣ���ؼ� �ؽ� �ڵ尪�� ��� �� ���� �����Ѵ�.*/
			return Objects.hash(sno,name);		
		}
		
	}
	
	
}
