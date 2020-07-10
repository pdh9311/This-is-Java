package sec05.ex06_람다식_andThen_compose;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerFunctionOperatorDefaultMethod {
	public static void main(String[] args) {
		// Consumer종류의 함수적 인터페이스는 리턴값이 없기때문에 andThen()메소드는 호출 순서만 결정한다.
		Consumer<Member> consumer1 = m -> { System.out.println(m.name); };
		Consumer<Member> consumer2 = m -> { System.out.println(m.age); };
		Consumer<Member> andThenConsumer = consumer1.andThen(consumer2);
		andThenConsumer.accept(new Member("홍길동",99));
		
		// Function, Operator종류의 함수적 인터페이스는 먼저 실행한 함수적인터페이스의 리턴값을 두번째로 실행할 함수적인터페이스의 매개값으로 주고 최종 결과를 리턴한다.
		Function<Member,String> fn1 = m -> { return m.name; };
		Function<String,Integer> fn2 = s -> { return (s == "홍길동") ? 100 : 0; };
		// andThen과 compose는 실행 순서에 차이가 있다.
		Function<Member,Integer> fn3 = fn1.andThen(fn2);
		int result1 = fn3.apply(new Member("홍길동", 99));
		System.out.println(result1);
		
		Function<Member,Integer> fn4 = fn2.compose(fn1);
		int result2 = fn4.apply(new Member("홍길동", 99));
		System.out.println(result2);
		
	}
	
}

class Member {
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	
}