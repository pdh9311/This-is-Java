package sec06.ex05_����������;

public class ThreadA extends Thread {
	private boolean stop = false;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while(!stop) {
			System.out.println(" ");
		}
		System.out.println("stop �÷��� �������� ������ ����");
	}

}
