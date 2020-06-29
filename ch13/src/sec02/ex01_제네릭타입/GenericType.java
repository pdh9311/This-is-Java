package sec02.ex01_제네릭타입;

public class GenericType<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public static void main(String[] args) {
		// 제네릭 타입으로 클래스를 만드므로써 타입변환이 발생하지 않기 때문에 전체 프로그램 성능에 좋은 결과를 가져온다.
		GenericType<String> genericType = new GenericType<String>();
		genericType.setT("테스트");
		String str = genericType.getT();
		System.out.println(str);
	}
}
