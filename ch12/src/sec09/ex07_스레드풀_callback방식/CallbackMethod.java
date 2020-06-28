package sec09.ex07_스레드풀_callback방식;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackMethod {
	public static void main(String[] args) {
		CompletionHandler<Integer,Void> callback  = new CompletionHandler<Integer,Void>() {
			@Override
			public void completed(Integer result, Void attachment) {
				System.out.println("completed callback method: " + result);
			}

			@Override
			public void failed(Throwable exc, Void attachment) {
				System.out.println("fail callback method: " + exc.toString());
			}
		};
		
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		executorService.submit(new Runnable() {
			@Override
			public void run() {
				try {
					int result  = Integer.parseInt("3");
					callback.completed(result, null);
				} catch (NumberFormatException e) {
					callback.failed(e, null);
				}
			}
		});
		
		executorService.submit(new Runnable() {
			@Override
			public void run() {
				try {
					int result  = Integer.parseInt("삼");
					callback.completed(result, null);
				} catch (NumberFormatException e) {
					callback.failed(e, null);
				}
			}
		});
		
		
		executorService.shutdown();
		
	}
	
	
}
