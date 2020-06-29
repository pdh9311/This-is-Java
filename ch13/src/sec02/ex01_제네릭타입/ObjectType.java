package sec02.ex01_제네릭타입;

public class ObjectType {
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	public static void main(String[] args) {
		// 최상위 클래스인 Object타입을 사용하므모써 모든 객체를 저장할 수 있지만 빈번한 타입변환으로 인해 전체 프로그램 성능에 좋지 못한 결과를 가져올 수 있다.
		ObjectType objType = new ObjectType();
		objType.setObject(new Apple());				// Apple객체가 Object로 자동 타입 변환 된다.
		Apple apple = (Apple)objType.getObject();	// Object객체가 Apple로 강제 타입 변환 된다.	
	}
	
}

class Apple {
	
}
