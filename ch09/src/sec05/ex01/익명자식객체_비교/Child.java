package sec05.ex01.�͸��ڽİ�ü_��;

public class Child {
	Child1 field = new Child1();
	
   	void method1() {
 		Child2 localVar = new Child2();
 		localVar.wake();
   	}
   	
   	void method2(Parent parent) {
   		parent.wake();
   	}
}
