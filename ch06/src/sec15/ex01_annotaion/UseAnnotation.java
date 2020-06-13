package sec15.ex01_annotaion;

import java.lang.reflect.Method;

public class UseAnnotation {
	public static void main(String[] args) {
		//getDeclaredMethod(): ������̼��� ����� �޼ҵ���� �����Ѵ�.
		Method[] declaredMethods = ApplyAnnotation.class.getDeclaredMethods();
		
		for(Method method : declaredMethods) {
			//isAnnotationPresent(������̼� Ŭ����): (�޼ҵ忡)������̼��� ����Ǿ��ִ��� Ȯ���Ѵ�.
			if(method.isAnnotationPresent(AnnotationName.class)) {
				// getAnnotation(������̼� Ŭ����): (�޼ҵ忡)������̼��� ����Ǿ������� ������̼��� �����Ѵ�.
				AnnotationName annotationName = method.getAnnotation(AnnotationName.class);
				
				System.out.println("["+method.getName()+"]");
				
				for(int i=0;i<annotationName.element();i++) {
					System.out.print(annotationName.value());
				}
				System.out.println();
				
				try {
					// ApplyAnnotation ��ü�� �����ϰ� ������ ApplyAnnotation ��ü�� �޼ҵ带 ȣ���ϴ� �ڵ�
					method.invoke(new ApplyAnnotation());
				} catch (Exception e) {}
				System.out.println();
			}
			
		}
		
	}


}
