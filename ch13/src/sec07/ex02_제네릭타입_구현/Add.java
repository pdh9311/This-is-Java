package sec07.ex02_제네릭타입_구현;

public interface Add<T> {
	void add(T t1, int index);
	T get(int index);
}
