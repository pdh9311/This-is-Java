package sec05.ex01.익명자식객체_비교;

public class UseChild {
	public static void main(String[] args) {
		Child child = new Child();
		child.field.wake();
		child.method1();
		child.method2(new Child3());
		
	}
}
