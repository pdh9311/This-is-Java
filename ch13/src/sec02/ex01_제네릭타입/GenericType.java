package sec02.ex01_���׸�Ÿ��;

public class GenericType<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public static void main(String[] args) {
		// ���׸� Ÿ������ Ŭ������ ����Ƿν� Ÿ�Ժ�ȯ�� �߻����� �ʱ� ������ ��ü ���α׷� ���ɿ� ���� ����� �����´�.
		GenericType<String> genericType = new GenericType<String>();
		genericType.setT("�׽�Ʈ");
		String str = genericType.getT();
		System.out.println(str);
	}
}
