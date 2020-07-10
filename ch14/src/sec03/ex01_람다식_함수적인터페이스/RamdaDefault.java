package sec03.ex01_람다식_함수적인터페이스;

@FunctionalInterface		// 함수적인터페이스를 작성할때 추상 메소드가 2개 이상 선언되지 않도록 컴파일러가 체크해주는 기능
public interface RamdaDefault {
	void method1();
}
