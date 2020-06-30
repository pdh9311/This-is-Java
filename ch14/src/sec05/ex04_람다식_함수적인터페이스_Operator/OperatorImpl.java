package sec05.ex04_람다식_함수적인터페이스_Operator;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

public class OperatorImpl {
	// 함수적인터페이스 XXXOperator의 applyXXX()메소드는 매개값, 리턴값이 있다.
	public static void main(String[] args) {
		BinaryOperator<String> binaryOperator = (t1,t2) -> { return t1+t2; };
		String str = binaryOperator.apply("시작 123", "끝 456");
		System.out.println(str);
		
		UnaryOperator<String> unaryOperator = t -> { return t; };
		str = unaryOperator.apply("유너리 오퍼레이터");
		System.out.println(str);
		
		DoubleBinaryOperator doubleBinaryOperator = (d1,d2) -> { return d1+d2; };
		double d = doubleBinaryOperator.applyAsDouble(10.0, 20.0);
		System.out.println(d);
		
		DoubleUnaryOperator doubleUnaryOperator = d3 -> { return d3; };
		d = doubleUnaryOperator.applyAsDouble(11.1);
		System.out.println(d);
		
		IntBinaryOperator intBinaryOperator = (i1,i2) -> { return i1+i2; };
		int i = intBinaryOperator.applyAsInt(10, 20);
		System.out.println(i);
		
		IntUnaryOperator intUnaryOperator = i3 -> { return i3; };
		i = intUnaryOperator.applyAsInt(11);
		System.out.println(i);
		
		LongBinaryOperator longBinaryOperator = (l1,l2) -> { return l1+l2; };
		long l = longBinaryOperator.applyAsLong(1123123, 1231231231231L);
		System.out.println(l);
		
		LongUnaryOperator longUnaryOperator = l3 -> { return l3; };
		l = longUnaryOperator.applyAsLong(234234234234L);
		System.out.println(l);
		
	}
}
