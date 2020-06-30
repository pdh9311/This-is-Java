package sec03.ex01_���ٽ�_�Լ����������̽�;

public class Ramda {
	public static void main(String[] args) {
		// ���ٽ��� �������̽��� �͸� ���� Ŭ������ �����ϰ� ��üȭ �Ѵ�.
		/* ���ٽ��� �Ű�Ÿ���� ���� �����ϰ�, �Ű������� �ϳ��ϰ�� ��ȣ()�� ������ �� �ִ�.
		 * ���ٽĿ��� �߰�ȣ{}�� �����ڵ尡 �ϳ��� ��� �߰�ȣ{}�� ������ �� �ִ�.
		 * ���ٽĿ��� �߰�ȣ{}�� �����ڵ尡 ����Ÿ�Ը� �ۼ��Ǿ����� ��� �߰�ȣ{}�� Return���� ������ �� �ִ�. */
		
		 
		RamdaDefault ramdaDefault; 
		ramdaDefault= () -> { 
			String str = "���ٽ� �⺻";
			System.out.println(str); 
		};
		ramdaDefault = () -> { System.out.println("���ٽ� �⺻"); };
		ramdaDefault = () -> System.out.println("���ٽ� �⺻");
		ramdaDefault.method1();			// ���ٽĽ����� ���� �͸� ���� ��ü�� �޼ҵ带 ȣ���ϸ� �ȴ�.
		
		RamdaParameter ramdaParameter;
		ramdaParameter = (int x) -> {
			int result = x*4;
			System.out.println(result); 
		};
		ramdaParameter = (x) -> { System.out.println(x*4); };
		ramdaParameter = x -> System.out.println(x*4);
		ramdaParameter.method2(311);	// ���ٽĽ����� ���� �͸� ���� ��ü�� �޼ҵ带 ȣ���ϸ� �ȴ�.
		
		RamdaReturn ramdaReturn;
		ramdaReturn = (x,y) -> { return x+y; };
		ramdaReturn = (x,y) -> x+y;
		int returnValue = ramdaReturn.method3(12, 33);
		System.out.println(returnValue);	// ���ٽĽ����� ���� �͸� ���� ��ü�� �޼ҵ带 ȣ���ϸ� �ȴ�.
		
		
	}
}
