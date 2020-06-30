package sec06.ex01_메소드참조_생성자참조;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

public class MethodReferences {
	public static void main(String[] args) {
		// 메소드·생성자 참조는 람다식에서 단순히 메소드를 호출 하여 리턴하거나 객체를 생성하여 리턴할때 사용된다. 
		
		// 정적메소드 참조
		Supplier<String> supplier = Calculate :: staticMethod;		// supplier = () -> { return Calculate.staticMethod(); };
		System.out.println(supplier.get());
		
		// 인스턴스메소드 참조
		Calculate calculate = new Calculate();
		supplier = calculate :: instanceMethod;		// supplier = () -> { return calculate.instanceMethod(); };
		System.out.println(supplier.get());
		
		// 람다식의 매개 변수의 메소드 참조
		ToIntBiFunction<String, String> toIntBiFunction = String :: compareToIgnoreCase;	// toIntBiFunction = (a,b) -> { return a.compareToIgnoreCase(b); };
		String str1 = "A";
		String str2 = "a";
		int result = toIntBiFunction.applyAsInt(str1,str2);
		if(result < 0) { 
			System.out.println(str1 + " 이 사전순으로 먼저 옵니다.");
		} else if( result > 0) {
			System.out.println(str1 + " 이 사전 순으로 나중에 옵니다.");
		} else {
			System.out.println(str1 + "과 " + str2 + "는 동일한 문자열 입니다.");
		}	

		// 단순히 객체를 생성하고 리턴하도록 구성된 람다식은 생성자 참조로 대치할 수 있다.
		// 생성자가 오버로딩되어 여러개일 경우 , 컴파일러는 함수적인터페이스의 추상메소드와 동일한 매개변수타입과 개수를 가지고 있는 생성자를 찾아 실행함.
		BiFunction<Integer, Integer, Calculate> biFunction = Calculate :: new;		// biFunction = (a,b) -> { return new Calculate(a,b); };
		Calculate calc = biFunction.apply(10, 20);
		System.out.println("Calculate의 x: " +calc.x + ", Calculate의 y: " +calc.y);
		
	}
}

class Calculate {
	int x;
	int y;
	
	Calculate() {}
	
	Calculate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	static String staticMethod() {
		return "정적메소드";
	}
	
	String instanceMethod() {
		return "인스턴스메소드";
	}
	
	String alphabet() {
		return "alphabet";
	}
}