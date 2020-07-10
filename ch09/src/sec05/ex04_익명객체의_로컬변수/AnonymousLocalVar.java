package sec05.ex04_익명객체의_로컬변수;

public class AnonymousLocalVar {
	private int field;
	
	public void method(final int arg1, int arg2) {
		final int var1 = 0;
		int var2 = 0;
		
		field = 10;
		
		Calculatable calc = new Calculatable() {
			// int arg2 = 매개값;	(컴파일시 복사됨)
			// int var2 = 0;	(컴파일시 복사됨)
			@Override
			public int sum() {
				// int arg1 = 매개값;	(컴파일시 복사됨)
				// int var1 = 0;	(컴파일시 복사됨)
				int result = field+arg1+arg2+var1+var2; 
				return result;
			}
		};
		System.out.println(calc.sum());
	}
}
