package sec02.ex01_���׸�Ÿ��;

public class ObjectType {
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	public static void main(String[] args) {
		// �ֻ��� Ŭ������ ObjectŸ���� ����ϹǸ�� ��� ��ü�� ������ �� ������ ����� Ÿ�Ժ�ȯ���� ���� ��ü ���α׷� ���ɿ� ���� ���� ����� ������ �� �ִ�.
		ObjectType objType = new ObjectType();
		objType.setObject(new Apple());				// Apple��ü�� Object�� �ڵ� Ÿ�� ��ȯ �ȴ�.
		Apple apple = (Apple)objType.getObject();	// Object��ü�� Apple�� ���� Ÿ�� ��ȯ �ȴ�.	
	}
	
}

class Apple {
	
}
