package sec09.ex03_스레드풀_submit의Future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitReturn {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("작업 처리");
			}
		};
		
		Future<?> future = executorService.submit(runnable);
//		try {future.get();} catch (Exception e1) {} 만약에 이 코드가 작성된다면 get()메소드를 호출하면서 블로킹되므로 "처리 중"은 출력되지 않을 것이다.	
		System.out.println(future.isDone() ? "처리 완료" : "처리 중");
		try { Thread.sleep(10); } catch(Exception e) {}
		System.out.println(future.isDone() ? "0.01초후 처리 완료" : "0.01초후 처리 중");
		
		
		/* Future의 get()메소드를 호출하면 스레드가 작업을 완료할 때까지 블로킹되었다가 작업을 완료하면 처리 결과를 리턴한다.
		 * 여기서 블로킹될 때 다른 코드를 실행할 수 없으므로 get()메소드는 새로운 스레드이거나 스레드풀의 또다른 스레드가 되어야 한다. (ex. UI작업) */
		
		// 새로운 스레드에서 get() 호출
		new Thread() {
			@Override
			public void run() {
				try { 
					System.out.println((future.get() == null) ? "작업이 정상적으로 처리되었음" : "작업처리안됨");
				} catch(Exception e) {};
			}
		}.start();
		
		// 스레드풀의 또 다른 스레드에서 get() 호출
		executorService.submit(new Runnable () {
			@Override
			public void run() {
				try { 
					System.out.println((future.get() == null) ? "작업이 정상적으로 처리되었음" : "작업처리안됨");
				} catch(Exception e) {};
			}
		});
		
		executorService.shutdown();
	}
}
