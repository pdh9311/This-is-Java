package sec03.ex02_��øŬ����this;

public class OutterClass {
	String field = "Outter-filed";
	
	void method() {
		System.out.println("Outter-method");
	}
	// �ν��Ͻ� ��� Ŭ����
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
