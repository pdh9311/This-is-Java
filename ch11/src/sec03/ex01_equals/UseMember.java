package sec03.ex01_equals;

public class UseMember {
	public static void main(String[] args) {
		Member m1 = new Member("���1");
		Member m2 = new Member("���2");
		Member m3 = new Member("���1");
		
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(m3));
		
	}
}

