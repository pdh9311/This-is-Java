package sec15.ex01_annotaion;

public class ApplyAnnotation {
	@AnnotationName		// 어노테이션의 기본 엘리먼트인 value의 default 값을 가진다.
	public void method1() {
		System.out.println("실행 내용1");
	}
	
	@AnnotationName("*")	// 어노테이션의 value의 값을 "*"로 변경한다.
	public void method2() {
		System.out.println("실행 내용2");
	}
	
	@AnnotationName(value = "#",element = 15)
	public void method3() {
		System.out.println("실행 내용3");
	}
}
