package sec11_ex02_Stream최종처리_사용자정의컨테이너에수집;

import java.util.ArrayList;
import java.util.List;

import sec11_ex01_Stream최종처리_수집.Student;

// 보통 자바에서 컨테이너라 하면 객체를 저장하는 객체를 말한다.
public class Container {
	
	private List<Student> list;
 
	public Container() {
		this.list = new ArrayList<Student>();
		System.out.println("[" + Thread.currentThread().getName() + "] Container()");
	}

	public List<Student> getList() { return list; }
	
	// 요소를 수집하는 메소드
	public void accumulate(Student student) {
		list.add(student);
		System.out.println("[" + Thread.currentThread().getName() + "] accumulate()");
	}
	
	// 병렬처리시 서로 다른 Container객체를 결합하는 메소드
	public void combine(Container other) {
		list.addAll(other.getList());	// addAll()메소드는 매개값으로 전달된 컬렉션의 모든 요소를 리스트에 추가합니다. 
		System.out.println("[" + Thread.currentThread().getName() + "] combine()");
	}
}
