package sec05.ex01.�͸��ڽİ�ü_��;

public class Child2 extends Parent {
	
	void walk() {
		System.out.println("��å�մϴ�.");
	}
	
	@Override
	void wake() {
		System.out.print("4�ÿ� ");
		walk();
	}
}
