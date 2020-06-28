package sec09.ex06_스레드풀_CompletionService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutoreServiceEX {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		Future<Integer> future1 = executorService.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for(int i=0; i<10;i++) {
					sum += i;
				}
				return sum;
			}
		});
		
		Future<Integer> future2 = executorService.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for(int i=0; i<3;i++) {
					sum += i;
				}
				return sum;
			}
		});

		executorService.submit(new Runnable() {
			@Override
			public void run() {
				try {
					int value1 = future1.get();
					int value2 = future2.get();
					System.out.println(value1);
					System.out.println(value2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
				
		executorService.shutdown();
	}
}
