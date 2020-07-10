package sec15.ex01_annotaion;

import java.lang.reflect.Method;

public class UseAnnotation {
	public static void main(String[] args) {
		//getDeclaredMethod(): 어노테이션이 적용된 메소드들을 리턴한다.
		Method[] declaredMethods = ApplyAnnotation.class.getDeclaredMethods();
		
		for(Method method : declaredMethods) {
			//isAnnotationPresent(어노테이션 클래스): (메소드에)어노테이션이 적용되어있는지 확인한다.
			if(method.isAnnotationPresent(AnnotationName.class)) {
				// getAnnotation(어노테이션 클래스): (메소드에)어노테이션이 적용되어있으면 어노테이션을 리턴한다.
				AnnotationName annotationName = method.getAnnotation(AnnotationName.class);
				
				System.out.println("["+method.getName()+"]");
				
				for(int i=0;i<annotationName.element();i++) {
					System.out.print(annotationName.value());
				}
				System.out.println();
				
				try {
					// ApplyAnnotation 객체를 생성하고 생성된 ApplyAnnotation 객체의 메소드를 호출하는 코드
					method.invoke(new ApplyAnnotation());
				} catch (Exception e) {}
				System.out.println();
			}
			
		}
		
	}


}
