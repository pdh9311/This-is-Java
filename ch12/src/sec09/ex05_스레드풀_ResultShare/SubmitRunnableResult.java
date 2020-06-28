package sec09.ex05_스레드풀_ResultShare;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitRunnableResult {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		// 요청할 작업이 2개이고, 공유객체를 이용해서 각 스레드의 결과를 조합할 것이므로  익명객체로 생성하지 않고 클래스로 만들어 사용한다.
		class Task implements Runnable {
			ResultShare resultShare;
			
			public Task(ResultShare resultShare) {
				this.resultShare = resultShare;
			}

			@Override
			public void run() {
				int sum = 0;
				for(int i=1; i<=10; i++) {
					sum += i;
				}
				resultShare.addSum(sum);	// ResultShare객체에 작업 결과 저장
			}
		}
		
		ResultShare result = new ResultShare();
		
		Task task1 = new Task(result);
		Task task2 = new Task(result);
		
		Future<ResultShare> future1 = executorService.submit(task1,result);
		Future<ResultShare> future2 = executorService.submit(task2,result);
		
		try {
			result = future1.get();
			result = future2.get();
			System.out.println(result.accumVal);
			
		} catch (Exception e) {}
		
		executorService.shutdown();
		
	}
}

// 공유 객체
class ResultShare {
	int accumVal;
	
	synchronized void addSum(int val) {
		this.accumVal += val;
	}
	
}

