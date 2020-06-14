package sec02.ex01_interface;

public interface RemoteControl {
	// ��� (������ �������� �ڵ����� public static final�� �ٰԵȴ�.)
	public static final int MAX_VALUE = 100;
	int MIN_VALUE = 0;
	
	// �߻� �޼ҵ� (������ �������� �ڵ����� public abstract�� �ٰԵȴ�.)
	public abstract void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// ����Ʈ �޼ҵ� (������ �������� �ڵ����� public�� �ٰ� �ȴ�.)
	// ���� �������̽��� Ȯ���ؼ� ���ο� ����� �߰��ϱ� ���ؼ� ���ȴ�.
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("���� ó��");
		} else {
			System.out.println("���� ����");
		}
	}
	
	// ���� �޼ҵ� (������ �������� �ڵ����� public�� �ٰ� �ȴ�.)
	// �������̽��� �ٷ� ȣ���� �����ϴ�.
	public static void changeBattery() {
		System.out.println("�������� ��ȯ�մϴ�.");
	}
}
