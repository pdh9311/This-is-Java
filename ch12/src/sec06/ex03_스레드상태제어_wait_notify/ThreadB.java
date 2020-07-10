package sec06.ex03_스레드상태제어_wait_notify;

public class ThreadB extends Thread {
	private ShareObject shareObj;
	
	public ThreadB(ShareObject shareObj) {
		this.shareObj = shareObj;
		setName("ThreadB");
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			shareObj.method();
		}
	}
}
