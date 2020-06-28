package sec08.ex01_������׷�;

import java.util.Map;
import java.util.Set;

public class ThreadGroupEX {
	public static void main(String[] args) {
		// ������ �׷� ����
		ThreadGroup tg = new ThreadGroup("tg");
		ThreadGroup threadG = new ThreadGroup("ThreadG");
		
		// tg������ �׷��� ���� ������� test�����带 ����
		Thread test = new Thread(tg,"test") {
			@Override
			public void run() {
				while(true) {}
			}
		};
		test.setDaemon(true);
		test.start();
		
		MyThread thread1 = new MyThread(threadG,"thread1");
		MyThread thread2 = new MyThread(threadG,"thread2");
		thread1.start();
		thread2.start();
		
		// ������ �׷� �̸� ���
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		String groupName = group.getName();
		System.out.println(groupName);
		
		// ���μ��� ������ �������� ��� �����忡 ���� ���� ���
		Map<Thread,StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();
		for(Thread thread : threads) {
			System.out.println("�Ҽ� �׷��: " + thread.getThreadGroup().getName() 
					+ ", �������: " + thread.getName() 
					+ ((thread.isDaemon()) ? "(����)" : "(��)") );
		}
		
		/* ������׷����� interrupt()�޼ҵ带 ȣ���ϹǷν� 
		 * ������׷쿡 ���Ե� ��� �����尡 ���������� interrupt()�޼ҵ带 ȣ���ϰ� �ȴ�. */
		threadG.interrupt();	
		
		/* "list()�� ������׷��� ������ ������ش�."
		 * ThreadGroup [�׷��, �ִ�켱����]
		 * 		 Thread [�������, �켱����, �Ҽ� �׷��]	 */
		Thread.currentThread().getThreadGroup().list();
	}
}
