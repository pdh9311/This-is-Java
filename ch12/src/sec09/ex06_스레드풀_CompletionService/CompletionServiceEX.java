package sec09.ex06_스레드풀_CompletionService;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceEX {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		// 작업 완료 순으로 결과를 가져오기 위해서 executorService객체를 매개값으로 넘겨주고 completionService객체를 받아온다.
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
		
		// take()가 실행되면 블로킹되어 다른 코드가 실행되지 않으므로 새로운 스레드나 스레드풀의 또 다른 스레드로 실행시켜주어야 한다.
		System.out.println("[처리 완료된 작업 확인]");
		executorService.submit(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Future<Integer> future = completionService.take();	 
						int value = future.get();	// 여기서 get()은 블로킹 되지 않고 바로 작업 결과를 리턴한다.
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
