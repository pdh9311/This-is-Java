package sec02.ex01_��øŬ����;

public class Use��øŬ���� {
	public static void main(String[] args) {
		// �ٱ� Ŭ���� ��ü ����
		A a = new A();
		
		// �ν��Ͻ� ��� Ŭ���� ����
		A.B b = a.new B();
		
		// ���� ��� Ŭ���� ����
		A.C c = new A.C();
		
		// ���� Ŭ���� ��ü ������ ���� �޼ҵ� ȣ��
		a.method();
		
	}
}
