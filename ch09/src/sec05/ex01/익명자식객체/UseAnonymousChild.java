package sec05.ex01.�͸��ڽİ�ü;

public class UseAnonymousChild {
	public static void main(String[] args) {
		AnonymousChild anony = new AnonymousChild();
		
		// �͸� ��ü �ʵ� ���
		anony.field.wake();
		
		// �͸� ��ü ���� ���� ���
		anony.method1();
		
		// �͸� ��ü �Ű��� ���
		anony.method2(
			// �͸� ��ü �Ű������� ����
			new Parent() {
				void study() {
					System.out.println("�����մϴ�.");
				}
	
				@Override
				void wake() {
					System.out.print("3�ÿ� ");
					study();
				}
			}
		);
	}
}
