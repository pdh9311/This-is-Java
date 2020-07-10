package sec08.ex01_abstract;

public class UseAbstract {
	public static void main(String[] args) {
		// 다형성
		Animal animal = null;
		
		animal = new Dog();
		animal.sound();
		
		animal = new Cat();
		animal.sound();
		
		System.out.println("------------");
		
		sound(new Dog());
		sound(new Cat());
	}
	// 자동 타입 변환
	public static void sound(Animal animal) {
		animal.sound();
	}
}
