package sec05.ex01_interfaceArray;

public class UseCar {
	public static void main(String[] args) {
		Car car = new Car();
		car.run();
		
		System.out.println("----------");
		car.tires[0] = new Kumho();
		car.tires[1] = new Kumho();
		car.run();
	}
}
