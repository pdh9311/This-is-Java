package sec06.ex03_스레드상태제어_wait_notify;

public class WaitNotify {
	// 두 스레드가 공유객체의 하나의 메소드를 번갈아 실행할 때
	public static void main(String[] args) {
		ShareObject shareObj = new ShareObject();
		
		ThreadA threadA = new ThreadA(shareObj);
		threadA.start();
		
		ThreadB threadB = new ThreadB(shareObj);
		threadB.start();
		
	}
}
