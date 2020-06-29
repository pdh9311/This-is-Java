package sec07.ex01_제네릭타입_상속;

public class Parent<K,M> {
	private K kind;
	private M model;
	
	public K getKind() {
		return kind;
	}
	public void setKind(K kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	
	public static void main(String[] args) {
		Child<String,String,String> child = new Child<>();
		child.setKind("TV");
		child.setModel("smartTV");
		child.setCompany("samsung");
		
		System.out.println(child.getKind() + " " + child.getModel() + " " + child.getCompany());
	}
}

//제네릭을 상속 받는 자식클래스는 제네릭 타입을 추가적으로 더 가질 수 있다.
class Child<K,M,C> extends Parent<K,M> {
	private C company;

	public C getCompany() {
		return company;
	}

	public void setCompany(C company) {
		this.company = company;
	}
	
}

