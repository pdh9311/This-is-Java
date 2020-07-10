package sec08.ex01_스레드그룹;

public class MyThread extends Thread {
	
	public MyThread(ThreadGroup threadGroup, String threadName) {
		super(threadGroup,threadName);	// Thread클래스의 Thread(ThreadGroup, String) 생성자에 값을 대입
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
		System.out.println(getName() + " 종료");
	}

}
