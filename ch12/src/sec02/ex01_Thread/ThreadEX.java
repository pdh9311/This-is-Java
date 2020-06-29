package sec02.ex01_Thread;

public class ThreadEX extends Thread {

	public ThreadEX() {
		this.setName("ThreadEX");
	}
	
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.print("띵5 ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName());
	}
	
}