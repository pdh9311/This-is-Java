package sec06.ex01_스레드상태제어_yield;

public class YieldMethod {
	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		threadA.start();
		
		ThreadB threadB = new ThreadB();
		threadB.start();
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {}
		threadA.work = false;	// ThreadA를 실행 대기 상태로 보낸다.
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {}
		threadB.work = false;	// ThreadB를 실행 대기 상태로 보낸다.
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {}
		threadA.stop = true;	
		threadB.stop = true;
		
	}
}
