package sec03.ex02_다중인터페이스구현클래스;

import sec02.ex01_interface.RemoteControl;

// 다중 인터페이스 : implements 뒤에 ","로 구분하여 여러개의 인터페이스를 작성할 수 있다.
// 작성된 인터페이스의 추상 메소드는 재정의 해야한다.
public class SmartTV implements RemoteControl, Searchable {
	@Override
	public void search(String url) { }

	@Override
	public void turnOn() { }

	@Override
	public void turnOff() { }

	@Override
	public void setVolume(int volume) { }
}
