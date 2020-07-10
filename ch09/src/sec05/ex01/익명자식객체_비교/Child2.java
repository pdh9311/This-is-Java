package sec05.ex01.익명자식객체_비교;

public class Child2 extends Parent {
	
	void walk() {
		System.out.println("산책합니다.");
	}
	
	@Override
	void wake() {
		System.out.print("4시에 ");
		walk();
	}
}
