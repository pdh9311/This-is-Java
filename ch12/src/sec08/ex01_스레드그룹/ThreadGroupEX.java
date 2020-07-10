package sec08.ex01_스레드그룹;

import java.util.Map;
import java.util.Set;

public class ThreadGroupEX {
	public static void main(String[] args) {
		// 스레드 그룹 생성
		ThreadGroup tg = new ThreadGroup("tg");
		ThreadGroup threadG = new ThreadGroup("ThreadG");
		
		// tg스레드 그룹의 하위 스레드로 test스레드를 생성
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
		
		// 스레드 그룹 이름 얻기
		ThreadGroup group = Thread.currentThread().getThreadGroup();
		String groupName = group.getName();
		System.out.println(groupName);
		
		// 프로세스 내에서 실행중인 모든 스레드에 대한 정보 얻기
		Map<Thread,StackTraceElement[]> map = Thread.getAllStackTraces();
		Set<Thread> threads = map.keySet();
		for(Thread thread : threads) {
			System.out.println("소속 그룹명: " + thread.getThreadGroup().getName() 
					+ ", 스레드명: " + thread.getName() 
					+ ((thread.isDaemon()) ? "(데몬)" : "(주)") );
		}
		
		/* 스레드그룹으로 interrupt()메소드를 호출하므로써 
		 * 스레드그룹에 포함된 모든 스레드가 내부적으로 interrupt()메소드를 호출하게 된다. */
		threadG.interrupt();	
		
		/* "list()는 스레드그룹의 정보를 출력해준다."
		 * ThreadGroup [그룹명, 최대우선순위]
		 * 		 Thread [스레드명, 우선순위, 소속 그룹명]	 */
		Thread.currentThread().getThreadGroup().list();
	}
}
