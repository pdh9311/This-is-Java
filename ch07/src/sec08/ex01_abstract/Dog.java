package sec08.ex01_abstract;

public class Dog extends Animal{
	
	// 추상메소드 오버라이딩
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
	
}
