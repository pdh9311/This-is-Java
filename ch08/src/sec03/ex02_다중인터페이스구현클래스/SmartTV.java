package sec03.ex02_�����������̽�����Ŭ����;

import sec02.ex01_interface.RemoteControl;

// ���� �������̽� : implements �ڿ� ","�� �����Ͽ� �������� �������̽��� �ۼ��� �� �ִ�.
// �ۼ��� �������̽��� �߻� �޼ҵ�� ������ �ؾ��Ѵ�.
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
