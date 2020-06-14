package sec03.ex01_익명구현객체;

import sec02.ex01_interface.RemoteControl;

public class UseRemoteControl {
	public static void main(String[] args) {
		// 익명 구현 객체
		// 익명 구현 객체는 컴파일후 클래스파일이 만들어질때 "UseRemoteControl$1.class"와 같이 $와 숫자가 붙게된다.
		RemoteControl rc = new RemoteControl() {
			@Override
			public void turnOn() { }
			
			@Override
			public void turnOff() { }
			
			@Override
			public void setVolume(int volume) { }
		};
	}
}