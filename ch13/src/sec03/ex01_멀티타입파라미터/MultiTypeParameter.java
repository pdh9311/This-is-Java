package sec03.ex01_��ƼŸ���Ķ����;

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
		samsungTV.setModel("�Ｚ");
		TV tv = samsungTV.getKind();
		String tvName = samsungTV.getModel();
		
		MultiTypeParameter<Car,String> HyundaiCar = new MultiTypeParameter<Car,String>();
		HyundaiCar.setKind(new Car());
		HyundaiCar.setModel("����");
		Car car = HyundaiCar.getKind();
		String carName = HyundaiCar.getModel();
	}
}

class Car {
	
}

class TV {
	
}


