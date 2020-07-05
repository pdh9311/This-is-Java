package sec05.ex02_���ٽ�_�Լ����������̽�_Supplier;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class SupplierImpl {
	// �Լ����������̽� XXXSupplier�� getXXX()�޼ҵ�� �Ű����� ������ ���ϰ��� �ִ�.
	public static void main(String[] args) {
		// Supplier<T>���� T�� Supplier�� ������ ��ü�� Ÿ���̴�.
		Supplier<String> supplier = () -> { return "Supplier<T>"; };
		String str = supplier.get();
		System.out.println(str);
		
		
		BooleanSupplier booleanSupplier = () -> { return true; };
		Boolean bool = booleanSupplier.getAsBoolean();
		System.out.println(bool);
		
		
		DoubleSupplier boubleSupplier = () -> { return 83.2; };
		Double d = boubleSupplier.getAsDouble();
		System.out.println(d);
		
		
		IntSupplier intSupplier = () -> {
			int sum = 0;
			for(int i=1; i<=100; i++) {
				sum += i;
			}
			return sum; 
		};
		int i = intSupplier.getAsInt();
		System.out.println(i);
		
		
		LongSupplier longSupplier = () -> { return 1231231231231L; };
		Long l = longSupplier.getAsLong();
		System.out.println(l);
		
	}
}
