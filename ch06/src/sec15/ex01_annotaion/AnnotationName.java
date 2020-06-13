package sec15.ex01_annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.METHOD,
		 ElementType.LOCAL_VARIABLE,ElementType.PACKAGE,ElementType.ANNOTATION_TYPE})	//어노테이션 적용 대상	
@Retention(RetentionPolicy.RUNTIME)		//어노테이션 유지 정책
public @interface AnnotationName {
	String value() default "-";		//default ~ 생략가능, value는 기본 엘리먼트 이다.
	int element() default 5;		//default ~ 생략가능
}
