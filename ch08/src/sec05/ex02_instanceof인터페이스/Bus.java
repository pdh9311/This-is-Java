package sec05.ex02_instanceof�������̽�;

public class Bus implements Vehicle{
	@Override
	public void run() {
		System.out.println("������ �޸��ϴ�.");
	}
	
	public void checkFare() {
		System.out.println("��������� Ȯ���մϴ�.");
	}
}
