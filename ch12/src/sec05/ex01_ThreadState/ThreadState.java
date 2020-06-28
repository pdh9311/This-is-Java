package sec05.ex01_ThreadState;

public class ThreadState extends Thread {
	private Thread targetThread;
	
	public ThreadState(Thread targetThread) {
		this.targetThread = targetThread;
	}

	@Override
	public void run() {
		while(true) {
			
			Thread.State state = targetThread.getState();	// getState()메소드는 Thread.State 열거 상수를 리턴
			
			System.out.println(targetThread.getName() + " 스레드의 상태 : " + state);
			
			if(state == Thread.State.NEW) {		
				targetThread.start();		// target스레드상태가 객체가 생성된 상태라면 실행대기상태로 만들겠다.
			}			
			if(state == Thread.State.RUNNABLE) {
				System.out.println(targetThread.getName() + " 스레드가 실행대기상태입니다.");
			}
			
			if(state == Thread.State.WAITING) {
				System.out.println(targetThread.getName() + " 스레드가 다른 스레드가 통지할 때까지 기다리는 상태입니다.");
			}
			
			if(state == Thread.State.TIMED_WAITING) {
				System.out.println(targetThread.getName() + " 스레드가 주어진 시간동안 기다리는 상태입니다.");
			}
			
			if(state == Thread.State.BLOCKED) {
				System.out.println(targetThread.getName() + " 스레드가 사용하고자하는 객체의 락이 풀릴때까지 기다리는 상태입니다.");
			}
			
			if(state == Thread.State.TERMINATED) {
				break;	// target스레드가 종료되면 상태를 확인하는 스레드(ThreadState)도 종료
			}
			
			/* ThreadState 스레드가 0.5초에 한번씩 스레드 상태를 확인하기 위함.
			 * Thead.sleep();을 하지 않으면 약1/1000초마다 스레드의 상태를 확인하게 된다.	 */
			try {
				Thread.sleep(300);		
			} catch (InterruptedException e) {}
		}
	}
	
	
}
