package sec07.ex02_제네릭타입_구현;

// 제네릭 인터페이스를 구현한 클래스도 제네릭 타입이 된다.
public class AddImpl<T> implements Add<T> {
	private T[] genericArray;
	
	// 생성자의 매개값으로 배열의 길이를 받아서 T타입의 배열 객체를 생성한다.
	public AddImpl(int capacity) {
		this.genericArray = (T[]) (new Object[capacity]);
	}
	
	// T배열의 index위치에 t1값을 추가해준다. 
	@Override
	public void add(T t1, int index) {
		 this.genericArray[index] = t1;
	}
	
	// T배열의 index위치에 있는 값을 리턴
	@Override
	public T get(int index) {
		return genericArray[index];
	}
	
	public static void main(String[] args) {
		AddImpl<String> addImpl = new AddImpl<String>(10);
		addImpl.add("홍길동", 0);
		String str =addImpl.get(0);
		System.out.println(str);
		
	}

}
