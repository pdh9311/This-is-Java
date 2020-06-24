package sec06.ex01_getClass_forName;

public class Car {
	public int carNumber;
	public String carName;
	
	public Car() { System.out.println("Car °´Ã¼ »ý¼º");}
	
	public Car(String carName) {
		this.carName = carName;
	}
	
	public Car(int carNumber, String carName) {
		this.carNumber = carNumber;
		this.carName = carName;
	}

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	
}
