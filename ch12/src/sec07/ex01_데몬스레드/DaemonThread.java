package sec07.ex01_���󽺷���;

public class DaemonThread {
	public static void main(String[] args) {
		Thread autoSaveThread = new Thread() {
			@Override
			public void run() {
				for(int i=0;i<1;i++) {
					if(this.isDaemon()) {
						System.out.println("���󽺷��� �̿����Դϴ�.");
					}
				}
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {}
					System.out.println("�ڵ� ���� �մϴ�.");
				}
			}
		};
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {}
		int sum = 0;
		for(int i=1; i<=1000; i++) {
			sum += i;
		}
		System.out.println("1~1000 ��:" + sum);
	}
}
