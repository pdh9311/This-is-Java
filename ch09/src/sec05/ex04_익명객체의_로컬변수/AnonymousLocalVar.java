package sec05.ex04_�͸�ü��_���ú���;

public class AnonymousLocalVar {
	private int field;
	
	public void method(final int arg1, int arg2) {
		final int var1 = 0;
		int var2 = 0;
		
		field = 10;
		
		Calculatable calc = new Calculatable() {
			// int arg2 = �Ű���;	(�����Ͻ� �����)
			// int var2 = 0;	(�����Ͻ� �����)
			@Override
			public int sum() {
				// int arg1 = �Ű���;	(�����Ͻ� �����)
				// int var1 = 0;	(�����Ͻ� �����)
				int result = field+arg1+arg2+var1+var2; 
				return result;
			}
		};
		System.out.println(calc.sum());
	}
}
