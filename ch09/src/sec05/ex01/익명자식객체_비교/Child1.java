package sec05.ex01.익명자식객체_비교;

public class Child1 extends Parent {	
	void work() {
		System.out.println("출근합니다.");
	}

	@Override
	void wake() {
		System.out.print("2시에 일어나서 ");
		work();
	}
}
