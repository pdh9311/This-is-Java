package sec05.ex02_람다식_함수적인터페이스_Supplier;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class SupplierImpl {
	// 함수적인터페이스 XXXSupplier의 getXXX()메소드는 매개값은 없지만 리턴값이 있다.
	public static void main(String[] args) {
		// Supplier<T>에서 T는 Supplier가 리턴할 객체의 타입이다.
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
