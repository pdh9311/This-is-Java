package sec05.ex02_instanceof�������̽�;

public class UseVehicle {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		
		// instanceof �����ڴ� ���� Ÿ�Ժ�ȯ�� �Ű����� Ÿ���� Ȯ���� �� �ַ� ���ȴ�.(���,�������̽�)
		if(vehicle instanceof Bus) {
			Bus bus = (Bus) vehicle;
			bus.checkFare();
		}
		
		vehicle.run();
	}
}
