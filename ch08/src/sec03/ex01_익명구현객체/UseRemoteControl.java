package sec03.ex01_�͸�����ü;

import sec02.ex01_interface.RemoteControl;

public class UseRemoteControl {
	public static void main(String[] args) {
		// �͸� ���� ��ü
		// �͸� ���� ��ü�� �������� Ŭ���������� ��������� "UseRemoteControl$1.class"�� ���� $�� ���ڰ� �ٰԵȴ�.
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