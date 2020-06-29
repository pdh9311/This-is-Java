package sec07.ex02_���׸�Ÿ��_����;

// ���׸� �������̽��� ������ Ŭ������ ���׸� Ÿ���� �ȴ�.
public class AddImpl<T> implements Add<T> {
	private T[] genericArray;
	
	// �������� �Ű������� �迭�� ���̸� �޾Ƽ� TŸ���� �迭 ��ü�� �����Ѵ�.
	public AddImpl(int capacity) {
		this.genericArray = (T[]) (new Object[capacity]);
	}
	
	// T�迭�� index��ġ�� t1���� �߰����ش�. 
	@Override
	public void add(T t1, int index) {
		 this.genericArray[index] = t1;
	}
	
	// T�迭�� index��ġ�� �ִ� ���� ����
	@Override
	public T get(int index) {
		return genericArray[index];
	}
	
	public static void main(String[] args) {
		AddImpl<String> addImpl = new AddImpl<String>(10);
		addImpl.add("ȫ�浿", 0);
		String str =addImpl.get(0);
		System.out.println(str);
		
	}

}
