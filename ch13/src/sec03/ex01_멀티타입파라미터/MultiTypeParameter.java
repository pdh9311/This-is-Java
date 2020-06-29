package sec03.ex01_멀티타입파라미터;

public class MultiTypeParameter<K,M> {
	private K kind;
	private M model;
	
	public K getKind() {
		return kind;
	}
	
	public void setKind(K kind) {
		this.kind = kind;
	}
	
	public M getModel() {
		return model;
	}
	
	public void setModel(M model) {
		this.model = model;
	}
	
	public static void main(String[] args) {
		MultiTypeParameter<TV,String> samsungTV = new MultiTypeParameter<TV,String>();
		samsungTV.setKind(new TV());
		samsungTV.setModel("삼성");
		TV tv = samsungTV.getKind();
		String tvName = samsungTV.getModel();
		
		MultiTypeParameter<Car,String> HyundaiCar = new MultiTypeParameter<Car,String>();
		HyundaiCar.setKind(new Car());
		HyundaiCar.setModel("현대");
		Car car = HyundaiCar.getKind();
		String carName = HyundaiCar.getModel();
	}
}

class Car {
	
}

class TV {
	
}


