package sec04.ex04_ObjectsisNull;

import java.util.Objects;

public class IsNull {
	public static void main(String[] args) {
		System.out.println(Objects.isNull(null));	//null이 맞는지 판단
		System.out.println(Objects.nonNull(null));	//null이 아닌지 판단
		
		String str = "홍길동";
		System.out.println(Objects.requireNonNull(str));	//null값이 아니면 값을 리턴함.
		
		try {
			Objects.requireNonNull(null);		// null값이 들어가면 NullPointerException예외를 발생시킴
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Objects.requireNonNull(null, "null값이 들어있습니다.");	// null값이 들어가면 NullPointerException예외를 발생시킴
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Supplier 구현 객체로 람다식을 대입
			Objects.requireNonNull(null, ()->"null이 들어있어요~!");	// null값이 들어가면 NullPointerException예외를 발생시킴			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
