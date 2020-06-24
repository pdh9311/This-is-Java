package sec06.ex02_reflection_newInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import sec06.ex01_getClass_forName.Car;

public class Reflection {
	public static void main(String[] args) {
		try {
			//Ŭ���� ��ü ����
			Class clazz = Class.forName("sec06.ex01_getClass_forName.Car");
			//Ŭ������ �ν��Ͻ� ���� (new �����ڸ� ������� �ʰ� �������� ��ü ����)
			Car carobj = (Car)clazz.newInstance();
			carobj.carName = "���������";
			System.out.println(carobj.carName + "\n");
			
			System.out.println("[Ŭ���� �̸�]");
			System.out.println(clazz.getName()+ "\n");
			
			System.out.println("[�ʵ� ����]");
			Field[] fields = clazz.getDeclaredFields();
			for(Field field : fields) {
				System.out.print(field.getType().getSimpleName() + " ");
				System.out.println(field.getName());
			}
			
			System.out.println("\n[������ ����]");
			Constructor[] constructors = clazz.getDeclaredConstructors();
			for(Constructor constructor : constructors) {
				System.out.print(constructor.getName() + "(");
				Class[] parameters = constructor.getParameterTypes();
				printParameters(parameters);
				System.out.println(")");
			}
			
			System.out.println("\n[�޼ҵ� ����]");
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
	// �Ű����� ���� 
	private static void printParameters(Class[] parameters) {
		for(int i=0; i<parameters.length; i++) {
			System.out.print(parameters[i].getName());
			if(parameters.length-i > 1) {
				System.out.print(",");
			}
		}
		
	}
}
