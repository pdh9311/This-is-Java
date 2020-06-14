package sec02.ex01_interface;

public interface RemoteControl {
	// 상수 (컴파일 과정에서 자동으로 public static final이 붙게된다.)
	public static final int MAX_VALUE = 100;
	int MIN_VALUE = 0;
	
	// 추상 메소드 (컴파일 과정에서 자동으로 public abstract가 붙게된다.)
	public abstract void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// 디폴트 메소드 (컴파일 과정에서 자동으로 public이 붙게 된다.)
	// 기존 인터페이스를 확장해서 새로운 기능을 추가하기 위해서 사용된다.
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리");
		} else {
			System.out.println("무음 해제");
		}
	}
	
	// 정적 메소드 (컴파일 과정에서 자동으로 public이 붙게 된다.)
	// 인터페이스로 바로 호출이 가능하다.
	public static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
}
