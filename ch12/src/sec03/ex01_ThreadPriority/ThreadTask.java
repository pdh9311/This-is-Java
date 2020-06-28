package sec03.ex01_ThreadPriority;

public class ThreadTask extends Thread {
	
	public ThreadTask(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		for(int i=0; i<200000000; i++) {}
		System.out.println(getName());
	}
	
}
