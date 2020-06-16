package sec05.ex01.익명자식객체_비교;

public class Child3 extends Parent {

	void study() {
		System.out.println("공부합니다.");
	}
	
	@Override
	void wake() {
		System.out.print("8시에 ");
		study();
	}
	
}
