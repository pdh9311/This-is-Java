package sec09.ex01_������Ǯ_����������;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	public static void main(String[] args) {
		/** [ ������Ǯ ���� ���1 ] */ 
		/* 1�� �̻��� �����尡 �߰��Ǿ��� ��� 
		 * 60�� ���� �߰��� �����尡 �ƹ� �۾��� ���� ������ �߰��� �����带 �����ϰ� Ǯ���� �����Ѵ�. */
		ExecutorService executorService1 = Executors.newCachedThreadPool();
		
		/**  [ ������Ǯ ���� ���2 ] */
		/* �����尡 �۾��� ó���ϰ� �ʰ� ��� �ִ��� ������ ������ ���� �ʴ´�. */
		ExecutorService executorService2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		/** [ ������Ǯ ���� ���3 ] */
		/* �ּ� 3���� �����尡 �����Ǹ�, 
		 * �ִ� 100���� �����尡 ���� �� �� �ְ�, 
		 * 3���� �����带 ������ ������ �߰��� �����尡 120�� ���� ��� ���� ��� �ش� �����带 �����ؼ� ������ ���� �����Ѵ�. 
		 * ��� �ִ� �ð� ����
		 * �۾� ť*/
		// newCashedThreadPool(),newFixedThreadPool()�޼ҵ�� ���������� ThreadPoolExecutor��ü�� �����ؼ� ExecutorService�� �����Ѵ�.
		ExecutorService executorService3 = new ThreadPoolExecutor(3, 100, 120L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		
		/** [ ������Ǯ ���� ���1 ] */
		/* ���� ó������ �۾� �Ӹ� �ƴ϶� �۾�ť�� ����ϰ� �ִ� ��� �۾��� ó���� �ڿ� ������Ǯ�� �����Ų��. */
		executorService1.shutdown();
		
		/** [ ������Ǯ ���� ���2 ] */
		/* ���� �ִ� �۾��� ������� interrupt�ؼ� ������ ������Ǯ�� �����Ų��. */
		executorService2.shutdownNow();
		
		/** [ ������Ǯ ���� ���3 ] */
		/* ��� �۾� ó���� �ð� ���� �Ϸ��ϸ� true�� �����ϰ�,
		 * �Ϸ����� ���ϸ� �۾�ó������ �����带 interrupt�ϰ� false�� �����Ѵ�. */
		try {
			executorService3.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {}
	}
}
