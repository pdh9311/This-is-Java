package sec07.ex01_instanceof���;

public class UseInstanceof {
	// instanceof �����ڴ� ���� Ÿ�Ժ�ȯ�� �Ű����� Ÿ���� Ȯ���� �� �ַ� ���ȴ�.(���,�������̽�)
	public static void method(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("Child Ÿ������ ��ȯ ����");
		} else {
			System.out.println("Child Ÿ������ ��ȯ �Ұ���");
		}
	}
	public static void main(String[] args) {
		Parent parent1 = new Parent();
		Parent parent2 = new Child();
		
		method(parent1);
		method(parent2);
	}
}
