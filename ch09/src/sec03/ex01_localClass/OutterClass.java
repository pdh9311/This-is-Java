package sec03.ex01_localClass;

public class OutterClass {
	/* ���� Ŭ������ �����ϴ� �޼ҵ忡 �Ű������� ���ú����� ���� Ŭ�������� ���� �� 
	 * ������ �� ���� Ŭ�������� ����ϴ� �Ű������� ���ú����� ���� ���� Ŭ���� ���ο� ������ �ΰ� ����Ѵ�.
	 * �̶� ���� Ŭ�������� ���� �Ű������� ���ú����� final Ư���� ���´�. */
	public void method1(final int arg1, int arg2) {
		final int var1 = 1;
		int var2 = 2;
		class localClass {
			// int arg2 = �Ű���;	(�����Ͻ� �����)
			// int var2 = 2;	(�����Ͻ� �����)
			void method2() {
				// int arg1 = �Ű���;	(�����Ͻ� �����)
				// int var1 = 1;	(�����Ͻ� �����)
				int result = arg1+arg2+var1+var2;
			}
		}
	}
	
}
