package sec05.ex07_람다식_and_or_negate_isEqual;

import java.util.function.Predicate;

public class PredicateDefaultMethodStaticMethod {
	public static void main(String[] args) {
		Predicate<Integer> predicate1 = t -> {return t%2 == 0;};
		Predicate<Integer> predicate2 = t -> {return t%3 == 0;};
		Predicate<Integer> predicate12 = predicate1.and(predicate2);
		boolean result = predicate12.test(9);
		System.out.println("9는 2와 3의 배수인가? " + result);
		
		predicate12 = predicate1.or(predicate2);
		result = predicate12.test(9);
		System.out.println("9는 2또는 3의 배수인가? " + result);
		
		predicate12 = predicate1.negate();
		result = predicate12.test(9);
		System.out.println("9는 2의 배수가 아닌가 · 홀수인가? " + result);
		
		predicate12 = predicate2.negate();
		result = predicate12.test(9);
		System.out.println("9는 3의 배수가 아닌가 · 짝수인가? " + result);
		
		// Predicate.isEqual()는 정적메소드로서 매개값과  test()메소드의 매값의 동등비교를 한다.
		Predicate<String> predicate  = Predicate.isEqual(null);
		boolean bool = predicate.test(null);
		System.out.println(bool);
		
		predicate = Predicate.isEqual("value");
		bool = predicate.test(null);
		System.out.println(bool);
		
		predicate = Predicate.isEqual(null);
		bool = predicate.test("value");
		System.out.println(bool);
		
		predicate = Predicate.isEqual("value");
		bool = predicate.test("value");
		System.out.println(bool);
		
		predicate = Predicate.isEqual("value1");
		bool = predicate.test("value2");
		System.out.println(bool);
		
	}
}
