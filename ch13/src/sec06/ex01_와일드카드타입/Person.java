package sec06.ex01_와일드카드타입;

public class Person {
	public String identity;

	public Person(String identity) {
		this.identity = identity;
	}

	@Override
	public String toString() {
		return identity;
	}
	
}
