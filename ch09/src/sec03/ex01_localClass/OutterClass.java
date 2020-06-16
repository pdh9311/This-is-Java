package sec03.ex01_localClass;

public class OutterClass {
	/* 로컬 클래스를 포함하는 메소드에 매개변수나 로컬변수가 로컬 클래스에서 사용될 때 
	 * 컴파일 시 로컬 클래스에서 사용하는 매개변수나 로컬변수의 값을 로컬 클래스 내부에 복사해 두고 사용한다.
	 * 이때 로컬 클래스에서 사용된 매개변수나 로컬변수는 final 특성을 갖는다. */
	public void method1(final int arg1, int arg2) {
		final int var1 = 1;
		int var2 = 2;
		class localClass {
			// int arg2 = 매개값;	(컴파일시 복사됨)
			// int var2 = 2;	(컴파일시 복사됨)
			void method2() {
				// int arg1 = 매개값;	(컴파일시 복사됨)
				// int var1 = 1;	(컴파일시 복사됨)
				int result = arg1+arg2+var1+var2;
			}
		}
	}
	
}
