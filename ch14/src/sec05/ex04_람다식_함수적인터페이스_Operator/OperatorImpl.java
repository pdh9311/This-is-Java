package sec05.ex04_���ٽ�_�Լ����������̽�_Operator;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.UnaryOperator;

public class OperatorImpl {
	// �Լ����������̽� XXXOperator�� applyXXX()�޼ҵ�� �Ű���, ���ϰ��� �ִ�.
	public static void main(String[] args) {
		BinaryOperator<String> binaryOperator = (t1,t2) -> { return t1+t2; };
		String str = binaryOperator.apply("���� 123", "�� 456");
		System.out.println(str);
		
		UnaryOperator<String> unaryOperator = t -> { return t; };
		str = unaryOperator.apply("���ʸ� ���۷�����");
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
