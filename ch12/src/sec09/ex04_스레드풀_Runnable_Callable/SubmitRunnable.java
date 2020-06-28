package sec09.ex04_������Ǯ_Runnable_Callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitRunnable {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println("[�۾� ó�� ��û]");
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				int sum = 0;
				for(int i=1; i<=10; i++) {
					sum += i;
				}
				System.out.println("[ó�� ���] " + sum);
			}
		};
		
		Future<?> future = executorService.submit(runnable);	// �۾�ť�� ó���� �۾��� �־��ش�.
		
		try {
			future.get();	// �۾��� �Ϸ�ɶ� ���� ���ŷ�ȴ�(��ٷ��ش�).
			System.out.println("[�۾� ó�� �Ϸ�]");
		} catch (Exception e) {
			System.out.println("[���� ���� �߻�] " + e.getMessage());
		}
		
		executorService.shutdown();
		
	}
}
