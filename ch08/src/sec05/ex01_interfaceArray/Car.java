package sec05.ex01_interfaceArray;

public class Car {
	Tire[] tires = {
		new Hankook(),
		new Hankook(),
		new Hankook(),
		new Hankook()
	};
	
	void run() {
		for(Tire tire : tires) {
			tire.roll();
		}
		
	}
}
