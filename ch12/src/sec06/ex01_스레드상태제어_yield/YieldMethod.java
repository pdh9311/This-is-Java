package sec06.ex01_�������������_yield;

public class YieldMethod {
	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		threadA.start();
		
		ThreadB threadB = new ThreadB();
		threadB.start();
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {}
		threadA.work = false;	// ThreadA�� ���� ��� ���·� ������.
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {}
		threadB.work = false;	// ThreadB�� ���� ��� ���·� ������.
		
		try {Thread.sleep(2000);} catch (InterruptedException e) {}
		threadA.stop = true;	
		threadB.stop = true;
		
	}
}
