package sec06.ex03_�������������_wait_notify;

public class WaitNotify {
	// �� �����尡 ������ü�� �ϳ��� �޼ҵ带 ������ ������ ��
	public static void main(String[] args) {
		ShareObject shareObj = new ShareObject();
		
		ThreadA threadA = new ThreadA(shareObj);
		threadA.start();
		
		ThreadB threadB = new ThreadB(shareObj);
		threadB.start();
		
	}
}
