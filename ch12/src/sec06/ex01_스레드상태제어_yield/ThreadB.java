package sec06.ex01_�������������_yield;

public class ThreadB extends Thread {
	public boolean stop = false;
	public boolean work = true;
	
	@Override
	public void run() {
		/* ���࿡ else{~}�� ���ٸ� work�� false�� �ٲپ����� ���ǹ��� ������ ��� �ݺ��ϰ� �ȴ�. 
		 * �̷��ٿ� �ٸ� �����忡�� ������ �纸�ϰ� ��������·� ���°��� ��ü ���α׷����ɿ� ������ �ȴ�. */
		while(!stop) {
			if(work) {
				try {Thread.sleep(50);} catch (InterruptedException e) {}
				System.out.println("ThreadB");
			} else {
				Thread.yield();
			}
		}
	}
}
