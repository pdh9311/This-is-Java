package sec08.ex01_������׷�;

public class MyThread extends Thread {
	
	public MyThread(ThreadGroup threadGroup, String threadName) {
		super(threadGroup,threadName);	// ThreadŬ������ Thread(ThreadGroup, String) �����ڿ� ���� ����
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(getName() + " interrupted");
				break;
			}
		}
		System.out.println(getName() + " ����");
	}

}
