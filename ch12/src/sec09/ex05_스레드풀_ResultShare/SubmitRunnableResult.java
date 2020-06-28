package sec09.ex05_������Ǯ_ResultShare;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitRunnableResult {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		// ��û�� �۾��� 2���̰�, ������ü�� �̿��ؼ� �� �������� ����� ������ ���̹Ƿ�  �͸�ü�� �������� �ʰ� Ŭ������ ����� ����Ѵ�.
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
				resultShare.addSum(sum);	// ResultShare��ü�� �۾� ��� ����
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

// ���� ��ü
class ResultShare {
	int accumVal;
	
	synchronized void addSum(int val) {
		this.accumVal += val;
	}
	
}

