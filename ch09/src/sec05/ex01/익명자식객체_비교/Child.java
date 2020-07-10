package sec05.ex01.익명자식객체_비교;

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
