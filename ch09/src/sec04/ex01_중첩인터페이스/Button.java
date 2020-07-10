package sec04.ex01_중첩인터페이스;

public class Button {
	// 인터페이스 필드
	OnClickListener listener;
	
	// 인터페이스 다형성
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	// 인터페이스 구현
	void touch() {
		listener.onClick();
	}
	
	// 인터페이스
	interface OnClickListener {
		void onClick();
	}
}
