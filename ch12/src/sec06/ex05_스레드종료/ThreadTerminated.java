package sec06.ex05_스레드종료;

public class ThreadTerminated {
	public static void main(String[] args) {
		// stop 플래그로 스레드 종료
		ThreadA threadA = new ThreadA();
		threadA.start();
		threadA.setStop(true);
		
		// interrupt()메소드 호출로 예외를 발생시켜 스레드 종료
		Thread threadB = new Thread() {
			@Override
			public void run() {
				while(true) {
					try { Thread.sleep(1); } catch (InterruptedException e) {
						System.out.println("interrupt()호출로 인한 예외발생으로 스레드 종료");
					}
				}
			}
		};
		threadB.start();
		threadB.interrupt();
		
		// interrupt()메소드 호출을 했는지 안했는지 스레드의 정적메소드로 확인후 종료
		Thread threadC = new Thread() {
			@Override
			public void run() {
				while(true) {
					if(Thread.interrupted()) {
						System.out.println("Thread.interrupted() 정적메소드로 확인 후 스레드 종료");
						break;
					}
				}
			}
		};
		threadC.start();
		threadC.interrupt();

		// interrupt()메소드 호출을 했는지 안했는지 스레드의 인스턴스메소드로 확인후 종료
		Thread threadD = new Thread() {
			@Override
			public void run() {
				while(true) {
					if(this.isInterrupted()) {
						System.out.println("Object.interrupted() 인스턴스메소드로 확인 후 스레드 종료");
						break;
					}
				}
			}
		};
		threadD.start();
		threadD.interrupt();
	}
}
