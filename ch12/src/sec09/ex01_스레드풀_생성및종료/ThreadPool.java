package sec09.ex01_스레드풀_생성및종료;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	public static void main(String[] args) {
		/** [ 스레드풀 생성 방법1 ] */ 
		/* 1개 이상의 스레드가 추가되었을 경우 
		 * 60초 동안 추간된 스레드가 아무 작업을 하지 않으면 추가된 스레드를 종료하고 풀에서 제거한다. */
		ExecutorService executorService1 = Executors.newCachedThreadPool();
		
		/**  [ 스레드풀 생성 방법2 ] */
		/* 스레드가 작업을 처리하고 않고 놀고 있더라도 스레드 개수가 줄지 않는다. */
		ExecutorService executorService2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		/** [ 스레드풀 생성 방법3 ] */
		/* 최소 3개의 스레드가 유지되며, 
		 * 최대 100개의 스레드가 생성 될 수 있고, 
		 * 3개의 스레드를 제외한 나머지 추가된 스레드가 120초 동안 놀고 있을 경우 해당 스레드를 제거해서 스레드 수를 관리한다. 
		 * 놀고 있는 시간 단위
		 * 작업 큐*/
		// newCashedThreadPool(),newFixedThreadPool()메소드는 내부적으로 ThreadPoolExecutor객체를 생성해서 ExecutorService를 리턴한다.
		ExecutorService executorService3 = new ThreadPoolExecutor(3, 100, 120L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		
		/** [ 스레드풀 종료 방법1 ] */
		/* 현재 처리중인 작업 뿐만 아니라 작업큐에 대기하고 있는 모든 작업을 처리한 뒤에 스레드풀을 종료시킨다. */
		executorService1.shutdown();
		
		/** [ 스레드풀 종료 방법2 ] */
		/* 남아 있는 작업과 상관없이 interrupt해서 강제로 스레드풀을 종료시킨다. */
		executorService2.shutdownNow();
		
		/** [ 스레드풀 종료 방법3 ] */
		/* 모든 작업 처리를 시간 내에 완료하면 true를 리턴하고,
		 * 완료하지 못하면 작업처리중인 스레드를 interrupt하고 false를 리턴한다. */
		try {
			executorService3.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {}
	}
}
