package sec06.ex01_�������̽����;

public class UseInterface {
	public static void main(String[] args) {
		ImplementationC impl = new ImplementationC();
		
		InterfaceA ia = impl;
		ia.methodA();
		System.out.println("-------------");
		InterfaceB ib = impl;
		ib.methodA();
		ib.methodB();
		System.out.println("-------------");
		InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}
