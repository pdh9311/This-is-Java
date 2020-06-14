package sec07.ex01_instanceof상속;

public class UseInstanceof {
	// instanceof 연산자는 강제 타입변환시 매개값의 타입을 확인할 때 주로 사용된다.(상속,인터페이스)
	public static void method(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("Child 타입으로 변환 가능");
		} else {
			System.out.println("Child 타입으로 변환 불가능");
		}
	}
	public static void main(String[] args) {
		Parent parent1 = new Parent();
		Parent parent2 = new Child();
		
		method(parent1);
		method(parent2);
	}
}
