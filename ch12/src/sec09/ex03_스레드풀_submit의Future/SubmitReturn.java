package sec09.ex03_������Ǯ_submit��Future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitReturn {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("�۾� ó��");
			}
		};
		
		Future<?> future = executorService.submit(runnable);
//		try {future.get();} catch (Exception e1) {} ���࿡ �� �ڵ尡 �ۼ��ȴٸ� get()�޼ҵ带 ȣ���ϸ鼭 ���ŷ�ǹǷ� "ó�� ��"�� ��µ��� ���� ���̴�.	
		System.out.println(future.isDone() ? "ó�� �Ϸ�" : "ó�� ��");
		try { Thread.sleep(10); } catch(Exception e) {}
		System.out.println(future.isDone() ? "0.01���� ó�� �Ϸ�" : "0.01���� ó�� ��");
		
		
		/* Future�� get()�޼ҵ带 ȣ���ϸ� �����尡 �۾��� �Ϸ��� ������ ���ŷ�Ǿ��ٰ� �۾��� �Ϸ��ϸ� ó�� ����� �����Ѵ�.
		 * ���⼭ ���ŷ�� �� �ٸ� �ڵ带 ������ �� �����Ƿ� get()�޼ҵ�� ���ο� �������̰ų� ������Ǯ�� �Ǵٸ� �����尡 �Ǿ�� �Ѵ�. (ex. UI�۾�) */
		
		// ���ο� �����忡�� get() ȣ��
		new Thread() {
			@Override
			public void run() {
				try { 
					System.out.println((future.get() == null) ? "�۾��� ���������� ó���Ǿ���" : "�۾�ó���ȵ�");
				} catch(Exception e) {};
			}
		}.start();
		
		// ������Ǯ�� �� �ٸ� �����忡�� get() ȣ��
		executorService.submit(new Runnable () {
			@Override
			public void run() {
				try { 
					System.out.println((future.get() == null) ? "�۾��� ���������� ó���Ǿ���" : "�۾�ó���ȵ�");
				} catch(Exception e) {};
			}
		});
		
		executorService.shutdown();
	}
}
