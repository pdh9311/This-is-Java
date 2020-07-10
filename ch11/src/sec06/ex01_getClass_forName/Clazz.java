package sec06.ex01_getClass_forName;

public class Clazz {
	public static void main(String[] args) {
		Car car = new Car();
		Class clazz1 = car.getClass();	//객체를 생성해야만 getClass()메소드를 사용할 수 있다.
		System.out.println(clazz1.getName());
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getPackage().getName());
		
		System.out.println("---------------------------------");
		try {
			Class clazz2 = Class.forName("sec06.ex01_getClass_forName.Car");
			System.out.println(clazz2.getName());
			System.out.println(clazz2.getSimpleName());
			System.out.println(clazz2.getPackage().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
