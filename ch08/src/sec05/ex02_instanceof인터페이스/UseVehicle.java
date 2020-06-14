package sec05.ex02_instanceof인터페이스;

public class UseVehicle {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		
		// instanceof 연산자는 강제 타입변환시 매개값의 타입을 확인할 때 주로 사용된다.(상속,인터페이스)
		if(vehicle instanceof Bus) {
			Bus bus = (Bus) vehicle;
			bus.checkFare();
		}
		
		vehicle.run();
	}
}
