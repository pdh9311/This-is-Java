package sec08.ex01_abstract;

public abstract class Animal {
	public String kind;
	
	public void breathe() {
		System.out.println("���� ���ϴ�.");
	}
	
	public abstract void sound();	// �߻�޼ҵ�
}
