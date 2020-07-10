package sec06.ex02_스레드상태제어_join;

public class ThreadA extends Thread {
	public int sum;
	
	@Override
	public void run() {
		for(int i=1; i<=100; i++) {
			sum += i;
		}
	}
}
