package sec03.ex01_ThreadPriority;

public class ThreadPriority {
	public static void main(String[] args) {
		/* 스케쥴링과 동시성, 병렬성 등에 의해 실행 순서가 달라진다.
		 * 하나의 코어에서 모두 동시성으로 실행된다면 Thread10이 가장 빨리 끝나는 것이 맞지만
		 * 멀티 코어에서 병렬성으로 실행된다면 Thread10이 가장 빨리 끝나지 않을 수 있다. */
		for(int i=1;i<=10;i++) {
			Thread  thread = new ThreadTask("Thread"+i);
			if(i != 10) {
				thread.setPriority(Thread.MIN_PRIORITY);
			} else {
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			thread.start();
		}
	}
}
