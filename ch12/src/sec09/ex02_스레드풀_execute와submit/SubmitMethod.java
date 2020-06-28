package sec09.ex02_스레드풀_execute와submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SubmitMethod {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<10;i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					
					System.out.println("[총 스레드 개수 : " + threadPoolExecutor.getPoolSize() + "] " + 
										"작업 스레드 이름 : " + Thread.currentThread().getName() );
					
					int value = Integer.parseInt("삼");		// 예외 발생
					
				}
			};
			
			/* submit()은 작업 처리 도중 예외가 발생하더라도 스레드를 제거하지않고 다음 작업을 위해 재사용되기 때문에   
			 * 스레드의 이름이 1번과 2번 만 있는 것을 볼 수 있다. */
			executorService.submit(runnable);
			Thread.sleep(10);
		}
		
		executorService.shutdown();
	}
}
