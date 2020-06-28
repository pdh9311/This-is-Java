package sec09.ex04_������Ǯ_Runnable_Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitCallable {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println("[�۾� ó�� ��û]");
		Callable<Integer> callable = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for(int i=1; i<=10; i++) {
					sum += i;
				}
				return sum;
			}
		};
		
		Future<Integer> future = executorService.submit(callable);	// �۾�ť�� ó���� �۾��� �־��ش�.
		
		try {
			int result = future.get();	// �۾��� �Ϸ�ɶ� ���� ���ŷ�ǰ�(��ٸ���) ������� �����Ѵ�.
			System.out.println("[ó�� ���] " + result);
			System.out.println("[�۾� ó�� �Ϸ�]");
		} catch (Exception e) {
			System.out.println("[���� ���� �߻�] " + e.getMessage());
		}
		
		executorService.shutdown();
	}
}
