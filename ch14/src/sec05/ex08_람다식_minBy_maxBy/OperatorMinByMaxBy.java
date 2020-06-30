package sec05.ex08_���ٽ�_minBy_maxBy;

import java.util.function.BinaryOperator;

public class OperatorMinByMaxBy {
	public static void main(String[] args) {
		/* BinaryOperator�� �����޼ҵ��� minBy(),maxBy()�� �Ű�Ÿ������ Comparator�������̽� �͸� ��ü�� �־��ְ�,
		 * apply()�޼ҵ带 �̿��� ��� ���� �ּ�,�ִ����� �� �� �ִ�. */
		BinaryOperator<Integer> binaryOperator = BinaryOperator.minBy( (o1,o2) -> { return Integer.compare(o1, o2);} );
		System.out.println(binaryOperator.apply(120, 21));
		
		binaryOperator = BinaryOperator.maxBy((o1,o2) -> { return Integer.compare(o1, o2); } );
		System.out.println(binaryOperator.apply(1231, 1234));
	}
}
