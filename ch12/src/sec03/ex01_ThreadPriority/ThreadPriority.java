package sec03.ex01_ThreadPriority;

public class ThreadPriority {
	public static void main(String[] args) {
		/* �����층�� ���ü�, ���ļ� � ���� ���� ������ �޶�����.
		 * �ϳ��� �ھ�� ��� ���ü����� ����ȴٸ� Thread10�� ���� ���� ������ ���� ������
		 * ��Ƽ �ھ�� ���ļ����� ����ȴٸ� Thread10�� ���� ���� ������ ���� �� �ִ�. */
		for(int i=1;i<=10;i++) {
			Thread  thread = new ThreadTask("Thread"+i);
			if(i != 10) {
				thread.setPriority(Thread.MIN_PRIORITY);
			} else {
				thread.setPriority(Thread.MAX_PRIORITY);
			}
			thread.start();
		}
	}
}
