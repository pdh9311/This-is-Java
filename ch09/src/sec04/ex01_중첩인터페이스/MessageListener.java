package sec04.ex01_중첩인터페이스;

public class MessageListener implements Button.OnClickListener {

	@Override
	public void onClick() {
		System.out.println("메시지를 보냅니다.");
	}
	
}
