package sec11_ex02_Stream����ó��_��������������̳ʿ�����;

import java.util.ArrayList;
import java.util.List;

import sec11_ex01_Stream����ó��_����.Student;

// ���� �ڹٿ��� �����̳ʶ� �ϸ� ��ü�� �����ϴ� ��ü�� ���Ѵ�.
public class Container {
	
	private List<Student> list;
 
	public Container() {
		this.list = new ArrayList<Student>();
		System.out.println("[" + Thread.currentThread().getName() + "] Container()");
	}

	public List<Student> getList() { return list; }
	
	// ��Ҹ� �����ϴ� �޼ҵ�
	public void accumulate(Student student) {
		list.add(student);
		System.out.println("[" + Thread.currentThread().getName() + "] accumulate()");
	}
	
	// ����ó���� ���� �ٸ� Container��ü�� �����ϴ� �޼ҵ�
	public void combine(Container other) {
		list.addAll(other.getList());	// addAll()�޼ҵ�� �Ű������� ���޵� �÷����� ��� ��Ҹ� ����Ʈ�� �߰��մϴ�. 
		System.out.println("[" + Thread.currentThread().getName() + "] combine()");
	}
}
