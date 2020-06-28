package sec06.ex05_스레드종료;

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
		System.out.println("stop 플래그 실행으로 스레드 종료");
	}

}
