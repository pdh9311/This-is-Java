package sec09.ex02_������Ǯ_execute��submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteMethod {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for(int i=0;i<10;i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					
					System.out.println("[�� ������ ���� : " + threadPoolExecutor.getPoolSize() + "] " + 
										"�۾� ������ �̸� : " + Thread.currentThread().getName() );
					
					int value = Integer.parseInt("��");		// ���� �߻�
					
				}
			};
			
			/* execute()�� �۾� ó�� ���� ���ܰ� �߻��ϸ� �ش� �����带 �����ϰ� ���ο� �����带 �����ϱ� ������ 
			 * �������� �̸��� 10�� ���� �ö󰡴� ���� �� �� �ִ�. */
			executorService.execute(runnable);
			Thread.sleep(10);
		}
		
		executorService.shutdown();
	}
}
