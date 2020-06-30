package sec05.ex06_���ٽ�_andThen_compose;

import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerFunctionOperatorDefaultMethod {
	public static void main(String[] args) {
		// Consumer������ �Լ��� �������̽��� ���ϰ��� ���⶧���� andThen()�޼ҵ�� ȣ�� ������ �����Ѵ�.
		Consumer<Member> consumer1 = m -> { System.out.println(m.name); };
		Consumer<Member> consumer2 = m -> { System.out.println(m.age); };
		Consumer<Member> andThenConsumer = consumer1.andThen(consumer2);
		andThenConsumer.accept(new Member("ȫ�浿",99));
		
		// Function, Operator������ �Լ��� �������̽��� ���� ������ �Լ����������̽��� ���ϰ��� �ι�°�� ������ �Լ����������̽��� �Ű������� �ְ� ���� ����� �����Ѵ�.
		Function<Member,String> fn1 = m -> { return m.name; };
		Function<String,Integer> fn2 = s -> { return (s == "ȫ�浿") ? 100 : 0; };
		// andThen�� compose�� ���� ������ ���̰� �ִ�.
		Function<Member,Integer> fn3 = fn1.andThen(fn2);
		int result1 = fn3.apply(new Member("ȫ�浿", 99));
		System.out.println(result1);
		
		Function<Member,Integer> fn4 = fn2.compose(fn1);
		int result2 = fn4.apply(new Member("ȫ�浿", 99));
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