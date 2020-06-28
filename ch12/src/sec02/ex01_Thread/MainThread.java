package sec02.ex01_Thread;

import java.awt.Toolkit;

public class MainThread {
	public static void main(String[] args) {
		// 작업 스레드 생성 방법1 - Runnable 익명객체
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.print("띵1 ");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
		
		// 작업 스레드 생성 방법2	- 람다식(함수적)	
		Thread thread2 = new Thread(() -> {
			for(int i=0;i<5;i++) {
				System.out.print("띵2 ");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread2.start();
		
		// 작업 스레드 생성 방법3 - Runnable구현 클래스를 쓰레드의 매개값으로 대입
		Runnable runnableEX = new RunnableEX();
		Thread thread3 = new Thread(runnableEX);
		thread3.start();

		// 작업 스레드 생성 방법4 - Thread의 익명객체
		Thread thread4 = new Thread() {
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					System.out.print("띵4 ");
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
		
		// 작업 스레드 생성 방법5 - Thread의 하위클래스
		Thread thread5 = new ThreadEX();
		thread5.start();
		
		// Main 스레드
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0;i<5;i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/* setName()과 getName()은 Thread의 인스턴스 메소드로써 쓰레드의 이름을 지정하고 불러올 수 있다.
		 * 따라서 Runnable을 구현한 클래스에서는 setName()과 getName()을 사용할 수 없다.
		 * 익명객체는 생성자를 사용할 수 없다.
		 * 람다식으로 작성할 경우 함수적인 특성을 이용해 thread를 실행하기때문에 람다식을 실행할 코드에 setName(), getName()을 사용할 수 없다.  */
		Thread mainThread = Thread.currentThread();		// 이 코드를 실행하는 Thread객체를 얻음.
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
