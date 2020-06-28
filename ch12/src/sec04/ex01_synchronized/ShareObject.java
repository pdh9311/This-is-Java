package sec04.ex01_synchronized;

public class ShareObject {
	
	private int number;

	public int getNumber() {
		return number;
	}

	/* 스레드들이 어떠한 객체를 공유해서 사용할 경우 공유객체의 필드값이 변경될 위험을 줄이기 위해 
	 * 단 하나의 스레드만 실행할 수 있도록 동기화(synchronized)된 메소드나 블록을 사용한다. 
	 * 동기화 메소드, 동기화 블록에 들어가면 즉시 객체에 잠금을 걸어 다른 스레드가 모든 동기화 메소드나 블록을 실행하지 못하도록 한다.
	 * 	ex) User1 스레드가 동기화 메소드를 실행하는 시점에 ShareObject객체를 잠그게 되고 
	 * 		User2 스레드를 실행시키지만 User1의 동기화로 인해 ShareObject 객체가 잠겨있어서 
	 * 		User1이 동기화 메소드를 모두 실행할 동안 대기상태에 있게 된다. */
	// 메소드 동기화
	public synchronized void setNumber(int number) {
		System.out.println("[ " + Thread.currentThread().getName() + " 시작 ]");	
		// 동기화 블록 synchronized(공유객체)	{}
		synchronized(this) {
			this.number = number;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println("[ " + Thread.currentThread().getName() + " 스레드 입력한 값: " + this.number + " ]");	// 확인할 값이 필드값이므로 number 앞에 this.을 꼭 붙여주어야함
		}
		System.out.println("[ " + Thread.currentThread().getName() + " 끝 ]");
	}
	
	/* [메소드에 동기화를 사용하지 않고 동기화 블록만 사용할 때 출력 순서 ] 
	 * User1 시작 | User2 시작 | User1 스레드 입력한 값: 10 | User1 끝 | User2 스레드 입력한 값: 5 | User2 끝 |

	 * [ 메소드 동기화, 동기화 블록 모두 사용할 때 출력 순서 ]
	 * User1 시작 | User1 스레드 입력한 값: 10 | User1 끝 | User2 시작 | User2 스레드 입력한 값: 5 | User2 끝 |  */
	
}
