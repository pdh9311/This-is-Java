package sec06.ex01_스레드상태제어_yield;

public class ThreadB extends Thread {
	public boolean stop = false;
	public boolean work = true;
	
	@Override
	public void run() {
		/* 만약에 else{~}가 없다면 work를 false로 바꾸었을때 무의미한 실행을 계속 반복하게 된다. 
		 * 이럴바에 다른 스레드에게 실행을 양보하고 실행대기상태로 가는것이 전체 프로그램성능에 도움이 된다. */
		while(!stop) {
			if(work) {
				try {Thread.sleep(50);} catch (InterruptedException e) {}
				System.out.println("ThreadB");
			} else {
				Thread.yield();
			}
		}
	}
}
