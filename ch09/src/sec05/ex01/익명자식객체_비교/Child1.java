package sec05.ex01.�͸��ڽİ�ü_��;

public class Child1 extends Parent {	
	void work() {
		System.out.println("����մϴ�.");
	}

	@Override
	void wake() {
		System.out.print("2�ÿ� �Ͼ�� ");
		work();
	}
}
