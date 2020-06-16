package sec05.ex02_익명구현객체;

public class UseRemoteControl {
	public static void main(String[] args) {
		AnonymousInterface anony = new AnonymousInterface();
		anony.field.turnOn();
		anony.method1();
		anony.method2(
			// 익명 객체 매개값으로 대입
			new RemoteControl() {
				@Override
				public void turnOn() {
					System.out.println("SmartTV를 켭니다.");
				}

				@Override
				public void turnOff() {
					System.out.println("SmartTV를 끕니다.");
				}
			}
		);
		
	}
}
