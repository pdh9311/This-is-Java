package sec04.ex01_��ø�������̽�;

public class Button {
	// �������̽� �ʵ�
	OnClickListener listener;
	
	// �������̽� ������
	void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	// �������̽� ����
	void touch() {
		listener.onClick();
	}
	
	// �������̽�
	interface OnClickListener {
		void onClick();
	}
}
