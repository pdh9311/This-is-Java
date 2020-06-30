package sec06.ex01_�޼ҵ�����_����������;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;

public class MethodReferences {
	public static void main(String[] args) {
		// �޼ҵ塤������ ������ ���ٽĿ��� �ܼ��� �޼ҵ带 ȣ�� �Ͽ� �����ϰų� ��ü�� �����Ͽ� �����Ҷ� ���ȴ�. 
		
		// �����޼ҵ� ����
		Supplier<String> supplier = Calculate :: staticMethod;		// supplier = () -> { return Calculate.staticMethod(); };
		System.out.println(supplier.get());
		
		// �ν��Ͻ��޼ҵ� ����
		Calculate calculate = new Calculate();
		supplier = calculate :: instanceMethod;		// supplier = () -> { return calculate.instanceMethod(); };
		System.out.println(supplier.get());
		
		// ���ٽ��� �Ű� ������ �޼ҵ� ����
		ToIntBiFunction<String, String> toIntBiFunction = String :: compareToIgnoreCase;	// toIntBiFunction = (a,b) -> { return a.compareToIgnoreCase(b); };
		String str1 = "A";
		String str2 = "a";
		int result = toIntBiFunction.applyAsInt(str1,str2);
		if(result < 0) { 
			System.out.println(str1 + " �� ���������� ���� �ɴϴ�.");
		} else if( result > 0) {
			System.out.println(str1 + " �� ���� ������ ���߿� �ɴϴ�.");
		} else {
			System.out.println(str1 + "�� " + str2 + "�� ������ ���ڿ� �Դϴ�.");
		}	

		// �ܼ��� ��ü�� �����ϰ� �����ϵ��� ������ ���ٽ��� ������ ������ ��ġ�� �� �ִ�.
		// �����ڰ� �����ε��Ǿ� �������� ��� , �����Ϸ��� �Լ����������̽��� �߻�޼ҵ�� ������ �Ű�����Ÿ�԰� ������ ������ �ִ� �����ڸ� ã�� ������.
		BiFunction<Integer, Integer, Calculate> biFunction = Calculate :: new;		// biFunction = (a,b) -> { return new Calculate(a,b); };
		Calculate calc = biFunction.apply(10, 20);
		System.out.println("Calculate�� x: " +calc.x + ", Calculate�� y: " +calc.y);
		
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
		return "�����޼ҵ�";
	}
	
	String instanceMethod() {
		return "�ν��Ͻ��޼ҵ�";
	}
	
	String alphabet() {
		return "alphabet";
	}
}