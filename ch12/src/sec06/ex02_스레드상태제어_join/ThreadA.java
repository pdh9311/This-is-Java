package sec06.ex02_�������������_join;

public class ThreadA extends Thread {
	public int sum;
	
	@Override
	public void run() {
		for(int i=1; i<=100; i++) {
			sum += i;
		}
	}
}
