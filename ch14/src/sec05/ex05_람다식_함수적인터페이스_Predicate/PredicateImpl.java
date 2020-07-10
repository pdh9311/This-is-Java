package sec05.ex05_람다식_함수적인터페이스_Predicate;

import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class PredicateImpl {
	// 함수적인터페이스 XXXPredicate의 testXXX()메소드는 매개값이 있고 리턴값이 boolean이다.
	public static void main(String[] args) {
		Predicate<String> predicate = t -> { 
			if(t.equals("0")) {
				return false;
			} else {
				return true;
			}
		};
		boolean bool = predicate.test("0");
		System.out.println(bool);
		bool = predicate.test("100");
		System.out.println(bool);
		
		BiPredicate<Integer, Integer> biPredicate = (t1,t2) -> {
			if(t1 == t2) { 
				return true;
			} else {
				return false;
			}
		};
		bool = biPredicate.test(123, 123);
		System.out.println(bool);
		bool = biPredicate.test(100, 23);
		System.out.println(bool);
		
		DoublePredicate doublePredicate = t -> {
			if(t > 0.0 && t < 1.0) {
				return true;
			}
			return false;
		};
		bool = doublePredicate.test(0.2321);
		System.out.println(bool);
		
		IntPredicate intPredicate = t -> {
			return (t>0) ? true : false;
		};
		bool = intPredicate.test(10);
		System.out.println(bool);
		bool = intPredicate.test(-10);
		System.out.println(bool);
		
		LongPredicate longPredicate = t -> {
			return (t > Integer.MAX_VALUE) ? true : false;
		};
		bool = longPredicate.test(1231231231231L);
		System.out.println("현재 값이 int최대값 보다 큰 값인가? " + bool);
		
		
	}
}
