package sec09.ex04_스레드풀_Runnable_Callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitRunnable {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println("[작업 처리 요청]");
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				int sum = 0;
				for(int i=1; i<=10; i++) {
					sum += i;
				}
				System.out.println("[처리 결과] " + sum);
			}
		};
		
		Future<?> future = executorService.submit(runnable);	// 작업큐에 처리할 작업을 넣어준다.
		
		try {
			future.get();	// 작업이 완료될때 까지 블로킹된다(기다려준다).
			System.out.println("[작업 처리 완료]");
		} catch (Exception e) {
			System.out.println("[실행 예외 발생] " + e.getMessage());
		}
		
		executorService.shutdown();
		
	}
}
