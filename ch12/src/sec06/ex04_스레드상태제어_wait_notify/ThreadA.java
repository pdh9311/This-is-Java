package sec06.ex04_스레드상태제어_wait_notify;

public class ThreadA extends Thread {
	public ShareObject shareObj;

	public ThreadA(ShareObject shareObj) {
		setName("ThreadA");
		this.shareObj = shareObj;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			shareObj.setData("Data-" + i);
		}
	}
	
}
