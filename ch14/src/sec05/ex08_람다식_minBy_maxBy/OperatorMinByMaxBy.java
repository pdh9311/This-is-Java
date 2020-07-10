package sec05.ex08_람다식_minBy_maxBy;

import java.util.function.BinaryOperator;

public class OperatorMinByMaxBy {
	public static void main(String[] args) {
		/* BinaryOperator의 정적메소드인 minBy(),maxBy()에 매개타입으로 Comparator인터페이스 익명 객체를 넣어주고,
		 * apply()메소드를 이용해 어느 값이 최소,최대인지 알 수 있다. */
		BinaryOperator<Integer> binaryOperator = BinaryOperator.minBy( (o1,o2) -> { return Integer.compare(o1, o2);} );
		System.out.println(binaryOperator.apply(120, 21));
		
		binaryOperator = BinaryOperator.maxBy((o1,o2) -> { return Integer.compare(o1, o2); } );
		System.out.println(binaryOperator.apply(1231, 1234));
	}
}
