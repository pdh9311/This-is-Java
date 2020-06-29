package sec07.ex01_���׸�Ÿ��_���;

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

//���׸��� ��� �޴� �ڽ�Ŭ������ ���׸� Ÿ���� �߰������� �� ���� �� �ִ�.
class Child<K,M,C> extends Parent<K,M> {
	private C company;

	public C getCompany() {
		return company;
	}

	public void setCompany(C company) {
		this.company = company;
	}
	
}

