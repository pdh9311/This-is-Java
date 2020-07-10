package sec02.ex01_중첩클래스;

// 바깥 클래스
public class A {
	A() {System.out.println("A 객체 생성");}
	// 인스턴스 멤버 클래스
	class B { 
		B() {System.out.println("B 객체 생성");}
		int field1;
		void method1() {}
	}
	// 정적 멤버 클래스
	static class C { 
		C() {System.out.println("C 객체 생성");}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	void method() {
		// 로컬 클래스 → 주로 비동기 처리를 위해 스레드 객체를 만들때 사용
		class D extends Thread {
			D() {System.out.println("D 객체 생성");}
			int field1;
			void method1() {}
			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.print("D 스레드 시작 |");
				}
			}
		}
		D d = new D();
		d.field1 = 3;
		d.method1();
		d.start();	// 스레드 객체는 메소드가 끝나더라도 힙 메모리에 존재할 수 있고 계속 실행문을 실행시킬 수 있습니다.
		System.out.println("method() 끝!");
	}

}
