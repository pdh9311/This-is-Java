package sec15.ex01_annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.METHOD,
		 ElementType.LOCAL_VARIABLE,ElementType.PACKAGE,ElementType.ANNOTATION_TYPE})	//������̼� ���� ���	
@Retention(RetentionPolicy.RUNTIME)		//������̼� ���� ��å
public @interface AnnotationName {
	String value() default "-";		//default ~ ��������, value�� �⺻ ������Ʈ �̴�.
	int element() default 5;		//default ~ ��������
}
