package sec06.ex03_�������������_wait_notify;

public class ShareObject {
		
	public synchronized void method() {
		
		// notify()�� wait()�� ����ȭ�޼ҵ� �Ǵ� ����ȭ ��Ͽ����� ��밡���ϴ�.
		
		/* notify()�� �Ͻ��������¿� �ִ� Thread�� �ϳ� ã�Ƽ� ��������·� �����.
		 * ���� �������� �����尡 �Ͻ��������¿� �ִٸ� � �����带 ã�� ������ ���·� �����? �ϴ� �ǹ��� ������ �ȴ�.
		 * ���� notify()�� �ݵ�� �� �����尡 ������ �����ϴ� ȯ�濡���� ����ϵ��� �մϴ�. */
		
		/* notify() , wait() ������ �����ؾ� ��!
		 * 1. ThreadA�� method ���� : ����ϰ�, ThreadB�� ��������·� �Ǿ� ������ �غ� ������ ����ȭ(synchronized)�� ���� ������ü�� ��� �����̹Ƿ� method()�� ������ �� ���� , ThreadA�� �Ͻ��������·� �ȴ�.
		 * 2. ThreadB�� method ���� : ����ϰ�, ThreadA�� ��������·� ���� ������ �غ� ������ ����ȭ(synchronized)�� ���� ������ü�� ��� �����̹Ƿ� method()�� ������ �� ���� , ThreadB�� �Ͻ��������·� �ȴ�.
		 * ... 1�� 2�� ������ �� ThreadA, ThreadB�� ������ ���鼭 �����ϰԵȴ�. */
		if(Thread.currentThread().getName() == "ThreadA") {
			System.out.print(Thread.currentThread().getName() + " : ");
		} else {
			System.out.println(Thread.currentThread().getName() + " | ");
		}
		// 23~28���� �ּ�ó�� �Ҷ��� ���Ҷ��� ���غ���!
		notify();
		try {
			wait();	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
