package sec06.ex04_�������������_wait_notify;

public class ShareObject {
	private String data;
	
	// ThreadA�� ������ �޼ҵ�
	public synchronized void setData(String data) {
		// ThreadB�� data�� null�� ������ �ʾҴٸ�(ThreadB�� data�� ������� �ʾҴٸ�) ThreadA�� �Ͻ��������¿� �ֵ��� ��.
		if(this.data != null) {
			try { wait(); } catch (InterruptedException e) {}
		}		
		
		this.data = data;
		System.out.print("���� ������: " + data + " | ");
		notify(); // ThreadB�� ��������·� �������� setData()�޼ҵ尡 �� ����Ǳ������� ThreadB�� ����ȭ�� ���� shareObj��ü�� ��������Ƿ� ������ �� ���� ���̴�.
		
	}
	
	// ThreadB�� ������ �޼ҵ�
	public synchronized String getData() {
		// ThreadA�� data�� ���� �ʾҴٸ� ThreadB�� �Ͻ��������¿� �ֵ��� ��.
		if(this.data == null) {
			try { wait(); } catch (InterruptedException e) {}	
		}
		
		String readData = data;
		System.out.println("���� ������ : " + readData);
		data = null;
		notify();	// ThreadA�� ��������·� �������� getData()�޼ҵ尡 �� ����Ǳ������� ThreadA�� ����ȭ�� ���� shareObj��ü�� ��������Ƿ� ������ �� ���� ���̴�.
		return readData;
	}
	
}