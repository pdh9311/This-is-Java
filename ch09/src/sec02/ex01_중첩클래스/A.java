package sec02.ex01_��øŬ����;

// �ٱ� Ŭ����
public class A {
	A() {System.out.println("A ��ü ����");}
	// �ν��Ͻ� ��� Ŭ����
	class B { 
		B() {System.out.println("B ��ü ����");}
		int field1;
		void method1() {}
	}
	// ���� ��� Ŭ����
	static class C { 
		C() {System.out.println("C ��ü ����");}
		int field1;
		static int field2;
		void method1() {}
		static void method2() {}
	}
	
	void method() {
		// ���� Ŭ���� �� �ַ� �񵿱� ó���� ���� ������ ��ü�� ���鶧 ���
		class D extends Thread {
			D() {System.out.println("D ��ü ����");}
			int field1;
			void method1() {}
			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.print("D ������ ���� |");
				}
			}
		}
		D d = new D();
		d.field1 = 3;
		d.method1();
		d.start();	// ������ ��ü�� �޼ҵ尡 �������� �� �޸𸮿� ������ �� �ְ� ��� ���๮�� �����ų �� �ֽ��ϴ�.
		System.out.println("method() ��!");
	}

}
