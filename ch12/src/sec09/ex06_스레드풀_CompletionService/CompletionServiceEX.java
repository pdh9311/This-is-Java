package sec09.ex06_������Ǯ_CompletionService;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceEX {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		// �۾� �Ϸ� ������ ����� �������� ���ؼ� executorService��ü�� �Ű������� �Ѱ��ְ� completionService��ü�� �޾ƿ´�.
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
		
		completionService.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for(int i=1; i<=1000000; i++) {
					sum += i;
				}
				return sum;
			}
		});
		
		completionService.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for(int i=1; i<=10; i++) {
					sum += i;
				}
				return sum;
			}
		});
		
		completionService.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for(int i=21; i<=23; i++) {
					sum += i;
				}
				return sum;
			}
		});
		
		// take()�� ����Ǹ� ���ŷ�Ǿ� �ٸ� �ڵ尡 ������� �����Ƿ� ���ο� �����峪 ������Ǯ�� �� �ٸ� ������� ��������־�� �Ѵ�.
		System.out.println("[ó�� �Ϸ�� �۾� Ȯ��]");
		executorService.submit(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Future<Integer> future = completionService.take();	 
						int value = future.get();	// ���⼭ get()�� ���ŷ ���� �ʰ� �ٷ� �۾� ����� �����Ѵ�.
						System.out.println(value);
					} catch (Exception e) {
						break;
					} 
				}
			}
		});
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		executorService.shutdownNow();
	}
}
