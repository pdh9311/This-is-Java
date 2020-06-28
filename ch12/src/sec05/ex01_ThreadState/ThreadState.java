package sec05.ex01_ThreadState;

public class ThreadState extends Thread {
	private Thread targetThread;
	
	public ThreadState(Thread targetThread) {
		this.targetThread = targetThread;
	}

	@Override
	public void run() {
		while(true) {
			
			Thread.State state = targetThread.getState();	// getState()�޼ҵ�� Thread.State ���� ����� ����
			
			System.out.println(targetThread.getName() + " �������� ���� : " + state);
			
			if(state == Thread.State.NEW) {		
				targetThread.start();		// target��������°� ��ü�� ������ ���¶�� ��������·� ����ڴ�.
			}			
			if(state == Thread.State.RUNNABLE) {
				System.out.println(targetThread.getName() + " �����尡 ����������Դϴ�.");
			}
			
			if(state == Thread.State.WAITING) {
				System.out.println(targetThread.getName() + " �����尡 �ٸ� �����尡 ������ ������ ��ٸ��� �����Դϴ�.");
			}
			
			if(state == Thread.State.TIMED_WAITING) {
				System.out.println(targetThread.getName() + " �����尡 �־��� �ð����� ��ٸ��� �����Դϴ�.");
			}
			
			if(state == Thread.State.BLOCKED) {
				System.out.println(targetThread.getName() + " �����尡 ����ϰ����ϴ� ��ü�� ���� Ǯ�������� ��ٸ��� �����Դϴ�.");
			}
			
			if(state == Thread.State.TERMINATED) {
				break;	// target�����尡 ����Ǹ� ���¸� Ȯ���ϴ� ������(ThreadState)�� ����
			}
			
			/* ThreadState �����尡 0.5�ʿ� �ѹ��� ������ ���¸� Ȯ���ϱ� ����.
			 * Thead.sleep();�� ���� ������ ��1/1000�ʸ��� �������� ���¸� Ȯ���ϰ� �ȴ�.	 */
			try {
				Thread.sleep(300);		
			} catch (InterruptedException e) {}
		}
	}
	
	
}
