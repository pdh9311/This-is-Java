package sec06.ex02_reflection_newInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import sec06.ex01_getClass_forName.Car;

public class Reflection {
	public static void main(String[] args) {
		try {
			//클래스 객체 생성
			Class clazz = Class.forName("sec06.ex01_getClass_forName.Car");
			//클랙스의 인스턴스 생성 (new 연산자를 사용하지 않고 동적으로 객체 생성)
			Car carobj = (Car)clazz.newInstance();
			carobj.carName = "람보르기니";
			System.out.println(carobj.carName + "\n");
			
			System.out.println("[클래스 이름]");
			System.out.println(clazz.getName()+ "\n");
			
			System.out.println("[필드 정보]");
			Field[] fields = clazz.getDeclaredFields();
			for(Field field : fields) {
				System.out.print(field.getType().getSimpleName() + " ");
				System.out.println(field.getName());
			}
			
			System.out.println("\n[생성자 정보]");
			Constructor[] constructors = clazz.getDeclaredConstructors();
			for(Constructor constructor : constructors) {
				System.out.print(constructor.getName() + "(");
				Class[] parameters = constructor.getParameterTypes();
				printParameters(parameters);
				System.out.println(")");
			}
			
			System.out.println("\n[메소드 정보]");
			Method[] methods = clazz.getDeclaredMethods();
			for(Method method : methods) {
				System.out.print(method.getName() + "(");
				Class[] parameters = method.getParameterTypes();
				printParameters(parameters);
				System.out.println(")");
			}
			
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 매개변수 정보 
	private static void printParameters(Class[] parameters) {
		for(int i=0; i<parameters.length; i++) {
			System.out.print(parameters[i].getName());
			if(parameters.length-i > 1) {
				System.out.print(",");
			}
		}
		
	}
}
