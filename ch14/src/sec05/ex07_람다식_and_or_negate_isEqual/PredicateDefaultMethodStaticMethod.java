package sec05.ex07_���ٽ�_and_or_negate_isEqual;

import java.util.function.Predicate;

public class PredicateDefaultMethodStaticMethod {
	public static void main(String[] args) {
		Predicate<Integer> predicate1 = t -> {return t%2 == 0;};
		Predicate<Integer> predicate2 = t -> {return t%3 == 0;};
		Predicate<Integer> predicate12 = predicate1.and(predicate2);
		boolean result = predicate12.test(9);
		System.out.println("9�� 2�� 3�� ����ΰ�? " + result);
		
		predicate12 = predicate1.or(predicate2);
		result = predicate12.test(9);
		System.out.println("9�� 2�Ǵ� 3�� ����ΰ�? " + result);
		
		predicate12 = predicate1.negate();
		result = predicate12.test(9);
		System.out.println("9�� 2�� ����� �ƴѰ� �� Ȧ���ΰ�? " + result);
		
		predicate12 = predicate2.negate();
		result = predicate12.test(9);
		System.out.println("9�� 3�� ����� �ƴѰ� �� ¦���ΰ�? " + result);
		
		// Predicate.isEqual()�� �����޼ҵ�μ� �Ű�����  test()�޼ҵ��� �Ű��� ����񱳸� �Ѵ�.
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
