package sec15.ex01_annotaion;

public class ApplyAnnotation {
	@AnnotationName		// ������̼��� �⺻ ������Ʈ�� value�� default ���� ������.
	public void method1() {
		System.out.println("���� ����1");
	}
	
	@AnnotationName("*")	// ������̼��� value�� ���� "*"�� �����Ѵ�.
	public void method2() {
		System.out.println("���� ����2");
	}
	
	@AnnotationName(value = "#",element = 15)
	public void method3() {
		System.out.println("���� ����3");
	}
}
