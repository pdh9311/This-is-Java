package sec06.ex03_�������������_wait_notify;

public class ThreadA extends Thread {
	private ShareObject shareObj;
	
	public ThreadA(ShareObject shareObj) {
		this.shareObj = shareObj;
		setName("ThreadA");
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			shareObj.method();
		}
	}
}
