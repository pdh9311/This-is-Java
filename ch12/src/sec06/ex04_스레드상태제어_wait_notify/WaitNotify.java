package sec06.ex04_스레드상태제어_wait_notify;

public class WaitNotify {
	public static void main(String[] args) {
		ShareObject shareObj = new ShareObject();

		ThreadA threadA = new ThreadA(shareObj);
		threadA.start();
		ThreadB threadB = new ThreadB(shareObj);
		threadB.start();
		
	}
}
