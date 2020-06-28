package sec09.ex07_스레드풀_callback방식;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackEX {
	private ExecutorService executorService;
	private CompletionHandler<Integer, Void> completionHandler = new CompletionHandler<Integer, Void>() {
		@Override
		public void completed(Integer result, Void attachment) {
			System.out.println("CompeltinoHandler → completed: " + result);
		}

		@Override
		public void failed(Throwable exc, Void attachment) {
			System.out.println("completionHandler → failed: " + exc.toString());
		}
	};
	
	public CallbackEX() {
		this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}
	
	public void doWork(String value) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					int result = Integer.parseInt(value);
					completionHandler.completed(result, null);
				} catch (NumberFormatException e) {
					completionHandler.failed(e, null);
				}
			}
		};
		this.executorService.submit(runnable);
	}
	
	
	public void finish() {
		this.executorService.shutdown();
	}
	
	public static void main(String[] args) {
		CallbackEX callback = new CallbackEX();
		callback.doWork("3");
		callback.doWork("삼");
		callback.finish();
	}
	
	
	
}
