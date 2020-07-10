package sec03.ex02_중첩클래스this;

public class OutterClass {
	String field = "Outter-filed";
	
	void method() {
		System.out.println("Outter-method");
	}
	// 인스턴스 멤버 클래스
	class LocalClass {
		String field = "Local-field";
	
		void method() {
			System.out.println("Local-method");
		}
		
		void print() {
			System.out.println(OutterClass.this.field);
			OutterClass.this.method();
			
			System.out.println(this.field);
			this.method();
		}
	}
	
}
