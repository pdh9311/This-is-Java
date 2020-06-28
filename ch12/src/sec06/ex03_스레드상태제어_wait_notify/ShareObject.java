package sec06.ex03_스레드상태제어_wait_notify;

public class ShareObject {
		
	public synchronized void method() {
		
		// notify()와 wait()는 동기화메소드 또는 동기화 블록에서만 사용가능하다.
		
		/* notify()는 일시정지상태에 있는 Thread를 하나 찾아서 실행대기상태로 만든다.
		 * 만약 여러개의 스레드가 일시정지상태에 있다면 어떤 스레드를 찾아 실행대기 상태로 만들까? 하는 의문을 가지게 된다.
		 * 따라서 notify()는 반드시 두 스레드가 번갈아 실행하는 환경에서만 사용하도록 합니다. */
		
		/* notify() , wait() 순으로 실행해야 함!
		 * 1. ThreadA가 method 실행 : 출력하고, ThreadB가 실행대기상태로 되어 실행할 준비를 하지만 동기화(synchronized)에 의해 공유객체가 잠긴 상태이므로 method()를 실행할 수 없고 , ThreadA가 일시정지상태로 된다.
		 * 2. ThreadB가 method 실행 : 출력하고, ThreadA를 실행대기상태로 만어 실행할 준비를 하지만 동기화(synchronized)에 의해 공유객체가 잠긴 상태이므로 method()를 실행할 수 없고 , ThreadB가 일시정지상태로 된다.
		 * ... 1번 2번 과정을 을 ThreadA, ThreadB가 번갈아 가면서 실행하게된다. */
		if(Thread.currentThread().getName() == "ThreadA") {
			System.out.print(Thread.currentThread().getName() + " : ");
		} else {
			System.out.println(Thread.currentThread().getName() + " | ");
		}
		// 23~28줄을 주석처리 할때와 안할때를 비교해보기!
		notify();
		try {
			wait();	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
