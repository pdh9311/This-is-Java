package sec05.ex02_�͸�����ü;

public class UseRemoteControl {
	public static void main(String[] args) {
		AnonymousInterface anony = new AnonymousInterface();
		anony.field.turnOn();
		anony.method1();
		anony.method2(
			// �͸� ��ü �Ű������� ����
			new RemoteControl() {
				@Override
				public void turnOn() {
					System.out.println("SmartTV�� �մϴ�.");
				}

				@Override
				public void turnOff() {
					System.out.println("SmartTV�� ���ϴ�.");
				}
			}
		);
		
	}
}
