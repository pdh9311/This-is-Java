package sec06.ex01_인터페이스상속;

public class ImplementationC implements InterfaceC {

	@Override
	public void methodA() {
		System.out.println("interfaceA의 methodA");
	}

	@Override
	public void methodB() {
		System.out.println("interfaceB의 methodB");
	}

	@Override
	public void methodC() {
		System.out.println("interfaceC의 methodC");
	}
	
}
