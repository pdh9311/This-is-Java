package sec02.ex01_중첩클래스;

public class Use중첩클래스 {
	public static void main(String[] args) {
		// 바깥 클래스 객체 생성
		A a = new A();
		
		// 인스턴스 멤버 클래스 생성
		A.B b = a.new B();
		
		// 정적 멤버 클래스 생성
		A.C c = new A.C();
		
		// 로컬 클래스 객체 생성을 위한 메소드 호출
		a.method();
		
	}
}
