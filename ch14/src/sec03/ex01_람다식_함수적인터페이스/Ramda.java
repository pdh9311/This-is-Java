package sec03.ex01_람다식_함수적인터페이스;

public class Ramda {
	public static void main(String[] args) {
		// 람다식은 인터페이스의 익명 구현 클래스를 생성하고 객체화 한다.
		/* 람다식의 매개타입은 생략 가능하고, 매개변수는 하나일경우 괄호()를 생략할 수 있다.
		 * 람다식에서 중괄호{}에 실행코드가 하나일 경우 중괄호{}를 생략할 수 있다.
		 * 람다식에서 중괄호{}에 실행코드가 리턴타입만 작성되어있을 경우 중괄호{}와 Return문은 생략할 수 있다. */
		
		 
		RamdaDefault ramdaDefault; 
		ramdaDefault= () -> { 
			String str = "람다식 기본";
			System.out.println(str); 
		};
		ramdaDefault = () -> { System.out.println("람다식 기본"); };
		ramdaDefault = () -> System.out.println("람다식 기본");
		ramdaDefault.method1();			// 람다식실행을 위해 익명 구현 객체의 메소드를 호출하면 된다.
		
		RamdaParameter ramdaParameter;
		ramdaParameter = (int x) -> {
			int result = x*4;
			System.out.println(result); 
		};
		ramdaParameter = (x) -> { System.out.println(x*4); };
		ramdaParameter = x -> System.out.println(x*4);
		ramdaParameter.method2(311);	// 람다식실행을 위해 익명 구현 객체의 메소드를 호출하면 된다.
		
		RamdaReturn ramdaReturn;
		ramdaReturn = (x,y) -> { return x+y; };
		ramdaReturn = (x,y) -> x+y;
		int returnValue = ramdaReturn.method3(12, 33);
		System.out.println(returnValue);	// 람다식실행을 위해 익명 구현 객체의 메소드를 호출하면 된다.
		
		
	}
}
