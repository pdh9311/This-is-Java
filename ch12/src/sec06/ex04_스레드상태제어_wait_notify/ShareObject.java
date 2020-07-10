package sec06.ex04_스레드상태제어_wait_notify;

public class ShareObject {
	private String data;
	
	// ThreadA가 실행할 메소드
	public synchronized void setData(String data) {
		// ThreadB가 data를 null로 만들지 않았다면(ThreadB가 data를 사용하지 않았다면) ThreadA는 일시정지상태에 있도록 함.
		if(this.data != null) {
			try { wait(); } catch (InterruptedException e) {}
		}		
		
		this.data = data;
		System.out.print("만든 데이터: " + data + " | ");
		notify(); // ThreadB를 실행대기상태로 만들지만 setData()메소드가 다 실행되기전에는 ThreadB는 동기화로 인해 shareObj객체가 잠겨있으므로 실행할 수 없을 것이다.
		
	}
	
	// ThreadB가 실행할 메소드
	public synchronized String getData() {
		// ThreadA가 data를 넣지 않았다면 ThreadB는 일시정지상태에 있도록 함.
		if(this.data == null) {
			try { wait(); } catch (InterruptedException e) {}	
		}
		
		String readData = data;
		System.out.println("읽은 데이터 : " + readData);
		data = null;
		notify();	// ThreadA를 실행대기상태로 만들지만 getData()메소드가 다 실행되기전에는 ThreadA는 동기화로 인해 shareObj객체가 잠겨있으므로 실행할 수 없을 것이다.
		return readData;
	}
	
}