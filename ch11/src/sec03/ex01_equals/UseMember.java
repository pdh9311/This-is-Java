package sec03.ex01_equals;

public class UseMember {
	public static void main(String[] args) {
		Member m1 = new Member("¸â¹ö1");
		Member m2 = new Member("¸â¹ö2");
		Member m3 = new Member("¸â¹ö1");
		
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(m3));
		
	}
}

