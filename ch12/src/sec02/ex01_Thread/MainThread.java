package sec02.ex01_Thread;

import java.awt.Toolkit;

public class MainThread {
	public static void main(String[] args) {
		// �۾� ������ ���� ���1 - Runnable �͸�ü
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.print("��1 ");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
		
		// �۾� ������ ���� ���2	- ���ٽ�(�Լ���)	
		Thread thread2 = new Thread(() -> {
			for(int i=0;i<5;i++) {
				System.out.print("��2 ");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread2.start();
		
		// �۾� ������ ���� ���3 - Runnable���� Ŭ������ �������� �Ű������� ����
		Runnable runnableEX = new RunnableEX();
		Thread thread3 = new Thread(runnableEX);
		thread3.start();

		// �۾� ������ ���� ���4 - Thread�� �͸�ü
		Thread thread4 = new Thread() {
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.print("��4 ");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				setName("Thread4");
				System.out.println(getName());
			}
		};
		thread4.start();
		
		// �۾� ������ ���� ���5 - Thread�� ����Ŭ����
		Thread thread5 = new ThreadEX();
		thread5.start();
		
		// Main ������
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0;i<5;i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/* setName()�� getName()�� Thread�� �ν��Ͻ� �޼ҵ�ν� �������� �̸��� �����ϰ� �ҷ��� �� �ִ�.
		 * ���� Runnable�� ������ Ŭ���������� setName()�� getName()�� ����� �� ����.
		 * �͸�ü�� �����ڸ� ����� �� ����.
		 * ���ٽ����� �ۼ��� ��� �Լ����� Ư���� �̿��� thread�� �����ϱ⶧���� ���ٽ��� ������ �ڵ忡 setName(), getName()�� ����� �� ����.  */
		Thread mainThread = Thread.currentThread();		// �� �ڵ带 �����ϴ� Thread��ü�� ����.
		mainThread.setName("MainThread");
		String mainThreadName = mainThread.getName(); 
		thread1.setName("Thread1");
		String thread1Name = thread1.getName();
		thread2.setName("Thread2");
		String thread2Name = thread2.getName();
		thread3.setName("Thread3");
		String thread3Name = thread3.getName();
		thread4.setName("Thread4");
		String thread4Name = thread4.getName();
		thread5.setName("Thread5");
		String thread5Name = thread5.getName();
		
		System.out.println(mainThreadName + " " + thread1Name + " " + thread2Name + " "	+ thread3Name + " "  + thread4Name + " " + thread5Name);		
		
	}
}
