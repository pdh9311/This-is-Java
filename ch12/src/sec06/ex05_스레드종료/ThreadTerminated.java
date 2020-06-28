package sec06.ex05_����������;

public class ThreadTerminated {
	public static void main(String[] args) {
		// stop �÷��׷� ������ ����
		ThreadA threadA = new ThreadA();
		threadA.start();
		threadA.setStop(true);
		
		// interrupt()�޼ҵ� ȣ��� ���ܸ� �߻����� ������ ����
		Thread threadB = new Thread() {
			@Override
			public void run() {
				while(true) {
					try { Thread.sleep(1); } catch (InterruptedException e) {
						System.out.println("interrupt()ȣ��� ���� ���ܹ߻����� ������ ����");
					}
				}
			}
		};
		threadB.start();
		threadB.interrupt();
		
		// interrupt()�޼ҵ� ȣ���� �ߴ��� ���ߴ��� �������� �����޼ҵ�� Ȯ���� ����
		Thread threadC = new Thread() {
			@Override
			public void run() {
				while(true) {
					if(Thread.interrupted()) {
						System.out.println("Thread.interrupted() �����޼ҵ�� Ȯ�� �� ������ ����");
						break;
					}
				}
			}
		};
		threadC.start();
		threadC.interrupt();

		// interrupt()�޼ҵ� ȣ���� �ߴ��� ���ߴ��� �������� �ν��Ͻ��޼ҵ�� Ȯ���� ����
		Thread threadD = new Thread() {
			@Override
			public void run() {
				while(true) {
					if(this.isInterrupted()) {
						System.out.println("Object.interrupted() �ν��Ͻ��޼ҵ�� Ȯ�� �� ������ ����");
						break;
					}
				}
			}
		};
		threadD.start();
		threadD.interrupt();
	}
}
