package sec08.ex01_abstract;

public class UseAbstract {
	public static void main(String[] args) {
		// ������
		Animal animal = null;
		
		animal = new Dog();
		animal.sound();
		
		animal = new Cat();
		animal.sound();
		
		System.out.println("------------");
		
		sound(new Dog());
		sound(new Cat());
	}
	// �ڵ� Ÿ�� ��ȯ
	public static void sound(Animal animal) {
		animal.sound();
	}
}
