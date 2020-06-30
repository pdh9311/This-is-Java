package sec05.ex03_���ٽ�_�Լ����������̽�_Function;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;

public class FunctionImpl {
	// �Լ����������̽� XXXFunction�� applyXXX()�޼ҵ�� �Ű���, ���ϰ��� �ִ�.
	public static void main(String[] args) {
		Function<String,String> function = t -> { return t; };
		String str = function.apply("Function<T>");
		System.out.println(str);
		
		BiFunction<String, String, String> biFunction = (t,u) -> { return t+u; };
		str = biFunction.apply("BiFun", "ction<T,U,V>");
		System.out.println(str);
		
		System.out.println("-------------------------------------------------------------");
		
		DoubleFunction<String> doubleFunction = d -> { return String.valueOf(d); };
		str = doubleFunction.apply(3423.1);
		System.out.println(str);
		
		IntFunction<String> intFunction = i -> { return String.valueOf(i); };
		str = intFunction.apply(100);
		System.out.println(str);
		
		System.out.println("-------------------------------------------------------------");
		
		IntToDoubleFunction intToDoubleF = iTod -> { return iTod; };
		Double d = intToDoubleF.applyAsDouble(120);
		System.out.println(d);
		
		IntToLongFunction intToLongF = iTol -> { return iTol; };
		Long l = intToLongF.applyAsLong(8854);
		System.out.println(l);
		
		System.out.println("-------------------------------------------------------------");
		
		LongToDoubleFunction longToDoubleF = lTod -> { return lTod; };
		d = longToDoubleF.applyAsDouble(1231231231231L);
		System.out.println(d);
		
		LongToIntFunction longToIntF = lToi -> { return (int) lToi; };
		int i = longToIntF.applyAsInt(123123L);
		System.out.println(i);
		
		System.out.println("-------------------------------------------------------------");
		
		ToDoubleBiFunction<String, String> toDoubleBiF = (t,u) -> {
			double d1 = 0.0;
			double d2 = 0;
			try {
				d1 = Double.parseDouble(t);
				d2 = Double.parseDouble(u);
			} catch (NumberFormatException e) {
				System.out.print("���ڸ� Double�� d1 �Ǵ� d2�� ������ �� �����ϴ�. > ");
			}
			return d1 + d2;
		};
		Double d1d2Result = toDoubleBiF.applyAsDouble("123.2", "3982.1");
		System.out.println(d1d2Result);
		d1d2Result = toDoubleBiF.applyAsDouble("������", "������");
		System.out.println(d1d2Result);
		
		ToDoubleFunction<String> toDoubleF = t -> {
			Double d3 = 0.0;
			try {
				d3 = Double.parseDouble(t);
			} catch (NumberFormatException e) {
				System.out.print("���ڸ� Double�� d3�� ������ �� �����ϴ�. > ");
			}
			return d3;
		};
		Double d3Result = toDoubleF.applyAsDouble("3242.1");
		System.out.println(d3Result);
		d3Result = toDoubleF.applyAsDouble("����1��");
		System.out.println(d3Result);
		
		System.out.println("-------------------------------------------------------------");
		
		ToIntBiFunction<String, String> toIntBiF = (t,u) -> {
			int i1 = 0;
			int i2 = 0;
			try {
				i1 = Integer.valueOf(t);
				i2 = Integer.valueOf(u);
			} catch (NumberFormatException e) {
				System.out.print("���ڸ� int�� i1 �Ǵ� i2�� �ٲܼ� �����ϴ�. > ");
			}
			return i1 + i2;
		};
		int i1i2Result = toIntBiF.applyAsInt("3", "34");
		System.out.println(i1i2Result);
		i1i2Result = toIntBiF.applyAsInt("��", "3");
		System.out.println(i1i2Result);
		
		ToIntFunction<String> toIntF = t -> {
			int i3 = 0;
			try {
				i3 = Integer.valueOf(t);
			} catch (NumberFormatException e) {
				System.out.print("���ڸ� int�� i3���� �ٲܼ� �����ϴ�. > ");
			}
			return i3;
		};
		int i3Result = toIntF.applyAsInt("100");
		System.out.println(i3Result);
		i3Result = toIntF.applyAsInt("��");
		System.out.println(i3Result);
		
		System.out.println("-------------------------------------------------------------");
		
		ToLongBiFunction<String, String> toLongBiF = (t,u) -> {
			long l1 = 0;
			long l2 = 0;
			try {
				l1 = Long.valueOf(t);
				l2 = Long.valueOf(u);
			} catch (NumberFormatException e) {
				System.out.print("���ڸ� long�� l1 �Ǵ� l2�� �ٲܼ� �����ϴ�. > ");
			}
			return l1 + l2;
		};
		long l1l2Result = toLongBiF.applyAsLong("3", "1231231231231");
		System.out.println(l1l2Result);
		l1l2Result = toLongBiF.applyAsLong("��", "1231231231231");
		System.out.println(l1l2Result);
		
		ToLongFunction<String> toLongF = t -> {
			long l3 = 0;
			try {
				l3 = Long.valueOf(t);
			} catch (NumberFormatException e) {
				System.out.print("���ڸ� long�� l3���� �ٲܼ� �����ϴ�. > ");
			}
			return l3;
		};
		long l3Result = toLongF.applyAsLong("1231231231231");
		System.out.println(l3Result);
		l3Result = toLongF.applyAsLong("1��4õ��");
		System.out.println(l3Result);
		
		
	}
}
