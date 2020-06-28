package sec09.ex04_스레드풀_Runnable_Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitCallable {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println("[작업 처리 요청]");
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
		
		Future<Integer> future = executorService.submit(callable);	// 작업큐에 처리할 작업을 넣어준다.
		
		try {
			int result = future.get();	// 작업이 완료될때 까지 블로킹되고(기다리고) 결과값을 리턴한다.
			System.out.println("[처리 결과] " + result);
			System.out.println("[작업 처리 완료]");
		} catch (Exception e) {
			System.out.println("[실행 예외 발생] " + e.getMessage());
		}
		
		executorService.shutdown();
	}
}
