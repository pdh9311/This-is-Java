package sec06.ex02_�������������_join;

public class JoinMethod {
	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		threadA.start();
		/* threadA.join()�޼ҵ带 �̿��ϸ� threadA�� ����ɶ� ���� main�����尡 �Ͻ��������°� �ǰ� threadA�� ����Ǹ� main�����尡 ����ȴ�. 
		 * threadA.join()�޼ҵ带 �̿����� �ʾҴٸ� threadA�� ����Ǵ� ���� main�����嵵 ���� ����Ǳ⶧���� ����� �Ϸ��ϱ� ���� ���� ��µ� �� �ִ�. */
		try { threadA.join(); } catch (InterruptedException e) {}	
		System.out.println("��: " + threadA.sum);
	}
}
