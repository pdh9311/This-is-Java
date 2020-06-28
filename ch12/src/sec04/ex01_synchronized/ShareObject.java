package sec04.ex01_synchronized;

public class ShareObject {
	
	private int number;

	public int getNumber() {
		return number;
	}

	/* ��������� ��� ��ü�� �����ؼ� ����� ��� ������ü�� �ʵ尪�� ����� ������ ���̱� ���� 
	 * �� �ϳ��� �����常 ������ �� �ֵ��� ����ȭ(synchronized)�� �޼ҵ峪 ����� ����Ѵ�. 
	 * ����ȭ �޼ҵ�, ����ȭ ��Ͽ� ���� ��� ��ü�� ����� �ɾ� �ٸ� �����尡 ��� ����ȭ �޼ҵ峪 ����� �������� ���ϵ��� �Ѵ�.
	 * 	ex) User1 �����尡 ����ȭ �޼ҵ带 �����ϴ� ������ ShareObject��ü�� ��װ� �ǰ� 
	 * 		User2 �����带 �����Ű���� User1�� ����ȭ�� ���� ShareObject ��ü�� ����־ 
	 * 		User1�� ����ȭ �޼ҵ带 ��� ������ ���� �����¿� �ְ� �ȴ�. */
	// �޼ҵ� ����ȭ
	public synchronized void setNumber(int number) {
		System.out.println("[ " + Thread.currentThread().getName() + " ���� ]");	
		// ����ȭ ��� synchronized(������ü)	{}
		synchronized(this) {
			this.number = number;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println("[ " + Thread.currentThread().getName() + " ������ �Է��� ��: " + this.number + " ]");	// Ȯ���� ���� �ʵ尪�̹Ƿ� number �տ� this.�� �� �ٿ��־����
		}
		System.out.println("[ " + Thread.currentThread().getName() + " �� ]");
	}
	
	/* [�޼ҵ忡 ����ȭ�� ������� �ʰ� ����ȭ ��ϸ� ����� �� ��� ���� ] 
	 * User1 ���� | User2 ���� | User1 ������ �Է��� ��: 10 | User1 �� | User2 ������ �Է��� ��: 5 | User2 �� |

	 * [ �޼ҵ� ����ȭ, ����ȭ ��� ��� ����� �� ��� ���� ]
	 * User1 ���� | User1 ������ �Է��� ��: 10 | User1 �� | User2 ���� | User2 ������ �Է��� ��: 5 | User2 �� |  */
	
}
