package sec02.ex01_Thread;

public class RunnableEX implements Runnable {
	
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.print("¶ò3 ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
